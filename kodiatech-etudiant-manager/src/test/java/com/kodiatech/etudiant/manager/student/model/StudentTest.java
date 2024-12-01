package com.kodiatech.etudiant.manager.student.model;

import com.kodiatech.etudiant.manager.features.model.Student;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest {
    //ici j'utilise
    private static Validator validator;
    //AssertJ


    @BeforeAll // Use @BeforeAll for JUnit 5
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenNotNullName_thenNoConstraintViolations1() {
        Student student = new Student("tra", "kaba", "M",
                "kaba@gmail.com", "+33755052865",
                LocalDate.of(2000, 11, 24), LocalDate.now());// set a valid first name

        // Validate the student object
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        // Assert that there are no violations for firstName
        assertThat(violations).isEmpty();
    }


    @Test
    public void whenNotNullName_thenNoConstraintViolations() {
        // given: un Student student avec tous les attribut
        // when: student est créé
        Student student = new Student("tra", "kaba", "M",
                "kaba@gmail.com", "+33755052865",
                LocalDate.of(2000, 11, 24), LocalDate.now());

        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        // then: student est pas validé par le validator
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenNullLastName_thenOneConstraintViolation() {
        // given: un Student student avec tous les attribut null lastname
        // when: student est créé
        Student student = new Student(null, "kaba", "M",
                "kaba@gmail.com", "+33755052865",
                LocalDate.of(2000, 11, 24), LocalDate.now());
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenEmptyName_thenOneConstraintViolations() {
        // given: un Student student avec tous les attribut vide lastname
        // when: student est créé
        Student student = new Student("", "kaba", "M",
                "kaba@gmail.com", "+33755052865",
                LocalDate.of(2000, 11, 24), LocalDate.now());
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        // then: student est pas validé par le validator avec une violation
        assertThat(violations.size()).isEqualTo(1);
    }

/***********Autere********************************/

@Test
public void testStudentValidations() {
    // Create a student object with invalid values
   Student student = new Student();
    student.setLastName(null); // Invalid: last name cannot be null
    student.setFirstName(""); // Invalid: first name cannot be blank
    student.setSexe("X"); // Invalid: sex must be 'M' or 'F'
    student.setEmail("invalidEmail"); // Invalid: email is not valid
    student.setPhone("+33755052865"); // Valid: but let's leave it empty
    student.setDateOfBirth(null); // Invalid: assuming it can be empty
    student.setEnrollmentDate(null); // Invalid: assuming it can be empty

   /* Student student = new Student(null, "", "X",
            "kabacom", "",
            null, null);*/
    // Perform the validation
    Set<ConstraintViolation<Student>> violations = validator.validate(student);

    // Assert that all the violations are correct
    assertThat(violations).hasSize(6); // There should be 4 validation violations

    // Assert the specific constraint violations
    assertThat(violations).anyMatch(v -> v.getMessage().equals("lastName may not be null"));
    assertThat(violations).anyMatch(v -> v.getMessage().equals("first name may not be null"));
    assertThat(violations).anyMatch(v -> v.getMessage().equals("Date de naissance may not be null"));
    assertThat(violations).anyMatch(v -> v.getMessage().equals("must match \"^[MF]{1}$\""));
    assertThat(violations).anyMatch(v -> v.getMessage().equals("must be a well-formed email address"));
}

    @Test
    public void testValidStudent() {
        // Create a valid student object
        Student student = new Student();
        student.setLastName("Doe");
        student.setFirstName("John");
        student.setSexe("M");
        student.setEmail("john.doe@example.com");
        student.setPhone("+33612345678");
        student.setDateOfBirth(LocalDate.of(2000, 1, 1));
        //pour future 2020 est ancien
        student.setEnrollmentDate(LocalDate.of(2020, 9, 1));

        // Perform the validation
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        // Assert there are no validation violations (because it's a valid student)
        assertThat(violations).isEmpty();
    }

    @Test
    public void testValidStudentDateEnr() {
        // Create a valid student object
        Student student = new Student();
        student.setLastName("Doe");
        student.setFirstName("John");
        student.setSexe("M");
        student.setEmail("john.doe@example.com");
        student.setPhone("0612345678");
        student.setDateOfBirth(LocalDate.of(2000, 1, 1));
        //pour future 2020 est ancien
        student.setEnrollmentDate(LocalDate.of(2025, 9, 1));

        // Perform the validation
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        // Assert there are no validation violations (because it's a valid student)
        assertThat(violations).isEmpty();
    }

    @Test
    public void testStudentValidDates() {
        Student student = new Student();

        // Set valid dates
        student.setDateOfBirth(LocalDate.of(2000, 1, 1));
        student.setEnrollmentDate(LocalDate.of(2023, 9, 1));

        // Test that dates are correctly set
        assertThat(student.getDateOfBirth()).isEqualTo(LocalDate.of(2000, 1, 1));
        assertThat(student.getEnrollmentDate()).isEqualTo(LocalDate.of(2023, 9, 1));
    }

    @Test
    public void testStudentInvalidDates() {
        Student student = new Student();

        // Set an invalid date for enrollment (future date)
        student.setEnrollmentDate(LocalDate.of(2025, 9, 1));

        // Test that the date is in the future (assuming we have some custom validation for future dates)
        assertThat(student.getEnrollmentDate()).isAfter(LocalDate.now());
    }
}
