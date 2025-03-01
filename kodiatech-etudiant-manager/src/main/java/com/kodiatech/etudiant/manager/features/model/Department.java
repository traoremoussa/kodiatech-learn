package com.kodiatech.etudiant.manager.features.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Department {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_seq")
//    @SequenceGenerator(name = "department_id_seq", sequenceName = "department_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String location;


    //je peux passer par departement pour atteindre les listes de de teacher ou student

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private Set<Student> students = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private Set<Teacher> teachers = new HashSet<>();

}
