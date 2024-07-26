# Use a Gradle image to build the application
FROM gradle:7.6.0-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and the build.gradle file
COPY build.gradle settings.gradle /app/

# Copy the source code
COPY src /app/src

# Build the application
RUN gradle build --no-daemon

# Use a JDK 17 image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built application from the build stage
COPY --from=build /app/build/libs/*.war app.war

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.war"]
