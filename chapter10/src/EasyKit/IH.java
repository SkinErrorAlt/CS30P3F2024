package EasyKit;

import java.awt.Component;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class IH {
	// InputHandler, it will handle inputs for gui's. Making them simple to add and easy to configure and work with.

	private static Panel Main;
	
	public static void UiSetupJPanel(Panel loginScreen) 
    {
        Main = loginScreen;
        Main.requestFocusInWindow();
    }
	
	public static void PressedEnter(Object Focus) 
	{
		if (Focus instanceof  Boolean) //
		{
			Main.requestFocusInWindow();
		}
		else if (Focus instanceof TextField)
		{
			((TextField) Focus).requestFocusInWindow();
		}
		else if (Focus instanceof Panel) 
		{
			((Panel) Focus).requestFocusInWindow();
		}
		else if (Focus instanceof JTextField) 
		{
			((JTextField) Focus).requestFocusInWindow();
		}
		else 
		{
			if (Focus != null) 
			{
				System.out.println("Not within a valid type: [" + Focus.getClass() + "]");
			}
			else 
			{
				System.out.println("Focus not set to a vaild type. No type given.");
			}
			
		}
	}
	
	/*public static void ChangeFocus(Object Focus) 
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
	*/

	public static <UiField> void ChangeFocus(UiField UiObject) 
	{
		if (UiObject != null) 
        {
			if (UiObject instanceof JComponent) 
			{
				 ((JComponent) UiObject).requestFocusInWindow();
			}
			else if (UiObject instanceof Component) 
			{
				 ((Component) UiObject).requestFocusInWindow();
			}
			else 
			{
				System.err.println("Not within if statement: [" + UiObject.getClass().getName() + "]");
			}
			
			System.err.println("Not within if statement: [" + UiObject.getClass().getName() + "]");
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
		}
		
		return "";
	}
}