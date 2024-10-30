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
		
		File textFile = new File("C:\\Users\\27237009\\git\\CS30P3F2024\\Chapter11\\src\\Mastery\\source.txt");
		
		System.out.println(textFile.exists() ? "Exists" : "Doesn't exist" + " | " + textFile.exists());
		
		if (!textFile.exists()) {return;}
		
		try 
		{
			Map<String, Integer> Words = new HashMap<>(); 
			
			System.out.println("");
			try (Scanner textFileReader = new Scanner(textFile)) 
			{
				while (textFileReader.hasNext()) 
				{
					String wordFound = textFileReader.next();
					//System.out.println(wordFound);
					
					for (Map.Entry<String, Integer> Word : Words.entrySet()) 
					{
						if (textFileReader.equals(Word.getKey())) 
						{
							int Count = Word.getValue() + 1;
							Word.setValue(Count);
							
							System.out.println(Word.getKey() + " | [" + Word.getValue() + "x]");
						}
					}
					
					if (Words.containsKey(textFileReader.next())) 
					{
						System.out.println("Added 1 to [" + textFileReader.next() + "]");
						
						int Count = Words.getOrDefault(textFileReader.next(), 1);
						Words.put(textFileReader.next(), Count++);
						
						System.out.println(Words.get(textFileReader.next()) + " | [" + Words.get(textFileReader.next()).intValue() + "x]");
					}
					else 
					{
						System.out.println("Created [" + textFileReader.next() + "]");
						Words.put(textFileReader.next(), 1);
					}	
				}
			}
			
			for (Map.Entry<String, Integer> Word : Words.entrySet()) 
			{
				System.out.println(Word.getKey() + " | [" + Word.getValue() + "x]");
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("Failed to get file");
		}
	}
}
