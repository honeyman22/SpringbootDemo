package com.example.demo.services.Impl;


import com.example.demo.domain.AuthorEntity;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity){
         return authorRepository.save(authorEntity);
    }


}
