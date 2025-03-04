package LocalBank_Mastery;

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

import EasyKit.Console;
import EasyKit.Gui_Handler;
import EasyKit.IH;
import EasyKit.OtherSystems;
import EasyKit.Text;
import EasyKit.Ui;
import EasyKit.Gui_Handler.*;
import LocalBank_MasteryData.LocalBankGUI_CurrencyHandler;
import LocalBank_MasteryData.LocalBankGUI_Data;
import LocalBank_MasteryData.LocalBankGUI_PageHandler;
import LocalBank_MasteryData.LocalBankGUI_Data.*;
import TextConfig.*;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
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
import java.awt.Window.Type;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.Window;

import javax.swing.Box;

public class LocalBankGUI {
	
	static  {
		boolean NeedsUserForTransfer = true; // Toggle if the withdrawal will require an actual account to give the money too.
		boolean AllowCurrencySwitching = true; // Toggle if the users are allowed to switch their currency.
	}

	private static JFrame frame;
	
	public static boolean sidebarOpen = false;
	
	public static LocalBank_MasteryData.LocalBankGUI_Data.NewAccount currentAccount;
	
	// Password\Sign up stuff
	private JTextField EnterUsername;
	private JTextField EnterPassword;
	private JLabel SwitchOverToSignUp;
	private JTextField EnterUsername_SignUp;
	private JTextField EnterPassword_SignUp;
	private JTextField ConfirmPassword;
	
	// Deposit Stuff
	private static JTextField Deposit_Amount;
	private static JLabel Withdrawal_CurrentBalance;
	
	private static JLabel Deposit_MoneySignIcon_1;
	private static JTextField Deposit_Giver;
	
	private static JLabel Deposit_CurrentBalance;
	
	private static JPanel Deposit_Trans_1;
	private static JPanel Deposit_Trans_2;
	private static JPanel Deposit_Trans_3;
	
	private static JLabel Deposit_AfterBalance;
	private static JLabel Deposit_AfterBalance_MinusSymbol;
	private static JLabel Deposit_Balance_MinusSymbol;
	private static JButton Deposit_Deposit;
	
	private static JLabel Deposit_Amount_Trans_1;
	private static JLabel Deposit_Amount_Trans_2;
	private static JLabel Deposit_Amount_Trans_3;
	
	private static JLabel Deposit_Amount_SelectedPerson_1;
	private static JLabel Deposit_Amount_SelectedPerson_2;
	private static JLabel Deposit_Amount_SelectedPerson_3;
	
	private static JLabel Deposit_PageCount;
	
	private static JButton Deposit_Amount_Remove_1;
	private static JButton Deposit_Amount_Remove_2;
	private static JButton Deposit_Amount_Remove_3;
	
	private static JButton Deposit_NextPage;
	private static JButton Deposit_PreviousPage;
	
	private static JLabel Deposit_MoneySignIcon_Balance;
	private static JLabel Deposit_MoneySignIcon_AfterBalance;
	
	private static JLabel SideBar_MoneySignIconDeposit_1;
	private static JLabel SideBar_MoneySignIconDeposit_2;
	private static JLabel SideBar_MoneySignIconDeposit_3;
	
	// Withdrawal Stuff
	private static JTextField Withdrawal_Amount;
	private static JTextField Withdrawal_Recever;
	
	private static JButton Withdrawal_Withdrawal;
	
	private static JPanel Withdrawal_Trans_1;
	private static JPanel Withdrawal_Trans_2;
	private static JPanel Withdrawal_Trans_3;
	
	private static JLabel Withdrawal_AfterBalance;
	private static JLabel Withdrawal_AfterBalance_MinusSymbol;
	private static JLabel Withdrawal_Balance_MinusSymbol;
	
	private static JLabel Withdrawal_Amount_Trans_1;
	private static JLabel Withdrawal_Amount_Trans_2;
	private static JLabel Withdrawal_Amount_Trans_3;
	
	private static JLabel Withdrawal_Amount_SelectedPerson_1;
	private static JLabel Withdrawal_Amount_SelectedPerson_2;
	private static JLabel Withdrawal_Amount_SelectedPerson_3;
	
	private static JLabel Withdrawal_PageCount;
	
	private static JButton Withdrawal_Amount_Remove_1;
	private static JButton Withdrawal_Amount_Remove_2;
	private static JButton Withdrawal_Amount_Remove_3;
	
	private static JButton Withdrawal_NextPage;
	private static JButton Withdrawal_PreviousPage;
	
	private static JLabel Withdrawal_MoneySignIcon_Balance;
	private static JLabel Withdrawal_MoneySignIcon_AfterBalance;
	
	private static JLabel SideBar_MoneySignIconWithdrawal_1;
	private static JLabel SideBar_MoneySignIconWithdrawal_2;
	private static JLabel SideBar_MoneySignIconWithdrawal_3;
	
	// AccountView Stuff
	private static JLabel MoneySignIcon_AccountView;
	private static JLabel Balance_AccountView_2;
	
	// Menus
	private static Panel AccountSettings;
	private static Panel SignUpScreen;
	private static Panel LoginScreen;
	private static Panel AccountView;
	private static Panel Withdrawal;
	private static Panel Deposit;
	private static Panel ConfirmTransaction;
	private static Panel ChangeNameScreen;
	
	// AccountSettings Buttons
	private static JButton AccountSettings_Delete;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//LocalBankGUI_Data.createAccount("DummyAccount", "");
		
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
		frame.setType(Type.NORMAL);
		frame.setAutoRequestFocus(false);
		frame.setResizable(false);
		frame.setBounds(100, 100, 666, 556); // SideBar = frame.setBounds(100, 100, 900, 461); | UnSideBar = frame.setBounds(100, 100, 666, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		SignUpScreen = new Panel();
		SignUpScreen.setVisible(false);
		
		Withdrawal = new Panel();
		Withdrawal.setVisible(false);
				
		Deposit = new Panel();
		Deposit.setVisible(false);
		
		Deposit.setBackground(Color.PINK);
		Deposit.setBounds(0, 0, 684, 422); // SideBar = Withdrawal.setBounds(0, 0, 884, 422); | UnSideBar = Withdrawal.setBounds(0, 0, 650, 422);
		Deposit.setLayout(null);
		frame.getContentPane().add(Deposit);
		Deposit_Amount = new JTextField();
		
		// Deposit Amount
		Deposit_Amount.setBounds(154, 234, 342, 27);
		Deposit_Amount.setToolTipText("Amount you wish to Deposit into your account");
		Deposit_Amount.setText("Enter Deposit Amount");
		Deposit_Amount.setSelectedTextColor(new Color(255, 159, 159));
		Deposit_Amount.setForeground(Color.GRAY);
		Deposit_Amount.setFont(new Font("Verdana", Font.PLAIN, 16));
		Deposit_Amount.setColumns(10);
		Deposit_Amount.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		Deposit_Amount.setBackground(new Color(255, 217, 217));
		Deposit.add(Deposit_Amount);
		
