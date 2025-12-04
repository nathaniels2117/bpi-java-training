package ph.com.bpi.hello;

public class Car {
	String brand, model, color;
	
	public Car(String brand, String model, String color) {
		this.brand = brand;
		this.model = model;
		this.color = color;
	}
	
	public Car() {
		this.brand = "";
		this.model = "";
		this.color = "";
	}
	
	public void setBrand(String brand) { 
		this.brand = brand; 
	}
	
	public void setModel(String model) { 
		this.model = model; 
	}
	
	public void setColor(String color) { 
		this.color = color; 
	}
	
	public String getBrand() { 
		return brand; 
	}
	
	public String getModel() { 
		return model; 
	}
	
	public String getColor() { 
		return color; 
	}
	
	void displayOutput() {
		System.out.println("===== CAR INFO =====");
		System.out.println("Brand : " + brand);
		System.out.println("Model : " + model);
		System.out.println("Color : " + color);
		System.out.println("====================");
	}
}
