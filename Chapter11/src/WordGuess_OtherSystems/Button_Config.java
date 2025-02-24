package WordGuess_OtherSystems;

import WordGuess_OtherSystems.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import EasyKit.Console;
import EasyKit.Gui_Handler.CreateTextField;
import WordGuess_OtherSystems.Gui_Handler.TextFieldSettings;

public class Button_Config 
{
	public static Map<JButton, Button> Buttons = new HashMap<>();
	
	public static class Settings 
	{
		private Map<Settings_Button_Config.ButtonFieldSettings, List<Object>> ButtonSettings = new HashMap<>();
		
		JButton Button;
		
		Color BackgroundColor = new Color(0,0,0);
		Color ForgroundColor = new Color(0,0,0);
		
		Border DefaultBorder;
		
		// Sets up the information about the button.
		Settings(JButton Button) 
		{
			this.Button = Button; // Sets the button to the button UI object
			
			this.BackgroundColor = Button.getBackground(); // Gets the background color
			this.ForgroundColor = Button.getForeground(); // Gets the text color
			
			this.DefaultBorder = Button.getBorder(); // Gets the boarder for what its like for default
		}
		
		public void changeSetting(Settings_Button_Config.ButtonFieldSettings setting, Object... values) 
        {
        	 if (ButtonSettings.containsKey(setting)) 
             {
        		 ButtonSettings.get(setting).clear();
        		 
                 for (Object value : values) 
                 {
                 	// System.out.println("Added: [" + value + "] to [" + setting.name() + "]");
                	 ButtonSettings.get(setting).add(value);
                 }
                 // System.out.println("Finished Setup for [" + setting.name() + "] and added Value");
             } 
             else 
             {
                 Console.error("Create TextField Settings", "Setting not found: " + setting, false);
             }
        }
		
		public void addSetting(Settings_Button_Config.ButtonFieldSettings setting, Object... values)
        {
        	if (!ButtonSettings.containsKey(setting)) 
        	{
        		ButtonSettings.put(setting, new ArrayList<>());
        		
            	for (Object Value : values) 
                {
            		ButtonSettings.get(setting).add(Value);
            		System.out.println("Value: " + Value);
                }
            	
            	System.out.println(ButtonSettings.get(setting).toString());
        	}
        	else 
        	{
        		Console.error("Add Text Field Setting", "Failed to create new Setting.", "Setting already exists, [" + setting.name() + "]", "Contains values: [" + ButtonSettings.get(setting), false);
        	}
        }
		
		public void removeSetting(Settings_Button_Config.ButtonFieldSettings setting)
        {
            if (ButtonSettings.containsKey(setting)) 
            {
            	ButtonSettings.remove(setting);
            	// Console.error("Remove TextField Settings", "Removed Textfield Setting [" + setting.name() + "]");
            } 
            else 
            {
                Console.error("Remove ButtonField Settings", "Setting not found: " + setting, false);
            }
        }
		
		public boolean hasSetting(Settings_Button_Config.ButtonFieldSettings setting) 
        {
			return ButtonSettings.containsKey(setting);
        }

        public List<Object> getSettings(Settings_Button_Config.ButtonFieldSettings setting) 
        {
            return ButtonSettings.get(setting);
        }
	}

	public static class Button
	{
		Settings Settings;
		
		Button(Settings Settings) 
		{
			this.Settings = Settings;
		}
	}
	
	public static Button GetButton(JButton Button) 
	{
		if (Button == null) 
		{
			System.out.println("Failed to get button");
			return null;
		}
		
		if (Buttons.containsKey(Button)) 
		{
			return Buttons.get(Button);
		}
		
		return null;
	}
}
