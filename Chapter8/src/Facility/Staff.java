package Facility;

public class Staff extends UEmployee
{
	private String jobTitle; // The Job title of the employee.
	
	public Staff(String name, double salary, String jobTitle) 
	{
		super(name, salary); // Calls the parents which is (UEmployee)
		this.jobTitle = jobTitle;
	}	
	
	public String getJobTitle() 
	{
		return jobTitle;
	}
}
