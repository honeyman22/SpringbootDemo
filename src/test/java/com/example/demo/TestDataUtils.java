package com.example.demo;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;

public final class TestDataUtils {

    private TestDataUtils() {}

    public static Author createTestAuthor() {
        return Author.builder().id(1L).name("Nishan Bhattarai").age(28).build();
    }
    public static Author createTestAuthorB() {
        return Author.builder().id(2L).name("Balen Shah").age(35).build();
    }
    public static Author createTestAuthorC() {
        return Author.builder().id(3L).name("Ramhari paudel").age(28).build();
    }

    public static Book createTestBook() {
        return Book.builder().
                isbn("1234-456-7890").
                title("Pyscology of Money").
                authorId(1L).
                build();
    }

    public static Book createTestBookB() {
        return Book.builder().
                isbn("1784-456-7890").
                title("Atomic Habits").
                authorId(1L).
                build();
    }
    public static Book createTestBookC() {
        return Book.builder().
                isbn("1894-456-7890").
                title("12 weeks year").
                authorId(1L).
                build();
    }
}
