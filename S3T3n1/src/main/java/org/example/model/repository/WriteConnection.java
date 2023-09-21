package org.example.model.repository;

import org.example.model.domain.Invoice;
import org.example.model.domain.Product;

import java.util.List;

public class WriteConnection implements Connector{
    @Override
    public void connect() {
        //connection with file
    }

    public void invoiceLogWriter(List<Invoice> invoiceLog){
        //   ' : ' colon will be default end of line symbol
    }
    public List<Product> stockListReader(){
        return null;
    }
}


