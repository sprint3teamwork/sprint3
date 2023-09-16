package org.example.model.domain;

public class Product {
    private static int idNextNumber = 1;
    private int id;
    private String name;
    private double price;
    private String type;



    public Product(String name, double price) {
        id = idNextNumber;
        idNextNumber++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }
}
