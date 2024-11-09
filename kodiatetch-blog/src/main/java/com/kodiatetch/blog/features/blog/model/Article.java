package com.kodiatetch.blog.features.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Article {
    @Id
    private String id;
    private String title;

    @Lob
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(unique = true)
    private String urlSlug;

   @ManyToOne
   @JoinColumn(name = "author_id")
    private Author author;  // ID de l'auteur (référence à User)


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;


    public void generateSlug() {
        this.urlSlug = this.title.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "") // Garder uniquement les caractères alphanumériques et les espaces
                .replaceAll("\\s+", "-"); // Remplacer les espaces par des tirets
    }

}
