package MasteryData;

import java.util.ArrayList;
import java.util.List;
import EasyKit.*;

public class LocalBankGUI_Data {

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
	
	private static class NewTransaction 
	{
		double Amount;
		String Reason;
		String Date = Text.GetTime();
		
		NewTransaction(double Amount, String Reason) 
		{
			
		}
	}
	
	public static List<NewAccount> Accounts = new ArrayList<>();
}
