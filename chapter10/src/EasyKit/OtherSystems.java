package EasyKit;

import java.util.ArrayList;
import java.util.List;

import EasyKit.*;

public class OtherSystems {

	public static class lookingForChar 
	{
		char Character; // The Character that is going to be checked.
		int Amount; // Amount of times it needs for it to turn true.
		
		int FoundAmount; // The amount that it has been found
		
		boolean GotAmount = false;
		
		lookingForChar(char Character, int Amount) 
		{
			this.Character = Character;
			this.Amount = Amount;
		}
	}
	
	public static List<lookingForChar> CharacterList = new ArrayList<>();
	
	public static void CreateLookingChar(char Character, int Amount) 
	{
		lookingForChar newLookingForChar = new lookingForChar(Character, Amount); // Creates a class for looking for a certain character and amount of that character.
		CharacterList.add(newLookingForChar);
	}
	
	public static void ClearList() 
	{
		CharacterList.clear();
	}
}
