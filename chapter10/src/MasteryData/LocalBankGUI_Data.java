package MasteryData;

import java.util.ArrayList;
import java.util.List;
import EasyKit.*;
import Mastery.LocalBankGUI;

public class LocalBankGUI_Data {

	public static class NewAccount 
	{
		public String Username;
		public String Password;
		public double Balance;
		
		public String CreationDate;
		
		NewAccount(String Username, String Password) 
		{
			this.Username = Username;
			this.Password = Password;
			this.Balance = Math.random() * 10000;
			
			CreationDate = Text.GetTime();
		}
		
		public List<NewTransaction> Transactions = new ArrayList<>();
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
	
	public static boolean createAccount(String Name, String Password) 
	{
		boolean AccountExists = false;
        for (int CA = 0; CA < Accounts.size(); CA++)
        {
            if (Name.equals(Accounts.get(CA).Username))
            {
                AccountExists = true;
                break;
            }
        }

        if (!AccountExists) // If the account doesn't exist.
        {
            NewAccount account = new NewAccount(Name, Password); // Creates a new NewAccount class and assigns the Entered username and password to the account.
            
            Accounts.add(account); // Adds the account to the accounts list.
            
           Console.error("Account Creation", "Account Doesn't Exists", true, "Account Name: " + account.Username);
        }
        else // If the account already exists.
        {
        	Console.error("Account Creation", "Account Already Exists ✖️");
        }
        
        return AccountExists;
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
			Console.error("Get Account", "Found Account: " + Account.Username + " | Usernames(" + Name + ")|Passowrds(" + Password + ") Same", Name.equals(Account.Username), Password.equals(Account.Password));
			
			if (Name.equals(Account.Username) && Password.equals(Account.Password)) 
			{
				SearchedAccount = Account;
				Console.error("Get Account", "Retreved Account.");
				break;
			}
		}
		
		if (SearchedAccount == null) 
		{
			Console.error("Get Account", "Failed to Retreved Account. [" + Name + "]");
		}
		
		return SearchedAccount;
	}
}
//