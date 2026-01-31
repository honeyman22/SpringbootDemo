//package com.example.demo.repositories;
//
//import com.example.demo.TestDataUtils;
//import com.example.demo.domain.Author;
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
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
//public class AuthorDaoImplIntegrationTests {
//
//    private AuthorDaoImpl underTest;
//
//    @Autowired
//    public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest) {
//        this.underTest = underTest;
//    }
//
//
//    @Test
//    public void testAuthorCanBECreatedAndRecalled() {
//        Author author = TestDataUtils.createTestAuthor();
//        underTest.create(author);
//        Optional<Author> result = underTest.findOne(author.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(author);
//
//    }
//
//    @Test
//    public void testAuthorFInManyWorksWell() {
//        Author author = TestDataUtils.createTestAuthor();
//        underTest.create(author);
//        Author authorB = TestDataUtils.createTestAuthorB();
//        underTest.create(authorB);
//        Author authorC = TestDataUtils.createTestAuthorC();
//        underTest.create(authorC);
//        List<Author> result = underTest.findMany();
//        assertThat(result).hasSize(3).containsExactly(author, authorB, authorC);
//    }
//
//
//    @Test
//    public void testAuthorUpdateWorksWell() {
//        Author author = TestDataUtils.createTestAuthor();
//        underTest.create(author);
//        author.setName("UPDATED");
//        underTest.update(author.getId(), author);
//        Optional<Author> result = underTest.findOne(author.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(author);
//    }
//
//    @Test
//    public void testAuthorDeleteWorksWell() {
//        Author author = TestDataUtils.createTestAuthor();
//        underTest.create(author);
//        underTest.delete(author.getId());
//        Optional<Author> result = underTest.findOne(author.getId());
//        assertThat(result).isEmpty();
//    }
//}
