# Creating Microservices for Account and Loan

## Objective

This hands-on exercise demonstrates how to create two independent Spring Boot RESTful microservices for a banking application.

The application is divided into two separate Maven projects:

- Account Microservice
- Loan Microservice

Each microservice exposes a REST API that returns dummy data without any backend or database connectivity.

---

## Technologies Used

- Java 17
- Spring Boot 3.1.5
- Spring Web
- Spring Boot DevTools
- Maven

---

## Project Structure

```text
microservices/
├── account/
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/
│           │       └── cognizant/
│           │           └── account/
│           │               ├── AccountApplication.java
│           │               ├── controller/
│           │               │   └── AccountController.java
│           │               └── model/
│           │                   └── Account.java
│           └── resources/
│               └── application.properties
│
└── loan/
    ├── pom.xml
    └── src/
        └── main/
            ├── java/
            │   └── com/
            │       └── cognizant/
            │           └── loan/
            │               ├── LoanApplication.java
            │               ├── controller/
            │               │   └── LoanController.java
            │               └── model/
            │                   └── Loan.java
            └── resources/
                └── application.properties
```

---

# Account Microservice

### Default Port

```
8080
```

### Endpoint

```
GET /accounts/{number}
```

### Sample Request

```
http://localhost:8080/accounts/00987987973432
```

### Sample Response

```json
{
  "number": "00987987973432",
  "type": "savings",
  "balance": 234343.0
}
```

---

# Loan Microservice

### Port

```
8081
```

### Endpoint

```
GET /loans/{number}
```

### Sample Request

```
http://localhost:8081/loans/H00987987972342
```

### Sample Response

```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000.0,
  "emi": 3258.0,
  "tenure": 18
}
```

---

# Running the Project

## Account Microservice

Open a terminal inside the **account** project.

Build the project:

```bash
mvn clean package
```

Run the application:

```bash
mvn spring-boot:run
```

or run `AccountApplication.java` from the IDE.

---

## Loan Microservice

Open another terminal inside the **loan** project.

Build the project:

```bash
mvn clean package
```

Run the application:

```bash
mvn spring-boot:run
```

or run `LoanApplication.java` from the IDE.

---

# Testing the APIs

### Account Service

Browser or curl:

```bash
curl http://localhost:8080/accounts/00987987973432
```

Expected Response

```json
{
  "number": "00987987973432",
  "type": "savings",
  "balance": 234343.0
}
```

---

### Loan Service

Browser or curl:

```bash
curl http://localhost:8081/loans/H00987987972342
```

Expected Response

```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000.0,
  "emi": 3258.0,
  "tenure": 18
}
```

---

# Features

- Two independent Spring Boot microservices
- Separate Maven projects
- RESTful APIs
- Dummy responses without database connectivity
- Different server ports for each service
- JSON response using Spring Boot object serialization

---

# Result

Both microservices run independently on different ports.

| Microservice | Port | Endpoint |
|--------------|------|----------|
| Account | 8080 | `/accounts/{number}` |
| Loan | 8081 | `/loans/{number}` |

The APIs return the expected dummy JSON responses as specified in the Cognizant Digital Nurture hands-on exercise.

---

## Conclusion

This hands-on exercise demonstrates the creation of two independent Spring Boot RESTful microservices using Maven. The Account and Loan services are developed as separate applications, each exposing its own REST endpoint and running on different ports. The implementation successfully fulfills the exercise requirements by returning dummy JSON responses without backend connectivity and illustrates the basic concept of microservice-based application development.