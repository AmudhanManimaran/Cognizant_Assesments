# Spring Boot - Hands-on 1  
## Create a Spring Web Project using Maven

### Objective

Create a Spring Boot web project using Maven, configure it using Spring Initializr, and verify that the application starts successfully by adding a log statement in the `main()` method.

---

## Software Used

- Java 17 or later
- Spring Boot 3.1.5
- Maven
- Eclipse / IntelliJ IDEA
- Spring Initializr

---

## Project Structure

```
spring-learn/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── cognizant/
    │   │           └── springlearn/
    │   │               └── SpringLearnApplication.java
    │   └── resources/
    │       ├── application.properties
    │       ├── static/
    │       └── templates/
    └── test/
        └── java/
            └── com/
                └── cognizant/
                    └── springlearn/
                        └── SpringLearnApplicationTests.java
```

---

## Project Configuration

The project was created using **Spring Initializr** with the following settings:

- Group: `com.cognizant`
- Artifact: `spring-learn`

Selected Dependencies:

- Spring Web
- Spring Boot DevTools

---

## Logging Configuration

`application.properties`

```properties
logging.level.com.cognizant.springlearn=INFO
```

---

## Main Class

`SpringLearnApplication.java`

```java
package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringLearnApplication.class, args);

        LOGGER.info("Inside main");
    }
}
```

---

## Project Walkthrough

### src/main/java

Contains all Java source files of the application.

---

### src/main/resources

Contains configuration files and other application resources.

The `application.properties` file is used to configure logging and other application settings.

---

### src/test/java

Contains test classes for the application.

---

### SpringLearnApplication.java

This is the entry point of the Spring Boot application.

The `main()` method calls:

```java
SpringApplication.run(...)
```

which starts the Spring Boot application, creates the application context, and launches the embedded Tomcat server.

A log statement is added to verify that the `main()` method executes successfully.

---

### @SpringBootApplication

`@SpringBootApplication` is a convenience annotation that combines:

- `@Configuration`
- `@EnableAutoConfiguration`
- `@ComponentScan`

It enables auto-configuration and component scanning, making Spring Boot applications easier to develop with minimal configuration.

---

### pom.xml

The `pom.xml` file manages the project's dependencies and build configuration.

The main dependencies used are:

- Spring Boot Starter Web
- Spring Boot DevTools
- Spring Boot Starter Test

Spring Boot automatically downloads all required transitive dependencies through Maven.

---

## Expected Output

```
:: Spring Boot ::

Tomcat started on port(s): 8080 (http)

Started SpringLearnApplication

Inside main
```

---

## Result

The Spring Boot web project was created successfully using Maven.

The application started successfully, the embedded Tomcat server was initialized, and the log message confirmed that the `main()` method executed successfully.

---
