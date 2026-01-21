package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // Use application-test.properties
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // Just verifies that the Spring context starts successfully
    }
}
