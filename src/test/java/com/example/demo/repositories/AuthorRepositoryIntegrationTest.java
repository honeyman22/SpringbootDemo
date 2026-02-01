package com.example.demo.repositories;

import com.example.demo.TestDataUtils;
import com.example.demo.domain.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class AuthorRepositoryIntegrationTest {

    private AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTest(AuthorRepository underTest) {
        this.underTest = underTest;
    }


    @Test
    public void testAuthorCanBECreatedAndRecalled() {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        underTest.save(author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);

    }

    @Test
    public void testAuthorFInManyWorksWell() {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        underTest.save(author);
        AuthorEntity authorB = TestDataUtils.createTestAuthorB();
        underTest.save(authorB);
        AuthorEntity authorC = TestDataUtils.createTestAuthorC();
        underTest.save(authorC);
        Iterable<AuthorEntity> result = underTest.findAll();
        assertThat(result).hasSize(3).containsExactly(author, authorB, authorC);
    }


    @Test
    public void testAuthorUpdateWorksWell() {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        underTest.save(author);
        author.setName("UPDATED");
        underTest.save( author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testAuthorDeleteWorksWell() {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        underTest.save(author);
        underTest.deleteById(author.getId());
        Optional<AuthorEntity> result = underTest.findById(author.getId());
        assertThat(result).isEmpty();
    }
}
