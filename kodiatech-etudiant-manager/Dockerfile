
# Utiliser l'image OpenJDK comme base
FROM openjdk:11-jre-slim
LABEL authors="TRAORE"
# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR de l'application dans le conteneur
COPY target/myapp.jar /app/myapp.jar

# Exposer le port de l'application
EXPOSE 8080

# Lancer l'application Java
ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
