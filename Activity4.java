package ph.com.bpi.hello;

import java.util.Scanner;

public class Activity4 {
	public static void main(String[] args) {
		
        Scanner age_input = new Scanner(System.in);
        System.out.print("Enter your age : ");
        int age = age_input.nextInt();
        
        if (age < 18 ) {
        	System.out.print("Minor");
        }
        else if (age >= 18 && age <= 59 ) {
        	System.out.print("Adult");
        } 
        else {
        	System.out.print("Senior");
        }
        
	}
}
