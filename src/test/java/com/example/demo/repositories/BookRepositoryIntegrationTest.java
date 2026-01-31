package com.example.demo.repositories;

import com.example.demo.TestDataUtils;
import com.example.demo.domain.Book;
import com.example.demo.domain.Author;
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
public class BookRepositoryIntegrationTest {

    private BookRepository underTest;


    @Autowired
     public BookRepositoryIntegrationTest(BookRepository underTest) {
        this.underTest = underTest;

    }


    @Test
    public void testBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtils.createTestAuthor();
        Book book = TestDataUtils.createTestBook(author);
        Book savedBook = underTest.save(book);
        Optional<Book>  result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBook);

    }

    @Test
    public void testBookFindAllWorksWell() {
        Author author = TestDataUtils.createTestAuthor();
        Book book = TestDataUtils.createTestBook(author);
        Book savedBookA = underTest.save(book);

        Book book2 = TestDataUtils.createTestBookB(author);
       Book savedBookB = underTest.save(book2);

        Book book3 = TestDataUtils.createTestBookC(author);
        Book savedBookC = underTest.save(book3);

        Iterable<Book> result = underTest.findAll();
        assertThat(result).hasSize(3).containsExactly(savedBookA, savedBookB, savedBookC);
    }

    @Test
    public void testBookUpdateWorksWell() {
        Author author = TestDataUtils.createTestAuthor();
        Book book = TestDataUtils.createTestBook(author);

        book.setIsbn("123");
        Book savedBook = underTest.save(book);

        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBook);

    }

    @Test
    public void testBookDeleteWorksWell() {
        Author author = TestDataUtils.createTestAuthor();
        Book book = TestDataUtils.createTestBook(author);

        Book savedBook = underTest.save(book);
        underTest.deleteById(savedBook.getIsbn());
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isEmpty();
    }

}
