package com.kodiatech.etudiant.manager.features.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kodiatech.etudiant.manager.auth.model.Utilisateur;
import com.kodiatech.etudiant.manager.features.validation.PhoneNumber;
import com.kodiatech.etudiant.manager.utils.CustomDateSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

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
public class Student {

    @Id

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
//    @SequenceGenerator(name = "student_id_seq", sequenceName = "student_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotEmpty(message = "lastName may not be null")
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotEmpty(message = "first name may not be null")
    @Column(name = "FIRST_NAME")
    private String firstName;


    @Pattern(regexp = "^[MF]{1}$", message = "must match \"^[MF]{1}$\"")
    private String sexe;


    @NotEmpty
    @Email(message = "must be a well-formed email address")
    private String email;

    @NotEmpty(message = "Phone may not be null")
    @PhoneNumber
    private String phone;

    @NotNull(message = "Date de naissance may not be null")
    @PastOrPresent(message = "Date of Birth must be in the past or present")

    @JsonSerialize(using = CustomDateSerializer.class)  // Serializer personnalisé
    @JsonFormat(pattern = "yyyy-MM-dd")  // Format de la date
    private LocalDate dateOfBirth;

    @NotNull(message = "enregistrement date may not be null")
    //@Future(message = "Enrollment Date must be in the future")
    private LocalDate enrollmentDate;


    public Student(String lastName, String fistName, String sexe, String email, String phone, LocalDate dateOfBirth, LocalDate enrollmentDate) {
        this.lastName = lastName;
        this.firstName = fistName;
        this.sexe = sexe;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;

    }


    //embade
    @Embedded
    private Address adress;


    // Prevents infinite recursion in the student-to-course direction
    //cour suivi
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_course",  // Nom de la table de jointure
            joinColumns = @JoinColumn(name = "student_id"), // Colonne pour l'étudiant
            inverseJoinColumns = @JoinColumn(name = "course_id") // Colonne pour le cours
    )
    //@JsonManagedReference("student-course")
    private Set<Course> courses = new HashSet<>();


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "department_id")// cle etrangere ref id dep
    private Department department;

    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;


    /***
     *@NotNull: a constrained CharSequence, Collection, Map, or Array is valid as long as it’s not null, but it can be empty.
     * @NotEmpty: a constrained CharSequence, Collection, Map, or Array is valid as long as it’s not null, and its size/length is greater than zero.
     * @NotBlank: a constrained String is valid as long as it’s not null, and the trimmed length is greater than zero.
     * @notnull
    /***
     * @JsonBackReference
     * @JsonIgnore
     *
     * @ManyToMany
     *
     * @ManyToOne
     *
     * mappedBy : on met dans la classe parent, ou ne se trouve pas la clé etrangere (attribut class parent(responsabilité))
     *
     *COMME ICI ON VOIT CLE ETRANGERE ( chez son parent on va mappedBy) pour assurer bidirectionnelle  
     * utilisateur_id
     *
     * department_id
     */


    /**
     SQL AST Tree:

     The SQL Abstract Syntax Tree (AST) indicates how the query will be structured.
     The FromClause shows that it will select from the Student table,
     and it includes a join with the address and a left join with the department.
     */


    /**** gERER pRIMARY KEY
     *
     * https://thorben-janssen.com/jpa-generate-primary-keys/
     *
     *
     *
     *
     */

}
