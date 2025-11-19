#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
# Set a clear working directory for the Maven build
WORKDIR /app
COPY . .
# Run install, skipping tests for faster build times in Docker
RUN mvn clean install -DskipTests

#
# Package stage
#
FROM eclipse-temurin:17-jdk
EXPOSE 8080
# FIX: Use a wildcard (*) to copy the actual JAR file produced by Maven.
# The JAR is located at /app/target/<artifact-id>-<version>.jar
COPY --from=build /app/target/*.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]