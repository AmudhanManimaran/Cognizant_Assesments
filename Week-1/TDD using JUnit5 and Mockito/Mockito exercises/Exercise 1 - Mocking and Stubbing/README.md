# Exercise 1: Mocking and Stubbing

## Objective

To learn how to isolate a service from its external dependencies using Mockito by creating mock objects and stubbing method responses.

## Scenario

In real-world applications, services often depend on external systems such as APIs, databases, payment gateways, or third-party services. Directly invoking these dependencies during unit testing can make tests slow, unreliable, and difficult to maintain.

Mockito allows us to create mock objects that simulate the behavior of these external dependencies. By defining predefined responses for specific method calls, we can test the service logic independently without relying on actual external systems.

## Technologies Used

* Java 17
* JUnit 5
* Mockito
* Maven

## Folder Structure

```text
MockitoExercises/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── mockito/
│   │               ├── ExternalApi.java
│   │               └── MyService.java
│   └── test/
│       └── java/
│           └── com/
│               └── mockito/
│                   └── MyServiceTest.java
└── README.md
```

## Code Explanation

### ExternalApi.java

Defines the external dependency used by the service.

```java
public interface ExternalApi {
    String getData();
}
```

The interface represents an external system whose behavior will be mocked during testing.

### MyService.java

Contains the business logic that depends on the external API.

```java
public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}
```

The service receives the dependency through constructor injection and retrieves data using the `getData()` method.

### MyServiceTest.java

Tests the service using Mockito.

```java
ExternalApi mockApi = Mockito.mock(ExternalApi.class);
when(mockApi.getData()).thenReturn("Mock Data");

MyService service = new MyService(mockApi);
String result = service.fetchData();

assertEquals("Mock Data", result);
```

The test performs the following steps:

1. Creates a mock object of `ExternalApi`.
2. Stubs the `getData()` method to return `"Mock Data"`.
3. Injects the mock object into `MyService`.
4. Calls the service method.
5. Verifies that the returned value matches the stubbed response.

## Execution Output

```text
Fetched data: Mock Data

Tests passed: 1 of 1 test

Process finished with exit code 0
```

## Key Concepts Demonstrated

### Mocking

A mock object is a simulated version of a real dependency.

```java
ExternalApi mockApi = Mockito.mock(ExternalApi.class);
```

Mockito creates a fake implementation of the interface at runtime.

### Stubbing

Stubbing defines the behavior of a mocked method.

```java
when(mockApi.getData()).thenReturn("Mock Data");
```

Whenever `getData()` is called, Mockito returns the predefined value instead of invoking a real external system.

### Dependency Injection

The mock object is passed to the service through the constructor.

```java
MyService service = new MyService(mockApi);
```

This allows the service to be tested independently of external dependencies.

## Learning Outcome

Successfully implemented Mockito mocking and stubbing to test a service that depends on an external API. The exercise demonstrated how to isolate business logic from external systems, create predictable test scenarios, and write reliable unit tests using mock objects.
