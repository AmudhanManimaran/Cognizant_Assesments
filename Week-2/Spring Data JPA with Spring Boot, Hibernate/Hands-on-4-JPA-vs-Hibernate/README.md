# Hands-on 4: Difference between JPA, Hibernate and Spring Data JPA

## Objective

To understand the differences between Java Persistence API (JPA), Hibernate, and Spring Data JPA, and to compare how each approach is used for database persistence in Java applications.

---

# Java Persistence API (JPA)

Java Persistence API (JPA) is a standard specification (JSR 338) for persisting, reading, updating, and deleting data from relational databases using Java objects.

### Key Points

* JPA is only a specification, not an implementation.
* It defines a standard set of interfaces and annotations.
* It allows applications to remain independent of any specific ORM framework.
* Hibernate, EclipseLink, and OpenJPA are popular implementations of JPA.

### Advantages

* Standard API across different ORM providers.
* Database-independent programming.
* Uses annotations for object-relational mapping.
* Improves portability of applications.

---

# Hibernate

Hibernate is an Object-Relational Mapping (ORM) framework that implements the JPA specification.

It converts Java objects into database records and database records back into Java objects.

### Key Points

* Hibernate is a complete ORM framework.
* It implements JPA.
* Provides additional features beyond JPA.
* Handles SQL generation automatically.
* Manages sessions, caching, lazy loading, and transactions.

### Advantages

* Reduces JDBC boilerplate code.
* Supports automatic SQL generation.
* Database independent.
* Rich caching support.
* Supports HQL (Hibernate Query Language).

---

# Spring Data JPA

Spring Data JPA is a Spring module built on top of JPA implementations such as Hibernate.

It does not provide its own ORM implementation. Instead, it simplifies database access by eliminating repetitive CRUD code.

### Key Points

* Works on top of JPA implementations like Hibernate.
* Automatically generates repository implementations.
* Provides built-in CRUD methods.
* Integrates seamlessly with Spring Boot.
* Simplifies transaction management.

### Advantages

* Very little boilerplate code.
* Automatic repository implementation.
* Easy integration with Spring applications.
* Supports custom query methods.
* Transaction management using `@Transactional`.

---

# Comparison

| Feature                | JPA                      | Hibernate                  | Spring Data JPA                 |
| ---------------------- | ------------------------ | -------------------------- | ------------------------------- |
| Type                   | Specification            | ORM Framework              | Spring Module                   |
| Implementation         | No                       | Yes                        | No                              |
| Database Operations    | Through implementation   | Directly supported         | Through JpaRepository           |
| Boilerplate Code       | Moderate                 | High                       | Very Low                        |
| Transaction Management | Via implementation       | Manual or annotation-based | Automatic with Spring           |
| Repository Support     | No                       | No                         | Yes                             |
| CRUD Operations        | Defined by specification | Implemented manually       | Available through JpaRepository |
| Uses                   | Standard persistence API | ORM implementation         | Simplified data access layer    |

---

# Code Comparison

## Hibernate

The developer is responsible for opening and closing sessions, starting transactions, committing changes, handling exceptions, and rolling back transactions.

```java
/* Method to CREATE an employee in the database */
public Integer addEmployee(Employee employee) {

    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee);
        tx.commit();

    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
        e.printStackTrace();

    } finally {
        session.close();
    }

    return employeeID;
}
```

### Observation

* Manual session management
* Manual transaction handling
* More boilerplate code
* More chances of programming errors

---

## Spring Data JPA

### EmployeeRepository.java

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

### EmployeeService.java

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
```

### Observation

* No Session object
* No Transaction object
* No try-catch-finally block
* No manual commit or rollback
* CRUD operations are provided automatically by `JpaRepository`
* Much cleaner and easier to maintain

---

# Conclusion

JPA provides a standard specification for object-relational mapping but does not include an implementation. Hibernate is one of the most widely used implementations of JPA and offers powerful ORM capabilities. Spring Data JPA builds on top of JPA implementations such as Hibernate and significantly reduces boilerplate code by providing ready-made repository interfaces and automatic transaction management. For Spring Boot applications, Spring Data JPA is generally the preferred approach because it simplifies development while retaining the capabilities of Hibernate.

---

# References

1. DZone – *What is the Difference Between Hibernate and Spring Data JPA?*

   https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1

2. JavaWorld – *Introduction to the Java Persistence API (JPA)*

   https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
