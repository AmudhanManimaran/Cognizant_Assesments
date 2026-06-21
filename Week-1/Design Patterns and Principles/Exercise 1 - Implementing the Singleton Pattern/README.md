# Exercise 1: Implementing the Singleton Pattern

## Objective
To ensure that a core utility class (in this case, a `Logger`) has only one globally accessible instance throughout the entire application lifecycle.

## Scenario
In enterprise applications, multiple components often need to write to the same log file or console. If every component created its own `Logger` object using the `new` keyword, it would cause unnecessary memory overhead and potential inconsistent logging states. The Singleton design pattern resolves this by strictly controlling object instantiation.

## Technologies Used
* **Java 17**

## Folder Structure
```text
SingletonPatternExample/
├── src/
│   └── com/
│       └── designpatterns/
│           └── singleton/
│               ├── Logger.java
│               └── SingletonTest.java
└── README.md

```

## Code Explanation

* **`Logger.java`:** * The constructor is explicitly made `private` to prevent any external class from instantiating it.
* A `private static` variable holds the single instance of the class.
* A `public static` method (`getInstance()`) provides global access. It checks if the instance is `null`; if so, it creates it. Otherwise, it simply returns the existing instance.


* **`SingletonTest.java`:** Acts as the client testing the implementation. It attempts to retrieve the logger instance twice and compares their memory references (hash codes) to prove they point to the exact same object.

## Execution Output

```text
Starting Singleton Pattern Test...

Logger initialized.
[LOG]: Application started...
[LOG]: Processing data...

 Verification 
Same instance: true
Success: Both logger1 and logger2 share the same memory reference.
Hashcode of logger1: 1149319664
Hashcode of logger2: 1149319664

Process finished with exit code 0

```

## Learning Outcome

Successfully demonstrated how to restrict class instantiation to a single object, ensuring memory efficiency and centralized control over shared resources.
