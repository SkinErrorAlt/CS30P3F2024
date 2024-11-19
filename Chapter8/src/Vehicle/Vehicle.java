package Vehicle;

public class Vehicle 
{
	protected String make;
	protected String model;
	protected int year;
	protected double price;
	
	public Vehicle(String make, String model, int year, double price) 
	{
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	public void start() 
	{
		System.out.println("Vehicle class started.");
	}

}
