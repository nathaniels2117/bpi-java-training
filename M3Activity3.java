package ph.com.bpi.hello;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class M3Activity3 {
	
	static Map<String, Integer> products = new HashMap<>();
 	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Creating a list of products with 5 records
		products.put("Laptop", 50000);
		products.put("Monitor", 7000);
		products.put("Mouse", 500);
		products.put("Keyboard", 1000);
		products.put("Printer", 6000);
		
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
	        		searchcheapestProduct();
	        		break;
	        	case "5":
	        		System.out.println("Exiting...");
	        		loopin = false;
	        		break;
	        	default:
	        		System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 5.");
			}
		} 
		
	}
	
	public static void printMenu() {
        System.out.println("Select an option : ");
        System.out.println("1. Search a product");
        System.out.println("2. Add a product");
        System.out.println("3. Print all products and prices");
        System.out.println("4. Find the cheapest product");
        System.out.println("5. Exit");
	}
	
	public static void searchProduct() {
     	System.out.print("Enter product name to search : ");
     	String prodName = input.nextLine();
     	if (products.containsKey(prodName)) {
     		System.out.println("Product found! Price : " + products.get(prodName));
     	}
     	else {
     		System.out.println("Product not found.");
     	}	
	}
	
	public static void addProduct() {
        System.out.print("Enter product name to add : ");
        String prodName = input.nextLine();
        System.out.print("Enter price : ");
        int price = input.nextInt();
		if (!products.containsKey(prodName)) {
			products.put(prodName, price);
            System.out.println("Product added: " + prodName);
        } else {
            System.out.println("Product already exists.");
        }
	}
	
	public static void printProduct() {
		System.out.println("All products and prices : ");
		for (Map.Entry<String, Integer> product : products.entrySet()) {
			System.out.println(product.getKey() + " - " + product.getValue());
        }
		System.out.println("Total products : " + products.size());
	}
	
	public static void searchcheapestProduct() {
		String cheapestProduct = null;
		Integer cheapestPrice = Integer.MAX_VALUE;
		for (Map.Entry<String, Integer> product : products.entrySet()) {
			if (product.getValue() < cheapestPrice) {
				 cheapestProduct = product.getKey();
				 cheapestPrice = product.getValue();
			}
		}

		System.out.println("Cheapest product : " + cheapestProduct + " - " + cheapestPrice);
	}
	
}
