package com.example.demo.controllers;

import com.example.demo.TestDataUtils;
import com.example.demo.domain.AuthorEntity;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // Converts AuthorEntity to JSON

    @Test
    public void testCreateAuthorReturnsHttp201() throws Exception {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        String authorJson = objectMapper.writeValueAsString(author);

        mockMvc.perform(
                        post("/authors")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(authorJson)
                )
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateAuthorReturnsSavedAuthor() throws Exception {
        AuthorEntity author = TestDataUtils.createTestAuthor();
        String authorJson = objectMapper.writeValueAsString(author);

        mockMvc.perform(
                        post("/authors")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(authorJson)
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.id").isNumber()
                ).andExpect(
                        MockMvcResultMatchers.jsonPath("$.name").value("Nishan Bhattarai")
                ).andExpect(
                        MockMvcResultMatchers.jsonPath("$.age").value(28));
    }
}
