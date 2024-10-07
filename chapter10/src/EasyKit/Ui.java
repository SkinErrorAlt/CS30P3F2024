package EasyKit;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import EasyKit.Account.NewAccount;

// Easy UI effects.
public class Ui {
	
	public static enum textFieldType 
	{
		NumberOnly,
		NumberRange,
		Text,
		TextLimit
	}
	
	private static class TextFieldSettings 
	{
		TextField selectedTextField;
		textFieldType currentType;
		
		String DefaultText;
		String DefaultName;
		Color BackgroundColor;
		Color ForgroundColor;
		
		@SuppressWarnings("unused")
		TextFieldSettings(TextField selected, textFieldType Type) 
		{
			selectedTextField = selected;
			currentType = Type;
			SetupValues();
		}
		
		void SetupValues() 
		{
			DefaultText = selectedTextField.getText();
			DefaultName = selectedTextField.getName();
			BackgroundColor = selectedTextField.getBackground();
			ForgroundColor = selectedTextField.getForeground();
		}
	}
	
	public static List<TextFieldSettings> TextFields = new ArrayList<>();
	
	public static void toggleTipTextSetUp(TextField TextUi, textFieldType Type) 
	{
		TextFieldSettings NewTextUi = new TextFieldSettings(TextUi, Type);
		TextFields.add(NewTextUi);
	}
	
	
	public static void toggleTipText(TextField TextUi, String tipText) // Changes the texts color and size of its box to the amount of text
	{
		String text = TextUi.getText();
		boolean focused = TextUi.hasFocus();
		
		if (focused) 
		{
			if (text.equals(tipText) || text.equals("Null")) 
			{
				TextUi.setText("");
			}
			
			if (TextUi.getText().length() > 1) 
			{
				TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 11 * TextUi.getText().length(), TextUi.getBounds().height);
			}
			else 
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
			
			TextUi.setForeground(Color.black);
		}
		else 
		{
			if (text.equals("")) 
			{
				if (TextUi.getName() == "FirstSemester") 
				{
					TextUi.setText("Enter First Grade");
				}
				else if (TextUi.getName() == "SecondSemester")
				{
					TextUi.setText("Enter Second Grade");
				}
				else if (TextUi.getName() == "ThirdSemester")
				{
					TextUi.setText("Enter Third Grade");
				}
				else 
				{
					TextUi.setText("Null");
				}
				
				TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 140, TextUi.getBounds().height);
			}
			else 
			{
				if (TextUi.getText().length() > 1) 
				{
					TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 11 * TextUi.getText().length(), TextUi.getBounds().height);
				}
				else 
				{
					if (TextUi.getText().equals("0")) 
					{
						TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 14, TextUi.getBounds().height);
					}
					else 
					{
						TextUi.setBounds(TextUi.getBounds().x, TextUi.getBounds().y, 15, TextUi.getBounds().height);
					}
				}
			}
			
			TextUi.setForeground(Color.gray);
		}
	}
}
