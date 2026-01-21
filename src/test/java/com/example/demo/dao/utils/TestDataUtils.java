package com.example.demo.dao.utils;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;

public final class TestDataUtils {

    private TestDataUtils() {}

    public static Author createTestAuthor() {
        return Author.builder().id(1L).name("Nishan Bhattarai").age(28).build();
    }

    public static Book createTestBook() {
        return Book.builder().
                isbn("1234-456-7890").
                title("Pyscology of Money").
                authorId(1L).
                build();
    }
}
