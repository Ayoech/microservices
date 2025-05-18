# Stage 1: Build the application
FROM gradle:8.5-jdk17 AS builder

# Set the working directory
WORKDIR /app

# Copy everything to the container
COPY . .

# Run the build (this will generate the JAR file in /app/build/libs)
RUN gradle bootJar

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the default port for Spring Boot (adjust if your app uses a different one)
EXPOSE 8090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
