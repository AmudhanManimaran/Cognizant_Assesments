# Exercise 1: Configuring a Basic Spring Application

## Objective

Set up a basic Spring application for a library management system using Spring Core's IoC container and XML-based bean configuration.

## Scenario

A company is building a web application to manage a library. The backend needs to be structured using the Spring Framework, where components like `BookService` and `BookRepository` are managed as Spring beans rather than being manually instantiated using the `new` keyword.

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

        <!-- Spring Context includes spring-core, spring-beans,
             spring-expression and spring-aop transitively -->
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

## applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- BookRepository bean -->
    <bean id="bookRepository"
          class="com.library.repository.BookRepository"/>

    <!-- BookService bean -->
    <bean id="bookService"
          class="com.library.service.BookService"/>

</beans>
```

---

## BookRepository.java

```java
package com.library.repository;

public class BookRepository {

    public void findAllBooks() {
        System.out.println("BookRepository: Fetching all books from the database.");
    }
}
```

---

## BookService.java

```java
package com.library.service;

public class BookService {

    public void getBooks() {
        System.out.println("BookService: Processing request to get all books.");
    }
}
```

---

## LibraryManagementApplication.java

```java
package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        // Load the Spring application context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and test the BookRepository bean
        BookRepository repository = context.getBean(BookRepository.class);
        repository.findAllBooks();

        // Retrieve and test the BookService bean
        BookService service = context.getBean(BookService.class);
        service.getBooks();

        System.out.println("Spring context loaded successfully.");

        // Close the Spring context
        context.close();
    }
}
```

---

## Code Explanation

### pom.xml

Only `spring-context` is declared as a dependency. This is the standard approach because `spring-context` pulls in `spring-core`, `spring-beans`, `spring-expression`, and `spring-aop` automatically through Maven's transitive dependency resolution. There is no need to declare each one separately.

### applicationContext.xml

This is the central configuration file that Spring reads on startup. Each `<bean>` element tells Spring which class to instantiate and what `id` to assign to it. Spring reads these definitions, creates the objects, stores them in the IoC container, and provides them whenever they are requested using `getBean()`. The application itself never calls `new BookService()` or `new BookRepository()` — Spring manages that entirely.

### BookRepository.java

A simple repository class representing the data access layer. It simulates fetching books from a database. No Spring annotations are used here because this exercise uses pure XML-based configuration.

### BookService.java

The service layer class that handles the business logic for book-related operations. No annotations here either — the bean is registered entirely through `applicationContext.xml`.

### LibraryManagementApplication.java

Three things worth noting:

- `ClassPathXmlApplicationContext` is used as the declared type instead of `ApplicationContext`. This is intentional — `ClassPathXmlApplicationContext` exposes the `close()` method which `ApplicationContext` does not declare.
- `context.getBean(BookService.class)` and `context.getBean(BookRepository.class)` use type-safe bean retrieval, which avoids casting and is the cleaner modern approach.
- Both beans are retrieved and tested independently — this directly satisfies the exercise requirement of testing the Spring configuration for both `BookService` and `BookRepository`.
- `context.close()` is called at the end to properly release the IoC container and any resources it holds.

---

## Execution Output

```
BookRepository: Fetching all books from the database.
BookService: Processing request to get all books.
Spring context loaded successfully.

Process finished with exit code 0
```

---

## Learning Outcome

Successfully demonstrated how to configure a Spring application using XML-based bean definitions. The key takeaway is that the Spring IoC container takes full responsibility for object creation and lifecycle management — the application code only asks for what it needs through `getBean()`, without worrying about how or when the object was created.
