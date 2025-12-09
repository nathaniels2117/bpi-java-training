package ph.com.bpi.hello;

public class Exercise2 {
	
	public static void main(String[] args) {
		Car2 car = new Car2("Toyota Raize",4);
		Truck truck = new Truck("Isuzu N-Series",6);
		
		car.startEngine();
		car.refuel();
		destroyVehicle(car);
		System.out.println("==================================");
		truck.startEngine();
		truck.refuel();
		destroyVehicle(truck);
		
	}

	private static void destroyVehicle(Truck mytruck) {
		mytruck.destroy();
	}
	
	private static void destroyVehicle(Car2 mycar) {
		mycar.destroy();
	}
}
