package M3_Activity1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M3Activity1 {
	
	public static void main(String[] args) {
		
		// Creating a list of products with 5 records
		List<String> products = new ArrayList<>();
		products.add("Laptop");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Monitor");
		products.add("Printer");
		
		
		// Print all products
		System.out.println("All Products : ");

		int x = 1;
		for(String i : products) {
			System.out.println(x + ". " + i);
			x++;
		}
		
		// Add new product and remove mouse
		products.add("Webcam");
		products.remove(1);
		
		System.out.println("After adding and removing products : ");
		
		x = 1;
		for(String i : products) {
			System.out.println(x + ". " + i);
			x++;
		}
		
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
		
		input.close();
		
	}
	
}
