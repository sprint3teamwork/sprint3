package org.example.model.domain;

import java.util.ArrayList;
import java.util.List;

public class FlowerShop {
    private String name;
    private List<Product> stockList;
    private List<Invoice> invoiceLog;
    private double totalEarnings;

    public FlowerShop(String name) {
        this.name = name;
        this.stockList = new ArrayList<>();
        this.invoiceLog = new ArrayList<>();
        this.totalEarnings = 0.0d;
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

    public void addStock(Product p){
        stockList.add(p);
    }

    public void removeStock(Product p){
        if(stockList.contains(p)){
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
