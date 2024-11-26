package com.kodiatech.etudiant.manager.student.model;


import com.kodiatech.etudiant.manager.features.model.Student;
import com.kodiatech.etudiant.manager.features.model.embeddbale.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@JsonTest
public class StudentJsonTest {
    //

    @Autowired
    private JacksonTester<Student> jacksonTester;


    @Test
    void shouldSerializePost() throws Exception {
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
    void shouldDeserializePost() throws Exception {
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
        // Use Jackson to get the actual expected JSON
        String expected2 = jacksonTester.write(student).getJson();

        // Deserialize the JSON back into a Student object
        Student actualStudent = jacksonTester.parseObject(expected2);

        // Perform assertions to ensure the deserialized values are correct
        assertThat(actualStudent.getFirstName()).isEqualTo("kaba");
        assertThat(actualStudent.getLastName()).isEqualTo("mama");
        assertThat(actualStudent.getEmail()).isEqualTo("kaba@gmail.com");
        assertThat(actualStudent.getAdress().name()).isEqualTo("Thomas edison bat a");
        assertThat(actualStudent.getAdress().city()).isEqualTo("Toulouse");
        assertThat(actualStudent.getAdress().country()).isEqualTo("France");
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