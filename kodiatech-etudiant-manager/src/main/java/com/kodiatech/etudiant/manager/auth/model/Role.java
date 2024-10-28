package com.kodiatech.etudiant.manager.auth.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", updatable = false, nullable = false)
    private int id;

    @Column(name="ROLE_NAME", updatable = true, nullable = false)
    private String roleName;


}
