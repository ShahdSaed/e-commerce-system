/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommercesystem;

import java.util.List;

/**
 *
 * @author dell
 */
public class ShippingService {
     public static void shippingService(List<ShippableItem> items){
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for(ShippableItem item : items){
            System.out.println(item.getQuantity() + "x " + item.getName() + "\t" + String.format("%.2f", (item.getWeight()*1000)) + "g");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight " + String.format("%.2f", totalWeight) + "kg\n");
    }
}
