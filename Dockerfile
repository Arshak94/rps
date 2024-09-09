#FROM openjdk:17-jdk-slim
#WORKDIR /app
#COPY target/rps-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080

#ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage 1: Build the application
FROM maven:3.6.3-openjdk-17-slim as build
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Run mvn clean package to build the application
RUN mvn clean package

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/rps-0.0.1-SNAPSHOT.jar app.jar

# Expose the application's port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]