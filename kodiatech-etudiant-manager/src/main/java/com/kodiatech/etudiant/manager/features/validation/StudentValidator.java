package com.kodiatech.etudiant.manager.features.validation;

import com.kodiatech.etudiant.manager.features.model.Student;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator  implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz); // Le validateur supporte la classe User

    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student=(Student) target;

        if(student.getFirstName()==null){
            errors.rejectValue("username", "username.empty", "Le nom d'utilisateur ne peut pas être vide");
        }
        // Validation du champ email
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            errors.rejectValue("email", "email.empty", "L'email ne peut pas être vide");
        } else if (!student.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.rejectValue("email", "email.invalid", "L'email est invalide");
        }
    }
}
