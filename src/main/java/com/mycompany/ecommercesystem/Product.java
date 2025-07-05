/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommercesystem;

import java.time.LocalDate;

/**
 *
 * @author dell
 */
public class Product {
     private String name;
    private double price;
    private int quantity;
    private boolean hasAnExpiration;
    private LocalDate expiryDate;
    private boolean shippableProduct;
    private double weight;
    
    public Product(String name, double price, int quantity, boolean hasAnExpiration, LocalDate expiryDate, boolean shippableProduct, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.hasAnExpiration = hasAnExpiration;
        this.expiryDate = expiryDate;
        this.shippableProduct = shippableProduct;
        this.weight = weight;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean hasAnExpiration(){
        return hasAnExpiration;
    }
    
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    
    public boolean shippableProduct() {
        return shippableProduct;
    }

    public double getWeight() {
        return weight;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}
