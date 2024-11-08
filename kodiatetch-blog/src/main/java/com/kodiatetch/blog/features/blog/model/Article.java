package com.kodiatetch.blog.features.blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Article {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String urlSlug;


    private String authorId;  // ID de l'auteur (référence à User)



    public void generateSlug() {
        this.urlSlug = this.title.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "") // Garder uniquement les caractères alphanumériques et les espaces
                .replaceAll("\\s+", "-"); // Remplacer les espaces par des tirets
    }

}
