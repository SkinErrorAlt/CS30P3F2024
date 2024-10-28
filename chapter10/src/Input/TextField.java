package Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import EasyKit.Console;
import EasyKit.Gui_Handler;
import EasyKit.IH;

public class TextField {
	
    private static void EnteredEvent(JTextField TextField, KeyEvent e) 
    {
        if (Gui_Handler.getTextField(TextField).hasSetting(Gui_Handler.TextFieldSettings.Allow_Enter)) 
        {
            if ((Boolean) Gui_Handler.getTextField(TextField).getSettings(Gui_Handler.TextFieldSettings.Allow_Enter).get(0)) 
            {
                Console.error("Entered Event", "Entered!", true);
                IH.ChangeFocus(Gui_Handler.getTextField(TextField).getSettings(Gui_Handler.TextFieldSettings.Allow_Enter).get(1));
            } 
            else 
            {
                Console.error("Entered Event", "Failed to Entered!", true);
            }
        }
    }
    
    private static void KeyEvent(JTextField TextField, KeyEvent e) 
    {
    	if ((Boolean) Gui_Handler.getTextField(TextField).hasSetting(Gui_Handler.TextFieldSettings.Currency))
    	{
    		TextField.setText(TextConfig.CurrencyFormatter.formatToCurrency(Input.TextField.getFutureText(TextField, e)));
    		
    		TextField.setText(TextField.getText().substring(0, TextField.getText().length() - 2));
    	}
    	
    	e.consume();
    }

    public static void EventsSetup(JTextField TextField) {
        TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                {
                	if (isEnterAllowed(TextField)) 
                	{
                		EnteredEvent(TextField, e);
                		return;
                	}
                	
                	return;
                }
                
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) 
                {
                    if (!isDeleteAllowed(TextField)) 
                    {
                        e.consume();
                        return;
                    }
                    
                    return;
                }
                
                if (isChar(e)) 
                {
                	KeyEvent(TextField, e);
                	e.consume();
                	return;
                }
                else 
                {
                	System.out.println("InvalidChar: [" + e.getKeyChar() + "]");
                	return;
                }
            }
        });
    }
    
    public static boolean isDeleteAllowed(JTextField textField) 
    {    	
    	if (Gui_Handler.getTextField(textField).hasSetting(Gui_Handler.TextFieldSettings.Allow_Delete)) 
    	{
    		return (boolean) Gui_Handler.getTextField(textField).getSettings(Gui_Handler.TextFieldSettings.Allow_Delete).get(0);
    	}
    	else 
    	{
    		return true;
    	}
    }
    
    public static boolean isEnterAllowed(JTextField textField) 
    {    	
    	if (Gui_Handler.getTextField(textField).hasSetting(Gui_Handler.TextFieldSettings.Allow_Enter)) 
    	{
    		return (boolean) Gui_Handler.getTextField(textField).getSettings(Gui_Handler.TextFieldSettings.Allow_Enter).get(0);
    	}
    	else 
    	{
    		return true;
    	}
    }
    
    public static String getFutureText(JTextField textField, KeyEvent e) 
    {
        String currentText = textField.getText();
        
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && currentText.length() > 0) 
        {
        	return currentText.substring(0, currentText.length() - 1);
        } 
        else if (e.getKeyCode() == KeyEvent.VK_DELETE && textField.getSelectionStart() < currentText.length()) 
        {
        	return currentText.substring(0, textField.getSelectionStart()) + currentText.substring(textField.getSelectionStart() + 1);
        } 
        else 
        {
        	return currentText + e.getKeyChar();
        }
    }
    
    public static boolean isChar(KeyEvent e) 
    {
    	String UpperCaseAlpha = "QWERTYUIOPASDFGHJKLZXCVBNM";
    	String LowerCaseAlpha = "qwertyuiopasdfghjklzxcvbnm";
    	String Numbers = "1234567890";
    	String SpecialCharacters = "!@#$%^&*()-=_+[]{};':.|><.";
    	
    	boolean isUppercaseAlpha = false;
    	boolean isLowerCaseAlpha = false;
    	boolean isNumbers = false;
    	boolean isSpecialCharacters = false;
    	
    	for (char Char : UpperCaseAlpha.toCharArray()) 
    	{
    		if (e.getKeyChar() == Char) 
    		{
    			isUppercaseAlpha = true;
    			break;
    		}
    	}
    	
    	for (char Char : LowerCaseAlpha.toCharArray()) 
    	{
    		if (e.getKeyChar() == Char) 
    		{
    			isLowerCaseAlpha = true;
    			break;
    		}
    	}
    	
    	for (char Char : Numbers.toCharArray()) 
    	{
    		if (e.getKeyChar() == Char) 
    		{
    			isNumbers = true;
    			break;
    		}
    	}
    	
    	for (char Char : SpecialCharacters.toCharArray()) 
    	{
    		if (e.getKeyChar() == Char) 
    		{
    			isSpecialCharacters = true;
    			break;
    		}
    	}
    	
    	return isUppercaseAlpha || isLowerCaseAlpha || isNumbers || isSpecialCharacters;
    }
}