package com.kodiatech.etudiant.manager.models;

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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String lastName;
    private String fistName;

    private String email;
    private String phone;

    public Student(String lastName, String fistName, String email, String phone) {
        this.lastName = lastName;
        this.fistName = fistName;
        this.email = email;
        this.phone = phone;

    }


    //embade
    @Embedded
    private Address adress;
    //cour suivi
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_course",  // Nom de la table de jointure
            joinColumns = @JoinColumn(name = "student_id"), // Colonne pour l'étudiant
            inverseJoinColumns = @JoinColumn(name = "course_id") // Colonne pour le cours
    )
    private Set<Course> courses = new HashSet<>();



}
