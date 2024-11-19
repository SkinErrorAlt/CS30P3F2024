package Facility;

import java.util.HashMap;

public class Faculty extends UEmployee 
{
	private static String department; // The Department name.
	
	public Faculty(String name, double salary, String department) 
	{
		super(name, salary); // Calls the parent which is (UEmployee).
		this.department = department;
	}

	public String getDepartment() 
	{
		return department;
	}
}
