package org.example;

import org.example.model.domain.*;

public class Main {
    public static void main(String[] args) {


        //TEST Products
        Product tree = new Tree("Oak",24.0d, 45f);
        Product flower = new Flower("Dalia",24.0d, "blue");
        Product woodArc = new Decoration("Arc",24.0d, true);
        Product woodArc2 = new Decoration("Arc2",24.0d, true);
        System.out.println(tree.toString());
        System.out.println(flower.toString());
        System.out.println(woodArc.toString() + "\n");

        //TEST Invoice
        Invoice invoice1 = new Invoice();
        System.out.println(invoice1.getId());
        invoice1.addProduct(woodArc);
        invoice1.addProduct(flower);
        System.out.println(invoice1.getProductList().toString());
        System.out.println(invoice1.getTotalSale());
        invoice1.removeProduct(flower);
        System.out.println(invoice1.getTotalSale());
        invoice1.removeProduct(tree);//It shouldn't be able to substract this one
        System.out.println(invoice1.getTotalSale());





    }
}