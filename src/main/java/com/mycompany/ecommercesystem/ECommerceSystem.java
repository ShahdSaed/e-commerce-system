/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecommercesystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class ECommerceSystem {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        Cart cart = new Cart();
        Customer customer = new Customer("Shahd", 60000);
        
        productList.add(new Product("Cheese", 80, 10, true, LocalDate.of(2025, 12, 1), true, 0.3));
        productList.add(new Product("Milk", 25, 15, true, LocalDate.of(2025, 8, 1), true, 0.5));
        productList.add(new Product("Bread", 15, 20, true, LocalDate.of(2025, 7, 8), false, 0.0));
        productList.add(new Product("Laptop", 7000, 5, false, null, true, 2.5));
        productList.add(new Product("Mobile", 4000, 8, false, null, true, 0.4));
        productList.add(new Product("ScratchCard", 50, 50, false, null, false, 0.0));
        productList.add(new Product("Perfume", 300, 12, false, null, true, 0.6));
        productList.add(new Product("Keyboard", 150, 25, false, null, true, 0.9));
        productList.add(new Product("Mouse", 80, 30, false, null, true, 0.2));
        productList.add(new Product("TV", 5000, 3, false, null, true, 8.0));
        productList.add(new Product("Chips", 10, 100, true, LocalDate.of(2025, 7, 15), true, 0.1));
        productList.add(new Product("Chocolate", 20, 60, true, LocalDate.of(2025, 9, 10), true, 0.15));
        productList.add(new Product("Notebook", 30, 40, false, null, true, 0.3));
        productList.add(new Product("Water Bottle", 12, 80, true, LocalDate.of(2025, 10, 1), true, 0.6));
        productList.add(new Product("Pen", 5, 100, false, null, true, 0.05));
        productList.add(new Product("Headphones", 250, 10, false, null, true, 0.5));
        productList.add(new Product("Power Bank", 400, 6, false, null, true, 0.7));
        productList.add(new Product("Sneakers", 600, 7, false, null, true, 1.2));
        productList.add(new Product("Watch", 1000, 4, false, null, true, 0.3));
        productList.add(new Product("Toothpaste", 25, 20, false, null, true, 0.2));
        
       while (true) {
            System.out.println("\n--- Product List ---");
            for (int i = 0; i < productList.size(); i++) {
                Product p = productList.get(i);
                System.out.println(i + 1 + ". " + p.getName() + " - " + p.getPrice() + " LE - In stock: " + p.getQuantity());
            }
            System.out.println("0. Checkout");
            System.out.print("Select product by number (or 0 to pay): ");

            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > productList.size()) {
                System.out.println("Invalid choice.");
                continue;
            }

            Product selected = productList.get(choice - 1);
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(scanner.nextLine());
            cart.add(selected, qty);
            System.out.println(qty + "x " + selected.getName() + " added to cart.");
        }

        CheckoutService.checkout(customer, cart);
        
    
    }
}
