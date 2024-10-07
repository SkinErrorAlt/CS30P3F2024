package EasyKit;

import java.util.ArrayList;
import java.util.List;
import EasyKit.*;

public class Account {

	@SuppressWarnings("unused")
	private static class NewAccount 
	{
		String Username;
		String Password;
		
		String creationDate;
		
		NewAccount(String Username, String Password) 
		{
			this.Username = Username;
			this.Password = Password;
			
			creationDate = Text.GetTime();
		}
	}
	
	public static List<NewAccount> Accounts = new ArrayList<>();

}
