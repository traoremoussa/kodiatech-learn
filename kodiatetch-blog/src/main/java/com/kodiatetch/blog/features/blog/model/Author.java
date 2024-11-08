package com.kodiatetch.blog.features.blog.model;

import jakarta.persistence.Id;

public class Author {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;

    private String role; // "AUTHOR", "ADMIN", "READER", etc.
}
