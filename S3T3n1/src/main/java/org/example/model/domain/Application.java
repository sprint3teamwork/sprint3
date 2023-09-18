package org.example.model.domain;

public class Application {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		if (flowerShop.getStockList().get(listIndex) != null) {
			Product product = flowerShop.getStockList().get(listIndex);
			flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
			System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
		} else {
			System.out.println("The tree with Id# " + id + " does not exist.");
		}
	}
	
	public void removeFlower(int id, String type) {		
		int listIndex = searchList(id, type);
		if (flowerShop.getStockList().get(listIndex) != null) {
			Product product = flowerShop.getStockList().get(listIndex);
			flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
			System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
		} else {
			System.out.println("The flower with Id# " + id + " does not exist.");
		}
	}
	
	public void removeDecoration(int id, String type) {		
		int listIndex = searchList(id, type);
		if (flowerShop.getStockList().get(listIndex) != null) {
			Product product = flowerShop.getStockList().get(listIndex);
			flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
			System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
		} else {
			System.out.println("The decoration with Id# " + id + " does not exist.");
		}
	}
	
}
