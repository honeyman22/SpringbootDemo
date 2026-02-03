package com.example.demo.controllers;


import com.example.demo.TestDataUtils;
import com.example.demo.domain.AuthorEntity;
import com.example.demo.domain.BookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public BookControllerIntegrationTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
    }


    @Test
    public void testCreateBookReturnsHttp201() throws Exception {

        BookEntity book = TestDataUtils.createTestBook(null);
        String authorJson = objectMapper.writeValueAsString(book);

        String isbnJson =book.getIsbn();

        mockMvc.perform(
                        put("/books/"+isbnJson )
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(authorJson)
                )
                .andExpect(status().isCreated());
    }


    @Test
    public void testCreateAuthorReturnsSavedAuthor() throws Exception {
        BookEntity book = TestDataUtils.createTestBook(null);
        String bookJson = objectMapper.writeValueAsString(book);

        String isbnJson =book.getIsbn();
        mockMvc.perform(
                        put("/books/"+isbnJson )
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(bookJson)
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.isbn").value(isbnJson)
                ).andExpect(
                        MockMvcResultMatchers.jsonPath("$.title").value(book.getTitle())
                );
    }


}