		Ui.TextFieldSetup(Deposit_Amount, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		Gui_Handler.TextFieldSetup(Deposit_Amount);
		Gui_Handler.getTextField(Deposit_Amount).addSetting(Gui_Handler.TextFieldSettings.Allow_Enter, true, Deposit_Giver);
		Gui_Handler.getTextField(Deposit_Amount).addSetting(Gui_Handler.TextFieldSettings.Allow_Delete, true, Deposit_Giver);
		
		Input.TextField.EventsSetup(Deposit_Amount);
		
		// Deposit Recever
		Deposit_Giver = new JTextField(); 
		Deposit_Giver.setToolTipText("The Individual/Group the money is coming from");
		Deposit_Giver.setText("Giver");
		Deposit_Giver.setSelectedTextColor(new Color(255, 159, 159));
		Deposit_Giver.setForeground(Color.GRAY);
		Deposit_Giver.setFont(new Font("Verdana", Font.PLAIN, 16));
		Deposit_Giver.setColumns(10); 
		Deposit_Giver.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		Deposit_Giver.setBackground(new Color(255, 217, 217));
		Deposit_Giver.setBounds(154, 302, 342, 27);
		Deposit.add(Deposit_Giver);
		
		Ui.TextFieldSetup(Deposit_Giver, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		// Deposit Text
		JLabel Deposit_Title = new JLabel("Deposit");
		Deposit_Title.setBounds(133, 11, 383, 75);
		Deposit_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Deposit_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Deposit_Title.setForeground(Color.WHITE);
		Deposit_Title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		Deposit_Title.setAlignmentX(0.5f);
		Deposit.add(Deposit_Title);

		Withdrawal.setBackground(Color.PINK);
		Withdrawal.setBounds(0, 0, 684, 422); // SideBar = Withdrawal.setBounds(0, 0, 884, 422); | UnSideBar = Withdrawal.setBounds(0, 0, 650, 422);
		Withdrawal.setLayout(null);
		frame.getContentPane().add(Withdrawal);
		
		Withdrawal_Amount = new JTextField();

		//Withdrawal_Amount.setText(TextConfig.CurrencyFormatter.formatToCurrency(Input.TextField.getFutureText(Withdrawal_Amount, e)));
		Withdrawal_Amount.setBounds(154, 234, 342, 27);
		Withdrawal_Amount.setToolTipText("Amount you wish to Withdrawal from your account");
		Withdrawal_Amount.setText("Enter Withdrawal Amount");
		Withdrawal_Amount.setSelectedTextColor(new Color(255, 159, 159));
		Withdrawal_Amount.setForeground(Color.GRAY);
		Withdrawal_Amount.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_Amount.setColumns(10);
		Withdrawal_Amount.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		Withdrawal_Amount.setBackground(new Color(255, 217, 217));
		Withdrawal.add(Withdrawal_Amount);
		
		Ui.TextFieldSetup(Withdrawal_Amount, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		Gui_Handler.TextFieldSetup(Withdrawal_Amount);
		Gui_Handler.getTextField(Withdrawal_Amount).addSetting(Gui_Handler.TextFieldSettings.Allow_Enter, true, Withdrawal_Recever);
		Gui_Handler.getTextField(Withdrawal_Amount).addSetting(Gui_Handler.TextFieldSettings.Allow_Delete, true, Withdrawal_Recever);
		
		Input.TextField.EventsSetup(Withdrawal_Amount);
		
		// Withdrawal recever
		Withdrawal_Recever = new JTextField(); 
		Withdrawal_Recever.setToolTipText("The Individual/Group the money is going to");
		Withdrawal_Recever.setText("Recever");
		Withdrawal_Recever.setSelectedTextColor(new Color(255, 159, 159));
		Withdrawal_Recever.setForeground(Color.GRAY);
		Withdrawal_Recever.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_Recever.setColumns(10); 
		Withdrawal_Recever.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		Withdrawal_Recever.setBackground(new Color(255, 217, 217));
		Withdrawal_Recever.setBounds(154, 302, 342, 27);
		Withdrawal.add(Withdrawal_Recever);
		
		Ui.TextFieldSetup(Withdrawal_Recever, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		// Withdrawal Title
		JLabel Withdrawal_Title = new JLabel("Withdrawal");
		Withdrawal_Title.setBounds(133, 11, 383, 75);
		Withdrawal_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Withdrawal_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Withdrawal_Title.setForeground(Color.WHITE);
		Withdrawal_Title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		Withdrawal_Title.setAlignmentX(0.5f);
		Withdrawal.add(Withdrawal_Title);
		
		// Withdrawal Withdrawal
		Withdrawal_Withdrawal = new JButton();
		Withdrawal_Withdrawal.setEnabled(false);
		Withdrawal_Withdrawal.setBounds(202, 384, 246, 27);
		Withdrawal_Withdrawal.setText("Withdrawal");
		Withdrawal_Withdrawal.setInheritsPopupMenu(true);
		Withdrawal_Withdrawal.setForeground(Color.BLACK);
		Withdrawal_Withdrawal.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_Withdrawal.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Withdrawal_Withdrawal.setBackground(new Color(255, 206, 206));
		Withdrawal_Withdrawal.setAutoscrolls(false);
		Withdrawal.add(Withdrawal_Withdrawal);
		
		// Deposit Deposit
		Deposit_Deposit = new JButton();
		Deposit_Deposit.setEnabled(false);
		Deposit_Deposit.setBounds(202, 384, 246, 27);
		Deposit_Deposit.setText("Deposit");
		Deposit_Deposit.setInheritsPopupMenu(true);
		Deposit_Deposit.setForeground(Color.BLACK);
		Deposit_Deposit.setFont(new Font("Verdana", Font.PLAIN, 16));
		Deposit_Deposit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Deposit_Deposit.setBackground(new Color(255, 206, 206));
		Deposit_Deposit.setAutoscrolls(false);
		Deposit.add(Deposit_Deposit);
		
		JButton Withdrawal_Half = new JButton();
		Withdrawal_Half.setBounds(290, 265, 70, 27);
		Withdrawal_Half.setText("Half");
		Withdrawal_Half.setInheritsPopupMenu(true);
		Withdrawal_Half.setForeground(Color.BLACK);
		Withdrawal_Half.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_Half.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Withdrawal_Half.setBackground(new Color(255, 206, 206));
		Withdrawal_Half.setAutoscrolls(false);
		Withdrawal.add(Withdrawal_Half);
		
		// Deposit CertainAmount
		JButton Deposit_Half = new JButton();
		Deposit_Half.setBounds(290, 265, 70, 27);
		Deposit_Half.setText("Half");
		Deposit_Half.setInheritsPopupMenu(true);
		Deposit_Half.setForeground(Color.BLACK);
		Deposit_Half.setFont(new Font("Verdana", Font.PLAIN, 16));
		Deposit_Half.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Deposit_Half.setBackground(new Color(255, 206, 206));
		Deposit_Half.setAutoscrolls(false);
		Deposit.add(Deposit_Half);
		
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 	Work on making the Transfer and Deposit Panels
		 * 		+ Add the ability to add friends
		 * 		- Add the ability to remove friends
		 * 		+ Make it so money can transfer between friends
		 * 		+ Make it so the Transactions can be viewed in the Transactions tab, and make it so it can sort by date, person, and amount. with some sub options for each
		 * 		- Remove the cash ($) sign from the sidebar amount labels
		 * 		+ Add the ability to see how many pages of the sidebar are available
		 * 		
		 * 
		 *  For Transactions it should have:
		 *  	> The ability to go through pages
		 *  	> The ability to see how many pages
		 *  	> The ability to sort it by many types (Amount, Time, Person)
		 *  	> The ability to hide or trash transactions
		 *  
		 *  More Features:
		 *  	+ Add the ability to lock accounts from getting money and be able to suspend accounts
		 *  	+ Allow for account deletion in the account settings
		 *  	+ Allow the current currency to change and for symbols and the amount to change as-well (1/2 complete)
		 *  	+ Add the ability to freeze money well in transfer
		 * 		+ Add a realistic time scale for a slight delay before money gets processed
		 * 		+ Add a menu to view pending cash and from who and what time it was sent
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		JPanel BalanceHolder_Withdrawal = new JPanel();
		BalanceHolder_Withdrawal.setBounds(154, 82, 342, 119);
		BalanceHolder_Withdrawal.setLayout(null);
		BalanceHolder_Withdrawal.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 206, 206), null));
		Withdrawal.add(BalanceHolder_Withdrawal);
		
		JLabel Withdrawal_Balance_Title = new JLabel("My Balance:");
		Withdrawal_Balance_Title.setFont(new Font("Verdana", Font.BOLD, 14));
		Withdrawal_Balance_Title.setBounds(10, 11, 119, 18);
		BalanceHolder_Withdrawal.add(Withdrawal_Balance_Title);

		Withdrawal_MoneySignIcon_Balance = new JLabel("$");
		Withdrawal_MoneySignIcon_Balance.setForeground(new Color(236, 119, 98));
		Withdrawal_MoneySignIcon_Balance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		Withdrawal_MoneySignIcon_Balance.setBounds(28, 37, 15, 18);
		BalanceHolder_Withdrawal.add(Withdrawal_MoneySignIcon_Balance);
		
		Withdrawal_CurrentBalance = new JLabel("0.00");
		Withdrawal_CurrentBalance.setForeground(new Color(233, 98, 73));
		Withdrawal_CurrentBalance.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Withdrawal_CurrentBalance.setBounds(36, 35, 285, 29);
		BalanceHolder_Withdrawal.add(Withdrawal_CurrentBalance);
		
		Withdrawal_AfterBalance = new JLabel("0.00");
		Withdrawal_AfterBalance.setForeground(new Color(233, 98, 73));
		Withdrawal_AfterBalance.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Withdrawal_AfterBalance.setBounds(36, 83, 285, 29);
		BalanceHolder_Withdrawal.add(Withdrawal_AfterBalance);
		
		Withdrawal_MoneySignIcon_AfterBalance = new JLabel("$");
		Withdrawal_MoneySignIcon_AfterBalance.setForeground(new Color(236, 119, 98));
		Withdrawal_MoneySignIcon_AfterBalance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		Withdrawal_MoneySignIcon_AfterBalance.setBounds(28, 85, 15, 18);
		BalanceHolder_Withdrawal.add(Withdrawal_MoneySignIcon_AfterBalance);
		
		JLabel Withdrawal_AfterBalance_Title = new JLabel("After Balance:");
		Withdrawal_AfterBalance_Title.setFont(new Font("Verdana", Font.BOLD, 14));
		Withdrawal_AfterBalance_Title.setBounds(10, 64, 119, 18);
		BalanceHolder_Withdrawal.add(Withdrawal_AfterBalance_Title);
		
		Withdrawal_AfterBalance_MinusSymbol = new JLabel("-");
		Withdrawal_AfterBalance_MinusSymbol.setForeground(new Color(233, 98, 73));
		Withdrawal_AfterBalance_MinusSymbol.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		Withdrawal_AfterBalance_MinusSymbol.setBounds(15, 83, 15, 29);
		BalanceHolder_Withdrawal.add(Withdrawal_AfterBalance_MinusSymbol);
		
		Withdrawal_Balance_MinusSymbol = new JLabel("-");
		Withdrawal_Balance_MinusSymbol.setForeground(new Color(233, 98, 73));
		Withdrawal_Balance_MinusSymbol.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		Withdrawal_Balance_MinusSymbol.setBounds(15, 35, 15, 29);
		BalanceHolder_Withdrawal.add(Withdrawal_Balance_MinusSymbol);
		
		// Deposit
		
		JPanel BalanceHolder_Deposit = new JPanel();
		BalanceHolder_Deposit.setBounds(154, 82, 342, 119);
		BalanceHolder_Deposit.setLayout(null);
		BalanceHolder_Deposit.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 206, 206), null));
		Deposit.add(BalanceHolder_Deposit);
		
		JLabel Deposit_Balance_Title = new JLabel("My Balance:");
		Deposit_Balance_Title.setFont(new Font("Verdana", Font.BOLD, 14));
		Deposit_Balance_Title.setBounds(10, 11, 119, 18);
		BalanceHolder_Deposit.add(Deposit_Balance_Title);

		Deposit_MoneySignIcon_Balance = new JLabel("$");
		Deposit_MoneySignIcon_Balance.setForeground(new Color(236, 119, 98));
		Deposit_MoneySignIcon_Balance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		Deposit_MoneySignIcon_Balance.setBounds(28, 37, 15, 18);
		BalanceHolder_Deposit.add(Deposit_MoneySignIcon_Balance);
		
		Deposit_CurrentBalance = new JLabel("0.00");
		Deposit_CurrentBalance.setForeground(new Color(233, 98, 73));
		Deposit_CurrentBalance.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Deposit_CurrentBalance.setBounds(36, 35, 285, 29);
		BalanceHolder_Deposit.add(Deposit_CurrentBalance);
		
		Deposit_AfterBalance = new JLabel("0.00");
		Deposit_AfterBalance.setForeground(new Color(233, 98, 73));
		Deposit_AfterBalance.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Deposit_AfterBalance.setBounds(36, 83, 285, 29);
		BalanceHolder_Deposit.add(Deposit_AfterBalance);
		
		Deposit_MoneySignIcon_AfterBalance = new JLabel("$");
		Deposit_MoneySignIcon_AfterBalance.setForeground(new Color(236, 119, 98));
		Deposit_MoneySignIcon_AfterBalance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		Deposit_MoneySignIcon_AfterBalance.setBounds(28, 85, 15, 18);
		BalanceHolder_Deposit.add(Deposit_MoneySignIcon_AfterBalance);
		
		JLabel Deposit_AfterBalance_Title = new JLabel("After Balance:");
		Deposit_AfterBalance_Title.setFont(new Font("Verdana", Font.BOLD, 14));
		Deposit_AfterBalance_Title.setBounds(10, 64, 119, 18);
		BalanceHolder_Deposit.add(Deposit_AfterBalance_Title);
		
		Deposit_AfterBalance_MinusSymbol = new JLabel("-");
		Deposit_AfterBalance_MinusSymbol.setVisible(false);
		Deposit_AfterBalance_MinusSymbol.setForeground(new Color(233, 98, 73));
		Deposit_AfterBalance_MinusSymbol.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		Deposit_AfterBalance_MinusSymbol.setBounds(15, 83, 15, 29);
		BalanceHolder_Deposit.add(Deposit_AfterBalance_MinusSymbol);
		
		Deposit_Balance_MinusSymbol = new JLabel("-");
		Deposit_Balance_MinusSymbol.setVisible(false);
		Deposit_Balance_MinusSymbol.setForeground(new Color(233, 98, 73));
		Deposit_Balance_MinusSymbol.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		Deposit_Balance_MinusSymbol.setBounds(15, 35, 15, 29);
		BalanceHolder_Deposit.add(Deposit_Balance_MinusSymbol);
		
		// Withdrawal
		
		JButton Withdrawal_All = new JButton();
		
		Withdrawal_All.setBounds(154, 265, 70, 27);
		Withdrawal_All.setText("All");
		Withdrawal_All.setInheritsPopupMenu(true);
		Withdrawal_All.setForeground(Color.BLACK);
		Withdrawal_All.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_All.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Withdrawal_All.setBackground(new Color(255, 206, 206));
		Withdrawal_All.setAutoscrolls(false);
		Withdrawal.add(Withdrawal_All);
		
		// Deposit
		
		JButton Deposit_All = new JButton();
		
		Deposit_All.setBounds(154, 265, 70, 27);
		Deposit_All.setText("All");
		Deposit_All.setInheritsPopupMenu(true);
		Deposit_All.setForeground(Color.BLACK);
		Deposit_All.setFont(new Font("Verdana", Font.PLAIN, 16));
		Deposit_All.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Deposit_All.setBackground(new Color(255, 206, 206));
		Deposit_All.setAutoscrolls(false);
		Deposit.add(Deposit_All);
		
		// Withdrawal
		
		JButton Withdrawal_None = new JButton();
		
		Withdrawal_None.setBounds(426, 265, 70, 27);
		Withdrawal_None.setText("None");
		Withdrawal_None.setInheritsPopupMenu(true);
		Withdrawal_None.setForeground(Color.BLACK);
		Withdrawal_None.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_None.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Withdrawal_None.setBackground(new Color(255, 206, 206));
		Withdrawal_None.setAutoscrolls(false);
		Withdrawal.add(Withdrawal_None);
		
		// Deposit
		
		JButton Deposit_None = new JButton();
		
		Deposit_None.setBounds(426, 265, 70, 27);
		Deposit_None.setText("None");
		Deposit_None.setInheritsPopupMenu(true);
		Deposit_None.setForeground(Color.BLACK);
		Deposit_None.setFont(new Font("Verdana", Font.PLAIN, 16));
		Deposit_None.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Deposit_None.setBackground(new Color(255, 206, 206));
		Deposit_None.setAutoscrolls(false);
		Deposit.add(Deposit_None);
		
		// Withdrawal
		
		JButton Withdrawal_SubmitAmount = new JButton();
		Withdrawal_SubmitAmount.setBounds(500, 234, 70, 27);
		
		Withdrawal_SubmitAmount.setText("Submit");
		Withdrawal_SubmitAmount.setInheritsPopupMenu(true);
		Withdrawal_SubmitAmount.setForeground(Color.BLACK);
		Withdrawal_SubmitAmount.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_SubmitAmount.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Withdrawal_SubmitAmount.setBackground(new Color(255, 206, 206));
		Withdrawal_SubmitAmount.setAutoscrolls(false);
		Withdrawal.add(Withdrawal_SubmitAmount);
		
		// Deposit
		
		JButton Deposit_SubmitAmount = new JButton();
		Deposit_SubmitAmount.setBounds(500, 234, 70, 27);
		
		Deposit_SubmitAmount.setText("Submit");
		Deposit_SubmitAmount.setInheritsPopupMenu(true);
		Deposit_SubmitAmount.setForeground(Color.BLACK);
		Deposit_SubmitAmount.setFont(new Font("Verdana", Font.PLAIN, 16));
		Deposit_SubmitAmount.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Deposit_SubmitAmount.setBackground(new Color(255, 206, 206));
		Deposit_SubmitAmount.setAutoscrolls(false);
		Deposit.add(Deposit_SubmitAmount);
		
		// Withdrawal
		
		JPanel SideBar = new JPanel();
		SideBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		SideBar.setBounds(648, 0, 236, 422);
		SideBar.setBackground(new Color(255, 217, 217));
		SideBar.setForeground(new Color(252, 122, 122));
		Withdrawal.add(SideBar);
		
		Withdrawal_Trans_1 = new JPanel();
		Withdrawal_Trans_1.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		Withdrawal_Trans_1.setLayout(null);
		
		SideBar_MoneySignIconWithdrawal_1 = new JLabel("$");
		SideBar_MoneySignIconWithdrawal_1.setForeground(new Color(236, 119, 98));
		SideBar_MoneySignIconWithdrawal_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		SideBar_MoneySignIconWithdrawal_1.setBounds(15, 19, 15, 18);
		Withdrawal_Trans_1.add(SideBar_MoneySignIconWithdrawal_1);
		
		Withdrawal_Amount_Trans_1 = new JLabel("0.00");
		Withdrawal_Amount_Trans_1.setForeground(new Color(233, 98, 73));
		Withdrawal_Amount_Trans_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Withdrawal_Amount_Trans_1.setBounds(20, 25, 196, 29);
		Withdrawal_Trans_1.add(Withdrawal_Amount_Trans_1);

		JLabel MinusSymbol = new JLabel("-");
		MinusSymbol.setForeground(new Color(236, 119, 98));
		MinusSymbol.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol.setBounds(4, 32, 15, 18);
		Withdrawal_Trans_1.add(MinusSymbol);

		JPanel Bar = new JPanel();
		Bar.setBackground(new Color(255, 217, 217));
		Bar.setBounds(0, 57, 216, 7);
		Withdrawal_Trans_1.add(Bar);
		
		Withdrawal_Amount_SelectedPerson_1 = new JLabel("For: ???");
		Withdrawal_Amount_SelectedPerson_1.setForeground(new Color(233, 98, 73));
		Withdrawal_Amount_SelectedPerson_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		Withdrawal_Amount_SelectedPerson_1.setBounds(4, 66, 208, 29);
		Withdrawal_Trans_1.add(Withdrawal_Amount_SelectedPerson_1);

		Withdrawal_Amount_Remove_1 = new JButton();
		Withdrawal_Amount_Remove_1.setText("x");
		Withdrawal_Amount_Remove_1.setInheritsPopupMenu(true);
		Withdrawal_Amount_Remove_1.setForeground(Color.RED);
		Withdrawal_Amount_Remove_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Withdrawal_Amount_Remove_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Withdrawal_Amount_Remove_1.setBackground(new Color(255, 217, 217));
		Withdrawal_Amount_Remove_1.setAutoscrolls(false);
		Withdrawal_Amount_Remove_1.setBounds(186, 3, 26, 26);
		Withdrawal_Trans_1.add(Withdrawal_Amount_Remove_1);
		
		Withdrawal_Trans_2 = new JPanel();
		Withdrawal_Trans_2.setVisible(false);
		Withdrawal_Trans_2.setLayout(null);
		Withdrawal_Trans_2.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		
		SideBar_MoneySignIconWithdrawal_2 = new JLabel("$");
		SideBar_MoneySignIconWithdrawal_2.setForeground(new Color(236, 119, 98));
		SideBar_MoneySignIconWithdrawal_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		SideBar_MoneySignIconWithdrawal_2.setBounds(15, 19, 15, 18);
		Withdrawal_Trans_2.add(SideBar_MoneySignIconWithdrawal_2);
		
		Withdrawal_Amount_Trans_2 = new JLabel("0.00");
		Withdrawal_Amount_Trans_2.setForeground(new Color(233, 98, 73));
		Withdrawal_Amount_Trans_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Withdrawal_Amount_Trans_2.setBounds(20, 25, 196, 29);
		Withdrawal_Trans_2.add(Withdrawal_Amount_Trans_2);
		
		JLabel MinusSymbol_1 = new JLabel("-");
		MinusSymbol_1.setForeground(new Color(236, 119, 98));
		MinusSymbol_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol_1.setBounds(4, 32, 15, 18);
		Withdrawal_Trans_2.add(MinusSymbol_1);
		
		JPanel Bar_1 = new JPanel();
		Bar_1.setBackground(new Color(255, 217, 217));
		Bar_1.setBounds(0, 57, 216, 7);
		Withdrawal_Trans_2.add(Bar_1);
		
		Withdrawal_Amount_SelectedPerson_2 = new JLabel("For: ???");
		Withdrawal_Amount_SelectedPerson_2.setForeground(new Color(233, 98, 73));
		Withdrawal_Amount_SelectedPerson_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		Withdrawal_Amount_SelectedPerson_2.setBounds(4, 66, 208, 29);
		Withdrawal_Trans_2.add(Withdrawal_Amount_SelectedPerson_2);
		
		Withdrawal_Amount_Remove_2 = new JButton();
		Withdrawal_Amount_Remove_2.setText("x");
		Withdrawal_Amount_Remove_2.setInheritsPopupMenu(true);
		Withdrawal_Amount_Remove_2.setForeground(Color.RED);
		Withdrawal_Amount_Remove_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Withdrawal_Amount_Remove_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Withdrawal_Amount_Remove_2.setBackground(new Color(255, 217, 217));
		Withdrawal_Amount_Remove_2.setAutoscrolls(false);
		Withdrawal_Amount_Remove_2.setBounds(186, 3, 26, 26);
		Withdrawal_Trans_2.add(Withdrawal_Amount_Remove_2);
		
		Withdrawal_Trans_3 = new JPanel();
		Withdrawal_Trans_3.setVisible(false);
		Withdrawal_Trans_3.setLayout(null);
		Withdrawal_Trans_3.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		
		SideBar_MoneySignIconWithdrawal_3 = new JLabel("$");
		SideBar_MoneySignIconWithdrawal_3.setForeground(new Color(236, 119, 98));
		SideBar_MoneySignIconWithdrawal_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		SideBar_MoneySignIconWithdrawal_3.setBounds(15, 19, 15, 18);
		Withdrawal_Trans_3.add(SideBar_MoneySignIconWithdrawal_3);
		
		Withdrawal_Amount_Trans_3 = new JLabel("0.00");
		Withdrawal_Amount_Trans_3.setForeground(new Color(233, 98, 73));
		Withdrawal_Amount_Trans_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Withdrawal_Amount_Trans_3.setBounds(20, 25, 196, 29);
		Withdrawal_Trans_3.add(Withdrawal_Amount_Trans_3);
		
		JLabel MinusSymbol_1_1 = new JLabel("-");
		MinusSymbol_1_1.setForeground(new Color(236, 119, 98));
		MinusSymbol_1_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol_1_1.setBounds(4, 32, 15, 18);
		Withdrawal_Trans_3.add(MinusSymbol_1_1);
		
		JPanel Bar_1_1 = new JPanel();
		Bar_1_1.setBackground(new Color(255, 217, 217));
		Bar_1_1.setBounds(0, 57, 216, 7);
		Withdrawal_Trans_3.add(Bar_1_1);
		
		Withdrawal_Amount_SelectedPerson_3 = new JLabel("For: Joe");
		Withdrawal_Amount_SelectedPerson_3.setForeground(new Color(233, 98, 73));
		Withdrawal_Amount_SelectedPerson_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		Withdrawal_Amount_SelectedPerson_3.setBounds(4, 66, 208, 29);
		Withdrawal_Trans_3.add(Withdrawal_Amount_SelectedPerson_3);
		
		Withdrawal_Amount_Remove_3 = new JButton();
		Withdrawal_Amount_Remove_3.setText("x");
		Withdrawal_Amount_Remove_3.setInheritsPopupMenu(true);
		Withdrawal_Amount_Remove_3.setForeground(Color.RED);
		Withdrawal_Amount_Remove_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Withdrawal_Amount_Remove_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Withdrawal_Amount_Remove_3.setBackground(new Color(255, 217, 217));
		Withdrawal_Amount_Remove_3.setAutoscrolls(false);
		Withdrawal_Amount_Remove_3.setBounds(186, 3, 26, 26);
		Withdrawal_Trans_3.add(Withdrawal_Amount_Remove_3);
		
		JPanel panel = new JPanel();
		
		JLabel lblChanges = new JLabel("Changes");
		lblChanges.setHorizontalAlignment(SwingConstants.CENTER);
		lblChanges.setForeground(new Color(202, 119, 119));
		lblChanges.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		GroupLayout gl_SideBar = new GroupLayout(SideBar);
		gl_SideBar.setHonorsVisibility(false);
		gl_SideBar.setHorizontalGroup(
			gl_SideBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SideBar.createSequentialGroup()
					.addGroup(gl_SideBar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SideBar.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_SideBar.createParallelGroup(Alignment.TRAILING)
								.addComponent(Withdrawal_Trans_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(Withdrawal_Trans_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(Withdrawal_Trans_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_SideBar.createSequentialGroup()
							.addGap(8)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_SideBar.createSequentialGroup()
							.addGap(8)
							.addComponent(lblChanges, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_SideBar.setVerticalGroup(
			gl_SideBar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_SideBar.createSequentialGroup()
					.addGap(6)
					.addComponent(lblChanges, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(Withdrawal_Trans_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Withdrawal_Trans_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Withdrawal_Trans_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		Withdrawal_NextPage = new JButton();
		Withdrawal_NextPage.setBounds(0, 0, 51, 36);
		Withdrawal_NextPage.setText("←");
		Withdrawal_NextPage.setInheritsPopupMenu(true);
		Withdrawal_NextPage.setForeground(Color.RED);
		Withdrawal_NextPage.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		Withdrawal_NextPage.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(253, 232, 232), new Color(253, 234, 234), new Color(252, 216, 216), new Color(251, 202, 202)));
		Withdrawal_NextPage.setBackground(new Color(253, 234, 234));
		Withdrawal_NextPage.setAutoscrolls(false);
		panel.add(Withdrawal_NextPage);
		
		Withdrawal_PreviousPage = new JButton();
		Withdrawal_PreviousPage.setText("→");
		Withdrawal_PreviousPage.setInheritsPopupMenu(true);
		Withdrawal_PreviousPage.setForeground(Color.RED);
		Withdrawal_PreviousPage.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		Withdrawal_PreviousPage.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(253, 232, 232), new Color(253, 234, 234), new Color(252, 216, 216), new Color(251, 202, 202)));
		Withdrawal_PreviousPage.setBackground(new Color(253, 234, 234));
		Withdrawal_PreviousPage.setAutoscrolls(false);
		Withdrawal_PreviousPage.setBounds(169, 0, 51, 36);
		panel.add(Withdrawal_PreviousPage);
		
		Withdrawal_PageCount = new JLabel("Page: 1");
		Withdrawal_PageCount.setHorizontalAlignment(SwingConstants.CENTER);
		Withdrawal_PageCount.setForeground(new Color(233, 98, 73));
		Withdrawal_PageCount.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		Withdrawal_PageCount.setBounds(0, 1, 220, 32);
		panel.add(Withdrawal_PageCount);
		SideBar.setLayout(gl_SideBar);
		
		// Deposit
		
		JPanel SideBar_Deposit = new JPanel();
		SideBar_Deposit.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		SideBar_Deposit.setBounds(648, 0, 236, 422);
		SideBar_Deposit.setBackground(new Color(255, 217, 217));
		SideBar_Deposit.setForeground(new Color(252, 122, 122));
		Deposit.add(SideBar_Deposit);
		
		Deposit_Trans_1 = new JPanel();
		Deposit_Trans_1.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		Deposit_Trans_1.setLayout(null);
		
		SideBar_MoneySignIconDeposit_1 = new JLabel("$");
		SideBar_MoneySignIconDeposit_1.setForeground(new Color(236, 119, 98));
		SideBar_MoneySignIconDeposit_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		SideBar_MoneySignIconDeposit_1.setBounds(15, 19, 15, 18);
		Deposit_Trans_1.add(SideBar_MoneySignIconDeposit_1);
		
		Deposit_Amount_Trans_1 = new JLabel("0.00");
		Deposit_Amount_Trans_1.setForeground(new Color(233, 98, 73));
		Deposit_Amount_Trans_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Deposit_Amount_Trans_1.setBounds(20, 25, 196, 29);
		Deposit_Trans_1.add(Deposit_Amount_Trans_1);

		JLabel MinusSymbol_Deposit = new JLabel("-");
		MinusSymbol_Deposit.setForeground(new Color(236, 119, 98));
		MinusSymbol_Deposit.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol_Deposit.setBounds(4, 32, 15, 18);
		Deposit_Trans_1.add(MinusSymbol_Deposit);

		JPanel Bar_Deposit = new JPanel();
		Bar_Deposit.setBackground(new Color(255, 217, 217));
		Bar_Deposit.setBounds(0, 57, 216, 7);
		Deposit_Trans_1.add(Bar_Deposit);
		
		Deposit_Amount_SelectedPerson_1 = new JLabel("For: ???");
		Deposit_Amount_SelectedPerson_1.setForeground(new Color(233, 98, 73));
		Deposit_Amount_SelectedPerson_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		Deposit_Amount_SelectedPerson_1.setBounds(4, 66, 208, 29);
		Deposit_Trans_1.add(Deposit_Amount_SelectedPerson_1);

		Deposit_Amount_Remove_1 = new JButton();
		Deposit_Amount_Remove_1.setText("x");
		Deposit_Amount_Remove_1.setInheritsPopupMenu(true);
		Deposit_Amount_Remove_1.setForeground(Color.RED);
		Deposit_Amount_Remove_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Deposit_Amount_Remove_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Deposit_Amount_Remove_1.setBackground(new Color(255, 217, 217));
		Deposit_Amount_Remove_1.setAutoscrolls(false);
		Deposit_Amount_Remove_1.setBounds(186, 3, 26, 26);
		Deposit_Trans_1.add(Deposit_Amount_Remove_1);
		
		Deposit_Trans_2 = new JPanel();
		Deposit_Trans_2.setVisible(false);
		Deposit_Trans_2.setLayout(null);
		Deposit_Trans_2.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		
		SideBar_MoneySignIconDeposit_2 = new JLabel("$");
		SideBar_MoneySignIconDeposit_2.setForeground(new Color(236, 119, 98));
		SideBar_MoneySignIconDeposit_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		SideBar_MoneySignIconDeposit_2.setBounds(15, 19, 15, 18);
		Deposit_Trans_2.add(SideBar_MoneySignIconDeposit_2);
		
		Deposit_Amount_Trans_2 = new JLabel("0.00");
		Deposit_Amount_Trans_2.setForeground(new Color(233, 98, 73));
		Deposit_Amount_Trans_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Deposit_Amount_Trans_2.setBounds(20, 25, 196, 29);
		Deposit_Trans_2.add(Deposit_Amount_Trans_2);
		
		JLabel MinusSymbol_Deposit_2 = new JLabel("-");
		MinusSymbol_Deposit_2.setForeground(new Color(236, 119, 98));
		MinusSymbol_Deposit_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol_Deposit_2.setBounds(4, 32, 15, 18);
		Deposit_Trans_2.add(MinusSymbol_Deposit_2);
		
		JPanel Bar_Deposit_2 = new JPanel();
		Bar_Deposit_2.setBackground(new Color(255, 217, 217));
		Bar_Deposit_2.setBounds(0, 57, 216, 7);
		Deposit_Trans_2.add(Bar_Deposit_2);
		
		Deposit_Amount_SelectedPerson_2 = new JLabel("For: ???");
		Deposit_Amount_SelectedPerson_2.setForeground(new Color(233, 98, 73));
		Deposit_Amount_SelectedPerson_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		Deposit_Amount_SelectedPerson_2.setBounds(4, 66, 208, 29);
		Deposit_Trans_2.add(Deposit_Amount_SelectedPerson_2);
		
		Deposit_Amount_Remove_2 = new JButton();
		Deposit_Amount_Remove_2.setText("x");
		Deposit_Amount_Remove_2.setInheritsPopupMenu(true);
		Deposit_Amount_Remove_2.setForeground(Color.RED);
		Deposit_Amount_Remove_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Deposit_Amount_Remove_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Deposit_Amount_Remove_2.setBackground(new Color(255, 217, 217));
		Deposit_Amount_Remove_2.setAutoscrolls(false);
		Deposit_Amount_Remove_2.setBounds(186, 3, 26, 26);
		Deposit_Trans_2.add(Deposit_Amount_Remove_2);
		
		Deposit_Trans_3 = new JPanel();
		Deposit_Trans_3.setVisible(false);
		Deposit_Trans_3.setLayout(null);
		Deposit_Trans_3.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		
		SideBar_MoneySignIconDeposit_3 = new JLabel("$");
		SideBar_MoneySignIconDeposit_3.setForeground(new Color(236, 119, 98));
		SideBar_MoneySignIconDeposit_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		SideBar_MoneySignIconDeposit_3.setBounds(15, 19, 15, 18);
		Deposit_Trans_3.add(SideBar_MoneySignIconDeposit_3);
		
		Deposit_Amount_Trans_3 = new JLabel("0.00");
		Deposit_Amount_Trans_3.setForeground(new Color(233, 98, 73));
		Deposit_Amount_Trans_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Deposit_Amount_Trans_3.setBounds(20, 25, 196, 29);
		Deposit_Trans_3.add(Deposit_Amount_Trans_3);
		
		JLabel MinusSymbol_Deposit_3 = new JLabel("-");
		MinusSymbol_Deposit_3.setForeground(new Color(236, 119, 98));
		MinusSymbol_Deposit_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol_Deposit_3.setBounds(4, 32, 15, 18);
		Deposit_Trans_3.add(MinusSymbol_Deposit_3);
		
		JPanel Bar_Deposit_3 = new JPanel();
		Bar_Deposit_3.setBackground(new Color(255, 217, 217));
		Bar_Deposit_3.setBounds(0, 57, 216, 7);
		Deposit_Trans_3.add(Bar_Deposit_3);
		
		Deposit_Amount_SelectedPerson_3 = new JLabel("For: Joe");
		Deposit_Amount_SelectedPerson_3.setForeground(new Color(233, 98, 73));
		Deposit_Amount_SelectedPerson_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		Deposit_Amount_SelectedPerson_3.setBounds(4, 66, 208, 29);
		Deposit_Trans_3.add(Deposit_Amount_SelectedPerson_3);
		
		Deposit_Amount_Remove_3 = new JButton();
		Deposit_Amount_Remove_3.setText("x");
		Deposit_Amount_Remove_3.setInheritsPopupMenu(true);
		Deposit_Amount_Remove_3.setForeground(Color.RED);
		Deposit_Amount_Remove_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Deposit_Amount_Remove_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Deposit_Amount_Remove_3.setBackground(new Color(255, 217, 217));
		Deposit_Amount_Remove_3.setAutoscrolls(false);
		Deposit_Amount_Remove_3.setBounds(186, 3, 26, 26);
		Deposit_Trans_3.add(Deposit_Amount_Remove_3);
		
		JPanel panel_Deposit = new JPanel();
		
		JLabel lblChanges_Deposit = new JLabel("Changes");
		lblChanges_Deposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblChanges_Deposit.setForeground(new Color(202, 119, 119));
		lblChanges_Deposit.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		GroupLayout gl_SideBar_Deposit = new GroupLayout(SideBar_Deposit);
		gl_SideBar_Deposit.setHonorsVisibility(false);
		gl_SideBar_Deposit.setHorizontalGroup(
				gl_SideBar_Deposit.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SideBar_Deposit.createSequentialGroup()
					.addGroup(gl_SideBar_Deposit.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SideBar_Deposit.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_SideBar_Deposit.createParallelGroup(Alignment.TRAILING)
								.addComponent(Withdrawal_Trans_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(Withdrawal_Trans_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(Withdrawal_Trans_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_SideBar_Deposit.createSequentialGroup()
							.addGap(8)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_SideBar_Deposit.createSequentialGroup()
							.addGap(8)
							.addComponent(lblChanges_Deposit, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_SideBar_Deposit.setVerticalGroup(
				gl_SideBar_Deposit.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_SideBar_Deposit.createSequentialGroup()
					.addGap(6)
					.addComponent(lblChanges_Deposit, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(Withdrawal_Trans_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Withdrawal_Trans_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Withdrawal_Trans_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_Deposit.setLayout(null);
		
		Deposit_NextPage = new JButton();
		Deposit_NextPage.setBounds(0, 0, 51, 36);
		Deposit_NextPage.setText("←");
		Deposit_NextPage.setInheritsPopupMenu(true);
		Deposit_NextPage.setForeground(Color.RED);
		Deposit_NextPage.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		Deposit_NextPage.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(253, 232, 232), new Color(253, 234, 234), new Color(252, 216, 216), new Color(251, 202, 202)));
		Deposit_NextPage.setBackground(new Color(253, 234, 234));
		Deposit_NextPage.setAutoscrolls(false);
		panel_Deposit.add(Deposit_NextPage);
		
		Deposit_PreviousPage = new JButton();
		Deposit_PreviousPage.setText("→");
		Deposit_PreviousPage.setInheritsPopupMenu(true);
		Deposit_PreviousPage.setForeground(Color.RED);
		Deposit_PreviousPage.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		Deposit_PreviousPage.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(253, 232, 232), new Color(253, 234, 234), new Color(252, 216, 216), new Color(251, 202, 202)));
		Deposit_PreviousPage.setBackground(new Color(253, 234, 234));
		Deposit_PreviousPage.setAutoscrolls(false);
		Deposit_PreviousPage.setBounds(169, 0, 51, 36);
		panel_Deposit.add(Deposit_PreviousPage);
		
		Deposit_PageCount = new JLabel("Page: 1");
		Deposit_PageCount.setHorizontalAlignment(SwingConstants.CENTER);
		Deposit_PageCount.setForeground(new Color(233, 98, 73));
		Deposit_PageCount.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		Deposit_PageCount.setBounds(0, 1, 220, 32);
		panel_Deposit.add(Deposit_PageCount);
		SideBar_Deposit.setLayout(gl_SideBar_Deposit);
		
		// Withdrawal
		
		JButton Withdrawal_Exit = new JButton();
		Withdrawal_Exit.setText("x");
		Withdrawal_Exit.setInheritsPopupMenu(true);
		Withdrawal_Exit.setForeground(Color.BLACK);
		Withdrawal_Exit.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_Exit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Withdrawal_Exit.setBackground(new Color(255, 206, 206));
		Withdrawal_Exit.setAutoscrolls(false);
		Withdrawal_Exit.setBounds(10, 11, 27, 27);
		Withdrawal.add(Withdrawal_Exit);
		
		// Deposit
		
		JButton Deposit_Exit = new JButton();
		Deposit_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		
		Deposit_Exit.setText("x");
		Deposit_Exit.setInheritsPopupMenu(true);
		Deposit_Exit.setForeground(Color.BLACK);
		Deposit_Exit.setFont(new Font("Verdana", Font.PLAIN, 16));
		Deposit_Exit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Deposit_Exit.setBackground(new Color(255, 206, 206));
		Deposit_Exit.setAutoscrolls(false);
		Deposit_Exit.setBounds(10, 11, 27, 27);
		Deposit.add(Deposit_Exit);
		
		// Confirm Transaction
		ConfirmTransaction = new Panel();
		ConfirmTransaction.setLayout(null);
		ConfirmTransaction.setBackground(Color.PINK);
		ConfirmTransaction.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(ConfirmTransaction);
		ConfirmTransaction.setVisible(false);
		
		// Account View
		
		AccountView = new Panel();
		AccountView.setLayout(null);
		AccountView.setBackground(Color.PINK);
		AccountView.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(AccountView);
		AccountView.setVisible(false);
		
		JLabel AccountView_Welcome = new JLabel("Welcome, [Place Holder]");
		AccountView_Welcome.setHorizontalTextPosition(SwingConstants.CENTER);
		AccountView_Welcome.setHorizontalAlignment(SwingConstants.CENTER);
		AccountView_Welcome.setForeground(Color.WHITE);
		AccountView_Welcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		AccountView_Welcome.setAlignmentX(0.5f);
		AccountView_Welcome.setBounds(136, 11, 383, 75);
		AccountView.add(AccountView_Welcome);
		
		JButton AccountView_Logout = new JButton();
		AccountView_Logout.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountView_Logout.setText("Log out");
		AccountView_Logout.setInheritsPopupMenu(true);
		AccountView_Logout.setForeground(Color.BLACK);
		AccountView_Logout.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Logout.setBackground(new Color(255, 206, 206));
		AccountView_Logout.setAutoscrolls(false);
		AccountView_Logout.setBounds(208, 366, 246, 27);
		AccountView.add(AccountView_Logout);
		
		JButton AccountView_Settings = new JButton();
		AccountView_Settings.setText("Account Settings");
		AccountView_Settings.setInheritsPopupMenu(true);
		AccountView_Settings.setForeground(Color.BLACK);
		AccountView_Settings.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Settings.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountView_Settings.setBackground(new Color(255, 206, 206));
		AccountView_Settings.setAutoscrolls(false);
		AccountView_Settings.setBounds(208, 312, 246, 27);
		AccountView.add(AccountView_Settings);
		
		JButton AccountView_Withdrawal = new JButton();
		AccountView_Withdrawal.setText("Withdrawal");
		AccountView_Withdrawal.setInheritsPopupMenu(true);
		AccountView_Withdrawal.setForeground(Color.BLACK);
		AccountView_Withdrawal.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Withdrawal.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountView_Withdrawal.setBackground(new Color(255, 206, 206));
		AccountView_Withdrawal.setAutoscrolls(false);
		AccountView_Withdrawal.setBounds(208, 220, 246, 27);
		AccountView.add(AccountView_Withdrawal);
		
		JButton AccountView_Deposit = new JButton();
		AccountView_Deposit.setText("Deposit");
		AccountView_Deposit.setInheritsPopupMenu(true);
		AccountView_Deposit.setForeground(Color.BLACK);
		AccountView_Deposit.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Deposit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountView_Deposit.setBackground(new Color(255, 206, 206));
		AccountView_Deposit.setAutoscrolls(false);
		AccountView_Deposit.setBounds(208, 182, 246, 27);
		AccountView.add(AccountView_Deposit);
		
		JPanel BalanceHolder = new JPanel();
		BalanceHolder.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 206, 206), null));
		BalanceHolder.setBounds(160, 82, 342, 75);
		AccountView.add(BalanceHolder);
		BalanceHolder.setLayout(null);
		
		JLabel Title = new JLabel("My Balance:");
		Title.setFont(new Font("Verdana", Font.BOLD, 14));
		Title.setBounds(10, 11, 119, 18);
		BalanceHolder.add(Title);
		
		MoneySignIcon_AccountView = new JLabel("$");
		MoneySignIcon_AccountView.setForeground(new Color(236, 119, 98));
		MoneySignIcon_AccountView.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIcon_AccountView.setBounds(28, 37, 15, 18);
		BalanceHolder.add(MoneySignIcon_AccountView);
		
		Balance_AccountView_2 = new JLabel("0.00");
		Balance_AccountView_2.setForeground(new Color(233, 98, 73));
		Balance_AccountView_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Balance_AccountView_2.setBounds(36, 35, 285, 29);
		BalanceHolder.add(Balance_AccountView_2);
		
		JButton AccountView_Transactions = new JButton();
		AccountView_Transactions.setText("Transactions");
		AccountView_Transactions.setInheritsPopupMenu(true);
		AccountView_Transactions.setForeground(Color.BLACK);
		AccountView_Transactions.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Transactions.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountView_Transactions.setBackground(new Color(255, 206, 206));
		AccountView_Transactions.setAutoscrolls(false);
		AccountView_Transactions.setBounds(208, 274, 246, 27);
		AccountView.add(AccountView_Transactions);
		
		LoginScreen = new Panel();
		IH.UiSetupJPanel(LoginScreen);
		
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
		GoToSignUp.setBounds(409, 323, 61, 27);
		LoginScreen.add(GoToSignUp);
		
		JLabel BankTitle = new JLabel("The Golden Bank of Calgary");
		BankTitle.setForeground(Color.WHITE);
		BankTitle.setBounds(133, 11, 383, 75);
		BankTitle.setAlignmentX(0.5f);
		BankTitle.setHorizontalAlignment(SwingConstants.CENTER);
		BankTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		BankTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		LoginScreen.add(BankTitle);
		
		EnterUsername = new JTextField();
		EnterUsername.setToolTipText("Enter the username to your account");
		EnterUsername.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		EnterUsername.setForeground(Color.GRAY);
		EnterUsername.setBackground(new Color(255, 206, 198));
		EnterUsername.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		EnterUsername.setSelectedTextColor(new Color(255, 159, 159));
		EnterUsername.setText("Enter Username");
		EnterUsername.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterUsername.setBounds(141, 194, 367, 27);
		LoginScreen.add(EnterUsername);
		EnterUsername.setColumns(10);
		
		Ui.TextFieldSetup(EnterUsername, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		EnterPassword = new JTextField();
		EnterPassword.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		EnterPassword.setText("Enter Password");
		EnterPassword.setSelectedTextColor(new Color(255, 159, 159));
		EnterPassword.setForeground(Color.GRAY);
		EnterPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterPassword.setColumns(10);
		EnterPassword.setBackground(new Color(255, 206, 198));
		EnterPassword.setBounds(141, 241, 367, 27);
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
		LoginButton.setBounds(257, 285, 136, 27);
		LoginScreen.add(LoginButton);
		SignUpScreen.setLayout(null);
		SignUpScreen.setBackground(Color.PINK);
		SignUpScreen.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(SignUpScreen);
		
		JButton GoToLogin = new JButton();
		GoToLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		BankTitle_SignUp.setBounds(133, 11, 383, 75);
		SignUpScreen.add(BankTitle_SignUp);
		
		EnterUsername_SignUp = new JTextField();
		EnterUsername_SignUp.setToolTipText("Enter the username to your account");
		EnterUsername_SignUp.setText("Enter Username");
		EnterUsername_SignUp.setSelectedTextColor(new Color(255, 159, 159));
		EnterUsername_SignUp.setForeground(Color.GRAY);
		EnterUsername_SignUp.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterUsername_SignUp.setColumns(10);
		EnterUsername_SignUp.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		EnterUsername_SignUp.setBackground(new Color(255, 206, 198));
		EnterUsername_SignUp.setBounds(141, 150, 367, 27);
		SignUpScreen.add(EnterUsername_SignUp);
		
		Ui.TextFieldSetup(EnterUsername_SignUp, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		EnterPassword_SignUp = new JTextField();
		EnterPassword_SignUp.setToolTipText("Enter the password to your account");
		EnterPassword_SignUp.setText("Enter Password");
		EnterPassword_SignUp.setSelectedTextColor(new Color(255, 159, 159));
		EnterPassword_SignUp.setForeground(Color.GRAY);
		EnterPassword_SignUp.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterPassword_SignUp.setColumns(10);
		EnterPassword_SignUp.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		EnterPassword_SignUp.setBackground(new Color(255, 206, 198));
		EnterPassword_SignUp.setBounds(141, 200, 367, 27);
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
		SignUpButton.setBounds(257, 285, 136, 27);
		SignUpScreen.add(SignUpButton);
		
		ConfirmPassword = new JTextField();
		ConfirmPassword.setToolTipText("Confirm the password to your account");
		ConfirmPassword.setText("Confirm Password");
		ConfirmPassword.setSelectedTextColor(new Color(255, 159, 159));
		ConfirmPassword.setForeground(Color.GRAY);
		ConfirmPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		ConfirmPassword.setColumns(10);
		ConfirmPassword.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		ConfirmPassword.setBackground(new Color(255, 206, 198));
		ConfirmPassword.setBounds(141, 241, 367, 27);
		
		SignUpScreen.add(ConfirmPassword);
		
		Ui.TextFieldSetup(ConfirmPassword, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		JButton LoginError = new JButton();
		LoginError.setVisible(false);
		LoginError.setBorderPainted(false);
		LoginError.setText("ACCOUNT ALREADY EXISTS.");
		LoginError.setForeground(Color.RED);
		LoginError.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		LoginError.setBorder(null);
		LoginError.setBackground(Color.PINK);
		LoginError.setAutoscrolls(false);
		LoginError.setBounds(141, 118, 367, 27);
		SignUpScreen.add(LoginError);
		
		AccountSettings = new Panel();
		AccountSettings.setLayout(null);
		AccountSettings.setBackground(Color.PINK);
		AccountSettings.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(AccountSettings);
		AccountSettings.setVisible(true);
		
		JLabel AccountSettings_Title = new JLabel("Account Settings");
		AccountSettings_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		AccountSettings_Title.setHorizontalAlignment(SwingConstants.CENTER);
		AccountSettings_Title.setForeground(Color.WHITE);
		AccountSettings_Title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		AccountSettings_Title.setAlignmentX(0.5f);
		AccountSettings_Title.setBounds(136, 11, 383, 75);
		AccountSettings.add(AccountSettings_Title);
		
		JButton AccountSettings_Username = new JButton();
		AccountSettings_Username.setText("Change Username");
		AccountSettings_Username.setInheritsPopupMenu(true);
		AccountSettings_Username.setForeground(Color.BLACK);
		AccountSettings_Username.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountSettings_Username.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountSettings_Username.setBackground(new Color(255, 206, 206));
		AccountSettings_Username.setAutoscrolls(false);
		AccountSettings_Username.setBounds(208, 123, 246, 27);
		AccountSettings.add(AccountSettings_Username);
		
		JButton AccountSettings_Password = new JButton();
		AccountSettings_Password.setText("Change Password");
		AccountSettings_Password.setInheritsPopupMenu(true);
		AccountSettings_Password.setForeground(Color.BLACK);
		AccountSettings_Password.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountSettings_Password.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountSettings_Password.setBackground(new Color(255, 206, 206));
		AccountSettings_Password.setAutoscrolls(false);
		AccountSettings_Password.setBounds(208, 173, 246, 27);
		AccountSettings.add(AccountSettings_Password);
		
		JButton AccountSettings_Currency = new JButton();
		AccountSettings_Currency.setText("Change Currency");
		AccountSettings_Currency.setInheritsPopupMenu(true);
		AccountSettings_Currency.setForeground(Color.BLACK);
		AccountSettings_Currency.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountSettings_Currency.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountSettings_Currency.setBackground(new Color(255, 206, 206));
		AccountSettings_Currency.setAutoscrolls(false);
		AccountSettings_Currency.setBounds(208, 223, 246, 27);
		AccountSettings.add(AccountSettings_Currency);
		
		AccountSettings_Delete = new JButton();
		AccountSettings_Delete.setText("Delete Account");
		AccountSettings_Delete.setInheritsPopupMenu(true);
		AccountSettings_Delete.setForeground(Color.BLACK);
		AccountSettings_Delete.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountSettings_Delete.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountSettings_Delete.setBackground(new Color(255, 206, 206));
		AccountSettings_Delete.setAutoscrolls(false);
		AccountSettings_Delete.setBounds(208, 273, 246, 27);
		AccountSettings.add(AccountSettings_Delete);
		
		JButton AccountSettings_Back = new JButton();
		AccountSettings_Back.setText("Back");
		AccountSettings_Back.setInheritsPopupMenu(true);
		AccountSettings_Back.setForeground(Color.BLACK);
		AccountSettings_Back.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountSettings_Back.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		AccountSettings_Back.setBackground(new Color(255, 206, 206));
		AccountSettings_Back.setAutoscrolls(false);
		AccountSettings_Back.setBounds(208, 366, 246, 27);
		AccountSettings.add(AccountSettings_Back);
		
		ChangeNameScreen = new Panel();
		ChangeNameScreen.setLayout(null);
		ChangeNameScreen.setBackground(Color.PINK);
		ChangeNameScreen.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(AccountSettings);
		ChangeNameScreen.setVisible(true);
		
		// Account Settings Events
		AccountSettings_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AccountSettings.setVisible(false);
				AccountView.setVisible(true);
			}
		});
				
		// Goto Login Events
		GoToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen.setVisible(true);
				SignUpScreen.setVisible(false);
				IH.ChangeFocus(null);
			}
		});
		
		// (SignUp) EnterUsername Events
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
				boolean beingUsed = Ui.UiBeingUsed(EnterPassword_SignUp, e);
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					if (beingUsed) // Allows to go to next enter because password is valid and entered.
					{
						IH.ChangeFocus(EnterPassword_SignUp);
					}
				}
				
				LoginError.setVisible(false);
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
				boolean beingUsed = Ui.UiBeingUsed(EnterPassword_SignUp, e);
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					if (beingUsed) // Allows to go to next enter because password is valid and entered.
					{
						IH.ChangeFocus(EnterPassword_SignUp);
					}
				}
				
				LoginError.setVisible(false);
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
					IH.ChangeFocus(ConfirmPassword);
				}
				
				LoginError.setVisible(false);
			}
		});
		
		// (SignUp) Sign Up Button Events
		SignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean UsernamebeingUsed = Ui.UiBeingUsed(EnterUsername_SignUp, null);
				boolean PasswordbeingUsed = Ui.UiBeingUsed(EnterPassword_SignUp, null);
				boolean ConfirmPasswordbeingUsed = Ui.UiBeingUsed(ConfirmPassword, null);
				
				if (!UsernamebeingUsed) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Please enter a Username.");
					return;
				}
				
				if (!PasswordbeingUsed) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Please enter a Password.");
					return;
				}
				
				if (!ConfirmPasswordbeingUsed) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Please re-enter the Password in Confirm Password.");
					return;
				}
				
				if (!ConfirmPassword.getText().equals(EnterPassword_SignUp.getText())) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Confirm Password isn't the same as Password.");
					return;
				}
				
				boolean AccountExists = LocalBank_MasteryData.LocalBankGUI_Data.createAccount(EnterUsername_SignUp.getText(), EnterPassword_SignUp.getText());
				
				if (AccountExists) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Account Already Exists.");
				}
				else 
				{
					currentAccount = LocalBank_MasteryData.LocalBankGUI_Data.getAccount(EnterUsername_SignUp.getText(), EnterPassword_SignUp.getText());
					
					if (currentAccount == null) 
					{
						Console.error("Sign up Button", "Failed to login to account", currentAccount);
						return;
					}
					
					EnterUsername_SignUp.setText(null);
					EnterPassword_SignUp.setText(null);
					ConfirmPassword.setText(null);
					
					EnterUsername.setText(null);
					EnterPassword.setText(null);
					
					Ui.toggleTipText(EnterUsername_SignUp);
					Ui.toggleTipText(EnterPassword_SignUp);
					Ui.toggleTipText(ConfirmPassword);
					
					Ui.toggleTipText(EnterUsername);
					Ui.toggleTipText(EnterPassword);
					
					AccountView_Welcome.setText("Welcome, " + currentAccount.Username);
					
					AccountView.setVisible(true);
					LoginScreen.setVisible(false);
					SignUpScreen.setVisible(false);
					
					System.out.println(currentAccount.CreationDate);
					
					UpdateCurrencySymbols();
					UpdateAccountViewBalance();
				}
			}
		});
		
		GoToSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SignUpScreen.setVisible(true);
				LoginScreen.setVisible(false);
				IH.ChangeFocus(null);
			}
		});
		
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
					IH.ChangeFocus(EnterPassword);
				}
				
				LoginError.setVisible(false);
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
					IH.ChangeFocus(ConfirmPassword);
				}
				
				LoginError.setVisible(false);
			}
		});
		
		// Get into Account View Events
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean UsernamebeingUsed = Ui.UiBeingUsed(EnterUsername, null);
				boolean PasswordbeingUsed = Ui.UiBeingUsed(EnterPassword, null);
				
				if (!UsernamebeingUsed) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Please enter a Username.");
					return;
				}
				
				if (!PasswordbeingUsed) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Please enter a Password.");
					return;
				}
				
				boolean AccountExists = LocalBankGUI_Data.getAccount(EnterUsername.getText(), EnterPassword.getText()) != null;
				
				if (AccountExists) 
				{
					currentAccount = LocalBankGUI_Data.getAccount(EnterUsername.getText(), EnterPassword.getText());
					
					if (currentAccount == null) 
					{
						Console.error("Login Button", "Failed to login to account", currentAccount);
						return;
					}
					
					EnterUsername_SignUp.setText(null);
					EnterPassword_SignUp.setText(null);
					ConfirmPassword.setText(null);
					
					EnterUsername.setText(null);
					EnterPassword.setText(null);
					
					Ui.toggleTipText(EnterUsername_SignUp);
					Ui.toggleTipText(EnterPassword_SignUp);
					Ui.toggleTipText(ConfirmPassword);
					
					Ui.toggleTipText(EnterUsername);
					Ui.toggleTipText(EnterPassword);
					
					AccountView_Welcome.setText("Welcome, " + currentAccount.Username);
					
					AccountView.setVisible(true);
					LoginScreen.setVisible(false);
					SignUpScreen.setVisible(false);
					
					UpdateAccountViewBalance();
				}
				else 
				{
					LoginError.setVisible(true);
					LoginError.setText("Username or Password is incorrect.");
				}
			}
		});
		
		// Get out of Account View Event
		AccountView_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AccountView.setVisible(false);
				SignUpScreen.setVisible(false);
				
				LoginScreen.setVisible(true);
			}
		});
		
		AccountView_Withdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdrawal.setVisible(true);
				AccountView.setVisible(false);
				
				UpdateAccountViewBalance();
			}
		});
		
		AccountView_Deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit.setVisible(true);
				AccountView.setVisible(false);
				
				UpdateAccountViewBalance();
			}
		});
		
		AccountView_Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AccountSettings.setVisible(true);
				AccountView.setVisible(false);
			}
		});
		
		// Account View Events
		Withdrawal_SubmitAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				double Currency = CurrencyFormatter.getAsDouble(Withdrawal_Amount.getText());
				if (!((Withdrawal_Amount.getText().isEmpty() && Withdrawal_Recever.getText().isEmpty()) || Withdrawal_Recever.getText().equals("Recever")) && Currency > 0) 
				{
					LocalBankGUI_PageHandler.addSection(Withdrawal_Recever.getText(), Currency);
					LocalBankGUI_PageHandler.CurrentPage = LocalBankGUI_PageHandler.getTotalPages();
					UpdateWithdrawalTransactionSideBar();
				}
			}
		});
		
		// Switch Page Events
		Withdrawal_NextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{		
				if (LocalBankGUI_PageHandler.CurrentPage < LocalBankGUI_PageHandler.getTotalPages()) 
				{
					LocalBankGUI_PageHandler.CurrentPage++;
					UpdateWithdrawalTransactionSideBar();
				}
			}
		});
		
		Withdrawal_PreviousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (LocalBankGUI_PageHandler.CurrentPage > 1) 
				{
					LocalBankGUI_PageHandler.CurrentPage--;
					UpdateWithdrawalTransactionSideBar();
				}
			}
		});
		
		// Withdrawal Events
		Withdrawal_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdrawal.setVisible(false);
				AccountView.setVisible(true);
				
				frame.setBounds(100, 100, 666, 461);
				Withdrawal.setBounds(0, 0, 650, 422);
			}
		});
		
		Deposit_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit.setVisible(false);
				AccountView.setVisible(true);
				
				frame.setBounds(100, 100, 666, 461);
				Withdrawal.setBounds(0, 0, 650, 422);
			}
		});
		
		Withdrawal_Amount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Ui.toggleTipText(Withdrawal_Amount);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Ui.toggleTipText(Withdrawal_Amount);
			}
		});
		
		Withdrawal_Recever.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Ui.toggleTipText(Withdrawal_Recever);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Ui.toggleTipText(Withdrawal_Recever);
			}
		});
		
		// Set Amount Text Buttons 
		Withdrawal_Half.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentAccount.Balance > 0) 
				{
					Withdrawal_Amount.setText("$" + String.format("%,.2f", currentAccount.Balance / 2));
				}
				else 
				{
					Withdrawal_Amount.setText("$0");
				}
				
				IH.ChangeFocus(Withdrawal_Amount);
			}
		});
		
		Withdrawal_None.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdrawal_Amount.setText("$0");
				IH.ChangeFocus(Withdrawal_Amount);
			}
		});
		
		Withdrawal_All.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdrawal_Amount.setText("$" + String.format("%,.2f", currentAccount.Balance));
				IH.ChangeFocus(Withdrawal_Amount);
			}
		});
		
		Withdrawal_Amount_Remove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				LocalBankGUI_PageHandler.removeSectionFromPage(LocalBankGUI_PageHandler.Pages, LocalBankGUI_PageHandler.CurrentPage, 1);
				UpdateWithdrawalTransactionSideBar();
			}
		});
		
		Withdrawal_Amount_Remove_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				LocalBankGUI_PageHandler.removeSectionFromPage(LocalBankGUI_PageHandler.Pages, LocalBankGUI_PageHandler.CurrentPage, 2);
				UpdateWithdrawalTransactionSideBar();
			}
		});
		
		Withdrawal_Amount_Remove_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				LocalBankGUI_PageHandler.removeSectionFromPage(LocalBankGUI_PageHandler.Pages, LocalBankGUI_PageHandler.CurrentPage, 3);
				UpdateWithdrawalTransactionSideBar();
			}
		});
		
		frame.setBounds(100, 100, 666, 461);
		Withdrawal.setBounds(0, 0, 650, 422);
	}
	
	public static void UpdateAccountViewBalance() 
	{
		if (currentAccount.Balance < 0) 
		{
			Withdrawal_Balance_MinusSymbol.setVisible(true);
			Withdrawal_AfterBalance_MinusSymbol.setVisible(true);
		}
		else
		{
			Withdrawal_Balance_MinusSymbol.setVisible(false);
			Withdrawal_AfterBalance_MinusSymbol.setVisible(false);
		}
		
		Withdrawal_AfterBalance.setText((currentAccount.Balance > 0 ? "" : "-") + String.format("%,.2f", ((currentAccount.Balance) > 0 ? (currentAccount.Balance) : -(currentAccount.Balance))));
		Withdrawal_CurrentBalance.setText((currentAccount.Balance > 0 ? "" : "-") + String.format("%,.2f", (currentAccount.Balance > 0 ? currentAccount.Balance : -currentAccount.Balance)));
		
		Deposit_CurrentBalance.setText((currentAccount.Balance > 0 ? "" : "-") + String.format("%,.2f", ((currentAccount.Balance) > 0 ? (currentAccount.Balance) : -(currentAccount.Balance))));
		Deposit_AfterBalance.setText((currentAccount.Balance > 0 ? "" : "-") + String.format("%,.2f", (currentAccount.Balance > 0 ? currentAccount.Balance : -currentAccount.Balance)));
		
		Balance_AccountView_2.setText((currentAccount.Balance > 0 ? "" : "-") + String.format("%,.2f", ((currentAccount.Balance) > 0 ? (currentAccount.Balance) : -(currentAccount.Balance))));
	}
	
	public static void UpdateCurrencySymbols() 
	{
		String Symbol = LocalBankGUI_CurrencyHandler.getExchangeRate(LocalBankGUI_CurrencyHandler.CurrentExchangeType).CurrencySymbol != "???" ? LocalBankGUI_CurrencyHandler.getExchangeRate(LocalBankGUI_CurrencyHandler.CurrentExchangeType).CurrencySymbol : "Failed" ;
		
		if (!Symbol.equals("Failed")) 
		{
			Withdrawal_MoneySignIcon_AfterBalance.setText(Symbol);
			Withdrawal_MoneySignIcon_Balance.setText(Symbol);
			
			SideBar_MoneySignIconWithdrawal_1.setText(Symbol);
			SideBar_MoneySignIconWithdrawal_2.setText(Symbol);
			SideBar_MoneySignIconWithdrawal_3.setText(Symbol);
			
			Deposit_MoneySignIcon_AfterBalance.setText(Symbol);
			Deposit_MoneySignIcon_AfterBalance.setText(Symbol);
			
			SideBar_MoneySignIconDeposit_1.setText(Symbol);
			SideBar_MoneySignIconDeposit_2.setText(Symbol);
			SideBar_MoneySignIconDeposit_3.setText(Symbol);
		}
	}
	
	public static void UpdateAfterAccountViewBalance() 
	{
		double Amount = 0.00;
		int LoopAmount = 0;
		
		for (LocalBankGUI_PageHandler.Transaction Trans : LocalBankGUI_PageHandler.Pages) 
		{
			LoopAmount++;
			Amount += Trans.Amount;
		}
		
		if (LoopAmount == 0) 
		{
			Amount = 0.00;
			Withdrawal_Withdrawal.setEnabled(false);
		}
		else 
		{
			Withdrawal_Withdrawal.setEnabled(true);
		}
		
		System.out.println("Amount: " + Amount + "\n" + "Balance: " + currentAccount.Balance);
		
		if (currentAccount.Balance - Amount < 0) 
		{
			Withdrawal_AfterBalance_MinusSymbol.setVisible(true);
		}
		else
		{
			Withdrawal_AfterBalance_MinusSymbol.setVisible(false);
		}
		
		if (currentAccount.Balance < 0) 
		{
			Withdrawal_Balance_MinusSymbol.setVisible(true);
		}
		else 
		{
			Withdrawal_Balance_MinusSymbol.setVisible(false);
		}
		
		Withdrawal_AfterBalance.setText(String.format("%,.2f", ((currentAccount.Balance - Amount) > 0 ? (currentAccount.Balance - Amount) : -(currentAccount.Balance - Amount))));
		Withdrawal_CurrentBalance.setText((currentAccount.Balance > 0 ? "" : "-") + String.format("%,.2f", (currentAccount.Balance > 0 ? currentAccount.Balance : -currentAccount.Balance)));
	}
	
	public static void UpdateWithdrawalTransactionSideBar() 
	{
		// Resets it so all are invisible - Makes it so i don't have to check if there is a section for it.
		Withdrawal_Trans_3.setVisible(false);
		Withdrawal_Trans_2.setVisible(false);
		Withdrawal_Trans_1.setVisible(false);
		
		Withdrawal_Amount_Trans_3.setText("0.00");
		Withdrawal_Amount_Trans_2.setText("0.00");
		Withdrawal_Amount_Trans_1.setText("0.00");
		
		if (LocalBankGUI_PageHandler.CurrentPage >= LocalBankGUI_PageHandler.getTotalPages()) 
		{
			Withdrawal_NextPage.setVisible(false);
			Withdrawal_PreviousPage.setVisible(LocalBankGUI_PageHandler.CurrentPage == 1 ? false : true);
		}
		else if (LocalBankGUI_PageHandler.CurrentPage <= 1 && LocalBankGUI_PageHandler.getTotalPages() > 1) 
		{
			Withdrawal_PreviousPage.setVisible(false);
			Withdrawal_NextPage.setVisible(true);
		}
		else if (LocalBankGUI_PageHandler.CurrentPage <= 1 && !(LocalBankGUI_PageHandler.getTotalPages() > 1)) 
		{
			Withdrawal_NextPage.setVisible(false);
			Withdrawal_PreviousPage.setVisible(false);
		}
		else 
		{
			Withdrawal_NextPage.setVisible(true);
			Withdrawal_PreviousPage.setVisible(true);
		}
		
		Withdrawal_PageCount.setText("Page: " + LocalBankGUI_PageHandler.CurrentPage);
		
		sidebarOpen = false;
		
		LocalBankGUI_PageHandler.printAllPages();
		
		// Gets the size for the current page.
		List<LocalBankGUI_PageHandler.Transaction> Transactions = LocalBankGUI_PageHandler.getSectionFromPage(LocalBankGUI_PageHandler.Pages, LocalBankGUI_PageHandler.CurrentPage - 1);

		Integer Sections = (Transactions != null ? Transactions.size() : null); // Uses Integer instead of int because it can handle being null.

		if (Sections == null) 
		{
		    //System.err.println("Failed to get sections. [" + Sections + "]");
		    
		    if (LocalBankGUI_PageHandler.CurrentPage > 1) 
		    {
		    	LocalBankGUI_PageHandler.CurrentPage -= 1;
		    	UpdateWithdrawalTransactionSideBar(); // Recalls the function to reload the previous page.
		    }
		    else 
		    {
		    	UpdateAfterAccountViewBalance();
		    	frame.setBounds(100, 100, 666, 461);
				Withdrawal.setBounds(0, 0, 650, 422);
		    }
		   
		    return;
		}
		
		UpdateAfterAccountViewBalance();
		
		if (Sections == 3) 
		{
			Withdrawal_Trans_3.setVisible(true);
			Withdrawal_Amount_Trans_3.setText(String.format("%,.2f", Transactions.get(2).Amount));
			Withdrawal_Amount_SelectedPerson_3.setText(Transactions.get(2).Person);
		}
		
		if (Sections >= 2) 
		{
			Withdrawal_Trans_2.setVisible(true);
			Withdrawal_Amount_Trans_2.setText(String.format("%,.2f", Transactions.get(1).Amount));
			Withdrawal_Amount_SelectedPerson_2.setText(Transactions.get(1).Person);
		}
		
		if (Sections >= 1) 
		{
			Withdrawal_Trans_1.setVisible(true);
			Withdrawal_Amount_Trans_1.setText(String.format("%,.2f", Transactions.get(0).Amount));
			Withdrawal_Amount_SelectedPerson_1.setText(Transactions.get(0).Person);
			sidebarOpen = true;
		}
		
		if (!sidebarOpen) 
		{
			frame.setBounds(100, 100, 666, 461);
			Withdrawal.setBounds(0, 0, 650, 422);
		}
		else 
		{
			frame.setBounds(100, 100, 900, 461);
			Withdrawal.setBounds(0, 0, 884, 422);
		}
	}
}