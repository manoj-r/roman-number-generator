# Get slim opnejdk 8u212 image
FROM openjdk:8u212-slim

# Declare work directory
WORKDIR /usr/app

# Copy JAR into image
COPY ./target/app.jar /usr/app/app.jar

COPY src/main/resources/logback.xml /usr/app/logback.xml

# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "-Dlogging.config=/usr/app/logback.xml", "/usr/app/app.jar"]

