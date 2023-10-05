package org.example.model.domain;

public abstract class Product {
    protected static int idNextNumber = 1;
    protected int id;
    protected String name;
    protected double price;
    protected String type;

    public Product(int id,String name, double price){
        this.id = id;
        idNextNumber = id +1;
        this.name = name;
        this.price = price;
    }

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

    public void setType(String type) {
        this.type = type;
    }
}
