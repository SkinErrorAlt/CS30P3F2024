/*

This is used for a way more easier way of creating text in the most fastest way.

I made this since i got bored and wanted to try to make something like a Module script.

The code should be easy to read. Hopefully.

*/

package EasyKit;

import java.util.Scanner; // Imports the Scanner for the users inputs.
import java.time.LocalDateTime; // Imports the LocalDateTime for getting the users local time.
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter for fomatting the dates.

public class Text
{
    static Scanner input = new Scanner(System.in); // Gets the users input.
	static boolean endLoop = false; // Used for the for statement loops to keep looking until its able to go to the next one.
	private static int userInt; // Used for returning the users Integer.
	private static double userNum; // Used for returning the users Number.
	private static String userStr; // Used for returning the users String.

    public String checkClass(Object variable) // Checks what class the variable is.
	{
		if (variable instanceof Number) // If its Type is a Integer.
		{
			return "Integer"; // Returns a String to show what class it is.
		}
		else if (variable instanceof Double)  // If its Type is a Number.
	  	{
			return "Double"; // Returns a String to show what class it is.
	  	}
	  	else if (variable instanceof Boolean) // If its Type is a Boolean.
	  	{
	  		return "Boolean"; // Returns a String to show what class it is.
	  	}
	  	else if (variable instanceof String) // If its Type is a String.
	  	{
	  		return "String"; // Returns a String to show what class it is.
	  	}
		return "Null"; // If its different then it will just return a string null.
	}
	
	public static <M> void print(M Message) // Allows for easier printing, because i can type Ui.print(""); better then System.out.println(""); which is much longer.
	{
		System.out.println(Message); // Prints the Message
	}
	
	public static void addButton(int ButtonNumber, String Text) // Makes a easy button that can be made in just a simple function.
	{
		System.out.println("[" + ButtonNumber + "] " + Text); // Puts the ButtonNumber as the button selection and the text to what the button does.
	}
	
	public static void addSpace(int Amount) // Adds a quick and easy space with adjustable amount.
	{
		if (Amount > 0) // If Amount is more then 0
		{
			for (int i = 0; i < Amount; i++) // Loops the amount of times that is specified.
			{
				System.out.println(); // Goes down a line by printing nothing.
			}
		}
		else 
		{
			System.out.println(errorMessage("Needs to be more then 0")); // Displays an error message if its below or equal to 0.
		}
	}
	
	public static void clear() // A easy way to clear the screen since there is no built in thing in java.
	{
		addSpace(50); // Just adds 50 spaces to act like its clearing the screen.
	}
	
	public static String errorMessage(String Message) // An error message thats easily makable.
	{
		String red = "\u001B[31m"; // A red color for the error message.
		String returnMessage = red + Message; // Adds the red to the message.
	
		return returnMessage; // Returns the updated red message
	}
	
