# Hands-on Exercise: REST - Country Web Service

## Objective

Develop a RESTful Web Service using Spring Boot that returns the details of the country **India** in JSON format. The country details are loaded from a Spring XML configuration file and exposed through a REST endpoint.

---

## Project Structure

```text
spring-learn
│
├── pom.xml
│
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── cognizant
    │   │           └── springlearn
    │   │               ├── SpringLearnApplication.java
    │   │               ├── Country.java
    │   │               └── controller
    │   │                   ├── HelloController.java
    │   │                   └── CountryController.java
    │   │
    │   └── resources
    │       ├── application.properties
    │       └── country.xml
    │
    └── test
        └── java
            └── com
                └── cognizant
                    └── springlearn
                        └── SpringLearnApplicationTests.java
```

---

# Technologies Used

- Java 17
- Spring Boot 3.1.5
- Spring Web
- Maven
- Embedded Apache Tomcat
- SLF4J Logging
- Jackson JSON Processor

---

# Project Description

This application demonstrates the implementation of a simple RESTful Web Service using Spring Boot.

The application loads the **India** bean from the Spring XML configuration file (`country.xml`) using the Spring IoC Container and exposes it through the REST endpoint:

```
GET /country
```

When the endpoint is invoked, Spring automatically converts the returned `Country` object into JSON using the Jackson library.

---

# REST Endpoint

| Request Method | URL | Description |
|---------------|-----|-------------|
| GET | `/country` | Returns India country details |

---

# Sample Request

```
http://localhost:8083/country
```

---

# Sample Response

```json
{
    "code": "IN",
    "name": "India"
}
```

---

# Application Flow

1. The client (Browser/Postman) sends an HTTP GET request to `/country`.
2. Spring Boot's **DispatcherServlet** receives the request.
3. DispatcherServlet maps the request to the `getCountryIndia()` method in `CountryController`.
4. The controller retrieves the **Country** bean from the Spring XML configuration using `ApplicationContext`.
5. The `Country` object is returned by the controller.
6. Spring MVC automatically converts the object into JSON using Jackson.
7. The JSON response is sent back to the client with **HTTP Status 200 (OK)**.

---

# XML Bean Configuration

The `country.xml` file contains the bean definition for India.

```xml
<bean id="in" class="com.cognizant.springlearn.Country">
    <property name="code" value="IN"/>
    <property name="name" value="India"/>
</bean>
```

---

# How JSON Conversion Works

The project includes the dependency:

```
spring-boot-starter-web
```

This dependency automatically includes the **Jackson** library.

When the controller returns a `Country` object, Spring MVC internally uses **MappingJackson2HttpMessageConverter** to serialize the Java object into JSON.

Jackson invokes the getter methods:

- `getCode()`
- `getName()`

to generate the following JSON response:

```json
{
    "code": "IN",
    "name": "India"
}
```

No additional JSON conversion code is required.

---

# Logging

Logging is implemented using **SLF4J**.

The controller logs:

- Start of request processing
- Country object details
- End of request processing

Sample log:

```
INFO  CountryController : START: getCountryIndia()

DEBUG CountryController : Country : Country [code=IN, name=India]

INFO  CountryController : END: getCountryIndia()
```

Jackson invokes the getter methods while converting the object to JSON.

Therefore, the following logs are also displayed:

```
DEBUG Country : Inside getCode.
DEBUG Country : Inside getName.
```

---

# HTTP Request

```
GET /country HTTP/1.1
Host: localhost:8083
Accept: application/json
```

---

# HTTP Response

```
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 29
Connection: keep-alive
```

---

# Browser Verification

Run the application and open:

```
http://localhost:8083/country
```

Expected output:

```json
{
    "code": "IN",
    "name": "India"
}
```

---

# Postman Verification

Method:

```
GET
```

URL:

```
http://localhost:8083/country
```

Expected Response:

```json
{
    "code": "IN",
    "name": "India"
}
```

Status:

```
200 OK
```

---

# SME Discussion Points

## What happens inside the controller?

- Browser/Postman sends an HTTP GET request.
- DispatcherServlet receives the request.
- DispatcherServlet maps the request to `getCountryIndia()`.
- The controller retrieves the `Country` bean from the Spring XML configuration using `ApplicationContext`.
- The `Country` object is returned.
- Spring MVC converts the object into JSON.
- JSON is sent back to the client with HTTP Status **200 OK**.

---

## How is the bean converted into JSON?

- `spring-boot-starter-web` automatically includes the Jackson library.
- Spring MVC uses **MappingJackson2HttpMessageConverter** to convert the `Country` object into JSON.
- Jackson calls the getter methods (`getCode()` and `getName()`) to generate the JSON response.

---

## HTTP Headers (Browser Developer Tools)

### Request Headers

```
GET /country HTTP/1.1
Host: localhost:8083
User-Agent: Mozilla/Chrome
Accept: application/json
```

### Response Headers

```
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 29
Connection: keep-alive
Date: ...
```

---

## HTTP Headers (Postman)

### Request Headers

```
Accept: */*
Host: localhost:8083
User-Agent: PostmanRuntime
```

### Response Headers

```
Content-Type: application/json
Content-Length: 29
Connection: keep-alive
Date: ...
```

---

# Conclusion

This hands-on demonstrates how to build a RESTful Web Service using Spring Boot that loads a bean from a Spring XML configuration file and exposes it through a REST endpoint. The application showcases Spring MVC request handling, Spring IoC for bean management, automatic JSON serialization using Jackson, SLF4J logging, and successful testing using both a web browser and Postman.