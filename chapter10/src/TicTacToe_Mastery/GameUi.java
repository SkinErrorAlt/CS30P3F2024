package TicTacToe_Mastery;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import TicTacToe_Mastery.GameStates.BoardSpotStates;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.UIManager;

public class GameUi {

	private static JFrame frame;
	
	// Box slots. (Aka the placement for the players X and O)
	public static JButton Box_1;
	public static JLabel PlayerSpot_1;
	
	public static JButton Box_2;
	public static JLabel PlayerSpot_2;
	
	public static JButton Box_3;
	public static JLabel PlayerSpot_3;
	
	public static JButton Box_4;
	public static JLabel PlayerSpot_4;
	
	public static JButton Box_5;
	public static JLabel PlayerSpot_5;
	
	public static JButton Box_6;
	public static JLabel PlayerSpot_6;
	
	public static JButton Box_7;
	public static JLabel PlayerSpot_7;
	
	public static JButton Box_8;
	public static JLabel PlayerSpot_8;
	
	public static JButton Box_9;
	public static JLabel PlayerSpot_9;
	
	// interface Buttons for the round system. | Difference between the two is play again reset all score between X and O and Rematch will restart the match up.
	public static JButton Rematch;
	public static JButton Restart;
	
	public static JPanel GameWindow;
	public static JPanel Game;
	public static JPanel Information;

	// Score
	public static JLabel Player_1_Score;
	public static JLabel Player_2_Score;
	public static JLabel Won;
	
	// Timer
	public static JLabel Timer;
	
	public static class SelectionBox
	{
		JButton Box;
		JLabel PlayerSpot;
		
		SelectionBox(JButton box_1, JLabel PlayerSpot) 
		{
			this.Box = box_1;
			this.PlayerSpot = PlayerSpot;
		}
	}
	
	public static Map<Integer, SelectionBox> UiBoard = new HashMap<>(); // Fast at getting data and also is extremely useful with being able to quickly look up the current state of a piece on the board. 
	
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void MainStart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize(); // window = new GameUi();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Game = new JPanel();
		Game.setBackground(new Color(165, 42, 42));
		Game.setBounds(0, 0, 584, 497);
		frame.getContentPane().add(Game);
		Game.setLayout(null);
		
		GameWindow = new JPanel();
		GameWindow.setBackground(new Color(139, 0, 0));
		GameWindow.setBounds(130, 37, 323, 323);
		Game.add(GameWindow);
		GameWindow.setLayout(null);
		
//		//\\
//		\\//
		
		Box_1 = new JButton();
		Box_1.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Box_1.setBackground(new Color(64, 0, 0));
		Box_1.setBounds(10, 11, 79, 79);
		GameWindow.add(Box_1);
		Box_1.setLayout(null);
		
		PlayerSpot_1 = new JLabel("");
		PlayerSpot_1.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerSpot_1.setFont(new Font("Verdana", Font.BOLD, 26));
		PlayerSpot_1.setForeground(new Color(255, 255, 255));
		PlayerSpot_1.setBounds(10, 11, 59, 57);
		Box_1.add(PlayerSpot_1);
		
//		//\\
//		\\//
		
		Box_2 = new JButton();
		Box_2.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Box_2.setBackground(new Color(64, 0, 0));
		Box_2.setBounds(122, 11, 79, 79);
		GameWindow.add(Box_2);
		Box_2.setLayout(null);
		
		PlayerSpot_2 = new JLabel("");
		PlayerSpot_2.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerSpot_2.setForeground(Color.WHITE);
		PlayerSpot_2.setFont(new Font("Verdana", Font.BOLD, 26));
		PlayerSpot_2.setBounds(10, 11, 59, 57);
		Box_2.add(PlayerSpot_2);
		
//		//\\
//		\\//
		
		Box_3 = new JButton();
		Box_3.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Box_3.setBackground(new Color(64, 0, 0));
		Box_3.setBounds(234, 11, 79, 79);
		GameWindow.add(Box_3);
		Box_3.setLayout(null);
		
		PlayerSpot_3 = new JLabel("");
		PlayerSpot_3.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerSpot_3.setForeground(Color.WHITE);
		PlayerSpot_3.setFont(new Font("Verdana", Font.BOLD, 26));
		PlayerSpot_3.setBounds(10, 11, 59, 57);
		Box_3.add(PlayerSpot_3);
		
//		//\\
//		\\//
		
		Box_4 = new JButton();
		Box_4.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Box_4.setBackground(new Color(64, 0, 0));
		Box_4.setBounds(10, 122, 79, 79);
		GameWindow.add(Box_4);
		Box_4.setLayout(null);
		
