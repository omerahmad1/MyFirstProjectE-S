# Use a base image with Java runtime
FROM eclipse-temurin:17

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application to the container
COPY target/MyFirstProjectE-S-0.0.1-SNAPSHOT.war  /app.war

# Expose the application port
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-war", "app.war"]
