package com.example.demo.repositories;

import com.example.demo.TestDataUtils;
import com.example.demo.domain.BookEntity;
import com.example.demo.domain.AuthorEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryIntegrationTest {

    private BookRepository underTest;


    @Autowired
     public BookEntityRepositoryIntegrationTest(BookRepository underTest) {
        this.underTest = underTest;

    }


    @Test
    public void testBookCanBeCreatedAndRecalled() {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        BookEntity bookEntity = TestDataUtils.createTestBook(author);
        BookEntity savedBookEntity = underTest.save(bookEntity);
        Optional<BookEntity>  result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBookEntity);

    }

    @Test
    public void testBookFindAllWorksWell() {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        BookEntity bookEntity = TestDataUtils.createTestBook(author);
        BookEntity savedBookEntityA = underTest.save(bookEntity);

        BookEntity bookEntity2 = TestDataUtils.createTestBookB(author);
       BookEntity savedBookEntityB = underTest.save(bookEntity2);

        BookEntity bookEntity3 = TestDataUtils.createTestBookC(author);
        BookEntity savedBookEntityC = underTest.save(bookEntity3);

        Iterable<BookEntity> result = underTest.findAll();
        assertThat(result).hasSize(3).containsExactly(savedBookEntityA, savedBookEntityB, savedBookEntityC);
    }

    @Test
    public void testBookUpdateWorksWell() {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        BookEntity bookEntity = TestDataUtils.createTestBook(author);

        bookEntity.setIsbn("123");
        BookEntity savedBookEntity = underTest.save(bookEntity);

        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBookEntity);

    }

    @Test
    public void testBookDeleteWorksWell() {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        BookEntity bookEntity = TestDataUtils.createTestBook(author);

        BookEntity savedBookEntity = underTest.save(bookEntity);
        underTest.deleteById(savedBookEntity.getIsbn());
        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isEmpty();
    }

}
