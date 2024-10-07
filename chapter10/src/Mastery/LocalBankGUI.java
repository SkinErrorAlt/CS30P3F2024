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

import EasyKit.Ui;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.ComponentOrientation;
import java.awt.event.KeyAdapter;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocalBankGUI {

	private JFrame frame;
	private JTextField EnterUsername;
	private JTextField EnterPassword;
	private JLabel txtDontHaveAn;
	private Panel SignUpScreen;
	private JButton goToLogin;
	private JLabel bankTitle;
	private JTextField SignUpUsername;
	private JTextField SignUpPassword;
	private JLabel HaveAccount;

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
		GoToSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GoToSignUp.setBorderPainted(false);
		GoToSignUp.setText("sign up");
		GoToSignUp.setForeground(Color.BLUE);
		GoToSignUp.setFont(new Font("Verdana", Font.PLAIN, 16));
		GoToSignUp.setBorder(null);
		GoToSignUp.setBackground(Color.PINK);
		GoToSignUp.setAutoscrolls(false);
		GoToSignUp.setBounds(408, 279, 61, 27);
		LoginScreen.add(GoToSignUp);
		
		GoToSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SignUpScreen.setVisible(true);
				LoginScreen.setVisible(false);
			}
		});
		
		JLabel BankTitle = new JLabel("The Golden Bank of Calgary");
		BankTitle.setForeground(Color.WHITE);
		BankTitle.setBounds(136, 11, 383, 75);
		BankTitle.setAlignmentX(0.5f);
		BankTitle.setHorizontalAlignment(SwingConstants.CENTER);
		BankTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		BankTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		LoginScreen.add(BankTitle);
		
		EnterUsername = new JTextField();
		EnterUsername.setToolTipText("Enter the username to your account");
		EnterUsername.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		EnterUsername.setForeground(Color.GRAY);
		EnterUsername.setBackground(new Color(255, 206, 198));
		EnterUsername.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		EnterUsername.setSelectedTextColor(new Color(255, 159, 159));
		EnterUsername.setText("Enter Username");
		EnterUsername.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterUsername.setBounds(163, 194, 367, 27);
		LoginScreen.add(EnterUsername);
		EnterUsername.setColumns(10);
		
		Ui.TextFieldSetup(EnterUsername, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		EnterPassword = new JTextField();
		EnterPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		EnterPassword.setText("Enter Password");
		EnterPassword.setSelectedTextColor(new Color(255, 159, 159));
		EnterPassword.setForeground(Color.GRAY);
		EnterPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterPassword.setColumns(10);
		EnterPassword.setBackground(new Color(255, 206, 198));
		EnterPassword.setBounds(163, 241, 367, 27);
		LoginScreen.add(EnterPassword);
		
		Ui.TextFieldSetup(EnterPassword, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
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
		
		// EnterUsername Events
		EnterUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Ui.toggleTipText(EnterUsername);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Ui.toggleTipText(EnterUsername);
			}
		});
		EnterUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					Ui.focusChange(EnterPassword);
				}
			}
		});
		
		// EnterPassword Events
		EnterPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Ui.toggleTipText(EnterPassword);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Ui.toggleTipText(EnterPassword);
			}
		});
		EnterPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					Ui.focusChange(EnterPassword);
				}
			}
		});
		
		Ui.UiSetup(LoginScreen);
		
		SignUpScreen = new Panel();
		SignUpScreen.setBounds(0, 0, 650, 422);
		LoginScreen.add(SignUpScreen);
		SignUpScreen.setVisible(false);
		SignUpScreen.setLayout(null);
		SignUpScreen.setBackground(Color.PINK);
		
		goToLogin = new JButton();
		goToLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goToLogin.setHorizontalAlignment(SwingConstants.LEFT);
		goToLogin.setText("login");
		goToLogin.setForeground(Color.BLUE);
		goToLogin.setFont(new Font("Verdana", Font.PLAIN, 16));
		goToLogin.setBorderPainted(false);
		goToLogin.setBorder(null);
		goToLogin.setBackground(Color.PINK);
		goToLogin.setAutoscrolls(false);
		goToLogin.setBounds(401, 364, 41, 27);
		SignUpScreen.add(goToLogin);
		
		bankTitle = new JLabel("The Golden Bank of Calgary");
		bankTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		bankTitle.setHorizontalAlignment(SwingConstants.CENTER);
		bankTitle.setForeground(Color.WHITE);
		bankTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		bankTitle.setAlignmentX(0.5f);
		bankTitle.setBounds(136, 11, 383, 75);
		SignUpScreen.add(bankTitle);
		
		SignUpUsername = new JTextField();
		SignUpUsername.setToolTipText("Enter the username to your account");
		SignUpUsername.setText("Enter Username");
		SignUpUsername.setSelectedTextColor(new Color(255, 159, 159));
		SignUpUsername.setForeground(Color.GRAY);
		SignUpUsername.setFont(new Font("Verdana", Font.PLAIN, 16));
		SignUpUsername.setColumns(10);
		SignUpUsername.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SignUpUsername.setBackground(new Color(255, 206, 198));
		SignUpUsername.setBounds(163, 194, 367, 27);
		SignUpScreen.add(SignUpUsername);
		
		SignUpPassword = new JTextField();
		SignUpPassword.setText("Enter Password");
		SignUpPassword.setSelectedTextColor(new Color(255, 159, 159));
		SignUpPassword.setForeground(Color.GRAY);
		SignUpPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		SignUpPassword.setColumns(10);
		SignUpPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SignUpPassword.setBackground(new Color(255, 206, 198));
		SignUpPassword.setBounds(163, 241, 367, 27);
		SignUpScreen.add(SignUpPassword);
		
		HaveAccount = new JLabel();
		HaveAccount.setText("Have an account?");
		HaveAccount.setHorizontalAlignment(SwingConstants.CENTER);
		HaveAccount.setForeground(Color.WHITE);
		HaveAccount.setFont(new Font("Verdana", Font.PLAIN, 16));
		HaveAccount.setBorder(null);
		HaveAccount.setBackground(Color.PINK);
		HaveAccount.setAutoscrolls(false);
		HaveAccount.setBounds(154, 364, 338, 27);
		SignUpScreen.add(HaveAccount);
		
		goToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SignUpScreen.setVisible(false);
				LoginScreen.setVisible(true);
			}
		});
		Ui.focusChange(null);
	}
}
