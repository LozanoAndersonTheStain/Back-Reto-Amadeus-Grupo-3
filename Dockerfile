# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and the build.gradle file
COPY gradlew build.gradle /app/
COPY gradle /app/gradle

# Copy the source code
COPY src /app/src

# Copy the settings.gradle file
COPY settings.gradle /app/

# Give execute permission to the Gradle wrapper
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Copy the built jar file to the container
COPY build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]