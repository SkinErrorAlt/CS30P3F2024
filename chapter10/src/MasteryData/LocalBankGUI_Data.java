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
		boolean AccountExists = false; // Used to see if the account already exists.
        for (int CA = 0; CA < Accounts.size(); CA++) // Loops through every account within the account storage array.
        {
            if (Name.equals(Accounts.get(CA).Username)) // Checks if the entered username is the same as a account.
            {
                AccountExists = true; // Changes the Account Exists varaible and ends the loop.
                break;
            }
        }

        if (!AccountExists) // If the account doesn't exist.
        {
            NewAccount account = new NewAccount(Name, Password); // Creates a new NewAccount class and assigns the Entered username and password to the account.
            
            Accounts.add(account); // Adds the account to the accounts list.
            
           // Console.error("Account Creation", "Account Doesn't Exists ✔️");
        }
        else // If the account already exists.
        {
        	//Console.error("Account Creation", "Account Already Exists ✖️");
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
			if (Account.Username == Name && Account.Password == Password) 
			{
				SearchedAccount = Account;
				break;
			}
		}
		
		return SearchedAccount;
	}
}
