package Input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import EasyKit.Gui_Handler;
import EasyKit.Gui_Handler.*;
import EasyKit.Console;

public class TextField_Click {
	public static void ClickEvent(JTextField TextField) 
	{
		if (Gui_Handler.getTextField(TextField).hasSetting(Gui_Handler.TextFieldSettings.Number_Range)) 
		{
			Console.error("Clicked!", true);
		}
	}
	
	public static void ClickEventSetup(JTextField TextField) 
	{
		TextField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				ClickEvent(TextField);
			}
		});
	}
}
