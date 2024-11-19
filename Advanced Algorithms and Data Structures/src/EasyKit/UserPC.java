package EasyKit;

// Used to figure out how to copy over string to the users clipboard: https://stackoverflow.com/questions/6710350/copying-text-to-the-clipboard-using-java
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class UserPC {
	public static void Clipboard(String Message) 
	{
		StringSelection stringSelection = new StringSelection(Message);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		clipboard.setContents(stringSelection, null);
	}
}
