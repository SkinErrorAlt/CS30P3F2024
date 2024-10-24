package EasyKit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;


import java.util.*;

public class Gui_Handler {
    public static class CreateTextField 
    {
        private Map<TextFieldSettings, List<Object>> textSettings = new HashMap<>(); // Instead of using an array i'm using a hashmap because its easier and wayyyy faster since i looks for the value directly instead of checking every single one.
        private Map<TextFieldEvents, List<Object>> textEventConfig = new HashMap<>();
        
        JTextField TextField = null;
        
        public void changeSetting(TextFieldSettings setting, Object... values) 
        {
        	 if (textSettings.containsKey(setting)) 
             {
        		 textSettings.get(setting).clear();
        		 
                 for (Object value : values) 
                 {
                 	// System.out.println("Added: [" + value + "] to [" + setting.name() + "]");
                     textSettings.get(setting).add(value);
                 }
                 // System.out.println("Finished Setup for [" + setting.name() + "] and added Value");
             } 
             else 
             {
                 Console.error("Create TextField Settings", "Setting not found: " + setting, false);
             }
        }

        public void addSetting(TextFieldSettings setting, Object... values)
        {
        	if (!textSettings.containsKey(setting)) 
        	{
        		textSettings.put(setting, new ArrayList<>());
            	
            	for (Object Value : values) 
                {
                    textSettings.get(setting).add(Value);
                }
        	}
        	else 
        	{
        		Console.error("Add Text Field Setting", "Failed to create new Setting.", "Setting already exists, [" + setting.name() + "]", "Contains values: [" + textSettings.get(setting), false);
        	}
        }
        
        public void addEvent(TextFieldSettings setting, Object... values)  
        {
        	textSettings.put(setting, new ArrayList<>());
        	
        	for (Object Value : values) 
            {
                textSettings.get(setting).add(Value);
            }
        }
        
        public void removeSetting(TextFieldSettings setting)
        {
            if (textSettings.containsKey(setting)) 
            {
            	textSettings.remove(setting);
            	// Console.error("Remove TextField Settings", "Removed Textfield Setting [" + setting.name() + "]");
            } 
            else 
            {
                Console.error("Remove TextField Settings", "Setting not found: " + setting, false);
            }
        }
        
        public boolean hasSetting(TextFieldSettings setting) 
        {
			return textSettings.containsKey(setting);
        }

        public List<Object> getSettings(TextFieldSettings setting) 
        {
            return textSettings.get(setting);
        }
        
        public void SetTextField(JTextField TextField) 
        {
        	this.TextField = TextField;
        }
    }
    
    public enum TextFieldSettings 
    {
    	Char_Range, // Used for setting a range that the selected Text Field is allowed to have, if the user tries to go below or higher it will consume their inputs.
    	Needs_Chars, // Used for checking if it needs to have specific chars.
    	Stricted_Needs_Chars, // Very stricted on how many of each character is used.
    	
    	Number_Range, // Used for setting a pacific range of numbers that are allowed. Setting a range for 0, 100 will make it so if the string is between 0-100 doubles it doesn't consume input.
    	Number_Only, // Only numbers like 123 is allowed.
    	
    	Letter_Only, // Only letters like ABC <>? or abc ,./ is allowed with no numbers.
    	Stricted_Letters_Only, // Very stricted on not allowing <>? or ,./ stuff and only allowing ABC or abc
    	
    	Allow_Delete,
    	Allow_Enter
    }
    
    public enum TextFieldEvents 
    {
    	Clicked,
    	Hovered,
    	Entered,
    	Deleted
    }
    
    public static List<CreateTextField> TextFields = new ArrayList<>();

	public static void  TextFieldSetup(JTextField TextField)
    {
    	CreateTextField textField = new CreateTextField();
        
        textField.SetTextField(TextField);
        
        TextFields.add(textField);
    }
    
    public static CreateTextField getTextField(JTextField TextField) 
    {
    	for (CreateTextField Field : TextFields) 
    	{
    		if (Field.TextField == TextField) 
    		{
    			return Field;
    		}
    	}
    	
    	Console.error("Get Text Field", "Faild to get Text Field");
    	return null;
    }
}
