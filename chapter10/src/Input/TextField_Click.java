package Input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import EasyKit.Gui_Handler;
import EasyKit.IH;
import EasyKit.Gui_Handler.*;
import EasyKit.Console;

public class TextField_Click {
	public static void ClickEvent(JTextField TextField, ActionEvent e) 
	{
		if (Gui_Handler.getTextField(TextField).hasSetting(Gui_Handler.TextFieldSettings.Number_Range)) 
		{
			Console.error("Clicked!", true);
		}
	}
	
	public static void ClickEventSetup(JTextField TextField) 
	{
		TextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || Gui_Handler.getTextField(TextField).hasSetting(Gui_Handler.TextFieldSettings.Allow_Enter)) 
				{
					Console.error("TextField Enter Event", "Entered.");
					return;
				}
				else if (!Gui_Handler.getTextField(TextField).hasSetting(Gui_Handler.TextFieldSettings.Allow_Enter)) 
				{
					Console.error("TextField Enter Event", "Not Allowed Event.");
					return;
				}
			}
		});
	}
}
