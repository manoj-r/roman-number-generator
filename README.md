# roman-numeral-app

roman-numeral-app is a webservice that converts an integer value to equivalent roman numeral value.

## Table of contents

* [Installation](#Installation)
* [Technologies](#Technologies)
* [Setup](#Setup)
* Layout

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
        
- Build: Run the following command from downloaded directory

        mvn clean install

- Run: 

        docker-compose up -d
        
## Directory/Package Layout
             
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
    ├── docker                                              # Docker volumes and config location
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


### Logging

This project uses Logback as the logging framework. Config file for the same can be found in 


## Reference
https://en.wikipedia.org/wiki/Roman_numerals#Vinculum
https://www.convert-me.com/en/convert/hex_octal_binary_roman/?u=numdec&v=2%20200%20000%20000