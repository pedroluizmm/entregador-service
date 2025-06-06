# Entregador Service

This service uses Spring Boot and requires a local secrets file to run.

1. Copy `src/main/resources/application-secret.properties.example` to
   `src/main/resources/application-secret.properties`.
2. Adjust the MongoDB URI and other credentials as needed.
3. Run the service with Maven:
   ```sh
   ./mvnw spring-boot:run
   ```

The secrets file is ignored by git to avoid committing sensitive data.
