package org.example.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	
	private static int id = 0;
	private List<Product> productList;
	private double totalSale = 0.0;
	
	public Invoice() {
		id += 1;
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

	public static int getId() {
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
	}
	
	public void removeProduct(Product p) {
		productList.remove(p);
	}
	
	public void printProductList() {
		productList.forEach(System.out::println);
	}
	
	public void sumTotal() {
		productList.forEach(p -> this.totalSale += p.getPrice());
		System.out.println(this.totalSale);
	}

}
