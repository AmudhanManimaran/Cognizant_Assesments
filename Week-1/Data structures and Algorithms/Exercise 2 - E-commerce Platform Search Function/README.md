# Exercise 2: E-commerce Platform Search Function

## Objective
To optimize product search functionality within an e-commerce platform by comparing the performance and implementation of Linear Search and Binary Search algorithms.

## Scenario
As an e-commerce platform scales, the product catalog grows exponentially. Searching through millions of products inefficiently can severely degrade user experience. This exercise demonstrates how selecting the right search algorithm (and understanding its underlying Time Complexity) is critical for enterprise performance.

## Technologies Used
* **Java 17**

## Folder Structure
```text
EcommerceSearchFunction/
├── src/
│   └── com/
│       └── dsa/
│           └── search/
│               ├── Product.java
│               ├── EcommerceSearchTest.java
│               └── Analysis.txt
└── README.md

```

## Code Explanation

`Product.java`: The data model representing an item in the store. It implements the `Comparable<Product>` interface (sorting by `productId`) which is a strict prerequisite for executing a Binary Search.

`EcommerceSearchTest.java`: The client application that populates an inventory array. It executes a `linearSearch()` on an unsorted dataset, and a `binarySearch()` on a cloned, sorted dataset to demonstrate the practical application of both methods.

`Analysis.txt`: Contains the theoretical Big O complexity breakdown and architectural recommendations.

## Execution Output

```text
Initializing E-commerce Search Algorithms...

> Executing Linear Search on UNSORTED array for ID: 109
  Found: Product [ID=109, Name=Gaming Monitor, Category=Displays]

> Executing Binary Search on SORTED array for ID: 109
  Found: Product [ID=109, Name=Gaming Monitor, Category=Displays]

Process finished with exit code 0

```

## Complexity Analysis & Recommendation

Linear Search (O(n)): Checks every single item sequentially. Useful only for very small, unsorted datasets. In the worst-case scenario, it must iterate through the entire database.

Binary Search (O(log n)): Repeatedly halves the search space. Exceptionally fast for massive datasets, turning a 1,000,000-item search into roughly 20 operations.

Conclusion: For a large e-commerce platform, **Binary Search** is the clear choice. While it requires the inventory to be pre-sorted (incurring a slight overhead on data insertion), the exponential increase in read/search speed is absolutely critical for user experience.