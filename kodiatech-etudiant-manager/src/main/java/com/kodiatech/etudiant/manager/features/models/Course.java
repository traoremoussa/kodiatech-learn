package com.kodiatech.etudiant.manager.features.models;


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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long  id;

    private String title;
    private String description;
    //coef du cours ou  de   la matiere
    private  Integer coefcicient;




    // liaison


    @ManyToOne
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")  // Indique que c'est le côté inverse de la relation
    private Set<Student> students = new HashSet<>();


}
