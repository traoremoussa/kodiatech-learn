package com.kodiatech.etudiant.manager.features.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    // Regular expression for validating phone numbers (this example allows various formats)
    private static final String PHONE_PATTERN = "^\\+?[1-9]\\d{1,14}$";  // E.164 format (e.g., +1234567890)

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

