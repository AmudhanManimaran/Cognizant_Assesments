# REST - Create Authentication Service that Returns JWT

## Objective

Implement a RESTful authentication service using **Spring Boot 3.1.5**, **Spring Security**, and **JWT (JSON Web Token)**.

The service accepts user credentials through the **Authorization** header using **HTTP Basic Authentication**, decodes the credentials, generates a JWT token, and returns it as a JSON response.

---

# Learning Objectives

- Configure Spring Security for a REST API.
- Enable HTTP Basic Authentication.
- Read and decode the Authorization header.
- Generate a JWT using the JJWT library.
- Return the JWT as a JSON response.
- Test the API using cURL and Postman.

---

# Technologies Used

- Java 17
- Spring Boot 3.1.5
- Spring Security
- JWT (JJWT 0.11.5)
- Maven
- Eclipse IDE
- Postman / cURL

---

# Project Structure

```
spring-learn
│
├── pom.xml
│
├── src
│   ├── main
│   │
│   ├── java
│   │   └── com
│   │       └── cognizant
│   │           └── springlearn
│   │
│   │               ├── SpringLearnApplication.java
│   │               │
│   │               ├── controller
│   │               │      └── AuthenticationController.java
│   │               │
│   │               ├── security
│   │               │      └── SecurityConfig.java
│   │               │
│   │               └── dto
│   │                      └── AuthenticationResponse.java
│   │
│   └── resources
│          └── application.properties
│
└── target
```

---

# Dependencies

The project uses the following Maven dependencies:

- Spring Boot Starter Web
- Spring Boot Starter Security
- JJWT API
- JJWT Impl
- JJWT Jackson
- Spring Boot DevTools
- Spring Boot Starter Test

---

# Configuration

### application.properties

```properties
server.port=8090

logging.level.com.cognizant.springlearn=DEBUG

logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} %-5level [%thread] %logger{36} : %msg%n

jwt.secret=Cognizant-Digital-Nurture-JWT-Secret-Key-Must-Be-Long
```

---

# Authentication Flow

The authentication process follows these steps:

1. Client sends credentials using HTTP Basic Authentication.
2. Spring Security receives the request.
3. The controller reads the Authorization header.
4. The Base64-encoded credentials are decoded.
5. The username is extracted.
6. A JWT token is generated.
7. The token is returned as a JSON response.

---

# REST Endpoint

## Generate JWT

**Request**

```
GET /authenticate
```

Example

```
http://localhost:8090/authenticate
```

---

# cURL Request

```bash
curl -s -u user:pwd http://localhost:8090/authenticate
```

---

# Authorization Header

The credentials

```
user:pwd
```

are automatically converted into

```
Basic dXNlcjpwd2Q=
```

This header is read inside the controller using

```java
@RequestHeader("Authorization")
```

The Base64 value is decoded to obtain the username and password.

---

# Sample Response

```json
{
    "token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNz...<JWT_TOKEN>"
}
```

---

# How JWT is Generated

The controller generates the JWT using the JJWT library.

The generated token contains:

- Subject (Username)
- Issued Time
- Expiration Time (1 Hour)
- HMAC SHA-256 Signature

---

# Testing Using Postman

## Method

```
GET
```

## URL

```
http://localhost:8090/authenticate
```

## Authorization

Select

```
Basic Auth
```

Username

```
user
```

Password

```
pwd
```

Click **Send**.

---

# Testing Using Browser

The browser cannot directly send Basic Authentication credentials like cURL or Postman.

Use:

- cURL
- Postman

for testing this API.

---

# Expected Console Output

```
INFO  AuthenticationController : START: inside authenticate()

DEBUG AuthenticationController : Received Authorization Header: Basic dXNlcjpwd2Q=

DEBUG AuthenticationController : Decoded Username: user

INFO  AuthenticationController : END: inside authenticate()
```

---

# Expected cURL Output

```json
{
    "token":"eyJhbGciOiJIUzI1NiJ9..."
}
```

---

# Security Configuration

The application uses Spring Security to

- Enable HTTP Basic Authentication
- Authenticate an in-memory user
- Protect REST endpoints
- Disable CSRF for REST APIs

Configured User

```
Username : user
Password : pwd
Role     : USER
```

---

# SME Questions & Answers

## 1. What happens when the request is sent?

1. Client sends a GET request.
2. Spring Security authenticates the user using HTTP Basic Authentication.
3. The controller receives the Authorization header.
4. The Base64 credentials are decoded.
5. Username is extracted.
6. JWT token is generated.
7. Token is returned as JSON.

---

## 2. Why do we use HTTP Basic Authentication?

HTTP Basic Authentication allows the client to send credentials securely in the Authorization header.

Example:

```
Authorization: Basic dXNlcjpwd2Q=
```

---

## 3. What is Base64?

Base64 is an encoding mechanism.

Example

```
user:pwd
```

becomes

```
dXNlcjpwd2Q=
```

It is **encoding**, not encryption.

---

## 4. Why do we decode the Authorization header?

The exercise specifically requires reading the Authorization header and extracting the username and password before generating the JWT.

---

## 5. What is JWT?

JWT (JSON Web Token) is a compact, secure token used to authenticate users in RESTful applications.

A JWT contains:

- Header
- Payload
- Signature

---

## 6. Why is JWT used?

JWT enables stateless authentication.

Once generated, the client sends the token with every request instead of sending username and password repeatedly.

---

## 7. Which library generates the JWT?

The project uses the **JJWT** library.

---

## 8. What information is stored in the JWT?

The generated token stores:

- Username (Subject)
- Issued Time
- Expiration Time

---

## 9. Where is the secret key stored?

The secret key is stored in

```
application.properties
```

using

```properties
jwt.secret=...
```

and injected into the controller using

```java
@Value("${jwt.secret}")
```

---

## 10. Why is CSRF disabled?

This project exposes REST APIs.

REST APIs are stateless.

Therefore,

```java
http.csrf(csrf -> csrf.disable());
```

is used.

---

# Conclusion

This hands-on demonstrates the first step of JWT authentication using Spring Boot and Spring Security. The application authenticates the user via HTTP Basic Authentication, reads and decodes the Authorization header, generates a JWT using the JJWT library, and returns it as a JSON response. This implementation satisfies the objectives of the Cognizant Digital Nurture exercise and serves as the foundation for implementing complete JWT-based authentication in subsequent exercises.