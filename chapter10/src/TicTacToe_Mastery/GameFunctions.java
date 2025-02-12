package TicTacToe_Mastery;

import java.util.Map.Entry;

import TicTacToe_Mastery.GameUi.SelectionBox;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFunctions {
	public static boolean BoardReady = false;
	
	public static boolean CheckForDraw() 
	{

		for (Entry<Integer, SelectionBox> BoardSelection : GameUi.UiBoard.entrySet()) 
		{
			if (GameStates.Board.containsKey(BoardSelection.getKey())) 
			{
				if (GameStates.Board.get(BoardSelection.getKey()) == GameStates.BoardSpotStates.Unclaimed) 
				{
					return false;
				}
			}
		}
		
		
		return true;
	}
	
	public static boolean CheckForWin() 
	{
		for (int i = 1; i <= 9; i += 3) 
		{
			if (GameStates.Board.get(i) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(i) == GameStates.Board.get(i + 1) && GameStates.Board.get(i + 1) == GameStates.Board.get(i + 2)) 
			{
				GameUi.UiBoard.get(i).PlayerSpot.setForeground(Color.green);
				GameUi.UiBoard.get(i).Box.setBackground(Color.BLACK);
				
				GameUi.UiBoard.get(i + 1).PlayerSpot.setForeground(Color.green);
				GameUi.UiBoard.get(i + 1).Box.setBackground(Color.BLACK);
				
				GameUi.UiBoard.get(i + 2).PlayerSpot.setForeground(Color.green);
				GameUi.UiBoard.get(i + 2).Box.setBackground(Color.BLACK);
				return true;
			}
		}
		
		for (int i = 0; i < 3; i++) 
		{
			if (GameStates.Board.get(i) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(i) == GameStates.Board.get(i + 3) && GameStates.Board.get(i + 3) == GameStates.Board.get(i + 6)) 
			{
				GameUi.UiBoard.get(i).PlayerSpot.setForeground(Color.green);
				GameUi.UiBoard.get(i).Box.setBackground(Color.BLACK);
				
				GameUi.UiBoard.get(i + 3).PlayerSpot.setForeground(Color.green);
				GameUi.UiBoard.get(i + 3).Box.setBackground(Color.BLACK);
				
				GameUi.UiBoard.get(i + 6).PlayerSpot.setForeground(Color.green);
				GameUi.UiBoard.get(i + 6).Box.setBackground(Color.BLACK);
				return true;
			}
		}
		
		if (GameStates.Board.get(1) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(1) == GameStates.Board.get(5) && GameStates.Board.get(5) == GameStates.Board.get(9)) 
		{
			GameUi.UiBoard.get(1).PlayerSpot.setForeground(Color.green);
			GameUi.UiBoard.get(1).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(5).PlayerSpot.setForeground(Color.green);
			GameUi.UiBoard.get(5).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(9).PlayerSpot.setForeground(Color.green);
			GameUi.UiBoard.get(9).Box.setBackground(Color.BLACK);
			return true;
		}
		
		if (GameStates.Board.get(3) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(3) == GameStates.Board.get(5) && GameStates.Board.get(5) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(5) == GameStates.Board.get(7) && GameStates.Board.get(7) != GameStates.BoardSpotStates.Unclaimed) 
		{
			GameUi.UiBoard.get(3).PlayerSpot.setForeground(Color.green);
			GameUi.UiBoard.get(3).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(5).PlayerSpot.setForeground(Color.green);
			GameUi.UiBoard.get(5).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(7).PlayerSpot.setForeground(Color.green);
			GameUi.UiBoard.get(7).Box.setBackground(Color.BLACK);
			return true;
		}
		
		return false;
		
	}
	
	public void MainStart()
	{
		while (!BoardReady) 
		{
			System.out.println("Waiting. [GameFunctions]");
			
			try 
			{
				Thread.sleep(10);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		for (Entry<Integer, SelectionBox> BoardSelection : GameUi.UiBoard.entrySet()) 
		{
			BoardSelection.getValue().Box.addActionListener(new ActionListener() 
			{	
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if (GameStates.Board.containsKey(BoardSelection.getKey())) 
					{
						System.out.println("State: " + GameStates.Board.get(BoardSelection.getKey()));
						
						if (GameStates.Board.get(BoardSelection.getKey()) == GameStates.BoardSpotStates.Unclaimed) 
						{
							GameStates.Board.replace(BoardSelection.getKey(), GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1 ? GameStates.BoardSpotStates.X : GameStates.BoardSpotStates.O);
							BoardSelection.getValue().PlayerSpot.setText(GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1 ? "X" : "O");
							
							//GameStates.CurrentTurn = GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1 ? GameStates.PlayersTurn.Player_2 : GameStates.PlayersTurn.Player_1;
						}
					}
					
					System.out.println("Match status: " + (CheckForWin() == true ? "Won" : (CheckForDraw() == true ? "Draw" : "On-going")));
				}
			});
		}
	}
}
