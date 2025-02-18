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
	public static boolean InMatch = true;
	
	public static void ActivateButtons() 
	{
		for (Entry<Integer, SelectionBox> BoardSelection : GameUi.UiBoard.entrySet()) 
		{
			if (GameStates.Board.containsKey(BoardSelection.getKey())) 
			{
				GameStates.Board.replace(BoardSelection.getKey(), GameStates.BoardSpotStates.Unclaimed);
			}
			
			BoardSelection.getValue().PlayerSpot.setText("");
			BoardSelection.getValue().PlayerSpot.setForeground(Color.WHITE);
			BoardSelection.getValue().Box.setEnabled(true);
			
			GameStates.Player_1.PreviousMoves.clear();
			GameStates.Player_2.PreviousMoves.clear();
			
			if (GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1) 
			{
				GameUi.GameWindow.setBackground(new Color(139, 0, 0));
				GameUi.Game.setBackground(new Color(165, 42, 42));
				GameUi.Information.setBackground(new Color(128, 0, 0));
				BoardSelection.getValue().Box.setBackground(new Color(64, 0, 0));
			}
			else 
			{
				GameUi.GameWindow.setBackground(new Color(0, 0, 139));
				GameUi.Game.setBackground(new Color(42, 42, 165));
				GameUi.Information.setBackground(new Color(0, 0, 128));
				BoardSelection.getValue().Box.setBackground(new Color(0, 0, 64));
			}
			
			GameUi.Won.setVisible(false);
		}
	}
	
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
		boolean GotCorrectPath = false;
		
		// Horizontal Lines
		
		/* Check Straight lines 1-2-3
		 * [1][2][3]
		 * [_][_][_]
		 * [_][_][_]
		*/
		if (GameStates.Board.get(1) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(1) == GameStates.Board.get(2) && GameStates.Board.get(2) == GameStates.Board.get(3)) 
		{
			GameUi.UiBoard.get(1).PlayerSpot.setForeground(GameStates.Board.get(1) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(1).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(2).PlayerSpot.setForeground(GameStates.Board.get(2) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(2).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(3).PlayerSpot.setForeground(GameStates.Board.get(3) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(3).Box.setBackground(Color.BLACK);
			
			GotCorrectPath = true;
		}
		
		/* Check Straight lines 4-5-6
		 * [_][_][_]
		 * [3][5][6]
		 * [_][_][_]
		*/
		if (GameStates.Board.get(4) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(4) == GameStates.Board.get(5) && GameStates.Board.get(5) == GameStates.Board.get(6)) 
		{
			GameUi.UiBoard.get(4).PlayerSpot.setForeground(GameStates.Board.get(4) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(4).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(5).PlayerSpot.setForeground(GameStates.Board.get(5) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(5).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(6).PlayerSpot.setForeground(GameStates.Board.get(6) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(6).Box.setBackground(Color.BLACK);
			
			GotCorrectPath = true;
		}
		
		/* Check Straight lines 7-8-9
		 * [_][_][_]
		 * [_][_][_]
		 * [7][8][9]
		*/
		if (GameStates.Board.get(7) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(7) == GameStates.Board.get(8) && GameStates.Board.get(8) == GameStates.Board.get(9)) 
		{
			GameUi.UiBoard.get(7).PlayerSpot.setForeground(GameStates.Board.get(7) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(7).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(8).PlayerSpot.setForeground(GameStates.Board.get(8) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(8).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(9).PlayerSpot.setForeground(GameStates.Board.get(9) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(9).Box.setBackground(Color.BLACK);
			
			GotCorrectPath = true;
		}
		
		// Vertical Lines
		
		/* Check Straight lines 1-4-7
		 * [1][_][_]
		 * [4][_][_]
		 * [7][_][_]
		*/
		if (GameStates.Board.get(1) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(1) == GameStates.Board.get(4) && GameStates.Board.get(4) == GameStates.Board.get(7)) 
		{
			GameUi.UiBoard.get(1).PlayerSpot.setForeground(GameStates.Board.get(1) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(1).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(4).PlayerSpot.setForeground(GameStates.Board.get(4) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(4).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(7).PlayerSpot.setForeground(GameStates.Board.get(7) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(7).Box.setBackground(Color.BLACK);
			
			GotCorrectPath = true;
		}
		
		/* Check Straight lines 2-5-8
		 * [_][2][_]
		 * [_][5][_]
		 * [_][8][_]
		*/
		if (GameStates.Board.get(2) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(2) == GameStates.Board.get(5) && GameStates.Board.get(5) == GameStates.Board.get(8)) 
		{
			GameUi.UiBoard.get(2).PlayerSpot.setForeground(GameStates.Board.get(2) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(2).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(5).PlayerSpot.setForeground(GameStates.Board.get(5) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(5).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(8).PlayerSpot.setForeground(GameStates.Board.get(8) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(8).Box.setBackground(Color.BLACK);
			
			GotCorrectPath = true;
		}
		
		/* Check Straight lines 3-6-9
		 * [_][_][3]
		 * [_][_][6]
		 * [_][_][9]
		*/
		if (GameStates.Board.get(3) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(3) == GameStates.Board.get(6) && GameStates.Board.get(6) == GameStates.Board.get(9)) 
		{
			GameUi.UiBoard.get(3).PlayerSpot.setForeground(GameStates.Board.get(3) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(3).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(6).PlayerSpot.setForeground(GameStates.Board.get(6) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(6).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(9).PlayerSpot.setForeground(GameStates.Board.get(9) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(9).Box.setBackground(Color.BLACK);
			
			GotCorrectPath = true;
		}
		
		// Cross Lines
		
		/* Check Straight lines 1-5-9
		 * [1][_][_]
		 * [_][5][_]
		 * [_][_][9]
		*/
		if (GameStates.Board.get(1) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(1) == GameStates.Board.get(5) && GameStates.Board.get(5) == GameStates.Board.get(9)) 
		{
			GameUi.UiBoard.get(1).PlayerSpot.setForeground(GameStates.Board.get(1) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(1).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(5).PlayerSpot.setForeground(GameStates.Board.get(5) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(5).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(9).PlayerSpot.setForeground(GameStates.Board.get(9) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(9).Box.setBackground(Color.BLACK);
			
			GotCorrectPath = true;
		}
		
		/* Check Straight lines 3-5-7
		 * [_][_][3]
		 * [_][5][_]
		 * [7][_][_]
		*/
		if (GameStates.Board.get(3) != GameStates.BoardSpotStates.Unclaimed && GameStates.Board.get(3) == GameStates.Board.get(5) && GameStates.Board.get(5) == GameStates.Board.get(7)) 
		{
			GameUi.UiBoard.get(3).PlayerSpot.setForeground(GameStates.Board.get(3) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(3).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(5).PlayerSpot.setForeground(GameStates.Board.get(5) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(5).Box.setBackground(Color.BLACK);
			
			GameUi.UiBoard.get(7).PlayerSpot.setForeground(GameStates.Board.get(7) == GameStates.BoardSpotStates.X ? Color.RED : Color.BLUE);
			GameUi.UiBoard.get(7).Box.setBackground(Color.BLACK);
			
			GotCorrectPath = true;
		}
		
		return GotCorrectPath;
	}
	
	public static void Tic_Tac_Toe_3_Mode() 
	{
		if (GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1) 
		{
			if (GameStates.Player_1.PreviousMoves.size() > GameStates.Tic_Tac_Toe_3_Mode.MovesBeforeRemove) 
			{
				GameStates.Board.replace(GameStates.Player_1.PreviousMoves.get(0), GameStates.BoardSpotStates.Unclaimed);
				
				GameUi.UiBoard.get(GameStates.Player_1.PreviousMoves.get(0)).PlayerSpot.setText("");
				GameUi.UiBoard.get(GameStates.Player_1.PreviousMoves.get(0)).PlayerSpot.setForeground(Color.WHITE);
				GameUi.UiBoard.get(GameStates.Player_1.PreviousMoves.get(0)).Box.setBackground(new Color(64, 0, 0));
				GameUi.UiBoard.get(GameStates.Player_1.PreviousMoves.get(0)).Box.setEnabled(true);
				GameStates.Player_1.PreviousMoves.remove(0);
			}
		}
		else 
		{
			if (GameStates.Player_2.PreviousMoves.size() > GameStates.Tic_Tac_Toe_3_Mode.MovesBeforeRemove) 
			{
				GameStates.Board.replace(GameStates.Player_2.PreviousMoves.get(0), GameStates.BoardSpotStates.Unclaimed);
				
				GameUi.UiBoard.get(GameStates.Player_2.PreviousMoves.get(0)).PlayerSpot.setText("");
				GameUi.UiBoard.get(GameStates.Player_2.PreviousMoves.get(0)).PlayerSpot.setForeground(Color.WHITE);
				GameUi.UiBoard.get(GameStates.Player_2.PreviousMoves.get(0)).Box.setBackground(new Color(64, 0, 0));
				GameUi.UiBoard.get(GameStates.Player_2.PreviousMoves.get(0)).Box.setEnabled(true);
				GameStates.Player_2.PreviousMoves.remove(0);
			}
		}
	}
	
	public static void MainStart()
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
						
						if (GameStates.Board.get(BoardSelection.getKey()) == GameStates.BoardSpotStates.Unclaimed && InMatch) 
						{
							GameStates.Board.replace(BoardSelection.getKey(), GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1 ? GameStates.BoardSpotStates.X : GameStates.BoardSpotStates.O);
							BoardSelection.getValue().PlayerSpot.setText(GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1 ? "X" : "O");
							BoardSelection.getValue().Box.setEnabled(false);
							
							if (GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1) 
							{
								GameStates.Player_1.PreviousMoves.add(BoardSelection.getKey());
							}
							else 
							{
								GameStates.Player_2.PreviousMoves.add(BoardSelection.getKey());
							}
							
							if (GameStates.CurrentMode == GameStates.GameMode.Tic_Tac_3) 
							{
								Tic_Tac_Toe_3_Mode();
							}

							if (!CheckForWin() && !CheckForDraw()) 
							{
								GameStates.CurrentTurn = GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1 ? GameStates.PlayersTurn.Player_2 : GameStates.PlayersTurn.Player_1;
								
								if (GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1) 
								{
									GameUi.GameWindow.setBackground(new Color(139, 0, 0));
									GameUi.Game.setBackground(new Color(165, 42, 42));
									GameUi.Information.setBackground(new Color(128, 0, 0));
								}
								else 
								{
									GameUi.GameWindow.setBackground(new Color(0, 0, 139));
									GameUi.Game.setBackground(new Color(42, 42, 165));
									GameUi.Information.setBackground(new Color(0, 0, 128));
								}
							}
							else
							{
								GameUi.Rematch.setEnabled(true);
								GameUi.Restart.setEnabled(true);
								InMatch = false;
								System.out.println("Match status: " + (CheckForWin() == true ? (GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1 ? "X Won" : "O Won") : (CheckForDraw() == true ? "Draw" : "On-going")));
								
								if (GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1) 
								{
									GameStates.Player_1.Score++;
									GameUi.Player_1_Score.setText("X = " + GameStates.Player_1.Score);
									GameUi.Won.setText("[X] Won!");
								}
								else 
								{
									GameStates.Player_2.Score++;
									GameUi.Player_2_Score.setText("O = " + GameStates.Player_2.Score);
									GameUi.Won.setText("[O] Won!");
								}
								
								GameUi.Won.setVisible(true);
								
								for (Entry<Integer, SelectionBox> BoardSelection : GameUi.UiBoard.entrySet()) 
								{
									BoardSelection.getValue().Box.setEnabled(false);
								}
								
								if (!CheckForWin() && CheckForDraw()) 
								{
									for (Entry<Integer, SelectionBox> BoardSelection : GameUi.UiBoard.entrySet()) 
									{
										BoardSelection.getValue().PlayerSpot.setForeground(Color.gray);
									}
								}
							}
							
							for (Entry<Integer, SelectionBox> BoardSelection : GameUi.UiBoard.entrySet()) 
							{
								if (GameStates.CurrentTurn == GameStates.PlayersTurn.Player_1) 
								{
									BoardSelection.getValue().Box.setBackground(new Color(64, 0, 0));
								}
								else 
								{
									BoardSelection.getValue().Box.setBackground(new Color(0, 0, 64));
								}
							}
						}
					}
				}
			});
		}
	}
}