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
		
		@SafeVarargs
		<Settings> lookingForChar(Settings... Settings) 
		{
			for (Settings Setting : Settings) 
			{
				if (Setting instanceof Character) 
				{
					this.Character = (char) Setting;
				}
				else if (Setting instanceof Integer) 
				{
					this.Amount = (int) Setting;
				}
			}
		}
	}
	
	public static List<lookingForChar> CharacterList = new ArrayList<>();
	
	private static enum CharType
	{
		Char,
		Amount
	}
	
	private static CharType CurrentCharType = CharType.Char;
	
	@SafeVarargs
	public static <Chars> void CreateLookingChar(Chars... Settings) 
	{
		for (Chars Character : Settings) 
		{
			if (CurrentCharType == CharType.Char) 
			{
				lookingForChar newLookingForChar = new lookingForChar(Character); // Creates a class for looking for a certain character and amount of that character.
				CharacterList.add(newLookingForChar);
			}
			else 
			{
				CharacterList.get(CharacterList.size() - 1).Character = (char) Character;
			}	
		}
	}
	
	public static void ClearList() 
	{
		CharacterList.clear();
	}
}
