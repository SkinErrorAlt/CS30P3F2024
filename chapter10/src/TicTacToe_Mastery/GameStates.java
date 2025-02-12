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
	
	public static PlayersTurn CurrentTurn = PlayersTurn.Player_1;

	// Turns for the players.
	public static enum PlayersTurn 
	{
		Player_1,
		Player_2
	}
	
	// Controls the gamemode for the entire game.
	public static enum GameMode 
	{
		Tic_Tac_Toe, // Base game, get 3 with it being normal gameplay like the original.
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
	
	public static void ResetBoardState() 
	{
		GameFunctions.BoardReady = false;
		Board.clear();
		
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
	}
	
	public void MainStart() 
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
}
