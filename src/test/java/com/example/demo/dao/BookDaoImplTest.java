package com.example.demo.dao;

import com.example.demo.dao.impl.BookDaoImpl;
import com.example.demo.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testCreateBookGenerateCorrectSql() {
        Book book =  Book.builder().
                isbn("1234-456-7890").
                title("Pyscology of Money").
                authorId(1L).
                build();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("1234-456-7890"),
                eq("Pyscology of Money"),
                eq(1L)
        );
    }

    @Test
    public void testFindFindOneBookGenerateCorrectSql() {
        underTest.findOne("1234-456-7890");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMappers>any(),
                eq("1234-456-7890")
                );
    }
}