	public static String YesNo(boolean DoingCustomMessage, String CustomMessage) // Checks if the user answered yes or no.
	{
		boolean gotAnswer = false; // Checks if the user got the answer to then end the loop.
		boolean yes = false, no = false; // Checks if the user answered yes or no.
		String userinput, answer = "null"; // Gets the users input and answer.
		
		while (!gotAnswer) // Loops until it get a valid answer.
		{
            // Its able to catch an error so the program wont break.
			try
			{
				if (DoingCustomMessage && CustomMessage != null) // If the user is doing a custom messaage and what the message is.
				{
					System.out.print(CustomMessage + ": "); // Prints out the custom message with a : added at the end of it.
				}
				else 
				{
					System.out.print("Enter: "); // If the user is not doing a CustomMessage and the CustomMessage is not null then it will just do a simple Enter: 
				}
				
				userinput = input.next().toLowerCase(); // Makes the users response to lowercase so it doesn't have to check for every single way it can be typed.
				
				String[] yesAnswers = {"yes", "ye", "y"}; // An array of all available Yes responses.
				String[] noAnswers = {"no", "n"}; // An array of all available No responses.
				
				for (int i = 0; i < yesAnswers.length; i++) // Loops through and sees if it fits into any yes respones.
				{
					if (userinput.equals(yesAnswers[i])) // If the userinput is the same as one of the ones in the Yes array.
					{
						yes = true; // Makes it yes so it can show that its a yes.
                        break; // Ends the loop.
					}
				}
				
				for (int i = 0; i < noAnswers.length; i++) // Loops through and sees if it fits into any no respones.
				{
					if (userinput.equals(noAnswers[i]))  // If the userinput is the same as one of the ones in the No array. 
					{
						no = true; // Makes it no so it can show that its a no.
                        break; // Ends the loop.
					}
				}
				
				if (!(yes && no)) // If its not yes or no.
				{
					if (yes) 
					{
						answer = "Yes"; // Switches the answer to be Yes which is returned at the end of the function.
					}
					else 
					{
						answer = "No"; // Switches the answer to be No which is returned at the end of the function.
					}

					gotAnswer = true; // Changes got answer so it can end the loop.
				}
				else if (!(yes || no)) // If its not yes or not then it will print out that something went wrong.
				{
					System.out.println("Sorry please enter Yes or No.");
				}
				else 
				{
					System.out.println("Sorry please enter Yes or No.");
				}
			}
			catch (NumberFormatException e) // Catches an error incase of an error.
			{
				clear(); // Clears the screen.
				userinput = input.nextLine(); // Goes to nextLine
				System.out.println("Sorry not a valid option. Please try again."); // Shows what went wrong to the user.
			}
		}

		return answer; // Returns the answer to be used in a different function.
	}
	
	public static int userIntager(boolean DoingCustomMessage, String CustomMessage) // Gets the users Integer
	{
		boolean gotInteger = false; // Sees if it got the Integer.
		String userinput; // Stores the users input.
		
		while (!gotInteger) // While it doesn't have the Integer it will keep looping until it does.
		{
			try
			{
				if (DoingCustomMessage && CustomMessage != null) // If the user is doing a custom message and what message it is.
				{
					if (!CustomMessage.isEmpty()) // Checks if the CustomMessage is isEmpty
					{
						System.out.print(CustomMessage + ": "); // Outputs the custom message with a : at the end to show that the user can type there.
					} 
                    else 
                    {
                        System.out.print("Enter: "); // By default it will do a normal Enter:
                    }
				}
				else 
				{
					System.out.print("Enter: "); // By default it will do a normal Enter:
				}
				
				userinput = input.nextLine(); // Ends the users input.
				userInt = Integer.parseInt(userinput); // Parses the string into a int to be returned later.
				gotInteger = true; // Once it gets an Integer it will end the loop by setting it to true.
			}
			catch (NumberFormatException e) // Catches an error if the user inputs something like a string instead.
			{
				clear(); // Clears the screen.
				return -1; // Returns -1 so the screen can reset and show the prevous text and also so a custom error message can be shown.
			}
		}
	
		return userInt; // Returns the users Integer
	}
	
	public static double userDouble(boolean DoingCustomMessage, String CustomMessage) // Gets the users Number
	{
		boolean gotDouble = false; // Sees if it got the number
		String userinput; // Stores the users input.

		while (!gotDouble) // While it doesn't have the Number it will keep looping until it does.
		{
			try 
			{
				if (DoingCustomMessage && CustomMessage != null) // If the user is doing a custom message and what message it is.
				{
					if (!CustomMessage.isEmpty()) // Checks if the CustomMessage is isEmpty
					{
						System.out.print(CustomMessage + ": "); // Outputs the custom message with a : at the end to show that the user can type there.
					} 
                    else 
                    {
                        System.out.print("Enter: "); // By default it will do a normal Enter:
                    }
				}
				else 
				{
					System.out.print("Enter: "); // By default it will do a normal Enter:
				}
				
				userinput = input.next(); // Ends the users input.
				userNum = Double.parseDouble(userinput); // Parses the string into a double to be returned later.
				gotDouble = true; // Once it gets a Number it will end the loop by setting it to true.
			}
			catch (NumberFormatException e)
			{
				clear(); // Clears the screen.
				return -1; // Returns -1 so the screen can reset and show the prevous text and also so a custom error message can be shown.
			}
		}
	
		return userNum; // Returns the users number
	}
	
