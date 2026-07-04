# Hands-on – Hello World RESTful Web Service

## Objective

The objective of this hands-on is to create a simple RESTful Web Service using Spring Boot and Spring Web that returns the text **"Hello World!!"** when a client sends an HTTP GET request.

This exercise also demonstrates the use of Spring MVC annotations, logging, and testing the service using both a web browser and Postman.

---

# Project Structure

```
spring-learn
│
├── pom.xml
│
└── src
    └── main
        ├── java
        │   └── com
        │       └── cognizant
        │           └── springlearn
        │               ├── SpringLearnApplication.java
        │               └── controller
        │                   └── HelloController.java
        │
        └── resources
            └── application.properties
```

---

# Files Used

## 1. SpringLearnApplication.java

This is the entry point of the Spring Boot application.

Responsibilities:

- Starts the Spring Boot application.
- Starts the embedded Tomcat server.
- Initializes the Spring IoC Container.

```java
SpringApplication.run(SpringLearnApplication.class, args);
```

---

## 2. HelloController.java

This class exposes the REST endpoint.

```java
@RestController
```

marks the class as a REST Controller.

```java
@GetMapping("/hello")
```

maps the URL

```
http://localhost:8083/hello
```

to the

```
sayHello()
```

method.

The method returns

```
Hello World!!
```

and includes start and end logs.

---

## 3. application.properties

Application configuration.

```properties
server.port=8083

logging.level.com.cognizant.springlearn=DEBUG
```

---

# REST Endpoint

| Property | Value |
|----------|-------|
| HTTP Method | GET |
| URL | /hello |
| Method | sayHello() |
| Return Type | String |
| Response | Hello World!! |

---

# Program Flow

```
Browser / Postman
        │
        ▼
GET /hello
        │
        ▼
DispatcherServlet
        │
        ▼
HelloController
        │
        ▼
sayHello()
        │
        ▼
Return "Hello World!!"
        │
        ▼
HTTP Response
```

---

# Sample Request

```
GET

http://localhost:8083/hello
```

---

# Sample Response

```
Hello World!!
```

---

# Expected Console Output

```
INFO  START: inside sayHello() method.

INFO  END: inside sayHello() method.
```

---

# Testing

## Browser

Open

```
http://localhost:8083/hello
```

Output

```
Hello World!!
```

---

## Postman

Method

```
GET
```

URL

```
http://localhost:8083/hello
```

Response

```
Hello World!!
```

---

# HTTP Request

An HTTP Request is sent by the client to request a resource from the server.

Example:

```
GET /hello HTTP/1.1

Host: localhost:8083

User-Agent: Chrome / Postman
```

Important parts:

- Request URL
- Request Method
- Headers
- Body (not used for GET)

---

# HTTP Response

The server sends an HTTP Response back to the client.

Example:

```
HTTP/1.1 200 OK

Content-Type: text/plain;charset=UTF-8
```

Response Body

```
Hello World!!
```

---

# RESTful Web Service

REST (Representational State Transfer) is an architectural style for building web services using HTTP.

Advantages:

- Lightweight
- Fast
- Scalable
- Platform Independent
- Easy to Maintain
- Uses standard HTTP methods

Common HTTP Methods:

- GET
- POST
- PUT
- DELETE

---

# Spring Annotations Used

## @SpringBootApplication

Marks the main class as a Spring Boot application and enables auto-configuration and component scanning.

---

## @RestController

Marks the class as a REST Controller.

The return value of every handler method is automatically written to the HTTP response body.

---

## @GetMapping

Maps an HTTP GET request to a controller method.

Example:

```java
@GetMapping("/hello")
```

---

# Logging

The `sayHello()` method includes logging to indicate the start and end of request processing.

```java
LOGGER.info("START: inside sayHello() method.");

LOGGER.info("END: inside sayHello() method.");
```

---

# SME Walkthrough

During the demonstration, the following concepts can be explained:

- HTTP Request and Response
- REST architecture
- `@RestController`
- `@GetMapping`
- Embedded Tomcat
- DispatcherServlet
- HTTP Headers in Browser Developer Tools
- HTTP Headers in Postman
- Logging using SLF4J
- Spring Boot auto-configuration

---

# Conclusion

In this hands-on, a simple RESTful web service was successfully developed using Spring Boot. The service handles an HTTP GET request at `/hello`, logs the execution of the controller method, and returns the response **"Hello World!!"**. The application was verified using both a web browser and Postman, demonstrating the basic workflow of a Spring Boot REST API.