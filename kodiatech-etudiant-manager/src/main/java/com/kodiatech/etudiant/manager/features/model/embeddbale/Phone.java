package com.kodiatech.etudiant.manager.features.model.embeddbale;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

public record Phone(
        String type,
        String areaCode,
        @Column(name = "P_NUMBER")
        String number) {


    //https://en.wikibooks.org/wiki/Java_Persistence/ElementCollection
   // https://github.com/sivaprasadreddy/sivalabs-youtube-code-samples/blob/main/spring-boot-rest-api-antipatterns/src/main/java/com/sivalabs/myapp/entities/Person.java
}