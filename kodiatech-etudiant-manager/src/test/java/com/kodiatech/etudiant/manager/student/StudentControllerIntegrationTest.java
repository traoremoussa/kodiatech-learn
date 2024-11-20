package com.kodiatech.etudiant.manager.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getHelloTest() throws Exception {
        ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/api/student/", String.class);

        assertThat(response.getBody()).isEqualTo("hello toulouse ok gg");
    }
}
