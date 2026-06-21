# Exercise 2: Verifying Interactions

## Objective

To verify that a specific method on a mocked dependency is invoked during the execution of a service method using Mockito's verification feature.

## Scenario

When writing unit tests, it is often important to verify not only the returned output but also the interactions between objects. In this exercise, the service depends on an external API. Instead of checking the returned value, we verify that the service correctly calls the expected method on the dependency.

Mockito provides the `verify()` method to confirm whether a particular interaction occurred during test execution.

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
│                   ├── MyServiceTest.java
│                   └── MyServiceVerifyTest.java
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

### MyServiceVerifyTest.java

Tests whether the service interacts with the mocked dependency correctly.

```java
ExternalApi mockApi = Mockito.mock(ExternalApi.class);

MyService service = new MyService(mockApi);
service.fetchData();

verify(mockApi).getData();
```

The test performs the following steps:

1. Creates a mock object of `ExternalApi`.
2. Injects the mock into `MyService`.
3. Calls the `fetchData()` method.
4. Uses `verify()` to confirm that `getData()` was invoked on the mock object.

If `getData()` is not called, Mockito throws a verification error and the test fails.

## Execution Output

```text
Verified: getData() was called on the mock.

Fetched Data: Mock Data

Tests passed: 2 of 2 test

Process finished with exit code 0
```

## Key Concepts Demonstrated

### Mock Object Creation

Mockito creates a simulated implementation of the dependency.

```java
ExternalApi mockApi = Mockito.mock(ExternalApi.class);
```

### Interaction Verification

Mockito verifies whether a method was called during execution.

```java
verify(mockApi).getData();
```

### Unit Testing in Isolation

The service is tested independently without relying on a real external system, making the test fast, reliable, and predictable.

## Learning Outcome

Successfully verified interactions between a service and its dependency using Mockito. This exercise demonstrated how to confirm that a method is invoked on a mock object, helping ensure that the service communicates correctly with external components.
