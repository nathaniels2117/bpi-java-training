package ph.com.bpi.hello;

import java.util.Scanner;

public class Activity2 {
	
	public static void main(String[] args) {
		
        Scanner age_input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        String age = age_input.nextLine();
        int ageint = Integer.parseInt(age);
        double agedouble = Double.parseDouble(age);
        System.out.print("Your age is int : " + ageint + "\n");
        System.out.print("Your age is double : " + agedouble);
        
	}
}
