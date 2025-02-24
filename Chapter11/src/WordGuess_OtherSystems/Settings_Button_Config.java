package WordGuess_OtherSystems;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Settings_Button_Config 
{
	// Button Settings.
	public static enum ButtonFieldSettings // Format is (name_settingSection)
    {
		// Button Classes (Aka types of buttons in ui's): 
		CustomOptions_ButtonClasses, // Example: Tic Tac Toe selection boxes for X, and O. This will be coded spacificly to the program use and not be used for interactions between stuff (using this).
		Toggleable_ButtonClasses, // Example: A light switch that toggles between on and off.
		AdvancedToggleable_ButtonClasses, // Example: A light switch with different light levels each click. For example 0%, 25%, 50%, 75%, 100%.
    	MenuSwitch_ButtonClasses, // Example: Start Buttons to switch to a different menu.
    	Exit_ButtonClasses, // Example Exit Buttons to switch out of a tab and or to end the program.
    	
    	// ButtonTypeUiObject:
    	NormalUi_ButtonUiTypes, // Default means its a normal button not within a tab.
    	TabUi_ButtonUiTypes, // This means the button is within some parents of a tab. Meaning to make this work a different set of functions must happen.
    	
    	// Effects:
    	Hover_Effects, // Hovering on and off the button will show an effect, either changing the color, size, position, or more.
    	Click_Effects, // Clicking the button can make it do a little animation or something.
    }
	
	public static class Toggleable
	{
		Boolean ForcedOrder = false; // Identifies if the code must follow the array order to identify the order of the values.
		List<Class> AllowedDataTypes = new ArrayList<>(); // Shows the allowed classes(data types) like if integer is allowed and to ensure later in a different function if its allowed to have a certain data type.
		
		Toggleable() 
		{
			AllowedDataTypes.add(Boolean.class);
		}
	}
	
	public static class AdvancedToggleable
	{
		Boolean ForcedOrder = false; // Identifies if the code must follow the array order to identify the order of the values.
		List<Class> AllowedDataTypes = new ArrayList<>(); // Shows the allowed classes(data types) like if integer is allowed and to ensure later in a different function if its allowed to have a certain data type.
		
		AdvancedToggleable() 
		{
			AllowedDataTypes.add(ArrayList.class);
		}
	}
	
	public static class MenuSwitch
	{
		Boolean ForcedOrder = true; // Identifies if the code must follow the array order to identify the order of the values.
		List<Class> AllowedDataTypes = new ArrayList<>(); // Shows the allowed classes(data types) like if integer is allowed and to ensure later in a different function if its allowed to have a certain data type.
		
		MenuSwitch() 
		{
			AllowedDataTypes.add(Boolean.class);
			AllowedDataTypes.add(JPanel.class);
			AllowedDataTypes.add(JFrame.class);
		}
	}
	
	public static class Exit
	{
		Boolean ForcedOrder = false; // Identifies if the code must follow the array order to identify the order of the values.
		List<Class> AllowedDataTypes = new ArrayList<>(); // Shows the allowed classes(data types) like if integer is allowed and to ensure later in a different function if its allowed to have a certain data type.
		
		Exit() 
		{
			AllowedDataTypes.add(JFrame.class);
		}
	}
	
	public static class NormalUi
	{
		Boolean ForcedOrder = false; // Identifies if the code must follow the array order to identify the order of the values.
		List<Class> AllowedDataTypes = new ArrayList<>(); // Shows the allowed classes(data types) like if integer is allowed and to ensure later in a different function if its allowed to have a certain data type.
		
		NormalUi() 
		{
			AllowedDataTypes.add(Boolean.class);
		}
	}
	
	public static class TabUi
	{
		Boolean ForcedOrder = false; // Identifies if the code must follow the array order to identify the order of the values.
		List<Class> AllowedDataTypes = new ArrayList<>(); // Shows the allowed classes(data types) like if integer is allowed and to ensure later in a different function if its allowed to have a certain data type.
		
		TabUi() 
		{
			AllowedDataTypes.add(Boolean.class);
		}
	}
	
	public static class Hover
	{
		Boolean ForcedOrder = false; // Identifies if the code must follow the array order to identify the order of the values.
		List<Class> AllowedDataTypes = new ArrayList<>(); // Shows the allowed classes(data types) like if integer is allowed and to ensure later in a different function if its allowed to have a certain data type.
		
		Hover() 
		{
			AllowedDataTypes.add(Boolean.class);
		}
	}
	
	public static class Click
	{
		Boolean ForcedOrder = false; // Identifies if the code must follow the array order to identify the order of the values.
		List<Class> AllowedDataTypes = new ArrayList<>(); // Shows the allowed classes(data types) like if integer is allowed and to ensure later in a different function if its allowed to have a certain data type.
		
		Click() 
		{
			AllowedDataTypes.add(Boolean.class);
		}
	}

	public static ButtonFieldSettings ButtonFieldSettings;
}
