package com.kodiatech.etudiant.manager.features.model.embeddbale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record Address (

     String name,
     String city,

     String country,
     String street,
     String number,
     String codePostal)

{
}
