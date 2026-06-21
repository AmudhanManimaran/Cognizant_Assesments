package com.dsa.search;
import java.util.Arrays;

public class EcommerceSearchTest {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product:products) {
            if (product.getProductId()==targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left=0;
        int right=products.length-1;

        while (left<=right) {
            int mid=left+(right-left)/2;
            int midId=products[mid].getProductId();

            if (midId==targetId) {
                return products[mid];
            }
            if (midId<targetId) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Initializing E-commerce Search Algorithms...\n");

        Product[] unsortedInventory={
                new Product(105, "Wireless Mouse", "Electronics"),
                new Product(101, "Mechanical Keyboard", "Electronics"),
                new Product(109, "Gaming Monitor", "Displays"),
                new Product(102, "USB-C Hub", "Accessories"),
                new Product(107, "Ergonomic Chair", "Furniture")
        };

        Product[] sortedInventory=unsortedInventory.clone();
        Arrays.sort(sortedInventory);

        int targetProductId=109;

        System.out.println("> Executing Linear Search on UNSORTED array for ID: " + targetProductId);
        Product linearResult=linearSearch(unsortedInventory, targetProductId);
        if (linearResult!=null) {
            System.out.println("  Found: " + linearResult);
        } else {
            System.out.println("  Product not found.");
        }

        System.out.println("> Executing Binary Search on SORTED array for ID: " + targetProductId);
        Product binaryResult=binarySearch(sortedInventory, targetProductId);
        if (binaryResult!=null) {
            System.out.println("  Found: " + binaryResult);
        } else {
            System.out.println("  Product not found.");
        }
    }
}