# Spring Data JPA — Quick Example (Hands-on 1)

## Objective

Demonstrate how Spring Data JPA simplifies database interaction by eliminating
boilerplate code. This exercise connects a Spring Boot application to a MySQL
database, maps a `country` table to a Java entity, and retrieves all records
using `JpaRepository`.

## Scenario

A country management system needs to read country data from a MySQL database.
Instead of writing raw JDBC code with manual connection handling, we use Spring
Data JPA which reduces the entire data access layer to a single interface
extending `JpaRepository`.

## Technologies Used

- Java 17
- Spring Boot 3.5.16
- Spring Data JPA
- Hibernate (JPA implementation)
- MySQL 8.0
- Maven

---

## Folder Structure

```
orm-learn/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── cognizant/
        │           └── ormlearn/
        │               ├── OrmLearnApplication.java
        │               ├── model/
        │               │   └── Country.java
        │               ├── repository/
        │               │   └── CountryRepository.java
        │               └── service/
        │                   └── CountryService.java
        └── resources/
            └── application.properties
```

---

## Step 1 — MySQL Database Setup

Open MySQL Workbench or MySQL command line and run:

```sql
-- Create schema
CREATE SCHEMA ormlearn;

-- Use schema
USE ormlearn;

-- Create country table
CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50)
);

-- Insert sample records
INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');
```

---

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.16</version>
        <relativePath/>
    </parent>

    <groupId>com.cognizant</groupId>
    <artifactId>orm-learn</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>orm-learn</name>
    <description>Demo project for Spring Data JPA and Hibernate</description>

    <properties>
        <java.version>17</java.version>
    </properties>

    <dependencies>

        <!-- Spring Data JPA — includes Hibernate and JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- MySQL Driver -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Spring Boot DevTools -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <!-- Spring Boot Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

---

## application.properties

```properties
# Spring Framework and application log
logging.level.org.springframework=info
logging.level.com.cognizant=debug

# Hibernate logs for displaying executed SQL, input and output
logging.level.org.hibernate.SQL=trace
logging.level.org.hibernate.type.descriptor.sql=trace

# Log pattern
logging.pattern.console=%d{dd-MM-yy} %d{HH:mm:ss.SSS} %-20.20thread %5p %-25.25logger{25} %25M %4L %m%n

# Database configuration
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
spring.datasource.username=root
spring.datasource.password=root

# Hibernate configuration
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## Country.java

```java
package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
```

---

## CountryRepository.java

```java
package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
```

---

## CountryService.java

```java
package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
```

---

## OrmLearnApplication.java

```java
package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");

        testGetAllCountries();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }
}
```

---

## Code Explanation

### Why jakarta.persistence instead of javax.persistence

This project uses Spring Boot 3.x which is built on Jakarta EE 9+. Starting
from Spring Boot 3.0, all `javax.*` packages were renamed to `jakarta.*`.
So `jakarta.persistence.Entity`, `jakarta.persistence.Table` and so on are
the correct imports. Using `javax.persistence` would cause compilation errors
in a Spring Boot 3.x project.

### Country.java

`@Entity` marks this class as a JPA entity — Spring Data JPA maps it to a
database table at runtime. `@Table(name = "country")` specifies the exact
table name in MySQL. `@Id` marks the primary key field. `@Column(name = "co_code")`
and `@Column(name = "co_name")` map Java field names to their actual MySQL
column names, which use a different naming convention.

### CountryRepository.java

This is the complete data access layer — just one interface with no method
bodies. By extending `JpaRepository<Country, String>`, Spring Data JPA
automatically provides `findAll()`, `findById()`, `save()`, `deleteById()`
and many more methods at runtime. No implementation class is needed.

### CountryService.java

Only `getAllCountries()` is implemented here as required by Hands-on 1.
`@Transactional` tells Spring to open a Hibernate session, begin a
transaction, execute `findAll()`, commit, and close the session —
all automatically. Without this annotation, Hibernate session management
would need to be handled manually.

### OrmLearnApplication.java

`SpringApplication.run()` returns an `ApplicationContext`. `CountryService`
is retrieved from it and stored in a static field so the static
`testGetAllCountries()` method can access it. This is the standard pattern
when calling Spring beans from static methods. `LOGGER.info("Inside main")`
confirms the main method executed successfully, and `LOGGER.debug("countries={}")`
prints the fetched data in the logs.

### application.properties

`spring.jpa.hibernate.ddl-auto=validate` tells Hibernate to verify that
the database table structure matches the entity class on startup. If a column
or table is missing, it throws an exception immediately. `MySQL8Dialect` is
the correct Hibernate dialect for MySQL 8.0.

---

## Execution Output

```
Inside main
Start
countries=[Country [code=IN, name=India],
           Country [code=US, name=United States of America]]
End

Process finished with exit code 0
```

## Learning Outcome

Successfully demonstrated how Spring Data JPA eliminates boilerplate database
code. The `CountryRepository` interface with zero implementation lines provides
complete CRUD functionality. Spring manages the Hibernate session lifecycle,
transaction boundaries, and connection pooling automatically — the application
code only focuses on business logic.
