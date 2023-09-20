package org.example.model.domain;

import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    static FlowerShop flowerShop = null;
    static ProductFactory productFactory = new ProductFactory();
    public static void boot() {
        int option = -1;

        createSmapleData();/////////////////////////////////////////////////////////////////////////////////////////
        do {
            option = menu();
            switch(option) {
                case 0 -> closeApplication();
                case 1 -> createFlowerShop();
                case 2 -> addTree();
                case 3 -> addFlower();
                case 4 -> addDecoration();
                case 5 -> showStock();
                case 6 ->
                case 7 -> System.out.print("A reveure!");
                case 8 -> System.out.print("A reveure!");
                case 9 -> System.out.print("A reveure!");
                case 10 -> System.out.print("A reveure!");
                case 11 -> startBuy();
                case 12 -> invoiceLog();
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

  //TEST DATA////////////////////////////////////////////////////////////////////////////////////////
    public static void createSmapleData(){

        flowerShop = new FlowerShop("La Rosita");

        Product tree = new Tree("Oak",24.0d, 45f);
        Product flower = new Flower("Dalia",24.0d, "blue");
        Product woodArc = new Decoration("Arc",24.0d, true);
        Product woodArc2 = new Decoration("Arc2",24.0d, true);
        flowerShop.addStock(tree);
        flowerShop.addStock(flower);
        flowerShop.addStock(woodArc);
        flowerShop.addStock(woodArc2);
    }

//////////////// Christian methods //////////////////////////////

    public static int searchList(int id, String type) {        //returns -1 if product is not in list.
        int index = -1;

        if (type.equalsIgnoreCase("product")) {
            index = searchStock(id);
        } else if (type.equalsIgnoreCase("invoice")) {
            index = searchInvoiceLog(id);
        }
        return index;
    }

    public static int searchStock(int id){
        int counter = 0;
        int index = -1;

        while (counter < flowerShop.getStockList().size()) {
            if (flowerShop.getStockList().get(counter).getId() == id) {
                index = counter;
                counter = flowerShop.getStockList().size();
            }
            counter++;
        }
        return index;
    }

    public static int searchInvoiceLog(int id){
        int counter = 0;
        int index = -1;

        while (counter < flowerShop.getInvoiceLog().size()) {
            if (flowerShop.getInvoiceLog().get(counter).getId() == id) {
                index = counter;
                counter = flowerShop.getInvoiceLog().size();
            }
            counter++;
        }
        return index;
    }

    public static void removeTree(int id) {
        int listIndex = searchList(id, "product");
        if (flowerShop.getStockList().get(listIndex) != null) {
            Product product = flowerShop.getStockList().get(listIndex);
            flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
            System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
        } else {
            System.out.println("The tree with Id# " + id + " does not exist.");
        }
    }

    public static void removeFlower(int id) {
        int listIndex = searchList(id, "product");
        if (flowerShop.getStockList().get(listIndex) != null) {
            Product product = flowerShop.getStockList().get(listIndex);
            flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
            System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
        } else {
            System.out.println("The flower with Id# " + id + " does not exist.");
        }
    }

    public static void removeDecoration(int id) {
        int listIndex = searchList(id, "product");
        if (flowerShop.getStockList().get(listIndex) != null) {
            Product product = flowerShop.getStockList().get(listIndex);
            flowerShop.removeStock(flowerShop.getStockList().get(listIndex));
            System.out.println("The " + product.getType() + " " + product.getId() + " " + product.getName() + " has been removed from the list.");
        } else {
            System.out.println("The decoration with Id# " + id + " does not exist.");
        }
    }

    public static int removerPrompt(){
        System.out.println("Here is the product list. Type the id of the product you want to remove");
        flowerShop.showStock();
    }

    //ARNAU METODS
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
        System.out.println("The item '" + p.getName() + "' was created succesfully!\n");
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
        System.out.println("The item '" + p.getName() + "' was created succesfully!\n");
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
        System.out.println("The item '" + p.getName() + "' was created succesfully!\n");
    }

    public static void showStock(){
        flowerShop.showStock();
    }

    public static void startBuy(){
        int option = 1;
        int invoiceId;
        int invoicePosition;
        Invoice invoice = new Invoice();

        flowerShop.addInvoice(invoice);
        invoicePosition = searchList(invoice.getId(),"invoice");
        invoice = flowerShop.getInvoiceLog().get(invoicePosition);

        while (option == 1){
            System.out.println("Here is the product list. Type the id of the product you want to buy");
            invoice = saleLoop(invoice);
            System.out.println("Do you want to keep shopping?\nYES(1)      NO(2)       (3)[Delete product from cart]\n");

            if(option == 3 && invoice.getProductList().size() == 0) {
                System.out.println("Your shopping cart is empty\nDo you want to keep shopping?\n" +
                        "YES(1)      NO(2)\n");
            } else if (option == 3 && invoice.getProductList().size() > 0) {
                deleteProductFromInvoice(invoice);
                option = 1;
            }
            System.out.println("Response (numerical): ");
            option = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("\nRECEIPT:");
        System.out.println(invoice.toString() + "\nInvoice archived.");
    }

    public static Invoice saleLoop(Invoice invoice){
        int idSelected;
        int productPosition = -1;


        flowerShop.showStock();
        System.out.print("Id: ");
        idSelected = sc.nextInt();
        sc.nextLine();
        productPosition =  searchList(idSelected,"product");

        while (productPosition == -1){
            productPosition = searchList(idSelected,"product");
            System.out.println("Id mismatch.\nEnter Id again: ");
            idSelected = sc.nextInt();
        }

        invoice.addProduct(flowerShop.getStockList().get(productPosition));
        flowerShop.removeStock(flowerShop.getStockList().get(productPosition));
        System.out.println("Shopping cart:\n");
        System.out.println(invoice.toString() + "\n");

        return invoice;
    }

    public static void deleteProductFromInvoice(Invoice invoice){
        int numberSelected;
        Product p;

        System.out.println("Select the number of the product you want to delete from the invoice:\n");
        System.out.print(invoice.toString() + "\nProduct number: ");
        numberSelected = sc.nextInt();
        sc.nextLine();
        p = invoice.getProductList().get(numberSelected-1);
        invoice.removeProduct(p);
        flowerShop.addStock(p);
        //add sum to networth/stockvalue
        System.out.println("'" + p.getName() + "' was deleted succesfully.");
    }

    public static void invoiceLog(){
        flowerShop.showInvoiceList();
    }
}