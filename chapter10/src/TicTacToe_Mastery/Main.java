package TicTacToe_Mastery;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		TicTacToe_Mastery.GameStates States = new TicTacToe_Mastery.GameStates();
		TicTacToe_Mastery.GameFunctions Functions = new TicTacToe_Mastery.GameFunctions();
		
		executorService.submit(() -> 
		{
			TicTacToe_Mastery.GameUi.MainStart();
		});
		
		executorService.submit(() -> 
		{
			States.MainStart();
		});
		
		executorService.submit(() -> 
		{
			Functions.MainStart();
		});
		
		executorService.shutdown();
	}
}
