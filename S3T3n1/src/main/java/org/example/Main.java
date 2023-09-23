package org.example;

import org.example.model.domain.*;
import org.example.model.repository.Connector;
import org.example.model.repository.ReadConnection;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Application.boot();

        ReadConnection read = new ReadConnection();
        List<Product> products = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();
        products = read.stockListReader();
        invoices = read.invoiceLogReader();

        products.forEach(p -> System.out.println(p.toString()));
        System.out.println("\n");
        invoices.forEach(p -> System.out.println(p.toString()));
    }
}