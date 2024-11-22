package Mastery;
import java.util.ArrayList;
import java.util.List;

import MasteryData.LocalBankGUI_PageHandler.Section;

public class ArrayPageHandler {
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
	
	public static ArrayList<Section> getSectionFromPage(List<Section> pages2, int PageNumber) 
	{
		int StartingPage = SectionLimit * PageNumber;
		int EndPage = Math.min(StartingPage + SectionLimit, pages2.size());
		
		List<Section> SectionsOnPage = new ArrayList<>(pages2.subList(StartingPage, EndPage));
		
		return (ArrayList<Section>) SectionsOnPage;
	}
	
	public static int getTotalPages() 
	{
		return (int) Math.ceil((double) Pages.size() / SectionLimit);
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

        // Demonstrate page retrieval
        for (int page = 0; page < getTotalPages(); page++) {
            ArrayList<Section> currentPage = getSectionFromPage(Pages, page);
            System.out.println("Page " + page + ":");
            
            for (Section CurrentSection : currentPage) 
            {
            	System.out.println(CurrentSection.Person + " | $" + CurrentSection.Amount);
            }
            
            System.out.println("");
        }
	}
}