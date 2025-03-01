package com.kodiatech.etudiant.manager.student.controller;


import com.kodiatech.etudiant.manager.features.controllers.StudentController;
import com.kodiatech.etudiant.manager.features.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@WebMvcTest(controllers =StudentController.class)
public class StudentControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private IStudentService studentService;

    @Test
    public void getHello() throws Exception {
//
        when(studentService.hello()).thenReturn("hello toulouse ok gg");

        mvc.perform(get("/api/student/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello toulouse ok gg")));
    }

    @Test
    public void getHello2() throws Exception {


        mvc.perform(get("/api/student/hh")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello toulouse ok gg")));
    }
}


/***
 *
 *@SpringBootTest : si je veux demarer le context complet de spring (Test integration ou j'ai besoin du context generale)
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) : Cela signifie que Spring Boot démarrera un serveur web embarqué
 * (comme Tomcat) sur un port aléatoire
 * Quand l'utiliser : Lorsque vous avez besoin de tester des composants web, par exemple des appels HTTP via un contrôleur REST,
 * tout en démarrant un serveur web dans un environnement d'intégration.
 *
 *@AutoConfigureMockMvc un outil qui permet de simuler des requêtes HTTP sans
 * démarrer un serveur web réel. MockMvc est utilisé pour tester des contrôleurs
 * dans des tests d'intégration sans avoir besoin de lancer un serveur réel.
 *Vous l'utilisez lorsque vous souhaitez tester les contrôleurs
 * (et non l'intégralité de l'application) sans démarrer un serveur web réel.
 *
 *pour tester des contrôleurs sans démarrer un serveur web.
 *
 *Utilisez @AutoConfigureTestDatabase(replace = NONE) pour conserver la configuration de votre base de données réelle.
 * données configurée dans votre environnement (par exemple, une base de données PostgreSQL ou MySQL).
 * Cette annotation est utilisée pour configurer la base de données dans les tests. Par défaut, Spring Boot remplace la base
 * de données configurée par une base de données
 * en mémoire (comme H2) pour les tests, mais en utilisant cette annotation, vous pouvez désactiver ce comportement.
 *
 *
 */