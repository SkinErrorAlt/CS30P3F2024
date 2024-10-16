package EasyKit;

import java.awt.Component;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JTextField;
import 

public class InputHandler {

	private static Panel Main;
	
	public static void UiSetupJPanel(Panel loginScreen) 
    {
        Main = loginScreen;
        Main.requestFocusInWindow();
    }
	
	public static void PressedEnter(Object Focus) 
	{
		if (Focus instanceof  Boolean) 
		{
			Main.requestFocusInWindow();
		}
		else if (Focus instanceof TextField)
		{
			((Component) Focus).requestFocusInWindow();
		}
		else if (Focus instanceof Panel) 
		{
			((Panel) Focus).requestFocusInWindow();
		}
		else if (Focus instanceof JComponent) 
		{
			((Component) Focus).requestFocusInWindow();
		}
		else 
		{
			System.out.println("Not within a valid type: [" + Focus.getClass() + "]");
		}
	}
	
	public static void ChangeFocus(Object Focus) 
	{
		if (Focus instanceof  Boolean) 
		{
			Main.requestFocusInWindow();
		}
		else if (Focus instanceof TextField)
		{
			((Component) Focus).requestFocusInWindow();
		}
		else if (Focus instanceof Panel) 
		{
			((Panel) Focus).requestFocusInWindow();
		}
		else if (Focus instanceof JComponent) 
		{
			((Component) Focus).requestFocusInWindow();
		}
		else 
		{
			System.out.println("Not within a valid type: [" + Focus.getClass() + "]");
		}
	}

	public static void focusChange(TextField UiObject) {
		if (UiObject != null) 
        {
            UiObject.requestFocusInWindow();
        } 
        else 
        {
            Main.requestFocusInWindow();
        }
	}
	
	public static String getFullText(JTextField TextUi, KeyEvent e) 
	{
		String realText = "";
		boolean validCharacter = Ui.ValidCharacters(TextUi.getText() + e.getKeyChar());

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) 
		{
			char[] Allcharacters = TextUi.getText().toCharArray();
			
			if (Allcharacters.length > 0) 
			{
				for (int i = 0; i < Allcharacters.length - 1; i++) 
				{
					realText += Allcharacters[i];
				}
			}

			System.out.println("Backspace: [" + realText + "] : " + validCharacter);
			
			return realText;
		}
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) 
		{
			System.out.println("Pressed Enter");
		}
		else
		{
			if (validCharacter) 
			{
				char[] Allcharacters = (TextUi.getText() + e.getKeyChar()).toCharArray();
				
				if (Allcharacters.length > 0) 
				{
					for (int i = 0; i < Allcharacters.length; i++) 
					{
						realText += Allcharacters[i];
					}
				}
				
				System.out.println("Setup: [" + realText + "] : " + validCharacter);
				
				return realText;
			}
			else 
			{
				System.out.println("Contains a non valid Character.");
			}
		}
	}
}
