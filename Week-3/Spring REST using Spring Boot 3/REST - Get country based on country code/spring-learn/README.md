# Hands-on Exercise: REST - Get Country Based on Country Code

## Objective

Develop a RESTful Web Service that returns the details of a country based on the country code provided in the URL. The country code matching should be **case-insensitive**.

---

## Project Structure

```text
spring-learn
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── cognizant
│   │   │           └── springlearn
│   │   │               ├── SpringLearnApplication.java
│   │   │               ├── Country.java
│   │   │               ├── controller
│   │   │               │   ├── HelloController.java
│   │   │               │   └── CountryController.java
│   │   │               └── service
│   │   │                   └── CountryService.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── country.xml
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── cognizant
│                   └── springlearn
│                       └── SpringLearnApplicationTests.java
```

---

## Technologies Used

- Java 17
- Spring Boot 3.1.5
- Spring Web
- Maven
- Spring Core (XML Configuration)
- Jackson (JSON Serialization)
- SLF4J Logging

---

## Endpoint Details

| HTTP Method | URL | Description |
|-------------|-----|-------------|
| GET | `/countries/{code}` | Returns the country matching the given country code |

---

## URL Mapping

```java
@GetMapping("/countries/{code}")
```

The country code is received using the `@PathVariable` annotation and passed to the service layer.

---

## Service Implementation

The `CountryService` performs the following operations:

- Loads the country list from `country.xml`.
- Retrieves the `countryList` bean.
- Searches for the requested country.
- Performs **case-insensitive** comparison using `equalsIgnoreCase()`.
- Returns the matching `Country` object.

A Java Stream with a Lambda expression is used for searching.

---

## Country Configuration (country.xml)

The Spring XML configuration contains the following countries:

| Country Code | Country Name |
|--------------|--------------|
| US | United States |
| DE | Germany |
| IN | India |
| JP | Japan |

---

## Sample Requests and Responses

### India

**Request**

```
GET http://localhost:8083/countries/in
```

**Response**

```json
{
  "code": "IN",
  "name": "India"
}
```

---

### United States

**Request**

```
GET http://localhost:8083/countries/us
```

**Response**

```json
{
  "code": "US",
  "name": "United States"
}
```

---

### Germany

**Request**

```
GET http://localhost:8083/countries/de
```

**Response**

```json
{
  "code": "DE",
  "name": "Germany"
}
```

---

### Japan

**Request**

```
GET http://localhost:8083/countries/jp
```

**Response**

```json
{
  "code": "JP",
  "name": "Japan"
}
```

---

## Case-Insensitive Search

Since the service uses `equalsIgnoreCase()`, the following URLs all return the same result.

### India

```
/countries/IN
/countries/in
/countries/In
/countries/iN
```

### United States

```
/countries/US
/countries/us
/countries/Us
/countries/uS
```

### Germany

```
/countries/DE
/countries/de
/countries/De
/countries/dE
```

### Japan

```
/countries/JP
/countries/jp
/countries/Jp
/countries/jP
```

---

## How the Request is Processed

1. The client sends a **GET** request to `/countries/{code}`.
2. Spring Boot's **DispatcherServlet** receives the request.
3. DispatcherServlet maps the request to `CountryController.getCountry()`.
4. The `@PathVariable` extracts the country code from the URL.
5. The controller invokes `CountryService.getCountry(code)`.
6. The service loads `country.xml`.
7. Spring creates the `countryList` bean.
8. The service searches the list using a **case-insensitive** comparison.
9. The matching `Country` object is returned to the controller.
10. Spring MVC uses **MappingJackson2HttpMessageConverter** (Jackson) to convert the Java object into JSON.
11. The JSON response is sent back to the client with **HTTP Status 200 OK**.

---

## JSON Conversion

The controller returns a `Country` object.

```java
return country;
```

Spring Boot automatically converts this Java object into JSON because the `spring-boot-starter-web` dependency includes the **Jackson** library.

No manual JSON conversion is required.

---

## HTTP Response

**Status Code**

```
200 OK
```

**Content-Type**

```
application/json
```

Example Response:

```json
{
  "code": "IN",
  "name": "India"
}
```

---

## Logging

The controller includes logs to trace request execution.

Example console output:

```
INFO  CountryController : START - getCountry()

DEBUG Country : Inside Country Constructor.
DEBUG Country : Inside setCode.
DEBUG Country : Inside setName.

DEBUG Country : Inside getCode.
DEBUG Country : Inside getName.

DEBUG CountryController : Country : Country [code=IN, name=India]

INFO  CountryController : END - getCountry()
```

---

## Concepts Covered

- RESTful Web Services
- Spring Boot
- Spring MVC
- `@RestController`
- `@GetMapping`
- `@PathVariable`
- Service Layer
- Spring XML Configuration
- ApplicationContext
- Java Streams
- Lambda Expressions
- Case-Insensitive Search
- JSON Serialization using Jackson
- SLF4J Logging

---

## Expected Output

Accessing the following URL:

```
http://localhost:8083/countries/in
```

returns:

```json
{
  "code": "IN",
  "name": "India"
}
```

Similarly,

```
http://localhost:8083/countries/us
```

returns:

```json
{
  "code": "US",
  "name": "United States"
}
```

---

## Conclusion

This hands-on demonstrates how to build a RESTful web service using Spring Boot that retrieves country details dynamically based on a country code provided in the URL. The implementation uses Spring MVC annotations, a service layer, Spring XML configuration, and automatic JSON serialization provided by Jackson. The search is implemented using a case-insensitive comparison to satisfy the exercise requirements.