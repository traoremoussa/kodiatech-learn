L'annotation `@JsonBackReference` est utilisée dans le contexte de la sérialisation JSON avec Jackson, notamment pour gérer les relations bidirectionnelles entre entités. Voici comment cela fonctionne :

### Contexte

Lorsque vous avez deux classes qui se référencent mutuellement, par exemple, une relation `OneToMany` (un à plusieurs) ou `ManyToMany` (plusieurs à plusieurs), cela peut créer des problèmes de sérialisation, car Jackson peut entrer dans une boucle infinie en essayant de sérialiser les objets liés.

### Utilisation de `@JsonBackReference`

- **`@JsonManagedReference`** : Utilisée sur la partie "d'origine" de la relation, celle qui doit être sérialisée normalement.
- **`@JsonBackReference`** : Utilisée sur la partie "inverse" de la relation, celle qui ne doit pas être sérialisée pour éviter les boucles.

### Exemple

Prenons un exemple de deux classes, `Student` et `Course`, où un étudiant peut suivre plusieurs cours :

```java
public class Student {
    private Long id;
    private String name;

    @JsonManagedReference
    private List<Course> courses; // Sérialisé normalement

    // Getters et Setters
}

public class Course {
    private Long id;
    private String title;

    @JsonBackReference
    private Student student; // Ne sera pas sérialisé pour éviter la boucle

    // Getters et Setters
}
```

