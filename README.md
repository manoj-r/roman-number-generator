# roman-numeral-app

roman-numeral-app is a webservice that converts an integer value to equivalent roman numeral value.

## Table of contents

* [Installation](#Installation)
* [Technologies](#Technologies)
* [Setup](#Setup)
* [Directory/Package Layout](#Directory/Package-Layout)
* [Testing](#Testing)
* [Logging](#Logging)
* [Metrics](#Metrics)
* [Monitoring](#Monitoring)
* [Note](#Note)
* [References](#Reference)

## Technologies

* Java
* Maven
* Spring Boot 2
* Docker
* Docker-compose
* Prometheus
* Grafana

## Installation

This application is built on Java and its essential to install java(jdk/jre) to compile and run the app

- JAVA: If you don't have java installed in your machine. 
Refer adoptopenjdk https://adoptopenjdk.net/installation.html to download appropriate artifact for your machine. 
Follow the instruction in the page for installation guidelines

- Maven: Maven is the build tool that's used in this project. Refer this link for installation instructions https://maven.apache.org/install.html

- Docker: Though this app can be run without Docker, it's containerized for better distribution of app. 
Refer this location for installation instructions - https://docs.docker.com/install/

- Docker-compose: Docker-compose is used to run the app and other monitoring tools. 
Refer this location for installation instructions - https://docs.docker.com/compose/install/

- Git (optional): This is an optional step to clone/download the project. You can also download the project as zip file from github.
If you don't have Git installed and would like to install it - Refer this link to download Git for your machine. https://git-scm.com/book/en/v2/Getting-Started-Installing-Git.



## Setup

- Download/Clone: Download/clone the project from https://github.com/manoj-r/roman-numeral-app. 

        git clone https://github.com/manoj-r/roman-numeral-app
        
- Build: Run the following command from downloaded directory in a terminal/command line window.

        mvn clean install

**This application uses port 9090 and 3000 for monitoring and visualization. Please make these ports available in your machine.**
*If you cannot free port 9090 and 3000, Please refer the section Note*
- Run: 

    Execute the following commands to run the application.

        docker-compose build
        docker-compose up -d

- To stop the running process:
    
        docker-compose down
        
## Directory/Package-Layout
             
    ├── src  
    |    |── main
    |    |    |── java                                      # Source files  
    |    |    |      |── com.aem.exercise.romannumeral
    |    |    |      |        |── controller                # package to hold rest resource 
    |    |    |      |        |── service                   # service layer packages that hold classes responsibl for conversion          
    |    |    |      |        |── exception                 # exception classes       
    |    |    |      |        |── dto                       # package to hold dtos                
    |    |    |── resources                                 # Resource files
    |    |── test 
    |    |    |── java                                      # Test source files
    |    |    |── resources                                 # test resources
    ├── grafana                                             # volume for grafana app - contains dahsboard
    |__ prometheus                                          # volume for prometheus - also contains prometheus config file
    ├── LICENSE
    └── README.md
    |__ Dockerfile
    |__ docker-compose.yml
    |__ pom.xml                                             # build file


## Testing

### Unit Testing:

Junit is the the testing framework used in the project. Mockito is the mock framework used to mock service objects. 
All the unit test cases are available under directory src/test.

### Integration Testing

SpringBootTest is the framework used for integration test. It checks for appropriate response codes
src/test/java/com/aem/exercise/romannumeral/RomanNumeralIntegrationTests.java contains the integration tests.


## Logging

This project uses Logback as the logging framework. Config file for the same can be found in src/main/resources/logback.xml
Application will create a directory called logs and add a log file when you run the application.

## Metrics

This project uses Spring Boot Actuator for management console which also provides metrics details. 
Metrics can be found https://localhost:8080/actuator/metrics/<metric name>
Actuator http://localhost:8080/actuator is the hateos resource for all the management information available.

## Monitoring

Thought Spring Boot Actuator provides necessary tools for Monitoring, this application uses Prometheus and grafana for visualization.
This can be accessed from 

        http://localhost:3000 
with credentials (admin/password). A dashboard has already been built and added to the project
which should automatically when you run docker-compose.


## Note

If you are trying to run the application and cannot free port 9090 and 3000, run the below command from project directory 

        mvn spring-boot:run


## Reference
https://en.wikipedia.org/wiki/Roman_numerals#Vinculum
https://www.convert-me.com/en/convert/hex_octal_binary_roman/?u=numdec&v=2%20200%20000%20000
