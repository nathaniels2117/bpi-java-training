package ph.com.bpi.hello;

public abstract class Vehicle {

	private String brand;
	private int numberOfWheels = 4;
	
	public Vehicle(String brandName, int numWheels) {
		this.brand = brandName;
		this.numberOfWheels  = numWheels;	
	}
	
	public Vehicle () {
	}
	
	public void destroy() {
		System.out.println(this.getBrand() + " is destroyed");
	}
   
	public void setBrand(String brandName) {
		this.brand = brandName;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setWheels(int numWheels) {
		this.numberOfWheels = numWheels;
	}
	
	public int getWheels() {
		return numberOfWheels;
	}
	
	abstract void startEngine();

	public void refuel() {
	}

}
