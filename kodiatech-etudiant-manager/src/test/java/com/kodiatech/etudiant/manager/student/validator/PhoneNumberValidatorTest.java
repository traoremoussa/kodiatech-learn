package com.kodiatech.etudiant.manager.student.validator;

import com.kodiatech.etudiant.manager.features.validation.PhoneNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator phoneNumberValidator;

    @BeforeEach
    void setUp() {
        // Initialisation du validateur avant chaque test
        phoneNumberValidator = new PhoneNumberValidator();
    }

    @Test
    void testValidPhoneNumberWithPlus33() {
        // Test avec un numéro valide : format international +33
        assertTrue(phoneNumberValidator.isValid("+33612345678", null));
    }

    @Test
    void testValidPhoneNumberWithZero() {
        // Test avec un numéro valide : format national 0
        assertTrue(phoneNumberValidator.isValid("0612345678", null));
    }

    @Test
    void testInvalidPhoneNumberTooShort() {
        // Test avec un numéro trop court
        assertFalse(phoneNumberValidator.isValid("061234567", null));  // Seulement 9 chiffres
    }

    @Test
    void testInvalidPhoneNumberWithInvalidPrefix() {
        // Test avec un préfixe incorrect (numéro qui ne commence pas par 0 ou +33)
        assertFalse(phoneNumberValidator.isValid("+1234567890", null));  // Non valide pour la France
    }

    @Test
    void testInvalidPhoneNumberWithSpecialCharacter() {
        // Test avec un caractère spécial
        assertFalse(phoneNumberValidator.isValid("+33-612345678", null));  // Tirets ne sont pas autorisés
    }

    @Test
    void testNullPhoneNumber() {
        // Test avec un numéro null
        assertFalse(phoneNumberValidator.isValid(null, null));
    }

    @Test
    void testInvalidPhoneNumberWithTooManyDigits() {
        // Test avec un numéro trop long
        assertFalse(phoneNumberValidator.isValid("061234567890", null));  // 11 chiffres au lieu de 10
    }

    @Test
    void testPhoneNumberWithZeroStartingNotValidForInternational() {
        // Test avec le préfixe 0 et un numéro incorrect
        assertFalse(phoneNumberValidator.isValid("0123456789", null));  // Non valide car "01" est réservé pour les numéros fixes
    }
}
