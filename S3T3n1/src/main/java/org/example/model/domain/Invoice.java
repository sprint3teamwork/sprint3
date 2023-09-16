package org.example.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	private static int idNextNumber = 1;
	private int id;
	private List<Product> productList;
	private double totalSale = 0.0;
	
	public Invoice() {
		id = idNextNumber;
		idNextNumber++;
		productList = new ArrayList();
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public double getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}

	public int getId() {
		return id;
	}
	
	public int searchProductList(int productId) {		//returns -1 if product is not in list. 
		int counter = 0;
		int index = -1;
		while (productList.get(counter).getId() != productId && counter < productList.size()) {
			if (productList.get(counter).getId() == productId) {
				index = counter;
			}
			counter++;
		}
		return index;
	}
	
	public void addProduct(Product p) {

		productList.add(p);
		totalSale += p.getPrice();
	}
	
	public void removeProduct(Product p) {
		if(productList.contains(p)){
		productList.remove(p);
		totalSale -= p.getPrice();
		}else{
			//we need to think were we'll deal with this
		}
	}
	
	public void printProductList() {
		productList.forEach(System.out::println);
	}
	
	/*public void sumTotal() {
		productList.forEach(p -> this.totalSale += p.getPrice());
		System.out.println(this.totalSale);
	}*/

	public String toString(){
		//return "Id = " + this.getId() + " | Products = " + productList.forEach(p -> p.getName()); +;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Id = ").append(id).append(" | [");

		for (int i = 0; i < productList.size(); i++) {
			stringBuilder.append(productList.get(i).getName());
			if (i < productList.size() - 1) {
				stringBuilder.append(", ");
			}
		}

		stringBuilder.append("] | TOTAL: " + this.totalSale + "€");

		return stringBuilder.toString();
	}

}
