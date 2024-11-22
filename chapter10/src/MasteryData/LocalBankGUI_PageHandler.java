package MasteryData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Mastery.ArrayPageHandler.Section;
import MasteryData.LocalBankGUI_ChangesHandler.Transaction;

public class LocalBankGUI_PageHandler {
	public static int SectionLimit = 3;
	
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
	
	static List<Section> Pages = new ArrayList<>();
	
	public static ArrayList<Section> getSectionFromPage(List<Section> Pages, int PageNumber) 
	{
		int StartingPage = SectionLimit * PageNumber;
		int EndPage = Math.min(StartingPage + SectionLimit, Pages.size());
		
		List<Section> SectionsOnPage = new ArrayList<>(Pages.subList(StartingPage, EndPage));
		
		return (ArrayList<Section>) SectionsOnPage;
	}
	
	public static void removeSectionFromPage(List<Section> Pages, int PageNumber, int SelectedSection) 
	{
		int StartingPage = SectionLimit * PageNumber;
		int EndPage = Math.min(StartingPage + SectionLimit, Pages.size());
		
		List<Section> SectionsOnPage = new ArrayList<>();
		
		int getSection = (SelectedSection - 1);
		
		System.err.println("removed: (" + SelectedSection + ") " + Pages.get(getSection).Person + " | $" + Pages.get(getSection).Amount);
		
		Pages.remove(Pages.subList(StartingPage, EndPage).get(getSection));
		
		System.err.println("Replacement: (" + SelectedSection + ") " + Pages.get(getSection).Person + " | $" + Pages.get(getSection).Amount);
	}
	
	public static int getTotalPages() 
	{
		return (int) Math.ceil((double) Pages.size() / SectionLimit) + 1;
	}
	
	public static void printAllPages() 
	{
		for (int Page = 1; Page < getTotalPages(); Page++) 
		{
			ArrayList<Section> currentPage = getSectionFromPage(Pages, Page - 1);
			System.out.println("Page " + Page + ": ");
			
			for (Section CurrentSection : currentPage) 
			{
				System.out.println(CurrentSection.Person + " | $" + CurrentSection.Amount);
			}
			
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("--------------");
		System.out.println("");
		System.out.println("");
	}
	
	public static void main(String[] args) 
	{
		Section NewSection = new Section(254, "Jack");
		Pages.add(NewSection);
		
		NewSection = new Section(2355, "Joe");
		Pages.add(NewSection);
		
		NewSection = new Section(1, "Tila");
		Pages.add(NewSection);
		
		NewSection = new Section(76, "Yalga");
		Pages.add(NewSection);
		
		NewSection = new Section(896, "Ichi");
		Pages.add(NewSection);
		
		NewSection = new Section(0, "Elica");
		Pages.add(NewSection);
		
		NewSection = new Section(-534, "Frinka");
		Pages.add(NewSection);
		
		printAllPages();
		
		removeSectionFromPage(Pages, 1, 2);
		
		printAllPages();
	}
}
