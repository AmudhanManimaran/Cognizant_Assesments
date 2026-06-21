# Exercise 2: Implementing the Factory Method Pattern

## Objective
To build a document management system that delegates the instantiation of specific document types to subclass factories, promoting loose coupling and adhering to the Open/Closed Principle.

## Scenario
An application needs to create different document formats (Word, PDF, Excel). Instead of hardcoding the object creation logic (`new WordDocument()`, `new PdfDocument()`) directly into the main application, we use the Factory Method Pattern. This ensures the main system remains closed for modification but open for extension—if a new document type (e.g., PowerPoint) is added later, the existing client code doesn't need to change.

## Technologies Used
* **Java 17**

## Folder Structure
```text
FactoryMethodPatternExample/
├── src/
│   └── com/
│       └── designpatterns/
│           └── factory/
│               ├── Document.java
│               ├── DocumentFactory.java
│               ├── ExcelDocument.java
│               ├── ExcelDocumentFactory.java
│               ├── PdfDocument.java
│               ├── PdfDocumentFactory.java
│               ├── WordDocument.java
│               ├── WordDocumentFactory.java
│               └── FactoryMethodTest.java
└── README.md

```

## Code Explanation

* **`Document.java` (Interface):** Defines the standard contract (`open()`, `save()`) that all documents must follow.
* **Concrete Documents (`WordDocument`, `PdfDocument`, `ExcelDocument`):** Implement the `Document` interface with specific behaviors for each file type.
* **`DocumentFactory.java` (Abstract Creator):** Declares the abstract `createDocument()` factory method.
* **Concrete Factories (`WordDocumentFactory`, etc.):** Extend the creator and implement the factory method to return the specific document instance.
* **`FactoryMethodTest.java` (Client):** Demonstrates creation by asking the respective factories for a document. The client only interacts with the `Document` interface, completely unaware of the concrete implementation details.

## Execution Output

```text
Starting Factory Method Pattern Test...

Word Document: 
Opening Word document (.docx)
Saving Word document (.docx)

PDF Document: 
Opening PDF document (.pdf)
Saving PDF document (.pdf)

Excel Document: 
Opening Excel document (.xlsx)
Saving Excel document (.xlsx)

Verification: 
Word document type   : WordDocument
PDF document type    : PdfDocument
Excel document type  : ExcelDocument

Process finished with exit code 0

```

## Learning Outcome

Successfully demonstrated how to decouple object creation from the core business logic. This pattern allows the software architecture to scale cleanly when new product families are introduced.