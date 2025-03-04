package EasyKit;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import EasyKit.*;
import EasyKit.OtherSystems.lookingForChar;
import LocalBank_MasteryData.LocalBankGUI_Data.NewAccount;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.*;
import java.lang.*;

// Easy UI effects.
public class Ui {
    public static enum textFieldType 
    {
        NumberOnly,
        NumberRange,
        Text,
        TextLimit
    }
    
    public static class TextFieldSettings 
    {
        JTextField selectedTextField;
        textFieldType currentType;
        
        String DefaultText;
        String DefaultName;
        Color BackgroundColor;
        
        boolean AllowResize = false;
        
        Rectangle Bounds;
        
        Color UnselectedTextColor;
        Color SelectedTextColor;
        
        int MaxLength = -1; // New field for text limit
        double MinValue = Double.MIN_VALUE; // New field for number range
        double MaxValue = Double.MAX_VALUE; // New field for number range
        
        String SelectedForcedText; // For example (Unselected: "Enter Money Amount." | Selected: "$") This will allow it to have $ at the beginning even when the user attempts to delete it.
        
        TextFieldSettings(JTextField selected, textFieldType Type, Color SelectedTextColor, boolean AllowResize) 
        {
            selectedTextField = selected;
            currentType = Type;
            this.AllowResize = AllowResize;
            Bounds = selected.getBounds();
            this.SelectedTextColor = SelectedTextColor;
            SetupValues();
        }
        
        void SetupValues() 
        {
            DefaultText = selectedTextField.getText();
            DefaultName = selectedTextField.getName();
            BackgroundColor = selectedTextField.getBackground();
            UnselectedTextColor = selectedTextField.getForeground();
        }
    }
    
    public static List<TextFieldSettings> TextFields = new ArrayList<>();

    public static void TextFieldSetup(JTextField TextUi, textFieldType Type, Color SelectedTextColor, boolean AllowResize) 
    {
        TextFieldSettings NewTextUi = new TextFieldSettings(TextUi, Type, SelectedTextColor, AllowResize);
        TextFields.add(NewTextUi);
    }
    
    // New method to set text limit for TextLimit type
    public static void SetTextLimit(JTextField TextUi, int maxLength) 
    {
        for (TextFieldSettings settings : TextFields) 
        {
            if (settings.selectedTextField == TextUi && settings.currentType == textFieldType.TextLimit) 
            {
                settings.MaxLength = maxLength;
                return;
            }
        }
        
        System.out.println("TextField not found or not of TextLimit type.");
    }
    
    // New method to set number range for NumberRange type
    public static void SetNumberRange(JTextField TextUi, double minValue, double maxValue) 
    {
        for (TextFieldSettings settings : TextFields) 
        {
            if (settings.selectedTextField == TextUi && settings.currentType == textFieldType.NumberRange) 
            {
                settings.MinValue = minValue;
                settings.MaxValue = maxValue;
                return;
            }
        }
        
        System.out.println("TextField not found or not a NumberRange type.");
    }
    
    public static void toggleTipText(JTextField TextUi) 
    {
        TextFieldSettings GotTextUi = null;
        for (TextFieldSettings settings : TextFields) 
        {
            if (settings.selectedTextField == TextUi) 
            {
                GotTextUi = settings;
                break;
            }
        }
        
        if (GotTextUi == null) 
        {
            System.out.println("Not in array.");
            return;
        }
        
        String text = TextUi.getText();
        boolean focused = TextUi.hasFocus();
        
        if (focused) 
        {
            handleFocusedState(TextUi, GotTextUi, text);
        }
        else 
        {
            handleUnfocusedState(TextUi, GotTextUi, text);
        }
    }
    
    private static void handleFocusedState(JTextField TextUi, TextFieldSettings GotTextUi, String text) 
    {
        if (text.equals(GotTextUi.DefaultText) || text.equals("Null")) 
        {
            TextUi.setText("");
        }
        resizeTextField(TextUi, GotTextUi);
        TextUi.setForeground(GotTextUi.SelectedTextColor);
        
        // used based on the text field type where it will use different text effects
        switch (GotTextUi.currentType) 
        {
            case NumberOnly:
                enforceNumberOnly(TextUi);
                break;
            case NumberRange:
                enforceNumberRange(TextUi, GotTextUi);
                break;
            case TextLimit:
                enforceTextLimit(TextUi, GotTextUi);
                break;
            default:
                break;
        }
    }
    
