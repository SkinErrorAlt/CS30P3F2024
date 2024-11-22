package MasteryData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalBankGUI_PageHandler {
	public static int SectionLimit = 3;
	public static int CurrentPage = 1;
	
	public static class Transaction 
	{
		double Amount;
		String Person;
		
		Transaction(String Person, double Amount) 
		{
			this.Person = Person;
			this.Amount = Amount;
		}
	}
	
	public static List<Transaction> Pages = new ArrayList<>();
	
	public static ArrayList<Transaction> getSectionFromPage(List<Transaction> Pages, int PageNumber) 
	{
		int StartingPage = SectionLimit * PageNumber;
		int EndPage = Math.min(StartingPage + SectionLimit, Pages.size());
		
		List<Transaction> SectionsOnPage = new ArrayList<>(Pages.subList(StartingPage, EndPage));
		
		return (ArrayList<Transaction>) SectionsOnPage;
	}
	
	public static void removeSectionFromPage(List<Transaction> Pages, int PageNumber, int SelectedSection) 
	{
		int StartingPage = SectionLimit * (PageNumber - 1);
		int EndPage = StartingPage + (SelectedSection - 1);

		int getSection = EndPage;

		Pages.remove(getSection);
		
		if (CurrentPage > Pages.size()) 
		{
			CurrentPage = getTotalPages();
		}
	}
	
	public static int getTotalPages() 
	{
		return (int) Math.ceil((double) Pages.size() / SectionLimit) + 1;
	}
	
	public static void printAllPages() 
	{
		for (int Page = 1; Page < getTotalPages(); Page++) 
		{
			ArrayList<Transaction> currentPage = getSectionFromPage(Pages, Page - 1);
			System.out.println("Page " + Page + ": ");
			
			for (Transaction CurrentSection : currentPage) 
			{
				System.out.println(CurrentSection.Person + " | " + (CurrentSection.Amount >= 0 ? "$" + CurrentSection.Amount : "-$" + (-CurrentSection.Amount)));
			}
			
			System.out.println("");
		}
	}
	
	public static void addSection(String Person, double Amount)
	{
		Transaction NewTransaction = new Transaction(Person, Amount);
		Pages.add(NewTransaction);
		
		
	}
}
