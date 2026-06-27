# Exercise 4: Creating and Configuring a Maven Project

## Objective

Set up the Maven project for the library management application with the required Spring dependencies and configure the Maven Compiler Plugin for Java 1.8.

## Scenario

The library management application needs a properly structured Maven project with Spring Context, Spring AOP, and Spring WebMVC dependencies declared, along with the Maven Compiler Plugin configured to target Java 1.8.

## Technologies Used

- Java 1.8 (compiler target)
- Spring Framework 5.3.30
- Maven 3.11.0 (Compiler Plugin)

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

## pom.xml — the only file that changes in this exercise

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

        <!-- Spring Context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.30</version>
        </dependency>

        <!-- Spring AOP -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>5.3.30</version>
        </dependency>

        <!-- Spring WebMVC -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.30</version>
        </dependency>

    </dependencies>

    <build>

        <resources>
            <resource>
                <directory>src/main/resources</directory>
            </resource>
        </resources>

        <plugins>

            <!-- Maven Compiler Plugin configured for Java 1.8 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>

        </plugins>

    </build>

</project>
```

---

## Code Explanation

### Dependencies

Three Spring dependencies are declared as the exercise requires:

- `spring-context` — provides the Spring IoC container and bean management.
- `spring-aop` — adds support for Aspect-Oriented Programming.
- `spring-webmvc` — provides the Spring MVC framework for building web applications.

All three use version `5.3.30` for consistency across the project.

### Maven Compiler Plugin

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.11.0</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
    </configuration>
</plugin>
```

The exercise explicitly asks to configure the Maven Compiler Plugin for Java 1.8. Two settings are configured inside `<configuration>`:

- `<source>1.8</source>` — tells the compiler which Java version syntax to accept when compiling source files.
- `<target>1.8</target>` — tells the compiler to generate bytecode compatible with a Java 1.8 JVM.

The plugin configuration alone is sufficient. There is no need to also declare `maven.compiler.source` and `maven.compiler.target` in a `<properties>` block — that would be redundant since the plugin already handles it.

---

## What Changed from Exercise 2

| File | Exercise 2 | Exercise 4 |
|---|---|---|
| `pom.xml` | Only `spring-context` | Added `spring-aop`, `spring-webmvc`, Maven Compiler Plugin |
| All other files | No change | No change |

---

## How to Verify After Updating

Press `Ctrl + Shift + O` in IntelliJ to reload Maven. Then open the **Maven** panel on the right side and expand **Dependencies**. You should see:

```
spring-context : 5.3.30
spring-aop     : 5.3.30
spring-webmvc  : 5.3.30
```

All three present — Exercise 4 is complete.

---

## Execution Output

Exercise 4 only modifies `pom.xml` and does not change any application logic. Running `LibraryManagementApplication.java` produces the same output as Exercise 2:

```
BookService: Processing request to get all books.
BookRepository: Fetching all books from the database.
Dependency Injection verified successfully.

Process finished with exit code 0
```

Getting the same output here is expected and correct.

---

## Learning Outcome

Successfully configured a Maven project with multiple Spring dependencies and the Maven Compiler Plugin. The key takeaway is that the compiler plugin configuration inside `<build><plugins>` is the single authoritative place to set the Java source and target version — no need to duplicate it in `<properties>`.