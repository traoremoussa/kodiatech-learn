[](https://github.com/emad-zaamout/SonarQube-Dockerized/blob/main/scripts/install-sonar-scanner.sh)

- Open a browser and navigate to http://localhost:9000.
  - Default credentials:
    -  Username: admin
    -  Password: admin
[](http://localhost:9000/tutorials?id=kodiatech-etudiant-manager&selectedTutorial=github-actions)

- maven 
  - mvn clean verify sonar:sonar -Dmaven.test.skip=true
  - mvn sonar:sonar -Dsonar.project.settings=sonar-project.properties -Dmaven.test.skip=true
  - docker-compose down
  - docker-compose up -d

