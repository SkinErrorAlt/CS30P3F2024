package Mastery;

import java.io.*;
import java.util.*;

public class FindAndReplace extends EasyKit.Text {

	public static void main(String[] args) 
	{
		while (true) 
		{
			print("[Replace Words]");
			addSpace();
			
			String UserFile = userString(true, "File name");
			
			File userFile = new File("..\\Chapter11\\src\\Mastery\\" + UserFile + ".txt");
			
			if (!userFile.exists()) 
			{
				clear();
				print("No file exists under the name [" + UserFile + "]");
				addSpace();
				
				continue; // Skips the rest of the loop.
			}
			
			clear();
			while (true) 
			{
				print("[Editing (" + UserFile + ".txt)");
				addSpace();
				
				String UserReplace = userString(true, "Replace");
				
				try 
				{
					Scanner readingFile = new Scanner(userFile);
					FileWriter fileReplacer = new FileWriter(userFile);
					
					String wholeFile = "";
					while (readingFile.hasNext()) 
					{
						String Word = readingFile.next().replaceAll(UserReplace, "Test");

						wholeFile += Word;
						
						String hasBeenReplaced = readingFile.equals(UserReplace) ? "Replaced" : "Not selected word";
						
						System.out.println("Checking word: " + Word + " | " + hasBeenReplaced);
					}
					
					//fileReplacer.write(wholeFile);
					break;
				} 
				catch (FileNotFoundException e) 
				{
					clear();
					print("Couldn't find file [" + userFile + "]");
					addSpace();
				} 
				catch (IOException e) {
					clear();
					print("Error on [" + userFile + "]");
					addSpace();
				}
			}
			
			break;
		}
	}
}
