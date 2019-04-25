# Get slim opnejdk 8u212 image
FROM openjdk:8u212-slim

# Declare work directory
WORKDIR /usr/app

# Copy JAR into image
COPY target/app.jar /usr/app/app.jar

# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/usr/app/app.jar"]

