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

import EasyKit.Text;
import EasyKit.Ui;
import MasteryData.LocalBankGUI_Data;
import MasteryData.LocalBankGUI_Data.NewAccount;

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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

public class LocalBankGUI {

	private JFrame frame;
	private JTextField EnterUsername;
	private JTextField EnterPassword;
	private JLabel SwitchOverToSignUp;
	private JTextField EnterUsername_SignUp;
	private JTextField EnterPassword_SignUp;
	private JTextField ConfirmPassword;
	@SuppressWarnings("unused")
	public static MasteryData.LocalBankGUI_Data.NewAccount currentAccount;

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
		Ui.UiSetup(LoginScreen);
		LoginScreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ui.focusChange(null);
			}
		});
		
		Panel SignUpScreen = new Panel();
		SignUpScreen.setVisible(false);
		SignUpScreen.setLayout(null);
		SignUpScreen.setBackground(Color.PINK);
		SignUpScreen.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(SignUpScreen);
		
		JButton GoToLogin = new JButton();
		GoToLogin.setHorizontalAlignment(SwingConstants.LEFT);
		GoToLogin.setText("login");
		GoToLogin.setForeground(Color.BLUE);
		GoToLogin.setFont(new Font("Verdana", Font.PLAIN, 16));
		GoToLogin.setBorderPainted(false);
		GoToLogin.setBorder(null);
		GoToLogin.setBackground(Color.PINK);
		GoToLogin.setAutoscrolls(false);
		GoToLogin.setBounds(410, 323, 61, 27);
		SignUpScreen.add(GoToLogin);
		
		JLabel BankTitle_SignUp = new JLabel("The Golden Bank of Calgary");
		BankTitle_SignUp.setHorizontalTextPosition(SwingConstants.CENTER);
		BankTitle_SignUp.setHorizontalAlignment(SwingConstants.CENTER);
		BankTitle_SignUp.setForeground(Color.WHITE);
		BankTitle_SignUp.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		BankTitle_SignUp.setAlignmentX(0.5f);
		BankTitle_SignUp.setBounds(136, 11, 383, 75);
		SignUpScreen.add(BankTitle_SignUp);
		
		EnterUsername_SignUp = new JTextField();
		EnterUsername_SignUp.setToolTipText("Enter the username to your account");
		EnterUsername_SignUp.setText("Enter Username");
		EnterUsername_SignUp.setSelectedTextColor(new Color(255, 159, 159));
		EnterUsername_SignUp.setForeground(Color.GRAY);
		EnterUsername_SignUp.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterUsername_SignUp.setColumns(10);
		EnterUsername_SignUp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		EnterUsername_SignUp.setBackground(new Color(255, 206, 198));
		EnterUsername_SignUp.setBounds(162, 150, 367, 27);
		SignUpScreen.add(EnterUsername_SignUp);
		
		Ui.TextFieldSetup(EnterUsername_SignUp, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		EnterPassword_SignUp = new JTextField();
		EnterPassword_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!EnterPassword.getText().equals("") && !EnterPassword.getText().equals(Ui.getTextFieldSettings(EnterPassword))) 
				{
					
				}
			}
		});
		EnterPassword_SignUp.setText("Enter Password");
		EnterPassword_SignUp.setSelectedTextColor(new Color(255, 159, 159));
		EnterPassword_SignUp.setForeground(Color.GRAY);
		EnterPassword_SignUp.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterPassword_SignUp.setColumns(10);
		EnterPassword_SignUp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		EnterPassword_SignUp.setBackground(new Color(255, 206, 198));
		EnterPassword_SignUp.setBounds(162, 201, 367, 27);
		SignUpScreen.add(EnterPassword_SignUp);
		
		Ui.TextFieldSetup(EnterPassword_SignUp, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		JLabel SwitchOverToLogin = new JLabel();
		SwitchOverToLogin.setText("Already have an account?");
		SwitchOverToLogin.setHorizontalAlignment(SwingConstants.CENTER);
		SwitchOverToLogin.setForeground(Color.WHITE);
		SwitchOverToLogin.setFont(new Font("Verdana", Font.PLAIN, 16));
		SwitchOverToLogin.setBorder(null);
		SwitchOverToLogin.setBackground(Color.PINK);
		SwitchOverToLogin.setAutoscrolls(false);
		SwitchOverToLogin.setBounds(131, 323, 332, 27);
		SignUpScreen.add(SwitchOverToLogin);
		
		JButton SignUpButton = new JButton();
		SignUpButton.setText("Sign up");
		SignUpButton.setInheritsPopupMenu(true);
		SignUpButton.setForeground(Color.BLACK);
		SignUpButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		SignUpButton.setBackground(new Color(249, 165, 153));
		SignUpButton.setAutoscrolls(false);
		SignUpButton.setBounds(271, 285, 136, 27);
		SignUpScreen.add(SignUpButton);
		
		ConfirmPassword = new JTextField();
		ConfirmPassword.setText("Confirm Password");
		ConfirmPassword.setSelectedTextColor(new Color(255, 159, 159));
		ConfirmPassword.setForeground(Color.GRAY);
		ConfirmPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		ConfirmPassword.setColumns(10);
		ConfirmPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ConfirmPassword.setBackground(new Color(255, 206, 198));
		ConfirmPassword.setBounds(162, 244, 367, 27);
		
		SignUpScreen.add(ConfirmPassword);
		
		LoginScreen.setBackground(Color.PINK);
		LoginScreen.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(LoginScreen);
		LoginScreen.setLayout(null);
		
		Ui.TextFieldSetup(ConfirmPassword, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		JButton GoToSignUp = new JButton();
		GoToSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GoToSignUp.setBorderPainted(false);
		GoToSignUp.setText("sign up");
		GoToSignUp.setForeground(Color.BLUE);
		GoToSignUp.setFont(new Font("Verdana", Font.PLAIN, 16));
		GoToSignUp.setBorder(null);
		GoToSignUp.setBackground(Color.PINK);
		GoToSignUp.setAutoscrolls(false);
		GoToSignUp.setBounds(409, 323, 61, 27);
		LoginScreen.add(GoToSignUp);
		
		GoToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen.setVisible(true);
				SignUpScreen.setVisible(false);
				Ui.focusChange(null);
			}
		});
		
		GoToSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SignUpScreen.setVisible(true);
				LoginScreen.setVisible(false);
				Ui.focusChange(null);
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
		
		SwitchOverToSignUp = new JLabel();
		SwitchOverToSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		SwitchOverToSignUp.setBorder(null);
		SwitchOverToSignUp.setAutoscrolls(false);
		SwitchOverToSignUp.setText("Don't have an account?");
		SwitchOverToSignUp.setForeground(Color.WHITE);
		SwitchOverToSignUp.setFont(new Font("Verdana", Font.PLAIN, 16));
		SwitchOverToSignUp.setBackground(Color.PINK);
		SwitchOverToSignUp.setBounds(137, 323, 338, 27);
		LoginScreen.add(SwitchOverToSignUp);
		
		JButton LoginButton = new JButton();
		LoginButton.setInheritsPopupMenu(true);
		LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LoginButton.setText("Login");
		LoginButton.setForeground(Color.BLACK);
		LoginButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		LoginButton.setBackground(new Color(249, 165, 153));
		LoginButton.setAutoscrolls(false);
		LoginButton.setBounds(271, 285, 136, 27);
		LoginScreen.add(LoginButton);
		
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
		
		// (SignUp) EnterPassword Events
		EnterPassword_SignUp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Ui.toggleTipText(EnterPassword_SignUp);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Ui.toggleTipText(EnterPassword_SignUp);
			}
		});
		EnterPassword_SignUp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					Ui.focusChange(EnterPassword_SignUp);
				}
			}
		});
		
		// (SignUp) EnterPassword Events
		EnterUsername_SignUp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Ui.toggleTipText(EnterUsername_SignUp);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Ui.toggleTipText(EnterUsername_SignUp);
			}
		});
		EnterUsername_SignUp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					Ui.focusChange(EnterUsername_SignUp);
				}
			}
		});
		
		// (SignUp) EnterPassword Events
		EnterPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Ui.toggleTipText(EnterUsername_SignUp);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Ui.toggleTipText(EnterUsername_SignUp);
			}
		});
		EnterUsername_SignUp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					Ui.focusChange(EnterUsername_SignUp);
				}
			}
		});
		
		// (SignUp) ConfirmPassword Events
		ConfirmPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Ui.toggleTipText(ConfirmPassword);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Ui.toggleTipText(ConfirmPassword);
			}
		});
		ConfirmPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					Ui.focusChange(ConfirmPassword);
				}
			}
		});
		
				
		MasteryData.LocalBankGUI_Data.createAccount("Test", "123");
	}
}
