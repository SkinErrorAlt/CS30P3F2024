package MasteryData;

import java.util.ArrayList;
import java.util.List;

import MasteryData.LocalBankGUI_ChangesHandler.Transaction;

public class LocalBankGUI_PageHandler {

	public static int CurrentPage = 1;
	public static int SectionLimit = 5;
	
	public static class Section 
	{
		int Amount;
		String Person;
		
		Section(int amount, String person) 
		{
			Amount = amount;
			Person = person;
		}
	}
	
	public static class Page 
	{
		int PageNum = 1;
		
		List<Section> Sections = new ArrayList<>();
		
		Page(int Page) 
		{
			this.PageNum = Page;
		}
		
		int getPage() 
		{
			return PageNum;
		}
		
		void addSection(int Amount, String Person) 
		{
			Section NewSection = new Section(Amount, Person);
			Sections.add(NewSection);
		}
		
		List<Section> getSections() 
		{
			return Sections;
		}
	}
	
	static List<Page> Pages = new ArrayList<>();
	
	public static void main(String[] args) 
	{
		createPage(1);
		
		createSection((int) (Math.random() * 1000), "Joe");
		createSection((int) (Math.random() * 1000), "Jack");
		createSection((int) (Math.random() * 1000), "Jin");
		
		createSection((int) (Math.random() * 1000), "Rando");
		createSection((int) (Math.random() * 1000), "Rank");
		createSection((int) (Math.random() * 1000), "Ricoo");
		
		createSection((int) (Math.random() * 1000), "Znip");
		createSection((int) (Math.random() * 1000), "Znorp");
		createSection((int) (Math.random() * 1000), "Zorps");
		
		createSection((int) (Math.random() * 1000), "Apple");
		createSection((int) (Math.random() * 1000), "Apps");
		createSection((int) (Math.random() * 1000), "Alse");
		
		for (Page Page : Pages) 
		{
			System.out.println("");
			int currentSection = 1;
			for (Section Section : Page.Sections) 
			{
				System.out.println("Page: [" + Page.PageNum + "] | Section: [" + currentSection + "],= Person: [" + Section.Person + "]");
				currentSection++;
			}
		}
	}
	
	public static void createSection(int Amount, String Person) 
	{
		Section NewSection = new Section(Amount, Person);

		if (Pages.get(CurrentPage - 1).Sections.size() >= SectionLimit) 
		{
			createPage(Pages.size() + 1);
			CurrentPage = Pages.size();
			
			System.out.println("Created new page");
		}
		else 
		{
			System.out.println("Didn't create new page");
		}
		
		Pages.get(CurrentPage - 1).Sections.add(NewSection);
	}
	
	public static void createPage(int PageNum) 
	{
		Page NewPage = new Page(PageNum);
		Pages.add(NewPage);
	}
	
	public static void removeSection(int Page, int Section) 
	{
		
	}
	
	public static int getPage() 
	{
		return CurrentPage;
	}
}
