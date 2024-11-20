/*
	The reason i'm using window builder is because i will come back and revise this later on to a UI instead of console.
*/

package Mastery;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.JFrame;

public class WordCount extends EasyKit.Text {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordCount window = new WordCount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WordCount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	// information on why i decided to use a hash-map. I could have easily coded it so it would use a class with the name word and it would contain the word and an amount of it.
	// However the reason why i chose to do it in a hash-map is because its way faster then looking it up with a list,
	// a list takes some time and depending on how its set up can take O(n) of time complexity. So rather then learning the best method to combat its weakness, i decided to use a hash-map for very fast O(1).
	
	// Also another reason is because i wanted to really challenge my-self with hash-maps because the only thing i actually used it for was for a text dungeon game i was working on in computer science 20.
	// And because i don't actually understand everything for a hash-map. And using it helped me improve in an area that i was lacking in.
	
	private static Map<String, Integer> Stricted_Words = new HashMap<>(); // Stricted just means it will determine if a word is same for letter for letter without caring for caps.
	private static Map<String, Integer> Relaxed_Words = new HashMap<>(); // Relaxed just means it will determine a difference in caps as a different word.

	private static boolean inStrictedMode = false; // Checks if the user wants the word search to be stricted or not.
	private static boolean SpecialCharacters_DifferentWords = false; // Checks if the program will separate words if there is a special character between them.
	private static boolean Word_Blocks = true; // Checks if it should allow for "(Word block)" to be counted as a full word rather then "(Word" and "block)".
	
	private static char[] SpecialCharacters = {'-', ',', '_', '!', '@', '#', '$', '%', '^', '&', '*'};
	
	private static String LastMessage = null;
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Makes the screen go to the bottom so it doesn't just snap after the first input.
		clear();
		
