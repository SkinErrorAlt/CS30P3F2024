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

public class GameUi {

	private static JFrame frame;
	
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
		
		JPanel Game = new JPanel();
		Game.setBackground(new Color(128, 64, 64));
		Game.setBounds(0, 0, 584, 497);
		frame.getContentPane().add(Game);
		Game.setLayout(null);
		
		JPanel GameWindow = new JPanel();
		GameWindow.setBackground(new Color(128, 0, 0));
		GameWindow.setBounds(130, 37, 323, 323);
		Game.add(GameWindow);
		GameWindow.setLayout(null);
		
//		//\\
//		\\//
		
		Box_1 = new JButton();
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

		JPanel Information = new JPanel();
		Information.setBackground(new Color(255, 0, 0));
		Information.setBounds(40, 385, 504, 84);
		Game.add(Information);
		Information.setLayout(null);

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
		UiBoard.put(9, NewSelectionBox_9);
		
		GameStates.BoardUiSetup = true;
		frame.setVisible(true);
	}
}
