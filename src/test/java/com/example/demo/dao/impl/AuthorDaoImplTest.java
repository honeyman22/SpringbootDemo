package com.example.demo.dao.impl;

import com.example.demo.dao.utils.TestDataUtils;
import com.example.demo.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;


@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testCreateAuthorGeneratesCorrectSql() {
        Author author = TestDataUtils.createTestAuthor();
        underTest.create(author);

        verify(jdbcTemplate).update(eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L),
                eq("Nishan Bhattarai"),
                eq(28));
    }

    @Test
    public void testFindOneAuthorGeneratesCorrectSql() {
        underTest.findOne(1L);

        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1" ),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
                );
    }

    @Test
    public void testFindManyAuthorsGeneratesCorrectSql() {
        underTest.findMany();
        verify(jdbcTemplate).query(eq("SELECT * FROM authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );
    }

    @Test
    public void testUpdateAuthorGeneratesCorrectSql() {
        Author author = TestDataUtils.createTestAuthor();

        underTest.update(3L,author);

        verify(jdbcTemplate).update(eq(
                "UPDATE authors SET name = ?, age = ? WHERE id = ?"),
                eq("Nishan Bhattarai"),
                eq(28),
                eq(3L)
                );
    }

    @Test
    public void testDeleteAuthorGeneratesCorrectSql() {
        Author author = TestDataUtils.createTestAuthor();

        underTest.delete(1L);

        verify(jdbcTemplate).update(
                eq("DELETE FROM authors WHERE id = ?"),
                eq(1L)
        );


    }

}
