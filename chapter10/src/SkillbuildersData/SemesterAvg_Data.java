package SkillbuildersData;

import java.awt.TextField;

import Skillbuilders.SemesterAvg;
@SuppressWarnings("unused")

public class SemesterAvg_Data {

	public static int Semester_1 = -1;
	public static int Semester_2 = -1;
	public static int Semester_3 = -1;
	
	public static void UpdateRating(TextField semester, int number) 
	{
		String fullText = semester.getText() + number;
		
		if (semester.getName().equals("FirstSemester")) 
		{
			if (fullText.equals("") || semester.getText().equals("Enter First Grade") || semester.getText().equals("Enter Second Grade") || semester.getText().equals("Enter Third Grade")) 
			{
				Semester_1 = -1;
			}
			else 
			{
				Semester_1 = number;
			}
		}
		else if (semester.getName().equals("SecondSemester")) 
		{
			if (fullText.equals("") || semester.getText().equals("Enter First Grade") || semester.getText().equals("Enter Second Grade") || semester.getText().equals("Enter Third Grade")) 
			{
				Semester_2 = -1;
			}
			else 
			{
				Semester_2 = number;
			}
		}
		else if (semester.getName().equals("ThirdSemester")) 
		{
			if (fullText.equals("") || semester.getText().equals("Enter First Grade") || semester.getText().equals("Enter Second Grade") || semester.getText().equals("Enter Third Grade")) 
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
