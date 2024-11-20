package com.kodiatech.etudiant.manager.features.messagemodel;


import lombok.Builder;

@Builder
public record ErrorResponse(
        String message,
         String details,
         int statusCode,
         long timestamp) { }
