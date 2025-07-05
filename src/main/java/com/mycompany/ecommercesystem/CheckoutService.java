/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommercesystem;

import java.util.*;

/**
 *
 * @author dell
 */
public class CheckoutService {
    public static void checkout(Customer customer, Cart cart){
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty.");
        }
        double totalPrice = 0;
        for(CartItem item : cart.getItems()){
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        if(customer.getBalance() < totalPrice){
            throw new IllegalArgumentException("Insufficient balance.");
        }
        
        List<ShippableItem> shippables = new ArrayList<ShippableItem>();
        
        for(CartItem item : cart.getItems()){
            if(item.getProduct().shippableProduct()){
                shippables.add(new ShippableItem(item.getProduct(), item.getQuantity()));
            }
        }
        if(!shippables.isEmpty()){
            ShippingService.shippingService(shippables);
        }
        
        double subtotal = 0;
        double shippingFees = 0;
        System.out.println("** Checkout receipt **");
        for(CartItem item : cart.getItems()){
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "\t" + String.format("%.2f", item.getProduct().getPrice()));
            subtotal += item.getProduct().getPrice() * item.getQuantity();
            if(item.getProduct().shippableProduct()){
                shippingFees += item.getProduct().getWeight() * 20;
            }
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        double amount = subtotal + shippingFees;
        customer.deductBalance(amount);
        System.out.println("---------------------------------");
        System.out.println("Subtotal\t" + String.format("%.2f", subtotal));
        System.out.println("Shipping Fees\t" + String.format("%.2f", shippingFees));
        System.out.println("Amount\t" + String.format("%.2f", amount));
        System.out.println("Customer Balance " + String.format("%.2f", customer.getBalance()));
    }
}
