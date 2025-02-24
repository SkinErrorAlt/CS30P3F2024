package WordGuess_Mastery;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.submit(() -> 
		{
			Guess_Gui.MainStart();
		});
	}
}
