package org.example.model.domain;

import java.util.Scanner;

public class Application {
    
	static Scanner sc = new Scanner(System.in);
    static FlowerShop flowerShop = null;
    static ProductFactory productFactory = new ProductFactory();
    
    public static void boot() {
    	
        int option = -1;

        do {
            option = menu();
            switch(option) {
                case 0 -> closeApplication();
                case 1 -> createFlowerShop();
                case 2 -> System.out.print("A reveure!");
                case 3 -> System.out.print("A reveure!");
                case 4 -> System.out.print("A reveure!");
                case 5 -> System.out.print("A reveure!");
                case 6 -> System.out.print("A reveure!");
                case 7 -> System.out.print("A reveure!");
                case 8 -> System.out.print("A reveure!");
                case 9 -> System.out.print("A reveure!");
                case 10 -> System.out.print("A reveure!");
                case 11 -> System.out.print("A reveure!");
                case 12 -> System.out.print("A reveure!");
                case 13 -> System.out.print("A reveure!");
            }
        } while(option != 0);

    }

    public static int menu() {
        int option = -1;

        System.out.print("MENU:\n"
                + "1.Create Flower Shop                 8.Remove Decortion\n"
                + "2.Add Tree item                      9.Quantity by stock type\n"
                + "3.Add Flower item                    10.FlowerShop Total Value\n"
                + "4.Add Decoration                     11.Start Buy\n"
                + "5.Show Stock                         12.Invoice Log\n"
                + "6.Remove Tree                        13.Total Earnings from Sales\n"
                + "7.Remove Flower                      CLOSE (press 0)\n\n");


        option = sc.nextInt();
        sc.nextLine();

        while(option < 0 || option > 13) {
            System.out.print("The number introduced isn't supported.\nTry again: ");
            option = sc.nextInt();
            sc.nextLine();
        }
        return option;
    }

    public static void closeApplication(){
        //Persistency goes here
        System.out.println("See You Soon!");
    }

    public static void createFlowerShop(){
        String name = "";

        if(flowerShop == null){
            System.out.println("Introduce the flower shop name: ");
            name = sc.nextLine();
            flowerShop = new FlowerShop(name);
        }else{
            System.out.println("You already created a flower-shop, you greedy bastard!\n");
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //////////////// Christian methods //////////////////////////////
    
    public void testObjectApp() {
    	//TEST Products
    	System.out.println("TESTING PRODUCTS");
        Product tree = new Tree("Oak",24.0d, 45f);
        Product flower = new Flower("Dalia",24.0d, "blue");
        Product woodArc = new Decoration("Arc",24.0d, true);
        Product woodArc2 = new Decoration("Arc2",24.0d, true);
        System.out.println(tree.toString());
        System.out.println(flower.toString());
        System.out.println(woodArc.toString());
        System.out.println(woodArc2.toString() + "\n");

        //TEST Invoice
        System.out.println("TESTING INVOICE");
        Invoice invoice1 = new Invoice();
        System.out.println(invoice1.getId());
        invoice1.addProduct(woodArc);
        invoice1.addProduct(flower);
        System.out.println(invoice1.getProductList().toString());
        System.out.println(invoice1.getTotalSale());
        invoice1.removeProduct(flower);
        System.out.println(invoice1.getTotalSale());
        invoice1.removeProduct(tree);//It shouldn't be able to substract this one
        System.out.println(invoice1.getTotalSale() + "\n");
        invoice1.addProduct(tree);
        invoice1.addProduct(tree);
        invoice1.addProduct(flower);
        invoice1.addProduct(woodArc2);

        //TEST FlowerShop
        System.out.println("TESTING FLOWERSHOP");
        flowerShop.addStock(tree);
        flowerShop.addStock(flower);
        flowerShop.addStock(woodArc);
        flowerShop.showStock();

        flowerShop.addInvoice(invoice1);
        System.out.println(flowerShop.getTotalEarnings());
        flowerShop.showInvoiceList();
        //flowerShop.removeInvoice(invoice1);
        System.out.println(flowerShop.getTotalEarnings());
    }
	
	public int searchList(int id, String type) {		//returns -1 if product is not in list. 
		int counter = 0;
		int index = -1;
		if (type.equalsIgnoreCase("product")) {			//enter if superclass is product
			while (flowerShop.getStockList().get(counter).getId() != id && counter < flowerShop.getStockList().size()) {
				if (flowerShop.getStockList().get(counter).getId() == id) {
					index = counter;
				}
				counter++;
			}
		} else if (type.equalsIgnoreCase("invoice")) {					//enter if class is invoice
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
