package org.example.model.domain;

public class Tree extends Product{
    private float height;

    public Tree(String name, double price) {
        super(name, price);
        super.setType("Tree");
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
