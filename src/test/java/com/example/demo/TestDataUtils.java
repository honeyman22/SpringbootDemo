package com.example.demo;

import com.example.demo.domain.AuthorEntity;
import com.example.demo.domain.BookEntity;

public final class TestDataUtils {

    private TestDataUtils() {}

    public static AuthorEntity createTestAuthor() {
        return AuthorEntity.builder().name("Nishan Bhattarai").age(28).build();
    }
    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder().name("Balen Shah").age(35).build();
    }
    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder().name("Ramhari paudel").age(28).build();
    }

    public static BookEntity createTestBook(final AuthorEntity author) {
        return BookEntity.builder().
                isbn("1234-456-7890").
                title("Pyscology of Money").
                author(author).
                build();
    }

    public static BookEntity createTestBookB(final AuthorEntity author) {
        return BookEntity.builder().
                isbn("1784-456-7890").
                title("Atomic Habits").
                author(author).
                build();
    }
    public static BookEntity createTestBookC(final AuthorEntity author) {
        return BookEntity.builder().
                isbn("1894-456-7890").
                title("12 weeks year").
                author(author).
                build();
    }
}
