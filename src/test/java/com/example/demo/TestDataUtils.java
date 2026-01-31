package com.example.demo;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;

public final class TestDataUtils {

    private TestDataUtils() {}

    public static Author createTestAuthor() {
        return Author.builder().name("Nishan Bhattarai").age(28).build();
    }
    public static Author createTestAuthorB() {
        return Author.builder().name("Balen Shah").age(35).build();
    }
    public static Author createTestAuthorC() {
        return Author.builder().name("Ramhari paudel").age(28).build();
    }

    public static Book createTestBook(final Author author) {
        return Book.builder().
                isbn("1234-456-7890").
                title("Pyscology of Money").
                author(author).
                build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder().
                isbn("1784-456-7890").
                title("Atomic Habits").
                author(author).
                build();
    }
    public static Book createTestBookC(final Author author) {
        return Book.builder().
                isbn("1894-456-7890").
                title("12 weeks year").
                author(author).
                build();
    }
}
