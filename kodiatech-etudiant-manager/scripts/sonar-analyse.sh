#!/bin/bash

# Charger les variables d'environnement depuis un fichier .env (facultatif)
if [ -f .env ]; then
  export $(grep -v '^#' .env | xargs)
fi

# Définir les paramètres SonarQube
SONAR_PROJECT_KEY="kodiatech-etudiant-manager"
SONAR_HOST_URL="http://localhost:9000"
SONAR_LOGIN="${SONAR_TOKEN}"  # Utilise la variable d'environnement SONAR_TOKEN

# Vérifier si le token est défini
if [ -z "$SONAR_LOGIN" ]; then
  echo "Error: SONAR_TOKEN is not set. Please set it in the environment or .env file."
  exit 1
fi

# Exécuter l'analyse avec Maven
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=$SONAR_PROJECT_KEY \
  -Dsonar.host.url=$SONAR_HOST_URL \
  -Dsonar.login=$SONAR_LOGIN
