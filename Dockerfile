# Use a base image with Java runtime
FROM adoptopenjdk:20-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application to the container
COPY target/MyFirstProjectE-S-0.0.1-SNAPSHOT.war app.jar

# Expose the application port
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
