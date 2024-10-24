package EasyKit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;

import java.util.*;

public class Gui_Handler {
	
	private static class Number_Range 
	{
		double minMax[] = {0, 0};
	}
	
	private static class Limited_Char 
	{
		int minMax[] = {0, 0};
	}
	
    public static class CreateTextField 
    {
        private Map<TextFieldSettings, List<Object>> textSettings = new HashMap<>(); // Instead of using an array i'm using a hashmap because its easier and wayyyy faster since i looks for the value directly instead of checking every single one.

        JTextField TextField = null;
        
        public void createTextField(TextFieldSettings... settings) // Gets a list of TextFieldSettings enum.
        {
            for (TextFieldSettings setting : settings) // Loops through all settings aka the enums.
            {
                textSettings.put(setting, new ArrayList<>()); // Puts it in the hash map.
            }
        }

        public void addSetting(TextFieldSettings setting, Object... values) // This function just gets a TextFieldSettings enum and then gets a list of Objects that i can use for the settings of it.
        {
            if (textSettings.containsKey(setting)) 
            {
                for (Object value : values) 
                {
                	System.out.println("Added: [" + value + "] to [" + setting.name() + "]");
                    textSettings.get(setting).add(value);
                }
                System.out.println("Finished Setup for [" + setting.name() + "] and added Value");
            } 
            else 
            {
                Console.error("Create TextField Settings", "Setting not found: " + setting, false);
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

    public static enum TextFieldSettings 
    {
        Number_Only,
        Stricted_Number_Only,
        Number_Range,
        
        Letter_Only,
        Stricted_Letter_Only,
        Limited_Char
    }
    
    public static List<CreateTextField> TextFields = new ArrayList<>();

    @SuppressWarnings({ "hiding", "unchecked" })
	public static <Ui> void  TextFieldSetup(Ui... fieldSettings)
    {
    	CreateTextField textField = new CreateTextField();
    	JTextField hasTextField = null;
    	
    	TextFieldSettings lastSetting = null;
    	
    	int currentFieldSetting = 0;
    	int amountLeft = 0;
    	int skips = 0;
    	
    	for (Ui Ob : fieldSettings) 
    	{
    		amountLeft = fieldSettings.length - currentFieldSetting;
    		
    		if (skips > 0) 
    		{
    			skips--;
    		}
    		else 
    		{
    			if (Ob instanceof JTextField) 
        		{
        			if (hasTextField == null) 
        			{
        				Console.error("Text Field Setup", "Created new text field.", "");
        				hasTextField = (JTextField) Ob;
        			}
        			else 
        			{
        				Console.error("Text Field Setup", "Overwritten TextField [" + hasTextField.getName() + "]", "replaced with [" + ((JTextField) Ob).getName() + "]");
        				hasTextField = (JTextField) Ob;
        			}
        		}
        		else if (Ob instanceof Enum) 
        		{
        			// Number Range
        			if (Ob == TextFieldSettings.Number_Range) 
        			{
        				if (lastSetting != TextFieldSettings.Number_Range) 
        				{
        					lastSetting = TextFieldSettings.Number_Range;
        					textField.createTextField(TextFieldSettings.Number_Range);
        				}
        				
        				Number_Range N_R = new Number_Range();
        				
        				if (amountLeft >= 2) 
        				{
        					if (fieldSettings[currentFieldSetting + 1] instanceof Double) 
        					{
        						if (fieldSettings[currentFieldSetting + 2] instanceof Double) 
        						{
        							N_R.minMax[0] = (double) fieldSettings[currentFieldSetting + 1];
        							N_R.minMax[1] = (double) fieldSettings[currentFieldSetting + 2];
        							
        							textField.addSetting(TextFieldSettings.Number_Range, N_R.minMax[0], N_R.minMax[1]);
        							skips++;
        						}
        						else 
        						{
        							N_R.minMax[1] = (double) fieldSettings[currentFieldSetting + 1];
        							
        							textField.addSetting(TextFieldSettings.Number_Range, N_R.minMax[0], N_R.minMax[1]);
        						}
        					}
        				}
        			}
        			// Limited Characters
        			else if (Ob == TextFieldSettings.Limited_Char) 
        			{
        				if (lastSetting != TextFieldSettings.Limited_Char) 
        				{
        					lastSetting = TextFieldSettings.Limited_Char;
        					textField.createTextField(TextFieldSettings.Limited_Char);
        				}
        				
        				Limited_Char L_C = new Limited_Char();
        				
        				if (amountLeft >= 2) 
        				{
        					if (fieldSettings[currentFieldSetting + 1] instanceof Integer) 
        					{
        						if (fieldSettings[currentFieldSetting + 2] instanceof Integer) 
        						{
        							L_C.minMax[0] = (int) fieldSettings[currentFieldSetting + 1];
        							L_C.minMax[1] = (int) fieldSettings[currentFieldSetting + 2];
        							
        							textField.addSetting(TextFieldSettings.Limited_Char, L_C.minMax[0], L_C.minMax[1]);
        							skips++;
        						}
        						else 
        						{
        							L_C.minMax[1] = (int) fieldSettings[currentFieldSetting + 1];
        							
        							textField.addSetting(TextFieldSettings.Limited_Char, L_C.minMax[0], L_C.minMax[1]);
        						}
        					}
        					else 
        					{
        						Console.error("Text Field Setup", "Not an integer. [" + fieldSettings[currentFieldSetting + 1].getClass().getName());
        					}
        				}
        				else 
        				{
        					Console.error("Text Field Setup", "No more pramitors");
        				}
        			}
        		}
    		}
    		
    		currentFieldSetting++;
    	}
    	
        
        textField.SetTextField(hasTextField);
        textField.createTextField();
        
        TextFields.add(textField);
    }
    
    public static CreateTextField getTextFieldSettings(JTextField TextField) 
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
