package org.example;

import org.example.model.domain.Decoration;
import org.example.model.domain.Flower;
import org.example.model.domain.Product;
import org.example.model.domain.Tree;

public class Main {
    public static void main(String[] args) {


        //TEST code
        Product tree = new Tree("Oak",24.0d, 45f);
        Product flower = new Flower("Dalia",24.0d, "blue");
        Product woodArc = new Decoration("Arc",24.0d, true);
        Product woodArc2 = new Decoration("Arc",24.0d, true);
        System.out.println(tree.toString());
        System.out.println(flower.toString());
        System.out.println(woodArc.toString());


    }
}