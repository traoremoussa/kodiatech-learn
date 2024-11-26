package com.kodiatech.etudiant.manager.student.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

//@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Transactional
public class StudentControllerIntegrationTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate template;
    private String baseUrl = "http://localhost";

    @BeforeEach
    public void beforeSetup() {
        baseUrl = baseUrl + ":" + port + "/api/student";
    }


    @Test
    public void getHelloTest() throws Exception {
        ResponseEntity<String> response = template.getForEntity(baseUrl+"/", String.class);

        assertThat(response.getBody()).isEqualTo("hello toulouse ok gg");
    }
}
