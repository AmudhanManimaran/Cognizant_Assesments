# Exercise 1: Logging Error Messages and Warning Levels using SLF4J

## Objective

To demonstrate how to use the SLF4J logging framework for recording application events at different severity levels, specifically **ERROR** and **WARN**.

## Scenario

Logging is an essential part of software development and maintenance. Instead of using `System.out.println()`, enterprise applications use logging frameworks to record important runtime information, warnings, and errors.

In this exercise, SLF4J is used as the logging API, while Logback serves as the logging implementation. The application logs one error message and one warning message to illustrate different log levels.

---

## Technologies Used

* Java 17
* SLF4J 1.7.30
* Logback Classic 1.2.3
* Maven

---

## Project Structure

```text
SLF4JLogging/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── slf4j/
                    └── LoggingExample.java
```

---

## Dependencies

The following dependencies were added to `pom.xml`:

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.30</version>
</dependency>

<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>
```

---

## Source Code Explanation

### LoggingExample.java

```java
package com.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        logger.error("This is an error message");

        logger.warn("This is a warning message");
    }
}
```

### Explanation

* `LoggerFactory.getLogger()` creates a logger associated with the current class.
* `logger.error()` records a message at the **ERROR** level, indicating a serious issue.
* `logger.warn()` records a message at the **WARN** level, indicating a potential problem that does not stop execution.
* Logback automatically formats and displays the log output.

---

## Execution Output

```text
21:50:25.649 [main] ERROR com.slf4j.LoggingExample - This is an error message
21:50:25.652 [main] WARN  com.slf4j.LoggingExample - This is a warning message
```

---

## Output Breakdown

| Component                  | Description                   |
| -------------------------- | ----------------------------- |
| `21:50:25.649`             | Timestamp of the log event    |
| `[main]`                   | Thread that generated the log |
| `ERROR / WARN`             | Logging level                 |
| `com.slf4j.LoggingExample` | Source class                  |
| Message                    | Actual log message            |

---

## Key Concepts Learned

* Introduction to the SLF4J logging framework.
* Difference between **ERROR** and **WARN** log levels.
* Integration of SLF4J with Logback.
* Creating and using logger instances through `LoggerFactory`.
* Producing structured log messages instead of console prints.

---

## Learning Outcome

Successfully implemented logging using SLF4J and Logback, demonstrating how applications can record warning and error messages in a structured and maintainable manner. This exercise provides the foundation for implementing professional logging practices in larger Java applications.
