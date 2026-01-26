package com.example.demo.dao;

import com.example.demo.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(Long authorId);

    List<Author> findMany();

    void update(Long authorId,Author author);

    void delete(Long authorId);
}
