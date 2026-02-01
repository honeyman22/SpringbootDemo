package com.example.demo.services;


import com.example.demo.domain.AuthorEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthorService {

    AuthorEntity createAuthor(AuthorEntity author);
}
