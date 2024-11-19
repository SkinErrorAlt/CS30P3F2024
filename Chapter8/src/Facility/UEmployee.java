package Facility;

import java.util.HashMap;

public class UEmployee 
{
	// Gives the name and the salary for the Employee
	String name;
	double salary;
	
	// Sets the name.
	public UEmployee(String name, double salary) 
	{
		this.name = name;
		this.salary = salary;
	}
	
	// getName() returns the name of the employee -||-||- getSalary() returns the salary of the employee. \\
	
	public String getName() 
	{
		return name;
	}
	
	public double getSalary() 
	{
		return salary;
	}
}
