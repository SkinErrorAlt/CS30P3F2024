package Mastery;

import EasyKit.*;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

public class WordCount {

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
	
	private static class Word 
	{
		String Word = "";
		int Amount = 1;
		
		@SafeVarargs
		<WordType> Word(WordType... Property) 
		{
			for (WordType Type : Property) 
			{
				if (Type instanceof String) 
				{
					Word = (String) Type;
				}
				else 
				{
					Console.error("Class Word", "Invalid property type: [" + Property.getClass().getName() + "] | Needing Number or Word.");
				}
			}
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Text.clear();
		Scanner userInput = new Scanner(System.in);
		
		for (boolean InMainMenu = true; InMainMenu;) 
		{
			Text.print("[File Scanner 9000]");
			Text.addSpace();
			
			Text.addButton(1, "Select File");
			Text.addButton(2, "Quit");
			Text.addSpace();
			
			int MainMenuSelection = Text.userIntager(false, null);
			
			if (MainMenuSelection == 2) 
			{
				InMainMenu = false;
				Text.clear();
			}
			else if (MainMenuSelection == 1) 
			{
				Text.clear();

				for (boolean GettingUserFile = true; GettingUserFile;) 
				{
					Text.print("[Finding File]");
					Text.addSpace();
					Text.addButton(-1, "Back");
					Text.addSpace();
					
					String UserFile = Text.userString(false, null);
					
					if (UserFile.equals("-1")) 
					{
						GettingUserFile = false;
						Text.clear();
					}
					else 
					{
						for (boolean FileViewing = true; FileViewing;) 
						{
							List<Word> Words = new ArrayList<>();
							File textFile = new File("..\\Chapter11\\src\\Mastery\\" + UserFile + ".txt");
							
							try 
							{
								System.out.println("");
								try (Scanner textFileReader = new Scanner(textFile)) 
								{
									while (textFileReader.hasNext()) 
									{
										String wordFound = textFileReader.next();
										//System.out.println(wordFound);
										
										if (wordFound != null) 
										{
											boolean HasWord = false;
											for (Word getWords : Words) 
											{
												if (getWords.Word.equals(wordFound)) 
												{
													getWords.Amount += 1;
													HasWord = true;
													break;
												}
											}
											
											if (!HasWord) 
											{
												Word newWord = new Word(wordFound);
												Words.add(newWord);
											}
										}
									}
									
									for (boolean SearchingFile = true; SearchingFile;) 
									{
										Text.print("[File Properties]");
										Text.addSpace();
										
										Text.addButton(-1, "Back");
										Text.print("Type: ");
										Text.print("| (All) to view all instances and appearances of all words in " + UserFile + " |");
										Text.print("| {a word} to view the number of instances of that word in " + UserFile + " |");
										Text.addSpace();
										
										String UserSearch = Text.userString(false, null);
										
										if (UserSearch.toLowerCase().equals("-1")) 
										{
											Text.clear();
											SearchingFile = false;
										}
										else if (UserSearch.toLowerCase().equals("all")) 
										{
											Text.clear();
											Text.print("[Word: " + UserSearch + " ]");
											Text.addSpace();
											
											for (Word Word : Words) 
											{
												Text.print("[" + Word.Word + "] shows up a total [" + Word.Amount + "]");
											}
										}
										else 
										{
											for (boolean SearchingWord = true; SearchingWord;) 
											{
												Text.print("[Word: " + UserSearch + " ]");
												Text.addSpace();
												
												Text.addButton(-1, "Back");
												Text.print("Type: ");
												Text.print("| (All) to view all instances and appearances of all words in " + UserFile + " |");
												Text.print("| {a word} to view the number of instances of that word in " + UserFile + " |");
												Text.addSpace();
											}
										}
									}
								}
							} 
							catch (FileNotFoundException e) 
							{
								FileViewing = false;
								Text.clear();
								Text.print("No file with the name [" + UserFile + "] exists. Please try again.");
								Text.addSpace();
							}
						}
					}
				}
			}
			else 
			{
				Text.clear();
				Text.print("Not a valid option");
				Text.addSpace();
			}
		}
	}
}
