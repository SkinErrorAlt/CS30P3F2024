package Mastery;

import java.util.*;

public class ReverseList extends EasyKit.Text
{
	private static int userNumberAmount = 10; // Number of loops and numbers the user will be asked to give.
	private static ArrayList<Integer> numbers = new ArrayList(){}; // Contains the users numbers.
	private static ArrayList<Integer> sortedNumbers = new ArrayList(){}; // The sorted numbers.
	
	public static void main(String[] args) 
	{
		while (true) 
		{
			// Loops for every number that is needed
			for (int i = 1; i <= userNumberAmount;) 
			{
				print("Enter your (" + i + ") number.");
				addSpace();
				
				int userChoice = userIntager(true, "Enter your number");
				
				if (userChoice == -1) 
				{
					error("Failed, please enter a number.");
				}
				else 
				{
					i++;
					clear();
					numbers.add(userChoice);
				}
			}
		}
	}

}
