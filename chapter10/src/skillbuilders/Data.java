package skillbuilders;

public class Data {

	static boolean sem1 = false;
	static boolean sem2 = false;
	static boolean sem3 = false;
	
	public static int getSem() 
	{
		int total = 0;
		
		if (sem1) 
		{
			total++;
		}
		
		if (sem2) 
		{
			total++;
		}
		
		if (sem3) 
		{
			total++;
		}
		
		return total;
	}
}
