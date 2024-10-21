package MasteryData;

import java.util.ArrayList;
import java.util.List;

import EasyKit.Console;
import MasteryData.LocalBankGUI_ChangesHandler.GotPage;

public class LocalBankGUI_ChangesHandler {

	public static int currentPage = 1;
	
	public static class Transaction 
	{
		String Person;
		double Amount;
		
		int Section = 1;
		
		Transaction(String Person, double Amount, int Section) 
		{
			this.Person = Person;
			this.Amount = Amount;
		}
	}
	
	public static List<Transaction> Transactions = new ArrayList<>();
	
	public static void CreateTransaction(String Person, double Amount) 
	{
		Transaction NewTransaction = new Transaction(Person, Amount, Transactions.size());
		
		Transactions.add(NewTransaction);
	}
	
	public static void NextPage() 
	{
		
	}
	
	public static void PreviousPage() 
	{
		
	}
	
	public static void RemoveTransaction(int Section) 
	{
		for (Transaction Transaction : Transactions) 
		{
			if (Transaction.Section == Section) 
			{
				Transactions.remove(Transaction);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		CreateTransaction("Joe", 15);
		CreateTransaction("Jack", 25);
		CreateTransaction("Jain", 35);
		
		CreateTransaction("Walter", 45);
		CreateTransaction("Worlk", 55);
		CreateTransaction("Wurk", 65);
		
		CreateTransaction("1", 45);
		CreateTransaction("2", 55);
		CreateTransaction("3", 65);
		
		GotPage SelectedPage = FindSection(3, 2);
		
		System.out.println("Page: " + SelectedPage.Page + " | Section: " + SelectedPage.Section);
		System.out.println("Person: " + SelectedPage.SectionArray.get(0).Transaction.Person + " | Amount: " + SelectedPage.SectionArray.get(0).Transaction.Amount);
	}
	
	public static class GotPage 
	{
		int Page = 0;
		int Section = 0;
		int fullCount = 0;
		
		Page PageClass;
		List<MasteryData.LocalBankGUI_ChangesHandler.Section> SectionArray;
	}
	
	public static class Page 
	{
		int Page = 0;
		
		List<Section> Sections = new ArrayList<>();
	}
	
	public static class Section 
	{
		Transaction Transaction;
		int Section = 1;
		
		Section(Transaction Transaction) 
		{
			this.Transaction = Transaction;
		}
	}
	
	public static GotPage FindSection(int Page, int Section) 
	{
		int Count = 0;
		int CurrentPage = 1;
		int fullCount = 0;
		
		for (Transaction Transaction : Transactions) 
		{
			Page NewPage = new Page();
			NewPage.Page = CurrentPage;
			
			Count++;
			fullCount++;
			
			Section NewSection = new Section(Transaction);
			NewSection.Section = Count;
			NewPage.Sections.add(NewSection);
			
			if (Page == NewPage.Page && Section == NewSection.Section) 
			{
				GotPage GotP = new GotPage();
				GotP.Page = NewPage.Page;
				GotP.Section = NewSection.Section;
				GotP.fullCount = fullCount;
				GotP.PageClass = NewPage;
				GotP.SectionArray = NewPage.Sections;
				
				return GotP;
			}
			
			if (Count == 3) 
			{
				Count = 0;
				CurrentPage++;
			}
		}
		
		return null;
	}
	
	public static GotPage FindPage(int Page) 
	{
		int Count = 0;
		int CurrentPage = 1;
		
		for (Transaction Transaction : Transactions) 
		{
			Page NewPage = new Page();
			NewPage.Page = CurrentPage;
			
			Count++;
			
			Section NewSection = new Section(Transaction);
			NewSection.Section = Count;
			NewPage.Sections.add(NewSection);
			
			if (Page == NewPage.Page) 
			{
				GotPage GotP = new GotPage();
				GotP.Page = NewPage.Page;
				GotP.PageClass = NewPage;
				GotP.SectionArray = NewPage.Sections;
				
				return GotP;
			}
			
			if (Count == 3) 
			{
				Count = 0;
				CurrentPage++;
			}
		}
		
		return null;
	}
}
