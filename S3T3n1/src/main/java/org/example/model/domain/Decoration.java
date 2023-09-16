package org.example.model.domain;

public class Decoration extends Product{

    private boolean materialIsWood;
    public Decoration(String name, double price, boolean materialIsWood) {
        super(name, price);
        super.setType("Decoration");
        this.materialIsWood = materialIsWood;
    }

    public boolean isMaterialIsWood() {
        return materialIsWood;
    }
    
    public void setMaterialIsWood(boolean materialIsWood) {
        this.materialIsWood = materialIsWood;
    }

    public String toString(){
        return "Id = " + this.getId() + " | Name = " + this.getName() + " | Price = " + this.getPrice() +
                " | Is wood? = " + this.isMaterialIsWood() + " | Type = " + this.getType();
    }

}
