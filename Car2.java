package ph.com.bpi.hello;

public class Car2 extends Vehicle implements Refuelable {
	
	public Car2(String brandName, int numWheels) {
		this.setBrand(brandName);
		this.setWheels(numWheels);
	}
	
	@Override
	public void startEngine() {
		System.out.println(this.getBrand() + " starting the engine");
		System.out.println(this.getWheels() + " wheels");
	}

	@Override
	public void refuel() {
		System.out.println("Refueling " + this.getBrand());
	}
	
	@Override
	public void destroy() {
		System.out.println(this.getBrand() + " Car is destroyed");
	}

}
