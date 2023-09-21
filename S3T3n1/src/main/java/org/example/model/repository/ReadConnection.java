package org.example.model.repository;

import org.example.model.domain.Invoice;
import org.example.model.domain.Product;

import java.util.List;

public class ReadConnection implements Connector{
    @Override
    public void connect() {
        //connection with file
    }

    public List<Invoice> invoiceLogReader(){
        //
        return null;
    }
    public List<Product> stockListReader(){
        return null;
    }
}
