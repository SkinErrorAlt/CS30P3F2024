package Mastery;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	public static Map<String, Integer> Stricted_Words = new HashMap<>(); // Stricted just means it will determine if a word is same for letter for letter without caring for caps.
	public static Map<String, Integer> Relaxed_Words = new HashMap<>(); // Relaxed just means it will determine a difference in caps as a different word.
	
	public static Map<String, Integer> Searched_Words_History = new HashMap<>(); // Used to get the users history of words they have looked for in the past.
	
	public static boolean inStrictedMode = false;
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		clear();
		
		while (true) 
		{
			print("[Word Finder]");
			addSpace();
			
			print("Enter a text file name and it will check wether it exists.");
			print("And if it does it will count how many of each word appears.");
			print("Then just search for a word or view all.");
			addSpace();
			
			String UserFile = userString(true, "Enter file name");
			
			File textFile = new File("..\\Chapter11\\src\\Mastery\\" + UserFile + (UserFile.contains(".") ? "" : ".txt"));
			System.out.println(textFile.exists() ? "Exists" : "Doesn't exist" + " | " + textFile.exists());
			
			if (!textFile.exists()) 
			{
				clear();
				print("No file was found [" + UserFile + "]");
				addSpace();
				continue;
			}
			
			try 
			{
				System.out.println("");
				try (Scanner textFileReader = new Scanner(textFile)) 
				{
					Relaxed_Words.clear();
					Stricted_Words.clear();
					
					while (textFileReader.hasNext()) 
					{
						String wordFound = textFileReader.next();
						wordFound.replace(" ", "");
						
						if (wordFound.contains("-")) 
						{
							boolean NewWord = false;
							for (char Char : wordFound.toCharArray()) 
							{
								if (Char == '-') 
								{
									
								}
							}
						}
						
						if (Stricted_Words.containsKey(wordFound.toLowerCase())) 
						{
							int Count = Stricted_Words.get(wordFound.toLowerCase()).intValue();
							Stricted_Words.put(wordFound.toLowerCase(), Count + 1);
						}
						else 
						{
							Stricted_Words.put(wordFound.toLowerCase(), 1);
						}
						
						if (Relaxed_Words.containsKey(wordFound)) 
						{
							int Count = Relaxed_Words.get(wordFound).intValue();
							Relaxed_Words.put(wordFound, Count + 1);
						}
						else 
						{
							Relaxed_Words.put(wordFound, 1);
						}
						
						System.out.println("");
					}
				}
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println("Failed to get file");
			}
			
			clear();
			
			while (true) 
			{
				print("[Word Searcher]");
				print("Successfully got file [" + UserFile + "]");
				addSpace();
				
				addButton("/All", "View all");
				addButton("/Clear", "Makes it clear");
				addButton("/Back", "Go back");
				addSpace();
				addButton((inStrictedMode ? "/Relaxed" : "/Strict"), "Enable " + (inStrictedMode ? "Relaxed" : "Strict") +  " mode");
				addSpace();
				
				String UserWord = userString(true, "Enter word");
				
				if (UserWord.charAt(0) == '/') 
				{
					if (UserWord.toLowerCase().equals("/all")) 
					{
						clear();
						
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
					else if (UserWord.toLowerCase().equals("/clear")) 
					{
						clear();
						continue;
					}
					else if (UserWord.toLowerCase().equals("/back")) 
					{
						clear();
						break;
					}
					else if (UserWord.toLowerCase().equals("/relaxed")) 
					{
						if (!inStrictedMode) 
						{
							clear();
							print("Already in [Relaxed] mode.");
							addSpace();
							continue;
						}
						else 
						{
							clear();
							inStrictedMode = !inStrictedMode;
							continue;
						}
					}
					else if (UserWord.toLowerCase().equals("/strict")) 
					{
						if (inStrictedMode) 
						{
							clear();
							print("Already in [Stricted] mode.");
							addSpace();
							continue;
						}
						else 
						{
							clear();
							inStrictedMode = !inStrictedMode;
							continue;
						}
					}
				}
				
				if (inStrictedMode) 
				{
					if (Stricted_Words.containsKey(UserWord.toLowerCase())) 
					{
						clear();
						print("[" + UserWord + "]: " + Stricted_Words.get(UserWord.toLowerCase()));
						addSpace();
					}
					else 
					{
						clear();
						print("[" + UserWord + "] doesn't appear in this file.");
						addSpace();
					}
				}
				else 
				{
					if (Relaxed_Words.containsKey(UserWord)) 
					{
						clear();
						print("[" + UserWord + "]: " + Relaxed_Words.get(UserWord));
						addSpace();
					}
					else 
					{
						clear();
						print("[" + UserWord + "] doesn't appear in this file.");
						addSpace();
					}
				}
			}
		}	
	}
}