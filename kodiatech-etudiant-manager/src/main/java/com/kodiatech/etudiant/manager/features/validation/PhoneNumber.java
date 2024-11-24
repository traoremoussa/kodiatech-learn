package com.kodiatech.etudiant.manager.features.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneNumberValidator.class)  // Reference the validator class
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "Invalid phone number format";  // Default error message
    Class<?>[] groups() default {};  // Used for validation groups
    Class<? extends Payload>[] payload() default {};  // Can be used for additional data (optional)
}
