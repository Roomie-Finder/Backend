# --- Stage 1: Build the Application ---
FROM maven:3.9-eclipse-temurin-17-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven project files (pom.xml) to download dependencies
COPY pom.xml .

# Download dependencies to leverage Docker layer caching
# If dependencies haven't changed, this layer is skipped.
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Package the application into a JAR file
RUN mvn clean install -DskipTests

# --- Stage 2: Create the Final Production Image ---
# Use a minimal JRE image for the smallest possible runtime size
FROM eclipse-temurin:17-jre-alpine

# Expose the default Spring Boot port (or use the $PORT variable)
EXPOSE 8080

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder stage
# Assuming your final JAR is named 'target/your-app-name.jar' (adjust if necessary)
# For most Spring Boot apps, it's safe to use the pattern:
COPY --from=builder /app/target/*.jar app.jar

# Define the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]