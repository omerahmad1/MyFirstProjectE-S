# Use a base image with Java runtime
FROM eclipse-temurin:17

# Set the working directory in the container
ADD ${JAR_FILE} app.jar

# Copy the packaged Spring Boot application to the container

ARG JAR_FILE=target/MyFirstProjectE-S-0.0.1-SNAPSHOT.war
# Expose the application port
EXPOSE 9090

# Define the command to run the application
CMD ["java", "-war", "/app.war"]
