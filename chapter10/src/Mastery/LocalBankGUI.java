package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class LocalBankGUI {

	private JFrame frame;
	private JTextField txtTest;
	private JTextField txtEnterPassword;
	private JLabel txtDontHaveAn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalBankGUI window = new LocalBankGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LocalBankGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 666, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel LoginScreen = new Panel();
		LoginScreen.setBackground(Color.PINK);
		LoginScreen.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(LoginScreen);
		LoginScreen.setLayout(null);
		
		JButton GoToSignUp = new JButton();
		GoToSignUp.setBorderPainted(false);
		GoToSignUp.setText("sign up");
		GoToSignUp.setForeground(Color.BLUE);
		GoToSignUp.setFont(new Font("Verdana", Font.PLAIN, 16));
		GoToSignUp.setBorder(null);
		GoToSignUp.setBackground(Color.PINK);
		GoToSignUp.setAutoscrolls(false);
		GoToSignUp.setBounds(408, 279, 61, 27);
		LoginScreen.add(GoToSignUp);
		
		JLabel BankTitle = new JLabel("The Golden Bank of Calgary");
		BankTitle.setForeground(Color.WHITE);
		BankTitle.setBounds(136, 11, 383, 75);
		BankTitle.setAlignmentX(0.5f);
		BankTitle.setHorizontalAlignment(SwingConstants.CENTER);
		BankTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		BankTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		LoginScreen.add(BankTitle);
		
		txtTest = new JTextField();
		txtTest.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTest.setForeground(Color.DARK_GRAY);
		txtTest.setBackground(new Color(255, 206, 198));
		txtTest.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtTest.setSelectedTextColor(new Color(255, 159, 159));
		txtTest.setText("Enter Username");
		txtTest.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtTest.setBounds(163, 194, 367, 27);
		LoginScreen.add(txtTest);
		txtTest.setColumns(10);
		
		txtEnterPassword = new JTextField();
		txtEnterPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtEnterPassword.setText("Enter Password");
		txtEnterPassword.setSelectedTextColor(new Color(255, 159, 159));
		txtEnterPassword.setForeground(Color.DARK_GRAY);
		txtEnterPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtEnterPassword.setColumns(10);
		txtEnterPassword.setBackground(new Color(255, 206, 198));
		txtEnterPassword.setBounds(163, 241, 367, 27);
		LoginScreen.add(txtEnterPassword);
		
		txtDontHaveAn = new JLabel();
		txtDontHaveAn.setHorizontalAlignment(SwingConstants.CENTER);
		txtDontHaveAn.setBorder(null);
		txtDontHaveAn.setAutoscrolls(false);
		txtDontHaveAn.setText("Don't have an account?");
		txtDontHaveAn.setForeground(Color.WHITE);
		txtDontHaveAn.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtDontHaveAn.setBackground(Color.PINK);
		txtDontHaveAn.setBounds(136, 279, 338, 27);
		LoginScreen.add(txtDontHaveAn);
	}
}
