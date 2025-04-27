# To use official Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# to use lightweight OpenJDK image to run the app
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/BasicGameArena-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]