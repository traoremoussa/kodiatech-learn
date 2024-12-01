package com.kodiatech.etudiant.manager.student.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodiatech.etudiant.manager.features.model.Student;
import com.kodiatech.etudiant.manager.features.model.embeddbale.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@JsonTest
public class StudentJsonTest {
    //

    @Autowired
    private JacksonTester<Student> jacksonTester;


    @Test
    void shouldSerializeStudent() throws Exception {
        Student student = new Student("mama", "kaba", "M",
                "kaba@gmail.com", "+33755052865",
                LocalDate.of(2000, 11, 24), LocalDate.now());

        Address adress = Address.builder()
                .name("Thomas edison bat a")
                .number("68")
                .codePostal("Thomas edison bat a")
                .city("Toulouse")
                .country("France")
                .build();
        student.setAdress(adress);

/*
        // Use Jackson's ObjectMapper to serialize the Address into JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String addressJson = objectMapper.writeValueAsString(adress); // Serialize Address to JSON string


        String expected = """
                {
                    "lastName": "%s",
                    "firstName": "%s",
                    "sexe": "%s",
                    "email": "%s",
                    "phone": "%s",
                    "dateOfBirth": "%s",
                    "enrollmentDate": "%s",
                    "adress": "%s"
                }
                """.formatted(student.getLastName(), student.getFirstName(), student.getSexe(),
                student.getEmail(), student.getPhone(), student.getDateOfBirth(), student.getEnrollmentDate(), addressJson);*/

        // Use Jackson to get the actual expected JSON
        String expected2 = jacksonTester.write(student).getJson();


        assertThat(jacksonTester.write(student)).isEqualToJson(expected2);


    }

    @Test
    void shouldDeserializeStudent() throws Exception {
        Student student = new Student("mama", "kaba", "M",
                "kaba@gmail.com", "+33755052865",
                LocalDate.parse("24-11-2000", DateTimeFormatter.ofPattern("dd-MM-yyyy")), LocalDate.now());

        Address address = Address.builder()
                .name("Thomas edison bat a")
                .number("68")
                .codePostal("Thomas edison bat a")
                .city("Toulouse")
                .country("France")
                .build();
        student.setAdress(address);

        // Serialize the student object to JSON
        String expectedJson = jacksonTester.write(student).getJson();

        // Deserialize the JSON back into a Student object
        Student actualStudent = jacksonTester.parseObject(expectedJson);

        // Perform assertions to ensure the deserialized values are correct
        assertThat(actualStudent.getFirstName()).isEqualTo("kaba");
        assertThat(actualStudent.getLastName()).isEqualTo("mama");
        assertThat(actualStudent.getEmail()).isEqualTo("kaba@gmail.com");
        assertThat(actualStudent.getAdress().name()).isEqualTo("Thomas edison bat a");
        assertThat(actualStudent.getAdress().city()).isEqualTo("Toulouse");
        assertThat(actualStudent.getAdress().country()).isEqualTo("France");
    }

    @Test
    void deserializeStudent() throws JsonProcessingException {
        // Configure the ObjectMapper with the date format
        ObjectMapper objectMapper = new ObjectMapper();


        // Deserialization example
        String json = "{ \"firstName\": \"mama\", \"lastName\": \"kaba\", \"gender\": \"M\", \"email\": \"kaba@gmail.com\", \"phoneNumber\": \"+33755052865\", \"dateOfBirth\": \"24-11-2000\", \"registrationDate\": \"01-12-2024\" }";


    }

}


/**
 * String expected = STR."""
 * {
 * <p>
 * "lastName":\{student.getLastName()},
 * "firstName":"\{student.getFirstName()}",
 * "sexe":"\{student.getSexe()}",
 * "email":"\{student.getEmail()}",
 * "phone":\{student.getPhone()},
 * "dateOfBirth":"\{student.getDateOfBirth()}",
 * "enrollmentDate":"\{student.getEnrollmentDate()}",
 * <p>
 * <p>
 * <p>
 * }
 * """;
 */


/**
 * https://github.com/danson-placeholder-service/posts/blob/main/src/test/java/dev/danvega/danson/post/PostJsonTest.java
 */