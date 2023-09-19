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
        }while(option != 0);

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

    public static int searchList(int id, String type) {		//returns -1 if product is not in list.
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

    public static void removeTree(int id, String type) {
        int listIndex = searchList(id, type);
        if (listIndex != -1) {
            Product product = flowerShop.getStockList().get(listIndex);
            flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
            System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
        } else {
            System.out.println("The tree with Id# " + id + " does not exist.");
        }
    }

    public static void removeFlower(int id, String type) {
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













































    //ARNAU METODS
    //StartBuy
    //Invoice Log
    public static void addTree(){
        String name = "";
        float price = 0.0f;
        float height = 0.0f;

        System.out.println("What's the tree species?");
        name = sc.nextLine();
        System.out.println("The price will be?");
        price = Float.parseFloat(sc.next());
        System.out.println("And it's height?");
        height = Float.parseFloat(sc.next());
        Product p = productFactory.createProduct("tree",name,price,height);
        flowerShop.addStock(p);

    }
    public static void addFlower(){
        String name = "";
        float price = 0.0f;
        String color = "";

        System.out.println("What's the flower species?");
        name = sc.nextLine();
        System.out.println("The price will be?");
        price = Float.parseFloat(sc.next());
        System.out.println("And it's color is?");
        color = sc.nextLine();
        Product p = productFactory.createProduct("flower",name,price,color);
        flowerShop.addStock(p);

    }
    public static void addDecoration(){
        String name = "";
        float price = 0.0f;
        int option = 0;
        boolean isWood;

        System.out.println("What's the item's name?");
        name = sc.nextLine();
        System.out.println("The price will be?");
        price = Float.parseFloat(sc.next());
        System.out.println("And it is made of wood(1) or plastic?(2)");
        option = sc.nextInt();
        sc.nextLine();
        isWood = option == 1;//if option == 1,isWood = true, if not is plastic
        Product p = productFactory.createProduct("decoration",name,price,isWood);
        flowerShop.addStock(p);

    }

    public static void showStock(){
        flowerShop.showStock();
    }

    public static void startBuy(){
        int idSelected = 0;
        int idfound = -1;

        System.out.println("Here is the product list. Type the id of the product you want to buy");
        flowerShop.showStock();
        idSelected = sc.nextInt();
        sc.nextLine();
        searchList(idfound,"product");
        //flowerShop.removeStock();

    }
}