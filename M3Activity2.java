package ph.com.bpi.hello;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class M3Activity2 {
	
	static Set<String> products = new HashSet<>();
	
	public static void main(String[] args) {
		
		// Creating a list of products with 5 records
		products.add("Laptop");
		products.add("Monitor");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Printer");
		
		boolean loopin = true;
		while (loopin) {
			printMenu();
			Scanner choiceMenu = new Scanner(System.in);
			System.out.print("> ");
			String choice = choiceMenu.nextLine();
			switch (choice) {
	        	case "1":
	        		searchProduct();
	        		break;
	        	case "2":
	        		addProduct();
	        		break;
	        	case "3":
	        		printProduct();
	        		break;
	        	case "4":
	        		System.out.println("Exiting...");
	        		loopin = false;
	        		break;
	        	default:
	        		System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
			}
		} 
		
	}
	
	public static void printMenu() {
        System.out.println("Select an option : ");
        System.out.println("1. Search a product");
        System.out.println("2. Add a product");
        System.out.println("3. Print all products and count");
        System.out.println("4. Exit");
	}
	
	public static void searchProduct() {
        // Finding product using for loop
     	Scanner input = new Scanner(System.in);
     	System.out.print("Enter product name to search : ");
     	String prod = input.nextLine();
     	boolean found = false;
     	
     	for(String prods : products) {
     		if (prod.equals(prods)) {
     			found = true;
     		}
     	}
     		
     	if (found) {
     		System.out.println("Product found : " + prod);
     	}
     	else {
     		System.out.println("Product not found.");
     	}	
	}
	
	public static void addProduct() {
		Scanner input = new Scanner(System.in);
        System.out.print("Enter product name to add : ");
        String prod = input.nextLine();
		if (products.add(prod)) {
            System.out.println("Product added: " + prod);
        } else {
            System.out.println("Product already exists.");
        }
	}
	
	public static void printProduct() {
		System.out.println("All Products : ");
		for(String i : products) {
			System.out.println(i);
		}
		System.out.println("Total unique products : " + products.size());
	}
	
}
