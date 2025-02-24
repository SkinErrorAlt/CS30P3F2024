package WordGuess_OtherSystems;

import WordGuess_OtherSystems.Button_Config;
import WordGuess_OtherSystems.Button_Config.Button;
import WordGuess_OtherSystems.Settings_Button_Config;
import WordGuess_OtherSystems.Settings_Button_Config.ButtonFieldSettings;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import EasyKit.*;
import EasyKit.OtherSystems.lookingForChar;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.util.*;
import java.lang.*;

// Easy UI effects.
public class Gui_Handler {
	
	private static DataStep CurrentDataStep = DataStep.GetName;
	
	private static enum DataStep 
	{
		GetName,
		SetValue,
		AddSetting,
	}
	
    public static List<Button_Config.Button> Buttons = new ArrayList<>();
    
    public static <UiObjects> void GuiObjectSetup(UiObjects... UiObjects) // format: (Ui Object, Settings for said Ui Object...)
    {
    	if (UiObjects == null || UiObjects[0] == null) {System.err.println("\n ---------- \n [Gui_Handler | Gui-Object-Setup]: Failed to create Gui Object. \n [1]	Reason: \n [2] 		Null"); return;}
    	CurrentDataStep = DataStep.AddSetting;
    	
    	Settings_Button_Config.ButtonFieldSettings CurrentSetting = null;
    	Object CurrentValue = null;
    	
    	if (UiObjects[0].getClass() == JButton.class) // Button
    	{
    		Button_Config.Settings ButtonSettings = new Button_Config.Settings((JButton) UiObjects[0]);
    		
    		for (UiObjects UiObjectSetting : UiObjects) 
    		{
    			if (CurrentDataStep == DataStep.GetName) 
    			{
    				CurrentSetting = (ButtonFieldSettings) UiObjectSetting;
    				CurrentDataStep = DataStep.SetValue;
    			}
    			else if (CurrentDataStep == DataStep.SetValue) 
    			{
    				CurrentValue = UiObjectSetting;
    				CurrentDataStep = DataStep.AddSetting;
    			}

    			if (CurrentDataStep == DataStep.AddSetting) 
    			{
    				ButtonSettings.addSetting(CurrentSetting, CurrentValue);
    				CurrentDataStep = DataStep.GetName;
    			}
    		}
    		
    		Button_Config.Button NewButton = new Button_Config.Button(ButtonSettings);
    		Button_Config.Buttons.put((JButton) UiObjects[0], NewButton);
    	}
    }
    
    public static ButtonFieldSettings GetButtonConfig() 
    {
    	return Settings_Button_Config.ButtonFieldSettings;
    }
}
