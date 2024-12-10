## TESTING EVOLUTION 
[BEST spring boot 1.3 à 1.4](https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4)



- pool de connexion (Hikari)



## Bonne Pratique
# Spring Boot REST API Anti Patterns
This is a sample repository to demonstrate some of the common antipatterns in Spring Boot REST API development.

- Not following REST API conventions
  - No proper URL structure
  - Not returning proper HTTP status code
- Using Field Injection
- Not using pagination for collection type resources
- Not using request-specific payload structures (Using entity types as payloads)
- Using JPA DDL auto generation
- Misusing Spring Data JPA derived-query method names
- Loading entire entities and using only a small subset of fields
- Using JPA that results in N+1 Select problems
- Not implementing proper Exception Handling
- Using @SpringBootTest for testing slices (controller, repository)
- Testing with in-memory database
- Not using proper package structure
  - package-by-layer
  - package-by-feature
  - package-by-component
  - Hexagonal
  - Ports & Adapters
  - Clean Code
 








GET    /utilisateurs            // Récupérer tous les utilisateurs
POST   /utilisateurs            // Créer un utilisateur
GET    /utilisateurs/{id}       // Récupérer un utilisateur par ID
PUT    /utilisateurs/{id}       // Mettre à jour un utilisateur par ID
DELETE /utilisateurs/{id}       // Supprimer un utilisateur par ID

GET    /utilisateurs/{id}/commandes   // Récupérer les commandes d'un utilisateur
POST   /utilisateurs/{id}/commandes  // Créer une commande pour un utilisateur
