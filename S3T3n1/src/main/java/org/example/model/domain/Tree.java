package org.example.model.domain;

public class Tree extends Product{
    private float height;

    public Tree(String name, double price, float height) {
        super(name, price);
        super.setType("Tree");
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String toString(){
        return "Id = " + this.getId() + " | Name = " + this.getName() + " | Price = " + this.getPrice() +
                " | Height = " + this.getHeight() + " | Type = " + this.getType();
    }
}
