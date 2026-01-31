//package com.example.demo.repositories;
//
//
//import com.example.demo.dao.AuthorDao;
//import com.example.demo.dao.BookDao;
//import com.example.demo.TestDataUtils;
//import com.example.demo.domain.Book;
//import com.example.demo.domain.Author;
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
//public class BookDaoImplIntegrationTest {
//
//    private BookDaoImpl underTest;
//    private AuthorDao authorDao;
//
//    @Autowired
//     public BookDaoImplIntegrationTest(BookDaoImpl underTest,AuthorDao authorDao) {
//        this.underTest = underTest;
//        this.authorDao = authorDao;
//    }
//
//
//    @Test
//    public void testBookCanBeCreatedAndRecalled() {
//        Author author = TestDataUtils.createTestAuthor();
//        authorDao.create(author);
//        Book book = TestDataUtils.createTestBook();
//        underTest.create(book);
//        Optional<Book>  result = underTest.findOne(book.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//
//    }
//
//    @Test
//    public void testBookFindAllWorksWell() {
//        Author author = TestDataUtils.createTestAuthor();
//        authorDao.create(author);
//        Book book = TestDataUtils.createTestBook();
//        underTest.create(book);
//
//        Book book2 = TestDataUtils.createTestBookB();
//        underTest.create(book2);
//
//        Book book3 = TestDataUtils.createTestBookC();
//        underTest.create(book3);
//
//        List<Book> result = underTest.findAll();
//        assertThat(result).hasSize(3).containsExactly(book, book2, book3);
//    }
//
//}
