package EasyKit;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTextField;

import EasyKit.Account;

// Easy UI effects.
public class Ui {
	
	private static Panel Main;
	
	public static enum textFieldType 
	{
		NumberOnly,
		NumberRange,
		Text,
		TextLimit
	}
	
	private static class TextFieldSettings 
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
	
	public static void UiSetup(Panel MainFrame) 
	{
		Main = MainFrame;
	}
	
	public static void TextFieldSetup(JTextField TextUi, textFieldType Type, Color SelectedTextColor, boolean AllowResize) 
	{
		TextFieldSettings NewTextUi = new TextFieldSettings(TextUi, Type, SelectedTextColor, AllowResize);
		TextFields.add(NewTextUi);
	}
	
	public static void focusChange(JComponent UiObject) { // Changes the focus to be somewhere else to make everything be more nice and clear.
		if (UiObject != null) 
		{
			UiObject.requestFocusInWindow();
        } 
		else 
		{
        	Main.requestFocusInWindow();
        }
	}
	
	public static void toggleTipText(JTextField TextUi) // Changes the texts color and size of its box to the amount of text
	{
		TextFieldSettings GotTextUi = null;
		for (int selectedTextUis = 0; selectedTextUis <= TextFields.size(); selectedTextUis++) 
		{
			if (TextFields.get(selectedTextUis).selectedTextField == TextUi) 
			{
				GotTextUi = TextFields.get(selectedTextUis);
				break;
			}
		}
		
		if (GotTextUi == null) 
		{
			System.out.println("Not in system.");
			return;
		}
		
		String text = TextUi.getText();
		boolean focused = TextUi.hasFocus();
		
		if (focused) 
		{
			if (GotTextUi.currentType == textFieldType.NumberOnly || GotTextUi.currentType == textFieldType.NumberRange) 
			{
				if (text.equals(GotTextUi.DefaultText) || text.equals("Null")) 
				{
					TextUi.setText("");
				}
				if (TextUi.getText().length() > 1) 
				{
					if (GotTextUi.AllowResize) 
					{
						TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 11 * TextUi.getText().length(), TextUi.getBounds().height);	
					}
				}
				else 
				{
					if (GotTextUi.AllowResize) 
					{
						if (TextUi.getText().equals("0")) 
						{
							TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 14, TextUi.getBounds().height);
						}
						else 
						{
							TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 9, TextUi.getBounds().height);
						}
					}
				}
				
				TextUi.setForeground(GotTextUi.SelectedTextColor);
			}
			else 
			{
				if (text.equals(GotTextUi.DefaultText) || text.equals("Null")) 
				{
					TextUi.setText("");
				}
				if (TextUi.getText().length() > 1) 
				{
					if (GotTextUi.AllowResize) 
					{
						TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 11 * TextUi.getText().length(), TextUi.getBounds().height);
					}
				}
				else 
				{
					if (TextUi.getText().equals("0")) 
					{
						if (GotTextUi.AllowResize) 
						{
							TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 14, TextUi.getBounds().height);
						}
					}
					else 
					{
						if (GotTextUi.AllowResize) 
						{
							TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 9, TextUi.getBounds().height);
						}
					}
				}
				
				TextUi.setForeground(GotTextUi.SelectedTextColor);
			}
		}
		else 
		{
			if (text.equals("")) 
			{
				TextUi.setText(GotTextUi.DefaultText);
				
				TextUi.setBounds(GotTextUi.Bounds);
			}
			else 
			{
				if (GotTextUi.AllowResize) 
				{
					if (TextUi.getText().length() > 1) 
					{
						if (GotTextUi.AllowResize) 
						{
							TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 11 * TextUi.getText().length(), TextUi.getBounds().height);
						}
					}
					else 
					{
						if (TextUi.getText().equals("0")) 
						{
							if (GotTextUi.AllowResize) 
							{
								TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 14, TextUi.getBounds().height);
							}
						}
						else 
						{
							if (GotTextUi.AllowResize) 
							{
								TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 15, TextUi.getBounds().height);
							}
						}
					}
				}
			}
			
			TextUi.setForeground(GotTextUi.UnselectedTextColor);
		}
	}
}
