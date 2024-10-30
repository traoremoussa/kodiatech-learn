package com.kodiatech.etudiant.manager.features.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long  id;

    @NotNull
    @Size(min = 1)
    private String lastName;
    @NotNull @Size(min = 1)
    private String fistName;

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
}
