# Hands-on 4 – Spring Core: Load Country from Spring Configuration XML

## Objective

The objective of this hands-on is to demonstrate how Spring Core loads Java objects (beans) from an XML configuration file using the Spring IoC Container.

The application reads the details of a country configured in `country.xml` and displays them using Spring's `ApplicationContext`.

---

# Project Structure

```
spring-learn
│
├── pom.xml
│
└── src
    └── main
        ├── java
        │   └── com
        │       └── cognizant
        │           └── springlearn
        │               ├── SpringLearnApplication.java
        │               └── Country.java
        │
        └── resources
            ├── application.properties
            └── country.xml
```

---

# Files Used

## 1. Country.java

Represents the Country bean.

Features:

- Empty constructor
- Instance variables
    - code
    - name
- Getter methods
- Setter methods
- Debug logging inside constructor and every getter/setter
- Overridden `toString()` method

---

## 2. country.xml

Spring XML configuration file used to configure the Country bean.

Example:

```xml
<bean id="country"
      class="com.cognizant.springlearn.Country">

    <property name="code" value="IN"/>
    <property name="name" value="India"/>

</bean>
```

This bean represents the country **India**.

---

## 3. SpringLearnApplication.java

Contains the application's entry point.

The `displayCountry()` method performs the following steps:

1. Creates the Spring IoC container using `ClassPathXmlApplicationContext`
2. Reads the bean named `"country"`
3. Retrieves it as a `Country` object
4. Displays the country details using Logger

Example:

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext("country.xml");

Country country =
        context.getBean("country", Country.class);

LOGGER.debug("Country : {}", country);
```

---

## 4. application.properties

Configured logging level to display DEBUG messages.

```properties
logging.level.com.cognizant.springlearn=DEBUG
```

---

# Program Flow

```
Application Starts
        │
        ▼
Spring Boot Starts
        │
        ▼
displayCountry() is invoked
        │
        ▼
Spring loads country.xml
        │
        ▼
IoC Container creates Country object
        │
        ▼
Constructor is executed
        │
        ▼
Setter Injection
(setCode() and setName())
        │
        ▼
Country bean returned
        │
        ▼
Country details displayed
```

---

# Output

```
INFO  Starting displayCountry()...

DEBUG Inside Country Constructor.

DEBUG Inside setCode.

DEBUG Inside setName.

DEBUG Country : Country [code=IN, name=India]
```

The output confirms that:

- Spring created the bean.
- Constructor was executed.
- Property values were injected using setter methods.
- The fully initialized bean was returned and displayed.

---

# SME Walkthrough

## 1. `<bean>` Tag

Defines an object that will be created and managed by the Spring IoC Container.

Example:

```xml
<bean id="country"
      class="com.cognizant.springlearn.Country">
```

---

## 2. `id` Attribute

Provides a unique identifier for the bean inside the Spring container.

Example:

```xml
id="country"
```

This identifier is later used in:

```java
context.getBean("country")
```

---

## 3. `class` Attribute

Specifies the fully qualified class name of the bean.

Example:

```xml
class="com.cognizant.springlearn.Country"
```

Spring creates an object of this class.

---

## 4. `<property>` Tag

Injects values into bean properties using setter methods.

Example:

```xml
<property name="code" value="IN"/>
```

Spring internally invokes:

```java
country.setCode("IN");
```

---

## 5. `name` Attribute

Specifies which property should receive the value.

Example:

```xml
name="code"
```

Maps to:

```java
setCode()
```

---

## 6. `value` Attribute

Specifies the value that should be injected.

Example:

```xml
value="India"
```

Spring passes this value to the setter method.

---

# ApplicationContext

`ApplicationContext` is the central interface of the Spring IoC Container.

Responsibilities:

- Reads configuration
- Creates objects
- Performs dependency injection
- Manages bean lifecycle
- Returns beans whenever requested

---

# ClassPathXmlApplicationContext

`ClassPathXmlApplicationContext` is an implementation of `ApplicationContext`.

It loads Spring configuration files from the project's classpath (typically `src/main/resources`).

Example:

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext("country.xml");
```

---

# What happens when `context.getBean()` is invoked?

When the following statement executes:

```java
Country country =
        context.getBean("country", Country.class);
```

Spring performs these steps:

1. Searches the IoC container for a bean with the ID `"country"`.

2. Creates the object using the default constructor (if it has not already been created).

3. Reads all `<property>` elements from `country.xml`.

4. Calls the corresponding setter methods to inject the configured values.

5. Stores the fully initialized object inside the IoC container.

6. Returns the bean to the application.

---

# Key Concepts Learned

- Spring Core
- Inversion of Control (IoC)
- Dependency Injection (DI)
- Spring XML Configuration
- Bean Creation
- Setter Injection
- ApplicationContext
- ClassPathXmlApplicationContext
- Logging using SLF4J
- Bean Retrieval using `getBean()`

---

# Conclusion

In this hands-on, a `Country` bean was successfully configured using Spring XML, loaded through the Spring IoC Container, and retrieved using `ApplicationContext`. The debug logs verified the sequence of bean creation, constructor execution, property injection, and bean retrieval, demonstrating how Spring Core manages object creation and dependency injection.