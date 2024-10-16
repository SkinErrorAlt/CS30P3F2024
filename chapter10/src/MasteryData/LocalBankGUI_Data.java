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
	
	public static List<NewAccount> Accounts = new ArrayList<>();
	
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
	
	// broken and doesn't function correctly
	// Todo: Finish up making it check if the account exists or not.
	public static boolean createAccount(String Name, String Password) 
	{
		NewAccount GotAccount = null ;
		int T = 0;
		for (NewAccount Account : Accounts) 
		{
			T++;
			Console.error("Checking: " + Account.Username + " account [" + T + "]");
			
			if (Name == Account.Username) 
			{
				GotAccount = Account;
				Console.error("account: " + Account.Username + " Already exists.");
				break;
			}
			
			if (Name == Accounts.get(T - 1).Username) 
			{
				Console.error("account: " + Account.Username + " Already exists.");
				break;
			}
			
			GotAccount = null;
		}
		
		if (GotAccount == null) 
		{
			NewAccount Account = new NewAccount(Name, Password);
			
			Accounts.add(Account);
			LocalBankGUI.currentAccount = Account;
			
			Console.error("Doesn't exists", "Added new Account: " + Account.Username);
		}
		else 
		{
			Console.error("Account Creation", "Account Already Exists");
		}
		
		return GotAccount != null;
	}
	
	public static void createTransaction(double Amount, String Reason) 
	{
		NewTransaction Transaction = new NewTransaction(Amount, Reason);
		
		LocalBankGUI.currentAccount.Transactions.add(Transaction);
	}
	
	public static NewAccount getAccount(String Name, String Password) 
	{
		NewAccount SearchedAccount = null;
		
		for (NewAccount Account : Accounts) 
		{
			if (Account.Username == Name && Account.Password == Password) 
			{
				SearchedAccount = Account;
				break;
			}
		}
		
		return SearchedAccount;
	}
}
