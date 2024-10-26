package com.kodiatech.etudiant.manager.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address {

    private String name;
    private String city;

    private String country;
    private String street;
    private String number;


}
