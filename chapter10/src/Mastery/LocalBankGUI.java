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

import EasyKit.Console;
import EasyKit.Gui_Handler;
import EasyKit.IH;
import EasyKit.OtherSystems;
import EasyKit.Text;
import EasyKit.Ui;
import EasyKit.Gui_Handler.*;
import MasteryData.LocalBankGUI_Data;
import MasteryData.LocalBankGUI_Data.*;
import MasteryData.LocalBankGUI_PageHandler;
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

	private static JFrame frame;
	
	public static boolean sidebarOpen = false;
	
	// Password\Sign up stuff
	private JTextField EnterUsername;
	private JTextField EnterPassword;
	private JLabel SwitchOverToSignUp;
	private JTextField EnterUsername_SignUp;
	private JTextField EnterPassword_SignUp;
	private JTextField ConfirmPassword;
	
	// Withdrawal Stuff
	private static JLabel Withdrawal_CurrentBalance;
	public static MasteryData.LocalBankGUI_Data.NewAccount currentAccount;
	private static JLabel MoneySignIcon_1;
	private static JTextField Withdrawal_Amount;
	private static JTextField Withdrawal_Recever;
	
	private static JPanel Withdrawal_Trans_1;
	private static JPanel Withdrawal_Trans_2;
	private static JPanel Withdrawal_Trans_3;
	
	private static JLabel Balance_AfterBalance;
	private static JButton Withdrawal_Withdrawal;
	
	private static JLabel Withdrawal_Amount_Trans_1;
	private static JLabel Withdrawal_Amount_Trans_2;
	private static JLabel Withdrawal_Amount_Trans_3;
	
	private static JLabel Withdrawal_Amount_SelectedPerson_1;
	private static JLabel Withdrawal_Amount_SelectedPerson_2;
	private static JLabel Withdrawal_Amount_SelectedPerson_3;
	
	private static JButton Withdrawal_Amount_Remove_1;
	private static JButton Withdrawal_Amount_Remove_2;
	private static JButton Withdrawal_Amount_Remove_3;
	
	// Menus
	private static Panel AccountSettings;
	private static Panel SignUpScreen;
	private static Panel LoginScreen;
	private static Panel AccountView;
	private static Panel Withdrawal;
	private static Panel ChangeNameScreen;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LocalBankGUI_Data.createAccount("DummyAccount", "");
		
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
		frame.setBounds(100, 100, 666, 461); // SideBar = frame.setBounds(100, 100, 900, 461); | UnSideBar = frame.setBounds(100, 100, 666, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		SignUpScreen = new Panel();
		SignUpScreen.setVisible(false);
		
		Panel Withdrawal = new Panel();
		Withdrawal.setVisible(false);
		
		Withdrawal.setBackground(Color.PINK);
		Withdrawal.setBounds(0, 0, 773, 422); // SideBar = Withdrawal.setBounds(0, 0, 884, 422); | UnSideBar = Withdrawal.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(Withdrawal);
		Withdrawal.setLayout(null);
		
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
		System.out.println("Ui name: " + Gui_Handler.getTextField(Withdrawal_Amount).getSettings(TextFieldSettings.Allow_Enter).get(1));
		Gui_Handler.getTextField(Withdrawal_Amount).addSetting(Gui_Handler.TextFieldSettings.Currency);
		
		Input.TextField.EventsSetup(Withdrawal_Amount);
		
		Withdrawal_Recever = new JTextField(); 
		Withdrawal_Recever.setToolTipText("The Individual the money is going to");
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
		
		JLabel Withdrawal_Title = new JLabel("Withdrawal");
		Withdrawal_Title.setBounds(133, 11, 383, 75);
		Withdrawal_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Withdrawal_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Withdrawal_Title.setForeground(Color.WHITE);
		Withdrawal_Title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		Withdrawal_Title.setAlignmentX(0.5f);
		Withdrawal.add(Withdrawal_Title);
		
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
		
		JPanel BalanceHolder_1 = new JPanel();
		BalanceHolder_1.setBounds(154, 82, 342, 119);
		BalanceHolder_1.setLayout(null);
		BalanceHolder_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 206, 206), null));
		Withdrawal.add(BalanceHolder_1);
		
		JLabel Title_1 = new JLabel("My Balance:");
		Title_1.setFont(new Font("Verdana", Font.BOLD, 14));
		Title_1.setBounds(10, 11, 119, 18);
		BalanceHolder_1.add(Title_1);
		
		JLabel Balance_MoneySignIcon_Balance = new JLabel("$");
		Balance_MoneySignIcon_Balance.setForeground(new Color(236, 119, 98));
		Balance_MoneySignIcon_Balance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		Balance_MoneySignIcon_Balance.setBounds(28, 37, 15, 18);
		BalanceHolder_1.add(Balance_MoneySignIcon_Balance);
		
		Withdrawal_CurrentBalance = new JLabel("0.00");
		Withdrawal_CurrentBalance.setForeground(new Color(233, 98, 73));
		Withdrawal_CurrentBalance.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Withdrawal_CurrentBalance.setBounds(36, 35, 285, 29);
		BalanceHolder_1.add(Withdrawal_CurrentBalance);
		
		Balance_AfterBalance = new JLabel("0.00");
		Balance_AfterBalance.setForeground(new Color(233, 98, 73));
		Balance_AfterBalance.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Balance_AfterBalance.setBounds(36, 83, 285, 29);
		BalanceHolder_1.add(Balance_AfterBalance);
		
		JLabel Withdrawal_MoneySignIcon_AfterBalance = new JLabel("$");
		Withdrawal_MoneySignIcon_AfterBalance.setForeground(new Color(236, 119, 98));
		Withdrawal_MoneySignIcon_AfterBalance.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		Withdrawal_MoneySignIcon_AfterBalance.setBounds(28, 85, 15, 18);
		BalanceHolder_1.add(Withdrawal_MoneySignIcon_AfterBalance);
		
		JLabel Title_1_1 = new JLabel("After Balance:");
		Title_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		Title_1_1.setBounds(10, 64, 119, 18);
		BalanceHolder_1.add(Title_1_1);
		
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
		
		JPanel SideBar = new JPanel();
		SideBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		SideBar.setBounds(648, 0, 236, 422);
		SideBar.setBackground(new Color(255, 217, 217));
		SideBar.setForeground(new Color(252, 122, 122));
		Withdrawal.add(SideBar);
		
		Withdrawal_Trans_1 = new JPanel();
		Withdrawal_Trans_1.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		
		JLabel MoneySignIconWithdrawal = new JLabel("$");
		MoneySignIconWithdrawal.setForeground(new Color(236, 119, 98));
		MoneySignIconWithdrawal.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIconWithdrawal.setBounds(15, 19, 15, 18);
		Withdrawal_Trans_1.add(MoneySignIconWithdrawal);
		
		Withdrawal_Amount_Trans_1 = new JLabel("0.00");
		Withdrawal_Amount_Trans_1.setBounds(20, 25, 196, 29);
		Withdrawal_Trans_1.add(Withdrawal_Amount_Trans_1);
		Withdrawal_Amount_Trans_1.setForeground(new Color(233, 98, 73));
		Withdrawal_Amount_Trans_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		
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
		Withdrawal_Amount_Remove_1.setForeground(new Color(255, 0, 0));
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
		
		JLabel MoneySignIconWithdrawal_1 = new JLabel("$");
		MoneySignIconWithdrawal_1.setForeground(new Color(236, 119, 98));
		MoneySignIconWithdrawal_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIconWithdrawal_1.setBounds(15, 19, 15, 18);
		Withdrawal_Trans_2.add(MoneySignIconWithdrawal_1);
		
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
		
		JLabel MoneySignIconWithdrawal_1_1 = new JLabel("$");
		MoneySignIconWithdrawal_1_1.setForeground(new Color(236, 119, 98));
		MoneySignIconWithdrawal_1_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIconWithdrawal_1_1.setBounds(15, 19, 15, 18);
		Withdrawal_Trans_3.add(MoneySignIconWithdrawal_1_1);
		
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
		
		JButton Remove_2_2 = new JButton();
		Remove_2_2.setBounds(0, 0, 51, 36);
		Remove_2_2.setText("←");
		Remove_2_2.setInheritsPopupMenu(true);
		Remove_2_2.setForeground(Color.RED);
		Remove_2_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		Remove_2_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(253, 232, 232), new Color(253, 234, 234), new Color(252, 216, 216), new Color(251, 202, 202)));
		Remove_2_2.setBackground(new Color(253, 234, 234));
		Remove_2_2.setAutoscrolls(false);
		panel.add(Remove_2_2);
		
		JButton Remove_2_1 = new JButton();
		Remove_2_1.setText("→");
		Remove_2_1.setInheritsPopupMenu(true);
		Remove_2_1.setForeground(Color.RED);
		Remove_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		Remove_2_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(253, 232, 232), new Color(253, 234, 234), new Color(252, 216, 216), new Color(251, 202, 202)));
		Remove_2_1.setBackground(new Color(253, 234, 234));
		Remove_2_1.setAutoscrolls(false);
		Remove_2_1.setBounds(169, 0, 51, 36);
		panel.add(Remove_2_1);
		
		JLabel Page = new JLabel("Page: 1");
		Page.setHorizontalAlignment(SwingConstants.CENTER);
		Page.setForeground(new Color(233, 98, 73));
		Page.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		Page.setBounds(0, 1, 220, 32);
		panel.add(Page);
		SideBar.setLayout(gl_SideBar);
		
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
		
		JLabel MoneySignIcon = new JLabel("$");
		MoneySignIcon.setForeground(new Color(236, 119, 98));
		MoneySignIcon.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIcon.setBounds(28, 37, 15, 18);
		BalanceHolder.add(MoneySignIcon);
		
		MoneySignIcon_1 = new JLabel("0.00");
		MoneySignIcon_1.setForeground(new Color(233, 98, 73));
		MoneySignIcon_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		MoneySignIcon_1.setBounds(36, 35, 285, 29);
		BalanceHolder.add(MoneySignIcon_1);
		
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
		
		JButton AccountSettings_Delete = new JButton();
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
				
				boolean AccountExists = MasteryData.LocalBankGUI_Data.createAccount(EnterUsername_SignUp.getText(), EnterPassword_SignUp.getText());
				
				if (AccountExists) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Account Already Exists.");
				}
				else 
				{
					currentAccount = MasteryData.LocalBankGUI_Data.getAccount(EnterUsername_SignUp.getText(), EnterPassword_SignUp.getText());
					
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
				if (!(Withdrawal_Amount.getText().isEmpty() || Withdrawal_Recever.getText().isEmpty()) && Currency > 0) 
				{
					LocalBankGUI_PageHandler.addSection(Withdrawal_Recever.getText(), Currency);
					LocalBankGUI_PageHandler.CurrentPage = LocalBankGUI_PageHandler.getTotalPages();
					System.out.println("CurrentPage: " + LocalBankGUI_PageHandler.getTotalPages());
					UpdateWithdrawalTransactionSideBar();
				}
			}
		});
		
		// Withdrawal Events
		Withdrawal_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdrawal.setVisible(false);
				AccountView.setVisible(true);
				
				/*
				frame.setBounds(100, 100, 666, 461);
				Withdrawal.setBounds(0, 0, 650, 422);
				*/
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
		
		frame.setBounds(100, 100, 666, 461);
		Withdrawal.setBounds(0, 0, 650, 422);
	}
	
	public static void UpdateAccountViewBalance() 
	{
		MoneySignIcon_1.setText(String.format("%,.2f", currentAccount.Balance));
		Withdrawal_CurrentBalance.setText(String.format("%,.2f", currentAccount.Balance));
	}
	
	public static void UpdateAfterAccountViewBalance() 
	{
		Balance_AfterBalance.setText(String.format("%,.2f", currentAccount.Balance));
		Withdrawal_CurrentBalance.setText(String.format("%,.2f", currentAccount.Balance));
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
		
		sidebarOpen = false;
		
		// Gets the size for the current page.
		Integer Sections = (LocalBankGUI_PageHandler.getSectionFromPage(LocalBankGUI_PageHandler.Pages, MasteryData.LocalBankGUI_PageHandler.CurrentPage) != null ? LocalBankGUI_PageHandler.getSectionFromPage(LocalBankGUI_PageHandler.Pages, MasteryData.LocalBankGUI_PageHandler.CurrentPage).size() : null);
		List<LocalBankGUI_PageHandler.Transaction> Transactions =  LocalBankGUI_PageHandler.getSectionFromPage(LocalBankGUI_PageHandler.Pages, MasteryData.LocalBankGUI_PageHandler.CurrentPage - 1);
		
		if (Sections == null) {System.err.println("Failed to get sections."); return;}
		
		if (Sections == 3) 
		{
			Withdrawal_Trans_3.setVisible(true);
			Withdrawal_Amount_Trans_3.setText(CurrencyFormatter.formatToCurrency("" + Transactions.get(2).Amount));
		}
		
		if (Sections >= 2) 
		{
			Withdrawal_Trans_2.setVisible(true);
			Withdrawal_Amount_Trans_2.setText(CurrencyFormatter.formatToCurrency("" + Transactions.get(1).Amount));
		}
		
		if (Sections >= 1) 
		{
			Withdrawal_Trans_1.setVisible(true);
			Withdrawal_Amount_Trans_1.setText(CurrencyFormatter.formatToCurrency("" + Transactions.get(0).Amount));
			sidebarOpen = true;
		}
		
		if (sidebarOpen) 
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