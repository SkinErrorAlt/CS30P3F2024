package Mastery;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
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
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		File textFile = new File("C:\\Users\\27237009\\git\\CS30P3F2024_7\\Chapter11\\src\\Mastery\\source.txt");
		
		System.out.println(textFile.exists() ? "Exists" : "Doesn't exist" + " | " + textFile.exists());
		
		if (!textFile.exists()) {return;}
		
		try 
		{
			Map<String, Integer> Stricted_Words = new HashMap<>(); 
			Map<String, Integer> Relaxed_Words = new HashMap<>(); 
			
			System.out.println("");
			try (Scanner textFileReader = new Scanner(textFile)) 
			{
				while (textFileReader.hasNext()) 
				{
					String wordFound = textFileReader.next();
					wordFound.replace(" ", "");
					
					if (Stricted_Words.containsKey(wordFound.toLowerCase())) 
					{
						int Count = Stricted_Words.get(wordFound.toLowerCase()).intValue();
						Stricted_Words.put(wordFound.toLowerCase(), Count + 1);
						
						System.out.println("Stricted: " + wordFound + " (" + Stricted_Words.get(wordFound.toLowerCase()).intValue()  + ") | already exists");
					}
					else 
					{
						Stricted_Words.put(wordFound.toLowerCase(), 0);
						System.out.println("Stricted: " + wordFound + " Not inside hashmap adding.");
					}
					
					if (Relaxed_Words.containsKey(wordFound)) 
					{
						int Count = Relaxed_Words.get(wordFound).intValue();
						Relaxed_Words.put(wordFound, Count + 1);
						
						System.out.println("Relaxed: " + wordFound + " (" + Relaxed_Words.get(wordFound).intValue()  + ") | already exists");
					}
					else 
					{
						Relaxed_Words.put(wordFound, 0);
						System.out.println("Relaxed: " + wordFound + " Not inside hashmap adding.");
					}
					
					System.out.println("");
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("Failed to get file");
		}
	}
}