package com.kodiatetch.blog.features.blog.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Author {
    @Id
    private String id;

    //AUTHENTIFICATION
    private String username;
    private String email;
    private String password;
    private String role; // "AUTHOR", "ADMIN", "READER", etc.
    //----------------------------------------------------------------
    private String bio;
    private String name;

    @Lob
    @Column(name = "profileImage", columnDefinition="BLOB")
    private byte[] profileImage;


    //A unique identifier (often lowercase name with hyphens, e.g., jane-doe).
    @Column(unique = true)
    private String urlSlug;


    @OneToMany(mappedBy = "author")
    private List<Article> articles; // List of posts written by the author

}