		PlayerSpot_4 = new JLabel("");
		PlayerSpot_4.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerSpot_4.setForeground(Color.WHITE);
		PlayerSpot_4.setFont(new Font("Verdana", Font.BOLD, 26));
		PlayerSpot_4.setBounds(10, 11, 59, 57);
		Box_4.add(PlayerSpot_4);
		
//		//\\
//		\\//
		
		Box_5 = new JButton();
		Box_5.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Box_5.setBackground(new Color(64, 0, 0));
		Box_5.setBounds(122, 122, 79, 79);
		GameWindow.add(Box_5);
		Box_5.setLayout(null);
		
		PlayerSpot_5 = new JLabel("");
		PlayerSpot_5.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerSpot_5.setForeground(Color.WHITE);
		PlayerSpot_5.setFont(new Font("Verdana", Font.BOLD, 26));
		PlayerSpot_5.setBounds(10, 11, 59, 57);
		Box_5.add(PlayerSpot_5);
		
//		//\\
//		\\//
		
		Box_6 = new JButton();
		Box_6.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Box_6.setBackground(new Color(64, 0, 0));
		Box_6.setBounds(234, 122, 79, 79);
		GameWindow.add(Box_6);
		Box_6.setLayout(null);
		
		PlayerSpot_6 = new JLabel("");
		PlayerSpot_6.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerSpot_6.setForeground(Color.WHITE);
		PlayerSpot_6.setFont(new Font("Verdana", Font.BOLD, 26));
		PlayerSpot_6.setBounds(10, 11, 59, 57);
		Box_6.add(PlayerSpot_6);
		
//		//\\
//		\\//
		
		Box_7 = new JButton();
		Box_7.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Box_7.setBackground(new Color(64, 0, 0));
		Box_7.setBounds(10, 233, 79, 79);
		GameWindow.add(Box_7);
		Box_7.setLayout(null);
		
		PlayerSpot_7 = new JLabel("");
		PlayerSpot_7.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerSpot_7.setForeground(Color.WHITE);
		PlayerSpot_7.setFont(new Font("Verdana", Font.BOLD, 26));
		PlayerSpot_7.setBounds(10, 11, 59, 57);
		Box_7.add(PlayerSpot_7);
		
//		//\\
//		\\//
		
		Box_8 = new JButton();
		Box_8.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Box_8.setBackground(new Color(64, 0, 0));
		Box_8.setBounds(122, 233, 79, 79);
		GameWindow.add(Box_8);
		Box_8.setLayout(null);
		
		PlayerSpot_8 = new JLabel("");
		PlayerSpot_8.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerSpot_8.setForeground(Color.WHITE);
		PlayerSpot_8.setFont(new Font("Verdana", Font.BOLD, 26));
		PlayerSpot_8.setBounds(10, 11, 59, 57);
		Box_8.add(PlayerSpot_8);
		
//		//\\
//		\\//
		
		Box_9 = new JButton();
		Box_9.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Box_9.setBackground(new Color(64, 0, 0));
		Box_9.setBounds(234, 233, 79, 79);
		GameWindow.add(Box_9);
		Box_9.setLayout(null);
		
		PlayerSpot_9 = new JLabel("");
		PlayerSpot_9.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerSpot_9.setForeground(Color.WHITE);
		PlayerSpot_9.setFont(new Font("Verdana", Font.BOLD, 26));
		PlayerSpot_9.setBounds(10, 11, 59, 57);
		Box_9.add(PlayerSpot_9);
		
//		//\\
//		\\//
		
		// Information panel | Contains the information of the game like score of the players and also round options.

		Information = new JPanel();
		Information.setBackground(new Color(128, 0, 0));
		Information.setBounds(40, 385, 504, 84);
		Game.add(Information);
		Information.setLayout(null);
		
		Won = new JLabel("[?] Won!");
		Won.setFont(new Font("Verdana", Font.BOLD, 15));
		Won.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Won.setHorizontalAlignment(SwingConstants.CENTER);
		Won.setHorizontalTextPosition(SwingConstants.CENTER);
		Won.setForeground(new Color(255, 255, 255));
		Won.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		Won.setToolTipText("The player that one is...");
		Won.setBackground(new Color(255, 255, 255));
		Won.setBounds(212, 17, 80, 49);
		Won.setVisible(false);
		Information.add(Won);
		
		Rematch = new JButton("Rematch?");
		Rematch.setEnabled(false);
		Rematch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Rematch.setBackground(new Color(255, 255, 255));
		Rematch.setBounds(35, 17, 146, 23);
		Information.add(Rematch);
		
