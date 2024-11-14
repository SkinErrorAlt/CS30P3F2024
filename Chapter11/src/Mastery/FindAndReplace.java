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

import EasyKit.Text;

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
			
			// Checks if the file exists.
			if (!textFile.exists()) 
			{
				clear();
				error("No text file with the name [" + UserFile + "] located in (.../Chapter11/src/Mastery/)");
				addSpace();
				continue;
			}

			clear();

			print("[Finder]");
			addSpace();
			
			String userFind = userString(true, "Enter Word or Sentence"); // Asks the user for a Word or Sentence to search for.
			
			clear();
			
			print("[Replacer] (" + userFind + ")");
			addSpace();
			
			String userReplace = userString(true, "Enter Word or Sentence"); // Asks the user for a Word or Sentence to replace the selected words with.
			
			// Calls the replace function for more easier replacing of a file.txt
			replaceTextInFile(UserFile, userFind, userReplace);
			
			clear();
		}	
	}
	
	public static void replaceTextInFile(String filePath, String target, String replace) throws IOException 
	{
		File file = new File("..\\Chapter11\\src\\Mastery\\" + filePath + (filePath.contains(".") ? "" : ".txt"));
		StringBuilder text = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
		{
			String currentLine;
			while ((currentLine = reader.readLine()) != null) 
			{
				currentLine = currentLine.replace(target, replace);
				text.append(currentLine).append(System.lineSeparator());
			}
		}
		
		// This will write over the text with 
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
		{
			writer.write(text.toString());
		}
	}
}
