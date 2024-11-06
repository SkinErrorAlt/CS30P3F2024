package Mastery;

import java.awt.EventQueue;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

import javax.swing.JFrame;

public class FindAndReplace extends EasyKit.Text {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindAndReplace window = new FindAndReplace();
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
	public FindAndReplace() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() throws IOException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Makes the screen go to the bottom so it doesn't just snap after the first input.
		clear();
		
		// The main loop for the console.
		while (true) 
		{
			// Title of the program.
			print("[Find And Replace]");
			addSpace();
			
			// Gives some context about it.
			print("Enter a text file name and it will check wether it exists.");
			print("And if it does it will then ask for a sentance or word.");
			print("And if it exists in the file it will replace it");
			print("Then it will ask for a word or sentance to replace it with");
			print("Then it will replace the word or sentance inside the text file.");
			addSpace();
			
			String UserFile = userString(true, "Enter file name"); // Asks the user for a file.
			
			File textFile = new File("..\\Chapter11\\src\\Mastery\\" + UserFile + (UserFile.contains(".") ? "" : ".txt")); // Looks for the file, and uses a ternary operator to adjust the .txt, Making a 8 line if statement into just a single line. and also make it easier to read.
			
			try // In-case the selected file doesn't exist it won't break and end the program.
			{
				clear();

				FileReader FileRead = new FileReader(textFile);
				BufferedReader BufferReader = new BufferedReader(FileRead);
				
				while (true) 
				{
					print("[Finder]");
					addSpace();
					
					String UserFind = userString(true, "Enter Word or Sentance"); // Asks the user for a file.
					
					String EntireFile = "";
					Scanner input = new Scanner(FileRead);
					
					while (input.hasNext()) 
					{
						EntireFile += input.next() + "\r\n";
					}
					
					System.out.println("Entire File: " + EntireFile);
					
					String UserReplace;
					
					clear();
					
					print("[Replacer]");
					addSpace();
					
					UserReplace = userString(true, "Enter Word or Sentance"); // Asks the user for a file.
					
					// Gets the users sentence or word to search for.
					clear();
					
					String OldText = "", Line = "";
					while (BufferReader.ready()) 
					{
						Line = BufferReader.readLine();
						OldText += Line + "\r";
						System.out.println("String [" + OldText + "]");
					}
					BufferReader.close();
					String NewText = OldText;
					
					NewText.replaceAll(UserFind, UserReplace);

					FileWriter writer = new FileWriter("..\\Chapter11\\src\\Mastery\\" + UserFile + (UserFile.contains(".") ? "" : ".txt"));
					writer.write(NewText);
					
					System.out.println("[" + NewText + "]");
					
					writer.close();
					break;
				}
			} 
			catch (FileNotFoundException e) 
			{
				clear();
				print("No file was found [" + UserFile + "]"); // Shows the user the file that doesn't exist.
				addSpace();
				continue; // Makes the loop end and go onto the next loop iteration.
			}
		}	
	}
}