		Restart = new JButton("Restart?");
		Restart.setEnabled(false);
		Restart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Restart.setBackground(new Color(255, 255, 255));
		Restart.setBounds(35, 43, 146, 23);
		Information.add(Restart);
		
		JLabel Score_Title = new JLabel("Score:");
		Score_Title.setToolTipText("The player that one is...");
		Score_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Score_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Score_Title.setForeground(Color.WHITE);
		Score_Title.setFont(new Font("Verdana", Font.BOLD, 10));
		Score_Title.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		Score_Title.setBackground(Color.WHITE);
		Score_Title.setBounds(396, 10, 80, 33);
		Information.add(Score_Title);
		
		Player_1_Score = new JLabel("X = 0");
		Player_1_Score.setToolTipText("The player that one is...");
		Player_1_Score.setHorizontalTextPosition(SwingConstants.CENTER);
		Player_1_Score.setHorizontalAlignment(SwingConstants.CENTER);
		Player_1_Score.setForeground(Color.WHITE);
		Player_1_Score.setFont(new Font("Verdana", Font.BOLD, 10));
		Player_1_Score.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		Player_1_Score.setBackground(Color.WHITE);
		Player_1_Score.setBounds(416, 23, 80, 33);
		Information.add(Player_1_Score);
		
		Player_2_Score = new JLabel("O = 0");
		Player_2_Score.setToolTipText("The player that one is...");
		Player_2_Score.setHorizontalTextPosition(SwingConstants.CENTER);
		Player_2_Score.setHorizontalAlignment(SwingConstants.CENTER);
		Player_2_Score.setForeground(Color.WHITE);
		Player_2_Score.setFont(new Font("Verdana", Font.BOLD, 10));
		Player_2_Score.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		Player_2_Score.setBackground(Color.WHITE);
		Player_2_Score.setBounds(416, 42, 80, 33);
		Information.add(Player_2_Score);

		SelectionBox NewSelectionBox_1 = new SelectionBox(Box_1, PlayerSpot_1);
		UiBoard.put(1, NewSelectionBox_1);
		
		SelectionBox NewSelectionBox_2 = new SelectionBox(Box_2, PlayerSpot_2);
		UiBoard.put(2, NewSelectionBox_2);
		
		SelectionBox NewSelectionBox_3 = new SelectionBox(Box_3, PlayerSpot_3);
		UiBoard.put(3, NewSelectionBox_3);
		
		SelectionBox NewSelectionBox_4 = new SelectionBox(Box_4, PlayerSpot_4);
		UiBoard.put(4, NewSelectionBox_4);
		
		SelectionBox NewSelectionBox_5 = new SelectionBox(Box_5, PlayerSpot_5);
		UiBoard.put(5, NewSelectionBox_5);
		
		SelectionBox NewSelectionBox_6 = new SelectionBox(Box_6, PlayerSpot_6);
		UiBoard.put(6, NewSelectionBox_6);
		
		SelectionBox NewSelectionBox_7 = new SelectionBox(Box_7, PlayerSpot_7);
		UiBoard.put(7, NewSelectionBox_7);
		
		SelectionBox NewSelectionBox_8 = new SelectionBox(Box_8, PlayerSpot_8);
		UiBoard.put(8, NewSelectionBox_8);
		
		SelectionBox NewSelectionBox_9 = new SelectionBox(Box_9, PlayerSpot_9);
		
		Timer = new JLabel("Time Played: 0");
		Timer.setBounds(131, 2, 322, 33);
		Game.add(Timer);
		Timer.setToolTipText("How long the game has been active.");
		Timer.setHorizontalTextPosition(SwingConstants.CENTER);
		Timer.setHorizontalAlignment(SwingConstants.CENTER);
		Timer.setForeground(Color.WHITE);
		Timer.setFont(new Font("Verdana", Font.BOLD, 10));
		Timer.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		Timer.setBackground(Color.WHITE);
		UiBoard.put(9, NewSelectionBox_9);
		
		GameStates.BoardUiSetup = true;
		frame.setVisible(true);
		
		Restart.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Restart.setEnabled(false);
				Rematch.setEnabled(false);
				
				GameStates.Player_1.Score = 0;
				GameStates.Player_2.Score = 0;
				
				GameUi.Player_1_Score.setText("X = " + GameStates.Player_1.Score);
				GameUi.Player_2_Score.setText("O = " + GameStates.Player_2.Score);
				
				GameFunctions.InMatch = true;
				GameFunctions.ActivateButtons();
			}
		});
		
		Rematch.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Rematch.setEnabled(false);
				Restart.setEnabled(false);
				
				GameFunctions.InMatch = true;
				GameFunctions.ActivateButtons();
			}
		});
	}
}
