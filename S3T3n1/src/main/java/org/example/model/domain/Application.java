package org.example.model.domain;

public class Application {
    
    
    
    
    FlowerShop flowerShop = new FlowerShop();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    //////////////// Christian methods //////////////////////////////
	
	public int searchList(int id, String type) {		//returns -1 if product is not in list. 
		int counter = 0;
		int index = -1;
		if (type.equalsIgnoreCase(flowerShop.getStockList().get(0).getClass().getSuperclass().getSimpleName())) {			//enter if superclass is product
			while (flowerShop.getStockList().get(counter).getId() != id && counter < flowerShop.getStockList().size()) {
				if (flowerShop.getStockList().get(counter).getId() == id) {
					index = counter;
				}
				counter++;
			}
		} else if (type.equalsIgnoreCase(flowerShop.getInvoiceLog().get(0).getClass().getSimpleName())) {					//enter if class is invoice
			while (flowerShop.getInvoiceLog().get(counter).getId() != id && counter < flowerShop.getInvoiceLog().size()) {
				if (flowerShop.getInvoiceLog().get(counter).getId() == id) {
					index = counter;
				}
				counter++;
			}
		}
		return index;
	}
    
	public void removeTree(int id, String type) {		
		int listIndex = searchList(id, type);
		if (listIndex != -1) {
			Product product = flowerShop.getStockList().get(listIndex);
			flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
			System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
		} else {
			System.out.println("The tree with Id# " + id + " does not exist.");
		}
	}
	
	public void removeFlower(int id, String type) {		
		int listIndex = searchList(id, type);
		if (listIndex != -1) {
			Product product = flowerShop.getStockList().get(listIndex);
			flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
			System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
		} else {
			System.out.println("The flower with Id# " + id + " does not exist.");
		}
	}
	
	public void removeDecoration(int id, String type) {		
		int listIndex = searchList(id, type);
		if (listIndex != -1) {
			Product product = flowerShop.getStockList().get(listIndex);
			flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
			System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
		} else {
			System.out.println("The decoration with Id# " + id + " does not exist.");
		}
	}
	
	public void printTotalEarnings() {
		System.out.println("The total earnings of " + flowerShop.getName() + " is: " + flowerShop.getTotalEarnings() + ".");
	}
	
	public void printNetWorth() {
		System.out.println("The total net worth of the stock is: " + flowerShop.getNetWorth() + ".");
	}
	
	public void printStockQuantities() {
		flowerShop.getProductMap().forEach((key, value) -> System.out.println("The total amount of " + key + " in stock is: " + value + "."));
	}
	
}
