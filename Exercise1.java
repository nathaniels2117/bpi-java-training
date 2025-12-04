package ph.com.bpi.hello;

public class Exercise1 {
	public static void main(String[] args) {
		
		// Using Parameterized Constructor
		Car car1 = new Car("Ford","Raptor","Black");
		car1.displayOutput();
		
		// Using Setter and Getter
		Car car2 = new Car();
		car2.setBrand("Toyota");
		car2.setModel("Wigo");
		car2.setColor("Yellow");
		car2.displayOutput();
	}
}
