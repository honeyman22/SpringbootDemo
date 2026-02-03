package com.example.demo.services;

import com.example.demo.domain.BookEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface BookService {

    BookEntity createBook( String isbn, BookEntity book);
}
