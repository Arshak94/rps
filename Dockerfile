# Stage 1: Build the application
FROM maven:3.6.3-openjdk-17-slim as build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/target/rps-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]