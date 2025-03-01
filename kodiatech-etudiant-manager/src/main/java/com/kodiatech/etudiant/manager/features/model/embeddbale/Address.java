package com.kodiatech.etudiant.manager.features.model.embeddbale;

import lombok.Builder;

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
