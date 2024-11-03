# kodiatech-learn


To show all available actuator endpoints in your Spring Boot application, you can access the `/actuator` endpoint. Here's how to do it:

### 1. Enable Endpoint Exposure
First, ensure that you have enabled the actuator endpoints in your configuration file (`application.yml` or `application.properties`).

#### For `application.yml`:
```yaml
management:
  endpoints:
    web:
      exposure:
        include: "*"
```

#### For `application.properties`:
```properties
management.endpoints.web.exposure.include=*
```

### 2. Access the Actuator Endpoint
Once your application is running, you can access the list of all actuator endpoints by navigating to:

```
http://localhost:8080/actuator
```

### 3. Expected Output
When you access the `/actuator` endpoint, you should see a JSON response that lists all the available endpoints, like this:

```json
{
  "_links": {
    "self": {
      "href": "http://localhost:8080/actuator",
      "templated": false
    },
    "health": {
      "href": "http://localhost:8080/actuator/health",
      "templated": false
    },
    "info": {
      "href": "http://localhost:8080/actuator/info",
      "templated": false
    },
    "shutdown": {
      "href": "http://localhost:8080/actuator/shutdown",
      "templated": false
    }
   
  }
}
```

### 4. Testing the Endpoint
You can use tools like `curl`, Postman, or your browser to make a GET request to the `/actuator` endpoint:

```bash
curl http://localhost:8080/actuator
```

### Conclusion
If the `/actuator` endpoint does not return the expected list of endpoints, double-check your configuration and ensure the application is running correctly. If you need further assistance, let me know!


https://github.com/containers/podman-compose/blob/main/examples/awx3/docker-compose.yml
(`https://howtodoinjava.com/spring-boot2/sb-multi-module-maven-project/ `)


In IntelliJ IDEA, you can format your code to improve readability and maintain coding standards. Here’s how to do it:

### Formatting Code
- `Ctrl + Alt + L`
  Dans IntelliJ IDEA, les raccourcis clavier peuvent grandement améliorer votre productivité. Voici quelques-uns des raccourcis les plus utiles :

### Navigation
- **Ctrl + N** : Rechercher une classe.
- **Ctrl + Shift + N** : Rechercher un fichier.
- **Ctrl + Alt + Shift + N** : Rechercher un symbole (méthode, variable, etc.).
- **Ctrl + E** : Ouvrir la liste des fichiers récemment utilisés.
- **Ctrl + Shift + E** : Ouvrir la liste des fichiers récemment modifiés.

### Édition de Code
- **Ctrl + Space** : Complétion de code de base.
- **Ctrl + Shift + Space** : Complétion intelligente (propose des suggestions plus pertinentes).
- **Ctrl + /** : Commenter/décommenter une ligne de code. (yml ou yaml on peut faire sur tout)
- **Ctrl + Shift + /** : Commenter/décommenter un bloc de code.
- **Ctrl + D** : Dupliquer la ligne actuelle.
- **Alt + Enter** : Afficher les suggestions de correction ou de changement contextuel.

### Refactoring
- **Ctrl + R** : Renommer une variable ou une méthode.
- **Ctrl + Alt + M** : Extraire une méthode.
- **Ctrl + Alt + V** : Extraire une variable.
- **Ctrl + Alt + F** : Extraire un champ.

### Exécution et Débogage
- **Shift + F10** : Exécuter l'application.
- **Shift + F9** : Déboguer l'application.
- **F8** : Passer à la ligne suivante lors du débogage.
- **F7** : Entrer dans la méthode lors du débogage.

### Autres Raccourcis Utiles
- **Ctrl + Shift + F12** : Masquer/afficher tous les outils.
- **Alt + 1** : Afficher/masquer le panneau de projet.
- **Ctrl + Shift + A** : Ouvrir une action (rechercher une action ou une option dans les menus).
- **Ctrl + Shift + F** : Rechercher dans tout le projet.

### Personnaliser les Raccourcis
Vous pouvez également personnaliser les raccourcis dans IntelliJ :
1. Allez dans **File > Settings** (ou **IntelliJ IDEA > Preferences** sur macOS).
2. Allez dans **Keymap** pour voir et modifier les raccourcis.

