package skillbuilders;

import skillbuilders.SemesterAvg;

public class SemesterAvg_Data {

	static boolean sem1 = false;
	static boolean sem2 = false;
	static boolean sem3 = false;
	
	public static void changeSem(int sem) 
	{
		if (sem == 1) 
		{
			sem1 = true;
		}
		else if (sem == 2) 
		{
			sem2 = true;
		}
		else if (sem == 3) 
		{
			sem3 = true;
		}
	}
	
	public static int getSem() 
	{
		int total = 0;
		
		if (sem1) 
		{
			total++;
			System.out.println("Sem1 " + sem1);
		}
		
		if (sem2) 
		{
			total++;
			System.out.println("Sem2 " + sem2);
		}
		
		if (sem3) 
		{
			total++;
			System.out.println("Sem3 " + sem3);
		}
		
		System.out.println(total);
		
		return total;
	}
}
