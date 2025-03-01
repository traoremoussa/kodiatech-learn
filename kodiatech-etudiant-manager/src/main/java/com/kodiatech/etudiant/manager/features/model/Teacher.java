package com.kodiatech.etudiant.manager.features.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodiatech.etudiant.manager.auth.model.Utilisateur;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long  id;

    @NotNull
    @Size(min = 1)
    @Column(name = "LAST_NAME")
    private String lastName;
    @NotNull @Size(min = 1)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[MF]{1}$")
    private String sexe;


    private String email;
    private String phone;

    private LocalDate dateOfBirth;
    private LocalDate enrollmentDate;


    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name = "department_id")// cle etrangere ref id dep
    private Department department;

    @JsonIgnore
    //@JsonManagedReference("teacher-course")  // Correspond à "teacher-course" dans Teacher
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Course> courseSet =new HashSet<>();

    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
}
