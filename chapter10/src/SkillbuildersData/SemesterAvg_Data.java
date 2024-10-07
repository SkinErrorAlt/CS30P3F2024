package SkillbuildersData;

import java.awt.TextField;

import javax.swing.JTextField;

import Skillbuilders.SemesterAvg;
@SuppressWarnings("unused")

public class SemesterAvg_Data {

	public static int Semester_1 = -1;
	public static int Semester_2 = -1;
	public static int Semester_3 = -1;
	
	public static void UpdateRating(JTextField firstSemester, int number) 
	{
		String fullText = firstSemester.getText() + number;
		
		if (firstSemester.getName().equals("FirstSemester")) 
		{
			if (fullText.equals("") || firstSemester.getText().equals("Enter First Grade") || firstSemester.getText().equals("Enter Second Grade") || firstSemester.getText().equals("Enter Third Grade")) 
			{
				Semester_1 = -1;
			}
			else 
			{
				Semester_1 = number;
			}
		}
		else if (firstSemester.getName().equals("SecondSemester")) 
		{
			if (fullText.equals("") || firstSemester.getText().equals("Enter First Grade") || firstSemester.getText().equals("Enter Second Grade") || firstSemester.getText().equals("Enter Third Grade")) 
			{
				Semester_2 = -1;
			}
			else 
			{
				Semester_2 = number;
			}
		}
		else if (firstSemester.getName().equals("ThirdSemester")) 
		{
			if (fullText.equals("") || firstSemester.getText().equals("Enter First Grade") || firstSemester.getText().equals("Enter Second Grade") || firstSemester.getText().equals("Enter Third Grade")) 
			{
				Semester_3 = -1;
			}
			else 
			{
				Semester_3 = number;
			} 
		}
		else 
		{
			System.out.println("Failed to get semester.");
		}
	}
	
	public static String GetAvg() 
	{
		int vailedSemesters = 0;
		int total = 0;
		
		if (Semester_1 >= 0) 
		{
			total += Semester_1;
			vailedSemesters++;
		}
		
		if (Semester_2 >= 0) 
		{
			total += Semester_2;
			vailedSemesters++;
		}
		
		if (Semester_3 >= 0) 
		{
			total += Semester_3;
			vailedSemesters++;
		}
		
		if (vailedSemesters == 0) 
		{
			return "0";
		}
		
		System.out.println(vailedSemesters + " | " + total);
		
		return "" + total / vailedSemesters;
	}
}
