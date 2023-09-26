package org.example.model.repository;

import org.example.model.domain.Decoration;
import org.example.model.domain.Flower;
import org.example.model.domain.Invoice;
import org.example.model.domain.Product;
import org.example.model.domain.Tree;

import java.io.*;
import java.util.List;

public class WriteConnection implements Connector{
	
	private static File InvoiceLogDB;
	private static File StockListDB;
	
    @Override
    public void connect() {
        
    	//try {
    		
    		InvoiceLogDB = new File("C:\\Users\\formacio\\1.Intellij Projects\\sprint3\\S3T3n1\\InvoiceLogDB.txt");
    		StockListDB = new File("C:\\Users\\formacio\\1.Intellij Projects\\sprint3\\S3T3n1\\StockListDB.txt");
    		
			/*if (InvoiceLogDB.createNewFile()) {
				System.out.println("New Txt Database created: " + InvoiceLogDB.getName());
			} else {
				System.out.println("File database for invoice already exists.");
			}
			
			if (StockListDB.createNewFile()) {
				System.out.println("New Txt Database created: " + StockListDB.getName());
			} else {
				System.out.println("File database for stock already exists.");
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}*/

    }

    public void invoiceLogWriter(List<Invoice> invoiceLog){
    	
    	/*int invoiceId;														//if individual fields are needed
		double invoiceTotalSale;
		String invoiceString;*/
		
    	for (int i = 0; i < invoiceLog.size(); i++) {
    		
    		/*invoiceId = invoiceLog.get(i).getId();							//if individual fields are needed
    		invoiceTotalSale = invoiceLog.get(i).getTotalSale();
    		invoiceString = invoiceLog.get(i).getProductList().toString();*/
    		
    		try {
    			//BufferedWriter bw = new BufferedWriter(new FileWriter(InvoiceLogDB,true));
    			PrintWriter pw = new PrintWriter(new FileOutputStream(InvoiceLogDB,false));		//or file writer
    			pw.write(invoiceLog.get(i).toString() + "\n");
    			//pw.append("Invoice: " + invoiceId + "," + invoiceString + "," + invoiceTotalSale + "\n");		//if individual fields are needed
    			pw.close();
    		} catch (IOException ioe) {
    			System.out.println(ioe.getMessage());
    		}
    	}
        //   ' : ' colon will be default end of line symbol
    }
    
    public void stockListWriter(List<Product> stockList) {
    	/*int productId;
		String productName;
		double productPrice;				///variables if needed for different types
		String productType;
		float productHeight;
		String productColor;
		boolean productMaterial;*/


		for (int i = 0; i < stockList.size(); i++) {
    		/*productId = stockList.get(i).getId();
    		productName = stockList.get(i).getName();
    		productPrice = stockList.get(i).getPrice();
    		productType = stockList.get(i).getType();*/
    		
    		/*switch (productType) {		//used this switch to pull the switch type before implementing writing to document. 
    		 * 								//needed to cast the product type first before extracting its generic value. unable to do (subclass casting) stockList.get(i).get"value"()
    		 * 								//unsure if switch method or if else is better for speed
    		case "Tree":
    			
    			break;
    		case "Flower":
    			
    			break;
    		case "Decoration":
    			
    			break;
    		}*/

			try {        //stick this within each switch statement?
				BufferedWriter bw = new BufferedWriter(new FileWriter(StockListDB.getAbsoluteFile(), true));
				//PrintWriter pw = new PrintWriter(new FileOutputStream(StockListDB,true));
				bw.write(stockList.get(i).toString() + "\n");
				bw.close();

				//////////if needed to get individual field items ///////
    			/*if (productType.equalsIgnoreCase("tree")) {
    				Tree t = (Tree) stockList.get(i);
        			productHeight = t.getHeight();
        			
    				pw.append("Stock: " + productId + "," + productName + "," + productPrice + "," + productType + "," + productHeight + "\n");
        			pw.close();
    			} else if (productType.equalsIgnoreCase("flower")) {
    				Flower f = (Flower) stockList.get(i);
        			productColor = f.getColor();
    				pw.append("Stock: " + productId + "," + productName + "," + productPrice + "," + productType + "," + productColor + "\n");
        			pw.close();
    			} else if (productType.equalsIgnoreCase("decoration")) {
    				Decoration d = (Decoration) stockList.get(i);
        			productMaterial = d.isMaterialIsWood();
    				pw.append("Stock: " + productId + "," + productName + "," + productPrice + "," + productType + "," + productMaterial + "\n");
        			pw.close();
    			}*/

			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
		//   ' : ' colon will be default end of line symbol
	}
}