    private static void handleUnfocusedState(JTextField TextUi, TextFieldSettings GotTextUi, String text) 
    {
        if (text.equals("")) 
        {
            TextUi.setText(GotTextUi.DefaultText);
            TextUi.setBounds(GotTextUi.Bounds);
        }
        else 
        {
            resizeTextField(TextUi, GotTextUi);
        }
        TextUi.setForeground(GotTextUi.UnselectedTextColor);
    }
    
    private static void resizeTextField(JTextField TextUi, TextFieldSettings GotTextUi) 
    {
        if (GotTextUi.AllowResize) 
        {
            int width;
            if (TextUi.getText().length() > 1) 
            {
                width = 11 * TextUi.getText().length();
            }
            else 
            {
                width = TextUi.getText().equals("0") ? 14 : 9;
            }
            TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, width, TextUi.getBounds().height);
        }
    }
    
    private static void enforceNumberOnly(JTextField TextUi) // Forces the text to only be numbers
    {
        String text = TextUi.getText();
        
        if (!text.matches("\\d*")) 
        {
            TextUi.setText(text.replaceAll("[^\\d]", ""));
        }
    }
    
    private static void enforceNumberRange(JTextField TextUi, TextFieldSettings GotTextUi) 
    {
        try 
        {
            double value = Double.parseDouble(TextUi.getText());
            if (value < GotTextUi.MinValue) 
            {
                TextUi.setText(String.valueOf(GotTextUi.MinValue));
            } 
            else if (value > GotTextUi.MaxValue) 
            {
                TextUi.setText(String.valueOf(GotTextUi.MaxValue));
            }
        } 
        catch (NumberFormatException e) 
        {
            TextUi.setText(String.valueOf(GotTextUi.MinValue));
        }
    }
    
    private static void enforceTextLimit(JTextField TextUi, TextFieldSettings GotTextUi) 
    {
        if (GotTextUi.MaxLength > 0 && TextUi.getText().length() > GotTextUi.MaxLength) 
        {
            TextUi.setText(TextUi.getText().substring(0, GotTextUi.MaxLength));
        }
    }
    
    public static TextFieldSettings getTextFieldSettings(JTextField TextUi) 
    {
    	for (TextFieldSettings settings : TextFields) // gets the Text Field
    	{
    		return settings;
    	}
    	
		return null;
    }
	
	public static boolean ValidCharacters(String str)
    {
        if (str == null || str == "") 
        {
            return false;
        }
        
        ArrayList<Character> alphabets = new ArrayList<Character>();
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+{}|:/?>.<,~`";
        
        for (int i = 0; i < alpha.length(); i++)
        {
            alphabets.add(alpha.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) 
        {
            if (!alphabets.contains(str.charAt(i))) 
            {
                return false;
            }
        }
        
        return true;
    }
	
	public static String handleTextInput(JTextField textField, KeyEvent e) 
	{
	    String currentText = textField.getText();
	    int keyCode = e.getKeyCode();

	    if (keyCode == KeyEvent.VK_BACK_SPACE) 
	    {
	        // Handle backspace
	        if (!currentText.isEmpty()) 
	        {
	            return currentText.substring(0, currentText.length() - 1);
	        }
	    } 
	    else 
	    {
	        char keyChar = e.getKeyChar();
	        if (Character.isLetterOrDigit(keyChar) || Character.isWhitespace(keyChar)) 
	        {
	            // Valid character, append to current text
	            return currentText + keyChar;
	        }
	    }

	    // If no changes were made, return the original text
	    return currentText;
	}
	
	public static boolean checkIfStringHas(String Text, List<Character> checkingChars, int amountNeeded) 
	{
		boolean DebugMode = true;
		boolean vailed = false;
		int vaildedChecks = 0;
		
		for (int i = 0; i < Text.length(); i++) 
		{
			for (int x = 0; x < checkingChars.size(); x++) 
			{
				if (Text.charAt(i) == checkingChars.get(x)) 
				{
					vaildedChecks++;
				}
			}
		}
		
		if (vaildedChecks >= amountNeeded) 
		{
			vailed = true;
		}
		
		if (DebugMode) 
		{
			System.out.println("Valided Checks: " + vaildedChecks);
		}
		
		return vailed;
	}

	public static <b> Object hasVaildChars(JTextField TextField, List<OtherSystems.lookingForChar> checkingChars) // Check if it has a certain amount of a character.
	{
		char[] TotalCharacters = TextField.getText().toCharArray();
		
		for (int i = 0; i <= TotalCharacters.length; i++) 
		{
			for (lookingForChar checkingChar : checkingChars) 
			{
				if (TotalCharacters[i] == checkingChar.Character) 
				{
					checkingChar.FoundAmount++;
					if (checkingChar.FoundAmount >= checkingChar.Amount) 
					{
						checkingChar.GotAmount = true;
						break;
					}
				}
			}
		}
		
		for (int x = 0; x <= checkingChars.size(); x++) 
		{
			if (!checkingChars.get(x).GotAmount) 
			{	
				return false;
			}
		}
		
		return true;
	}
	
	public static <b> Object hasVaildCharsUnStricted(JTextField TextField, List<OtherSystems.lookingForChar> checkingChars, int AmountNeeded) // Check if it has a certain amount of a character.
	{
		char[] TotalCharacters = TextField.getText().toCharArray();
		
		for (int i = 0; i <= TotalCharacters.length; i++) 
		{
			for (lookingForChar checkingChar : checkingChars)
			{
				if (TotalCharacters[i] == checkingChar.Character) 
				{
					checkingChar.FoundAmount++;
					
					if (checkingChar.FoundAmount >= checkingChar.Amount) 
					{
						checkingChar.GotAmount = true;
						break;
					}
				}
			}
		}
		
		int AmountGot = 0;
		
		for (int x = 0; x <= checkingChars.size(); x++) 
		{
			if (checkingChars.get(x).GotAmount) 
			{	
				AmountGot++;
			}
		}
		
		if (AmountGot >= AmountNeeded) 
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean UiBeingUsed(JTextField TextUi, KeyEvent e) 
	{
		for (TextFieldSettings settings : TextFields) // gets the Text Field
    	{
			if (settings.selectedTextField == TextUi) 
			{
				String realText = "";
				//boolean validCharacter = ValidCharacters(settings.selectedTextField.getText() + e.getKeyChar());
				
				if (e != null) 
				{
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) 
					{
						char[] Allcharacters = settings.selectedTextField.getText().toCharArray();
						
						if (Allcharacters.length > 0) 
						{
							for (int i = 0; i < Allcharacters.length - 1; i++) 
							{
								realText += Allcharacters[i];
							}
						}

						//System.out.println("Backspace: [" + realText + "] : " + validCharacter);
						
						if (realText.isEmpty()) 
						{
							return false;
						}
						else 
						{
							return true;
						}
					}
					else if (e.getKeyCode() == KeyEvent.VK_ENTER) 
					{
						
					}
					else
					{
						char[] Allcharacters = (settings.selectedTextField.getText() + e.getKeyChar()).toCharArray();
						
						if (Allcharacters.length > 0) 
						{
							for (int i = 0; i < Allcharacters.length; i++) 
							{
								realText += Allcharacters[i];
							}
						}
						
						//System.out.println("Setup: [" + realText + "] : " + validCharacter);
						
						if (realText.isEmpty() || settings.selectedTextField.getText().equals(settings.DefaultText)) 
						{
							return false;
						}
						else 
						{
							return true;
						}
					}
				}
				else 
				{
					char[] Allcharacters = settings.selectedTextField.getText().toCharArray();
					
					if (Allcharacters.length > 0) 
					{
						for (int i = 0; i < Allcharacters.length; i++) 
						{
							realText += Allcharacters[i];
						}
					}
					
					//System.out.println("Setup: [" + realText + "] : " + validCharacter);
					
					if (realText.isEmpty() || settings.selectedTextField.getText().equals(settings.DefaultText)) 
					{
						return false;
					}
					else 
					{
						return true;
					}
				}
			}
    	}
		
		return false;
	}
}