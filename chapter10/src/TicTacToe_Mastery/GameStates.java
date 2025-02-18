package TicTacToe_Mastery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import EasyKit.Gui_Handler.TextFieldSettings;
import TicTacToe_Mastery.*;

public class GameStates {
	private static final boolean Debug = false;
	public static boolean BoardUiSetup = false;
	public static int MiniGameTime = 0;
	
	public static PlayersTurn CurrentTurn = PlayersTurn.Player_1;
	public static GameMode CurrentMode = GameMode.Tic_Tac_Toe;
	
	public static Player_1_Config Player_1 = new Player_1_Config();
	public static Player_2_Config Player_2 = new Player_2_Config();
	public static Tic_Tac_Toe_3_Mode_Config Tic_Tac_Toe_3_Mode = new Tic_Tac_Toe_3_Mode_Config();
	
	static class Tic_Tac_Toe_3_Mode_Config
	{
		int MovesBeforeRemove = 3; // The amount of moves the player can do before the last move they made (in this case 3 behind the current move) will be removed and placed where they decided to move.
		int TimeLimit = 30; // In Seconds.
	}
	
	static class Player_1_Config 
	{
		List<Integer> PreviousMoves = new ArrayList<>();
		int Score = 0;
	}
	
	static class Player_2_Config
	{
		List<Integer> PreviousMoves = new ArrayList<>();
		int Score = 0;
	}

	// Turns for the players.
	public static enum PlayersTurn 
	{
		Player_1,
		Player_2
	}
	
	// Controls the gamemode for the entire game.
	public static enum GameMode 
	{
		Tic_Tac_Toe, // Base game, get 3 with it being normal gameplay like the original. Get 3 in a row however a draw can still happen.
		Tic_Tac_3 // Rule set (Players will have to make 3 match with only having 3 moves on the board. Once 3 are placed already, the first one played will be removed and placed where the new spot the player clicked is)
	}
	
	// The (X/O) spots on the board.
	public static enum BoardSpotStates 
	{
		Unclaimed,
		X,
		O
	}
	
	public static Map<Integer, BoardSpotStates> Board = new HashMap<>(); // Fast at getting data and also is extremely useful with being able to quickly look up the current state of a piece on the board. 
	
	public static void MainStart() 
	{
		while (!BoardUiSetup) 
		{
			System.out.println("Waiting. [GameStates]");
			try 
			{
				Thread.sleep(10);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		for (int i = 1; i <= 9; i++) 
		{
			Board.put(i, BoardSpotStates.Unclaimed);
		}
		
		if (Debug) 
		{
			for (Entry<Integer, BoardSpotStates> BoardSpot : Board.entrySet()) 
			{
				System.out.println("BoardSpot: " + BoardSpot.getKey() + " | set to: " + BoardSpot.getValue().toString());
			}
		}
		
		GameFunctions.BoardReady = true;
	}
	
	public static void StartTimer() 
	{
		int CurrentTime100ms = 0;
		while (true) 
		{
			if (GameFunctions.InMatch) 
			{
				try 
				{
					Thread.sleep(100);
					CurrentTime100ms++;
					
					if (CurrentTime100ms >= 10) 
					{
						MiniGameTime++;
						CurrentTime100ms = 0;
						GameUi.Timer.setText("Current Time: " + MiniGameTime); 
					}
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			else 
			{
				MiniGameTime = 0;
				
				try 
				{
					Thread.sleep(10);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
