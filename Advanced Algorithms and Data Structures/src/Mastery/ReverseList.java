package Mastery;

import java.util.*;
import java.text.DecimalFormat;

public class ReverseList extends EasyKit.Text
{
	private static int userNumberAmount = 10; // Number of loops and numbers the user will be asked to give.
	private static ArrayList<Double> numbers = new ArrayList<>(); // Contains the users numbers.

	public static void main(String[] args) 
	{
		clear();
		
		while (true) 
		{
			// Prompts the user with entering an amount of numbers that will be sorting.
			print("Enter the amount of numbers you wish to sort.");
			addSpace();
			
			Integer userInt = userInteger(true, "Enter amount");
			
			// Makes sure the user entered a valid number.
			if (userInt == null) 
			{
				clear();
				error("Failed, please enter a number.");
				continue; // Skips to the next loop without continuing the code.
			}
			
			// Sets the amount to the amount the user wants.
			userNumberAmount = userInt;
			clear();

			// Loops for every number that is needed
			for (int i = 0; i < userNumberAmount;) 
			{
				print("Enter your (" + (i + 1) + ") number.");
				addSpace();
				
				Double userChoice = userDouble(false, null);
				
				// Makes sure the user entered a valid number.
				if (userChoice == null) 
				{
					error("Failed, please enter a number.");
					continue; // Skips to the next loop without continuing the code.
				}

				i++;
				clear();
				
				// Adds the users number to the list to be stored for later use.
				numbers.add(userChoice);
			}
			
			BubbleSort(numbers);
			break;
		}
	}

	/*
	
	Sorts by looping through the array given.
	
	Then it will compare the current number its checking with the next number.
	If the next number is greater then it will swap those numbers.
	
	Once its done swapping the numbers it will continue to the next set of number.
	Or it will go back to the beginning and check it again.

	------------------------------------------------------------------------------------
	
	A better way of explaining this is:
	
	The main "Loop" will be considered a group.
	Each group will contain sections. There will be a number of sections that there are numbers within the array.
	
	Once a (Loop) group is started. It will then start a section, which is another loop within a group.
	A section will loop for the amount of numbers inside the array.
	
	Inside the loop is a check statement that will check the current Number with the next Number in the section.
	And it will compare its numbers. If the current selection is greater than the next selection then it will swap the numbers.
	Then it will make the selected number go to the next selected number.
	
	Then once all numbers within all sections has been checked it will go onto the next group.

	 */
	
	public static void BubbleSort(ArrayList<Double> numbers) 
	{
		// Gets the size of the array.
		// This is used for making sure every single number has been checked. And also handling the loops.
		int lengthOfArray = numbers.size();

		// Loops through the array for every number.
		// The (AllArray < lengthOfArray - 1) makes sure that there is enough loops to go through the array for each group.
		for (int AllArray = 0; AllArray < lengthOfArray - 1; AllArray++) 
		{
			// The section will go through each number in the array one by one until the end.
			// With also switching the current number with the next number if the current number is bigger then the next number.
			for (int Number = 0; Number < lengthOfArray - AllArray - 1; Number++) 
			{
				// Checks if the next number is bigger then the current number.
				// If it is then it will switch those numbers around.
				if (numbers.get(Number) > numbers.get(Number + 1)) 
				{
					double swapNum = numbers.get(Number); // Temporarily stores the current number. 
					numbers.set(Number, numbers.get(Number + 1)); // Swaps the current number with the next number.
					numbers.set(Number + 1, swapNum); // Sets the next number to the temporarily stored current number.
				}
			}
		}
		
		// Used for formating the number.
		DecimalFormat Decimal = new DecimalFormat("#.##");

		// Shows the sorted numbers.
		print("-=- Sorted -=-");

		for (double num : numbers) 
		{	
			print("    [" + Decimal.format(num) + "]");
		}
	}
}
