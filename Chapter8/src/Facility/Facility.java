package Facility;

public class Facility 
{

	public static void main(String[] args) 
	{
		// Creates a new Professor.
		Faculty professor = new Faculty("Jack", 85000d, "Computer Science");
		System.out.println("Professor: " + professor.getName());
		System.out.println("Salary: " + professor.getSalary());
		System.out.println("Department: " + professor.getDepartment());
		System.out.println("");
		
		// Creates a new Staff Member.
		Staff StaffMember = new Staff("Stand", 55000d, "Head Assistant");
		System.out.println("Staff: " + StaffMember.getName());
		System.out.println("Salary: " + StaffMember.getSalary());
		System.out.println("Department: " + StaffMember.getJobTitle());
	}

}
