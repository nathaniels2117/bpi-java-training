package ph.com.bpi.hello;

import java.util.Scanner;

public class Activity3 {
	
	public static void main(String[] args) {
		
        Scanner int1_input = new Scanner(System.in);
        System.out.print("Enter first integer : ");
        int int1 = int1_input.nextInt();
        
        Scanner int2_input = new Scanner(System.in);
        System.out.print("Enter first integer : ");
        int int2 = int2_input.nextInt();
        
        int sum = int1 + int2; 
        int dif = int1 - int2; 
        int pro = int1 * int2; 
        
        System.out.print("SUM : " + sum + "\n");
        System.out.print("Difference : " + dif + "\n");
        System.out.print("Product : " + pro);
        
	}
}
