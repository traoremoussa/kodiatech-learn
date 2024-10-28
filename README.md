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
