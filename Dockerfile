# Use a lightweight Java Runtime
FROM eclipse-temurin:21-jre

# Create a working directory inside container
WORKDIR /app

# Copy the pre-built jar from local target/ folder
COPY target/BasicGameArena-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]