
# Utiliser l'image OpenJDK comme base
FROM openjdk:24-slim-bullseye
LABEL authors="TRAORE"
# Définir le répertoire de travail
WORKDIR /app
ARG JAR_FILE=target/*.jar

# Copier le JAR de l'application dans le conteneur
COPY ${JAR_FILE} /app/kodiatech-student-manager.jar

# Exposer le port de l'application
EXPOSE 8080

# Lancer l'application Java
ENTRYPOINT ["java", "-jar", "/app/kodiatech-student-manager.jar"]
