package com.kodiatech.etudiant.manager.features.model;


import com.kodiatech.etudiant.manager.utils.TypeEvaluation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private double note;
    private double pourcentage;

    @Enumerated(EnumType.STRING)
    private TypeEvaluation typeEvalution;




    private LocalDate dateOfEvaluation;

    // etudient noté
    @ManyToOne
   // @Column(name = "student_id")
    private Student student;
    //course note
    @ManyToOne(cascade=CascadeType.ALL)
    //@Column(name = "course_id")
    private Course course;
    //professeur qui a noté
    @ManyToOne
    private Teacher teacher;
}
