# Build stage
FROM maven:3.9.8-eclipse-temurin-22-alpine AS builder

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# Build the application
RUN mvn clean verify

# Runtime stage
FROM eclipse-temurin:22-jre-alpine

# Copy the JAR file from the build stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port on which the app will run
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
