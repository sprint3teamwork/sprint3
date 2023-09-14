package org.example.model.domain;

public class Decoration extends Product{

    private boolean materialIsWood;
    public Decoration(String name, double price, String material) {
        super(name, price);
        super.setType("Decoration");
    }

    public boolean isMaterialIsWood() {
        return materialIsWood;
    }
    
    public void setMaterialIsWood(boolean materialIsWood) {
        this.materialIsWood = materialIsWood;
    }

}
