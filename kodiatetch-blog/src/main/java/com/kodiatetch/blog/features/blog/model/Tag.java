package com.kodiatetch.blog.features.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;
@Entity
public class Tag {

    @Id
    private Long id;

    private String name;

    @Column(unique = true)
    private String urlSlug;

    @ManyToMany(mappedBy = "tags")
    private List<Article> articles;
}
