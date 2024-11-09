package com.kodiatetch.blog.features.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/article")
public class ArticleController {


    @GetMapping("/list")
    public String featchArticles(){
        return "Liste des articles";
    }
}
