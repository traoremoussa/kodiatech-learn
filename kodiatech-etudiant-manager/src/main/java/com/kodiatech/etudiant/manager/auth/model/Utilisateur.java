package com.kodiatech.etudiant.manager.auth.model;

import com.kodiatech.etudiant.manager.features.model.Student;
import com.kodiatech.etudiant.manager.features.model.Teacher;
import com.kodiatech.etudiant.manager.features.validation.ValidPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

@Table(name="UTILISATEUR")
public class Utilisateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", updatable = false, nullable = false)
    private Long id;

    @NotEmpty(message = "Le nom d'utilisateur ne doit pas être vide")
    @Size(min = 3, max = 20, message = "Le nom d'utilisateur doit contenir entre 3 et 20 caractères")
    @Column(name = "USERNAME", unique=true, insertable=true, updatable=true, nullable=false)
    private String username;

    @NotEmpty(message = "Le mot de passe ne doit pas être vide")
    @Column(name = "USER_PASSWORD", insertable=true, updatable=true, nullable=false)
    @ValidPassword
    private String password;




    @Column(name = "USER_ACTIVE", insertable=true, updatable = true, nullable=false)
    private Integer active;


    // vas creer table d'association automatiquement
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<Role> roles= new HashSet<>();


   // -------

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Student student;
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Teacher teacher;
}
