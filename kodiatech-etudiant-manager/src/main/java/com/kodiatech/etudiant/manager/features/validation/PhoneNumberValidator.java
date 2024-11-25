package com.kodiatech.etudiant.manager.features.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    // Regular expression for validating phone numbers (this example allows various formats)
    private static final String PHONE_PATTERN = "^(\\+33|0)(6|7)\\d{8}$";




    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        // Initialization logic, if needed (this can be left empty for now)
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null) {
            return false;  // Return false if the phone number is null
        }

        // Validate phone number against the regex
        return Pattern.matches(PHONE_PATTERN, phoneNumber);
    }
}

