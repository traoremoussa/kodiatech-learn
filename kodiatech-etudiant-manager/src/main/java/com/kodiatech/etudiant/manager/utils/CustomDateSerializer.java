package com.kodiatech.etudiant.manager.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // Définir un format personnalisé pour la date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
        gen.writeString(formattedDate);
    }
}