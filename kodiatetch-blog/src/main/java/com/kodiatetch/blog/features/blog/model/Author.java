package com.kodiatetch.blog.features.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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
    private String profileImageUrl; // URL to profile image
    //A unique identifier (often lowercase name with hyphens, e.g., jane-doe).
    @Column(unique = true)
    private String urlSlug;


    @OneToMany(mappedBy = "author")
    private List<Article> articles; // List of posts written by the author

}
