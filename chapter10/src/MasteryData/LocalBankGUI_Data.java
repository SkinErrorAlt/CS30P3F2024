package MasteryData;

import java.util.ArrayList;
import java.util.List;
import EasyKit.*;
import Mastery.LocalBankGUI;

public class LocalBankGUI_Data {

	@SuppressWarnings("unused")
	public static class NewAccount 
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
		
		List<NewTransaction> Transactions = new ArrayList<>();
	}
	
	@SuppressWarnings("unused")
	private static class NewTransaction 
	{
		double Amount;
		String Reason;
		String Date = Text.GetTime();
		
		NewTransaction(double Amount, String Reason) 
		{
			this.Amount = Amount;
			this.Reason = Reason;
		}
	}
	
	public static void createAccount(String Name, String Password) 
	{
		NewAccount Account = new NewAccount(Name, Password);
		Accounts.add(Account);
		LocalBankGUI.currentAccount = Account;
	}
	
	public static void createTransaction(double Amount, String Reason) 
	{
		NewTransaction Transaction = new NewTransaction(Amount, Reason);
		
		LocalBankGUI.currentAccount.Transactions.add(Transaction);
	}
	
	public static List<NewAccount> Accounts = new ArrayList<>();
}
