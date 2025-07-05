/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommercesystem;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author dell
 */
public class Cart {
    private List<CartItem> items = new ArrayList<CartItem>();
    public void add(Product product, int quantity){
        if(quantity > product.getQuantity()){
            throw new IllegalArgumentException("Not enough quantity for: " + product.getName());
        }
        if(product.hasAnExpiration()){
            if(product.getExpiryDate().isBefore(LocalDate.now())){
                throw new IllegalArgumentException(product.getName() + " is expired.");
            }
        }
        if(product.shippableProduct()){
            items.add(new ShippableItem(product, quantity));
        } else {
            items.add(new CartItem(product, quantity));
        }
    }
    
    public List<CartItem> getItems(){
        return items;
    }
    
    public boolean isEmpty(){
        return items.isEmpty();
    }
}
