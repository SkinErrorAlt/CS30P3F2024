package TicTacToe_Mastery;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		executorService.submit(() -> 
		{
			TicTacToe_Mastery.GameUi.MainStart();
		});
		
		executorService.submit(() -> 
		{
			TicTacToe_Mastery.GameStates.MainStart();
		});
		
		executorService.submit(() -> 
		{
			TicTacToe_Mastery.GameFunctions.MainStart();
		});
		
		executorService.submit(() -> 
		{
			TicTacToe_Mastery.GameStates.StartTimer();
		});
		
		executorService.shutdown();
	}
}
