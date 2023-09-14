package org.example.model.domain;

public class Flower extends  Product{

    private String color;
    public Flower(String name, double price, String color) {
        super(name, price);
        super.setType("Flower");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
