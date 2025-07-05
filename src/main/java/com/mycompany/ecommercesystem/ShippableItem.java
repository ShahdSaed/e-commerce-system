/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommercesystem;

/**
 *
 * @author dell
 */

public class ShippableItem extends CartItem implements Shippable{
    public ShippableItem(Product product, int quantity){
        super(product, quantity);
    }
    
    public String getName(){
        return product.getName();
    }
    
    public double getWeight(){
        return product.getWeight();
    }
}
