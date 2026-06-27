# Exercise 2: Implementing Dependency Injection

## Objective

Manage the dependencies between `BookService` and `BookRepository` using Spring's Inversion of Control (IoC) and Dependency Injection (DI) through XML-based setter injection.

## Scenario

The library management application already has `BookService` and `BookRepository` configured as Spring beans. In this exercise, `BookRepository` is wired into `BookService` using Spring's setter injection — meaning Spring automatically provides `BookRepository` to `BookService` without any manual object passing in code.

## Technologies Used

- Java 17
- Spring Framework 5.3.30
- Maven

---

## Folder Structure

```
LibraryManagement/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── library/
        │           ├── service/
        │           │   └── BookService.java
        │           ├── repository/
        │           │   └── BookRepository.java
        │           └── LibraryManagementApplication.java
        └── resources/
            └── applicationContext.xml
```

---

## pom.xml

No changes from Exercise 1.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.library</groupId>
    <artifactId>LibraryManagement</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <dependencies>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.30</version>
        </dependency>

    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
            </resource>
        </resources>
    </build>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

</project>
```

---

## applicationContext.xml — updated

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- BookRepository bean -->
    <bean id="bookRepository"
          class="com.library.repository.BookRepository"/>

    <!-- BookService bean with BookRepository injected via setter -->
    <bean id="bookService"
          class="com.library.service.BookService">
        <property name="bookRepository" ref="bookRepository"/>
    </bean>

</beans>
```

---

## BookRepository.java

No changes from Exercise 1.

```java
package com.library.repository;

public class BookRepository {

    public void findAllBooks() {
        System.out.println("BookRepository: Fetching all books from the database.");
    }
}
```

---

## BookService.java — updated

```java
package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter method for Spring to inject BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void getBooks() {
        System.out.println("BookService: Processing request to get all books.");
        bookRepository.findAllBooks();
    }
}
```

---

## LibraryManagementApplication.java — updated

```java
package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        // Load the Spring application context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve BookService — BookRepository is already injected by Spring
        BookService service = context.getBean(BookService.class);

        // This internally calls BookRepository through the injected dependency
        service.getBooks();

        System.out.println("Dependency Injection verified successfully.");

        // Close the Spring context
        context.close();
    }
}
```

---

## Code Explanation

### applicationContext.xml

The key change from Exercise 1 is this single line inside the `bookService` bean definition:

```xml
<property name="bookRepository" ref="bookRepository"/>
```

- `name="bookRepository"` — maps directly to the setter method `setBookRepository()` in `BookService`. Spring follows the JavaBean convention: it strips `set`, lowercases the first letter, and matches it to the property name.
- `ref="bookRepository"` — tells Spring to inject the bean with id `bookRepository`, which is the `BookRepository` instance already managed by the IoC container.

Spring calls `setBookRepository()` automatically after creating the `BookService` bean. No manual object passing happens anywhere in the application code.

### BookService.java

Two things were added compared to Exercise 1:

```java
private BookRepository bookRepository;

public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
}
```

The private field holds the injected dependency. The setter method is what Spring calls internally during bean initialization. The setter name must strictly follow the JavaBean convention — `set` + capitalized field name — otherwise Spring cannot match it to the XML `property` element.

Inside `getBooks()`, `bookRepository.findAllBooks()` is now called directly. This works because by the time `getBooks()` is invoked, Spring has already injected the `BookRepository` instance through the setter.

### LibraryManagementApplication.java

Only `BookService` is retrieved from the context this time — not `BookRepository` separately. This is intentional. The fact that `service.getBooks()` successfully calls `bookRepository.findAllBooks()` internally is itself the proof that dependency injection worked. If the injection had failed, a `NullPointerException` would have been thrown at that line.

---

## Execution Output

```
BookService: Processing request to get all books.
BookRepository: Fetching all books from the database.
Dependency Injection verified successfully.

Process finished with exit code 0
```

---

## What Changed from Exercise 1

| File | Exercise 1 | Exercise 2 |
|---|---|---|
| `applicationContext.xml` | Beans defined independently | `BookRepository` wired into `BookService` via `<property>` |
| `BookService.java` | No dependency on `BookRepository` | Added field, setter, and internal call to `BookRepository` |
| `BookRepository.java` | No change | No change |
| `LibraryManagementApplication.java` | Both beans retrieved separately | Only `BookService` retrieved — DI verified through internal call |
| `pom.xml` | No change | No change |

---

## Learning Outcome

Successfully demonstrated setter-based dependency injection using Spring's XML configuration. The core takeaway is that `BookService` does not create or look up `BookRepository` itself — Spring reads the `<property>` wiring in `applicationContext.xml`, creates both beans, and connects them automatically before the application code ever runs.