	public static String userString(boolean DoingCustomMessage, String CustomMessage) 
	{
		boolean gotString = false; // Sees if it got the String
		String userinput; // Stores the users input.
		while (!gotString) // While it doesn't have the String it will keep looping until it does.
		{
			try 
			{
				if (DoingCustomMessage && CustomMessage != null) // If the user is doing a custom message and what message it is.
				{
					if (!CustomMessage.isEmpty()) // Checks if the CustomMessage is isEmpty
					{
						System.out.print(CustomMessage + ": "); // Outputs the custom message with a : at the end to show that the user can type there.
					} 
                    else 
                    {
                        System.out.print("Enter: "); // By default it will do a normal Enter:
                    }
				}
				else 
				{
					System.out.print("Enter: "); // By default it will do a normal Enter:
				}

				userinput = input.nextLine();
				addSpace(1);
                
				userStr = userinput;
				gotString = true;
			}
			catch (NumberFormatException e)
			{
				clear(); // Clears the screen.
				userinput = input.next(); // Goes to the next line.
				return "null"; // Returns a string null to show that the user inputted something wrong.
			}
		}
	
		return userStr; // Returns the users String to be used later in a different function.
	}
	
	public static void userNext(boolean DoingCustomMessage, String CustomMessage) // Used for making the user enter nothing to go to the next line.
	{
		boolean gotString = false; // Sees if it got the String
		String userinput; // Stores the users input.

		while (!gotString) // While it doesn't have the String it will keep looping until it does.
		{
			try 
			{
				if (DoingCustomMessage && CustomMessage != null) // If the user is doing a custom message and what message it is.
				{
					if (!CustomMessage.isEmpty()) // Checks if the CustomMessage is isEmpty
					{
						System.out.print(CustomMessage + ": "); // Outputs the custom message with a : at the end to show that the user can type there.
					} 
                    else 
                    {
                        System.out.print("Enter: "); // By default it will do a normal Enter:
                    }
				}
				else 
				{
					System.out.print("Enter: "); // By default it will do a normal Enter:
				}
				
				userinput = input.next(); // Goes to the next line.
				userStr = userinput; // Makes the users string into the users input.
				gotString = true; // Ends the loop.
			}
			catch (NumberFormatException e)
			{
				clear(); // Clears the screen.
				userinput = input.nextLine(); // Goes to the nextline.
				System.out.println("Sorry not a valid option. Please try again."); // Shows the user that what they inputted didn't work.
			}
		}
	}
	
	public static void time(double seconds) // Allows the thread to sleep (aka waiting a certain amount of time before continuing).
	{
		try 
		{
            Thread.sleep((long) (seconds * 1000)); // Makes the thread sleep for a certain amount of time which is multiplied by 1000 to make a second.
        } 
		catch (InterruptedException e) // Catches an error.
		{
            e.printStackTrace();
        }
	}
	
	public static double RandomNumber(double Min, double Max) // Quickly gives a random number between a min and a max.
	{
		double GenRandomNumber = (Max * Math.random() + Min); // Generates a Random Number.
		return GenRandomNumber; // returns the random number.
	}

	public static String GetTime() // Returns the users time.
	{
		LocalDateTime myDateObj = LocalDateTime.now(); // Gets the current time.
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy/dd/MM - HH:mm:ss"); // Makes the date format.
        String formattedDate = myDateObj.format(myFormatObj); // Formats the current time to be more readable.

		return formattedDate; // Returns the date as a string.
	}

}