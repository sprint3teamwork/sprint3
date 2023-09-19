package org.example.model.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowerShop {
    private String name;
    private List<Product> stockList;
    private List<Invoice> invoiceLog;
    private double totalEarnings;
    private double netWorth;
    private Map<String, Integer> productMap;


	public FlowerShop(String name) {
        this.name = name;
        this.stockList = new ArrayList<>();
        this.invoiceLog = new ArrayList<>();
        this.totalEarnings = 0.0d;
        this.netWorth = 0.0d;
        this.productMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getStockList() {
        return stockList;
    }

    public void setStockList(List<Product> stockList) {
        this.stockList = stockList;
    }

    public List<Invoice> getInvoiceLog() {
        return invoiceLog;
    }

    public void setInvoiceLog(List<Invoice> invoiceLog) {
        this.invoiceLog = invoiceLog;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public double getNetWorth() {
    	return netWorth;
    }
    
    public void setNetWorth(double netWorth) {
    	this.netWorth = netWorth;
    }
    
    public Map<String, Integer> getProductMap() {
    	return productMap;
    }
    
    public void setProductMap(Map<String, Integer> productMap) {
    	this.productMap = productMap;
    }
    
    //aqui me sale error con el get objeto
    public void addStock(Product p){
        stockList.add(p);
        netWorth += p.getPrice();
        productMap.put(p.getType(), (int) productMap.get(p.getType()) + 1); // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "java.util.Map.get(Object)" is null
    }

    public void removeStock(Product p){
        if(stockList.contains(p)){
        	netWorth -= p.getPrice();
        	productMap.put(p.getType(), (int) productMap.get(p.getType()) - 1);
            stockList.remove(p);
        }else{
            //we need to think where and how will we deal with this
        }
    }

    public void showStock(){
        stockList.forEach(System.out::println);
    }

    public void addInvoice(Invoice i ){
        invoiceLog.add(i);
        totalEarnings += i.getTotalSale();
    }

    public void removeInvoice(Invoice i){
        if(invoiceLog.contains(i)){
            invoiceLog.remove(i);
            totalEarnings -= i.getTotalSale();
        }else{
            //we need to think where and how will we deal with this
        }
    }

    public void showInvoiceList() {
        invoiceLog.forEach(System.out::println);
    }
}