		// The main loop for the console.
		while (true) 
		{
			// Title of the program.
			print("[Word Finder]");
			addSpace();
			
			// Gives some context about it.
			print("Enter a text file name and it will check wether it exists.");
			print("And if it does it will count how many of each word appears.");
			print("Then just search for a word or view all.");
			addSpace();
			
			String UserFile = userString(true, "Enter file name"); // Asks the user for a file.
			
			File textFile = new File("..\\Chapter11\\src\\Mastery\\" + UserFile + (UserFile.contains(".") ? "" : ".txt")); // Looks for the file, and uses a ternary operator to adjust the .txt, Making a 8 line if statement into just a single line. and also make it easier to read.
			
			try // In-case the selected file doesn't exist it won't break and end the program.
			{
				try (Scanner textFileReader = new Scanner(textFile)) // It will try to get the textFileReader as a scanner which will give access to the files strings.
				{
					// Clears them in-case of new words or a different selected file.
					Relaxed_Words.clear();
					Stricted_Words.clear();
					
					List<String> FullWords = new ArrayList<>(); // Contains all the words for the selected text-file once the while loop happens.
					
					// The whole point of this part of the code is to check and add words to a FullWords array which will contain every word within the text field. Slightly more slow by it works for now.
					while (textFileReader.hasNext()) // While it has the next string it will continue to loop through each word.
					{
						String wordFound = textFileReader.next(); // Gets the next word in the file.
						String FullWord = ""; // Declared for getting a full word.
						String WordSection = "";
						
						// For context of WordSection is that its used for checking a word block. This is just a message with "(" at the beginning, and ")" at its end. To be used for getting a block of a word.
						// This will be counted (as everything within it) a single word rather then different words. -- NOTE: This can be toggled. And is off by default.
						boolean isWordSection = false; // This is used for checking if -> (This is a message block) <- is happening.
						
						for (char Char : wordFound.toCharArray()) // Loops through the wordFound string by turning it into a character array to be checked.
						{
							if (Word_Blocks) 
							{
								if (Char == '(') // Starts the word block.
								{
									WordSection += Char;
									isWordSection = true;
									continue;
								}
								
								if (isWordSection) // If it is the word block.
								{
									WordSection += Char;
									print("[Word Section Before]: " + WordSection);
									continue;
								}

								if (Char == ')') // Ends the word block.
								{
									isWordSection = false;
									
									WordSection = WordSection + Char; // Adds the character ")" to it.
									FullWords.add(WordSection); // Adds it to the words list.
									print("[Word Section]: " + FullWords.get(FullWords.size() - 1));
									
									WordSection = ""; // Clears it.
									
									continue;
								}
							}
							
							// If it is toggled for special characters to be counted to separate words then it will do that.
							if (SpecialCharacters_DifferentWords) 
							{
								for (char Character : SpecialCharacters) // Loops through the Special Characters list. Then checks to see if it is a special character.
								{
									if (Char == Character) 
									{
										FullWords.add(FullWord); // Makes the new word : This is because the task was to separate the words when a special character is introduced.
										FullWord = ""; // Clears it so a new word can be created.
										continue; // Continues onto the next iteration because it already got the word.
									}
								}
							}
							
							FullWord += Char; // Fills up the word.
						}
						
						FullWords.add(FullWord); // Adds it when the character array stops because that means the word is completed.
					}
					
					for (String Word : FullWords) // Loops through every string inside FullWords list to then assign the current loops string to Word to then be checked if it exists within the stricted or relaxed hash-maps.
					{
						if (Stricted_Words.containsKey(Word.toLowerCase())) // Checks if it contains the word in lower-case because it doesn't care about caps and will always add up the value even if the user spelt it differently.
						{
							int Count = Stricted_Words.get(Word.toLowerCase()).intValue(); // Gets the current word amount.
							Stricted_Words.put(Word.toLowerCase(), Count + 1); // Overwrites the previous data key with the same string but a different value. It add 1 to the previous key value.
						}
						else // If doesn't contain the value it will add it with putting 1 since there is only 1 instance
						{
							Stricted_Words.put(Word.toLowerCase(), 1);
						}
						
						// Same thing as strict except how the word is sorted, and what hash-map its being stored in. This is case sensitive. Allowing the same word to be used with it having its own value.
						if (Relaxed_Words.containsKey(Word)) 
						{
							int Count = Relaxed_Words.get(Word).intValue();
							Relaxed_Words.put(Word, Count + 1);
						}
						else 
						{
							Relaxed_Words.put(Word, 1);
						}
					}
				}
			} 
			catch (FileNotFoundException e) 
			{
				clear();
				print("No file was found [" + UserFile + "]"); // Shows the user the file that doesn't exist.
				addSpace();
				continue; // Makes the loop end and go onto the next loop iteration.
			}
			
			clear();
			
			// The point of this loop is to in-sure that the user can check different words in the file and also for the 
			while (true) 
			{
				if (LastMessage != null) 
				{
					ShowWordCount(LastMessage);
				}
				
				// Shows the current menu to the user so they aren't confused.
				print("[Word Searcher]");
				print("Successfully got file [" + UserFile.replaceAll(".txt", "") + "].txt"); // Shows the selected file to the user and that it successfully got it. Also formats it so it wont have 2 .txt's for more clarity.
				addSpace();
				
				// Shows the commands the user has
				addButton("/All", "View all words");
				addButton("/Clear", "Clears Previous Words");
				addButton((SpecialCharacters_DifferentWords ? "/UnSpecial" : "/Special"), (SpecialCharacters_DifferentWords ? "All words attached count as one" : "Seperates words based on special characters"));
				addButton("/Back", "Go back");
				addSpace();

				// Adds a button, and to make it more dynamic so i don't have to waste a if statement on if it is stricted or not. And to do that i used a ternary operator to check if its true or false to change the text.
				addButton((inStrictedMode ? "/Relaxed" : "/Strict"), "Enable " + (inStrictedMode ? "Relaxed" : "Strict") +  " mode");
				addSpace();
				
				// Gets the users word to search for.
				String UserWord = userString(true, "Enter word");
				
				if (UserWord.charAt(0) == '/') // Checks if its apart of the command.
				{
					if (UserWord.toLowerCase().equals("/all")) 
					{
						LastMessage = null;
						clear();
						
						// If its is in stricted mode it will just print out all entries from the hash-map into the console in a format of "[word]: amount".
						if (inStrictedMode) 
						{
							for (Entry<String, Integer> Word : Stricted_Words.entrySet()) 
							{
								print("[" + Word.getKey() + "]: " + Word.getValue());
							}
						}
						else 
						{
							for (Entry<String, Integer> Word : Relaxed_Words.entrySet()) 
							{
								print("[" + Word.getKey() + "]: " + Word.getValue());
							}
						}
						
						addSpace();
						
						continue;
					}
					// Clears the console and goes onto the next iteration.
					else if (UserWord.toLowerCase().equals("/clear")) 
					{
						LastMessage = null;
						clear();
						continue;
					}
					// Goes to the last loop.
					else if (UserWord.toLowerCase().equals("/back")) 
					{
						LastMessage = null;
						clear();
						break;
					}
					
					// This block will check if the user is changing the stricted or relaxed modes.
					// Checks if it will be able to change the mode into relaxed or not. And if so then it will change it.
					else if (UserWord.toLowerCase().equals("/relaxed") || UserWord.toLowerCase().equals("/r")) 
					{
						if (!inStrictedMode) 
						{
							clear();
							print("Already in [Relaxed] mode."); // Shows the user that they are already in relaxed mode.
							addSpace();
							continue;
						}
						else 
						{
							clear();
							inStrictedMode = !inStrictedMode; // Changes the mode.
							continue;
						}
					}
					// Checks if it will be able to change the mode into strict or not. And if so then it will change it.
					else if (UserWord.toLowerCase().equals("/strict") || UserWord.toLowerCase().equals("/s")) 
					{
						if (inStrictedMode) 
						{
							clear();
							print("Already in [Stricted] mode."); // Shows the user they are already in strict mode.
							addSpace();
							continue;
						}
						else 
						{
							clear();
							inStrictedMode = !inStrictedMode; // Changes the mode.
							continue;
						}
					}
					
					// If no if-statements connected it will just pass through and continue.
				}
				// End of code block: changing stricted or relaxed modes.
				
				LastMessage = UserWord;
				
				// This function shows the words so there's less redundant code.
				ShowWordCount(LastMessage);
			}
		}	
	}
	
	// This function will show the word and count of the selected word.
	public static void ShowWordCount(String UserWord) 
	{
		// Checks if the user is in stricted mode
		if (inStrictedMode) 
		{
			// Checks if the Stricted Words contains the word in lower-case since every word is auto set lower-case.
			if (Stricted_Words.containsKey(UserWord.toLowerCase())) 
			{
				clear();
				print("[" + UserWord + "]: " + Stricted_Words.get(UserWord.toLowerCase())); // Shows the user the word in-cluding its amount
				addSpace();
			}
			else 
			{
				clear();
				print("[" + UserWord + "] doesn't appear in this file."); // Tells the user that the word doesn't exist.
				addSpace();
			}
		}
		else 
		{
			// Checks if the Relaxed Words contains the word.
			if (Relaxed_Words.containsKey(UserWord)) 
			{
				clear();
				print("[" + UserWord + "]: " + Relaxed_Words.get(UserWord)); // Shows the word and it's amount.
				addSpace();
			}
			else 
			{
				clear();
				print("[" + UserWord + "] doesn't appear in this file."); // Shows that the word doesn't exist.
				addSpace();
			}
		}
	}
	
}