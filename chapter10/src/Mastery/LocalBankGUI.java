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
import EasyKit.IH;
import EasyKit.Text;
import EasyKit.Ui;
import MasteryData.LocalBankGUI_Data;
import MasteryData.LocalBankGUI_Data.NewAccount;

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
import javax.swing.Box;

public class LocalBankGUI {

	private static final Object False = null;
	private JFrame frame;
	private JTextField EnterUsername;
	private JTextField EnterPassword;
	private JLabel SwitchOverToSignUp;
	private JTextField EnterUsername_SignUp;
	private JTextField EnterPassword_SignUp;
	private JTextField ConfirmPassword;
	@SuppressWarnings("unused")
	public static MasteryData.LocalBankGUI_Data.NewAccount currentAccount;
	private JTextField EnterAmount;
	private JTextField Recever;

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
		frame.setType(Type.NORMAL);
		frame.setAutoRequestFocus(false);
		frame.setResizable(false);
		frame.setBounds(100, 100, 666, 461); // SideBar = frame.setBounds(100, 100, 900, 461); | UnSideBar = frame.setBounds(100, 100, 666, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel LoginScreen = new Panel();
		IH.UiSetupJPanel(LoginScreen);
		IH.ChangeFocus(null);
		
		Panel SignUpScreen = new Panel();
		SignUpScreen.setVisible(false);
		
		Panel Withdrawal = new Panel();
		Withdrawal.setBackground(Color.PINK);
		Withdrawal.setBounds(0, 0, 650, 422); // SideBar = Withdrawal.setBounds(0, 0, 884, 422); | UnSideBar = Withdrawal.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(Withdrawal);
		Withdrawal.setLayout(null);
		
		EnterAmount = new JTextField();
		EnterAmount.setBounds(160, 218, 342, 27);
		EnterAmount.setToolTipText("Amount you wish to Withdrawal from your account");
		EnterAmount.setText("Enter Withdrawal Amount");
		EnterAmount.setSelectedTextColor(new Color(255, 159, 159));
		EnterAmount.setForeground(Color.GRAY);
		EnterAmount.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterAmount.setColumns(10);
		EnterAmount.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		EnterAmount.setBackground(new Color(255, 217, 217));
		Withdrawal.add(EnterAmount);
		
		
		
		JLabel Deposit_Title = new JLabel("Withdrawal");
		Deposit_Title.setBounds(136, 11, 383, 75);
		Deposit_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Deposit_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Deposit_Title.setForeground(Color.WHITE);
		Deposit_Title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		Deposit_Title.setAlignmentX(0.5f);
		Withdrawal.add(Deposit_Title);
		
		JButton AccountView_Withdrawal_1 = new JButton();
		AccountView_Withdrawal_1.setVisible(false);
		AccountView_Withdrawal_1.setBounds(207, 384, 246, 27);
		AccountView_Withdrawal_1.setText("Withdrawal");
		AccountView_Withdrawal_1.setInheritsPopupMenu(true);
		AccountView_Withdrawal_1.setForeground(Color.BLACK);
		AccountView_Withdrawal_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Withdrawal_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AccountView_Withdrawal_1.setBackground(new Color(255, 206, 206));
		AccountView_Withdrawal_1.setAutoscrolls(false);
		Withdrawal.add(AccountView_Withdrawal_1);
		
		JButton AccountView_Deposit_1 = new JButton();
		AccountView_Deposit_1.setBounds(303, 251, 70, 27);
		AccountView_Deposit_1.setText("Half");
		AccountView_Deposit_1.setInheritsPopupMenu(true);
		AccountView_Deposit_1.setForeground(Color.BLACK);
		AccountView_Deposit_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Deposit_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AccountView_Deposit_1.setBackground(new Color(255, 206, 206));
		AccountView_Deposit_1.setAutoscrolls(false);
		Withdrawal.add(AccountView_Deposit_1);
		
		JPanel BalanceHolder_1 = new JPanel();
		BalanceHolder_1.setBounds(160, 82, 342, 119);
		BalanceHolder_1.setLayout(null);
		BalanceHolder_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 206, 206), null));
		Withdrawal.add(BalanceHolder_1);
		
		JLabel Title_1 = new JLabel("My Balance:");
		Title_1.setFont(new Font("Verdana", Font.BOLD, 14));
		Title_1.setBounds(10, 11, 119, 18);
		BalanceHolder_1.add(Title_1);
		
		JLabel MoneySignIcon_2 = new JLabel("$");
		MoneySignIcon_2.setForeground(new Color(236, 119, 98));
		MoneySignIcon_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIcon_2.setBounds(28, 37, 15, 18);
		BalanceHolder_1.add(MoneySignIcon_2);
		
		JLabel MoneySignIcon_1_1 = new JLabel("0.00");
		MoneySignIcon_1_1.setForeground(new Color(233, 98, 73));
		MoneySignIcon_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		MoneySignIcon_1_1.setBounds(36, 35, 285, 29);
		BalanceHolder_1.add(MoneySignIcon_1_1);
		
		JLabel MoneySignIcon_1_1_1 = new JLabel("0.00");
		MoneySignIcon_1_1_1.setForeground(new Color(233, 98, 73));
		MoneySignIcon_1_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		MoneySignIcon_1_1_1.setBounds(36, 83, 285, 29);
		BalanceHolder_1.add(MoneySignIcon_1_1_1);
		
		JLabel MoneySignIcon_2_1 = new JLabel("$");
		MoneySignIcon_2_1.setForeground(new Color(236, 119, 98));
		MoneySignIcon_2_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIcon_2_1.setBounds(28, 85, 15, 18);
		BalanceHolder_1.add(MoneySignIcon_2_1);
		
		JLabel Title_1_1 = new JLabel("After Balance:");
		Title_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		Title_1_1.setBounds(10, 64, 119, 18);
		BalanceHolder_1.add(Title_1_1);
		
		JButton AccountView_Deposit_1_1 = new JButton();
		AccountView_Deposit_1_1.setBounds(160, 251, 70, 27);
		AccountView_Deposit_1_1.setText("All");
		AccountView_Deposit_1_1.setInheritsPopupMenu(true);
		AccountView_Deposit_1_1.setForeground(Color.BLACK);
		AccountView_Deposit_1_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Deposit_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AccountView_Deposit_1_1.setBackground(new Color(255, 206, 206));
		AccountView_Deposit_1_1.setAutoscrolls(false);
		Withdrawal.add(AccountView_Deposit_1_1);
		
		JButton AccountView_Deposit_1_2 = new JButton();
		AccountView_Deposit_1_2.setBounds(432, 251, 70, 27);
		AccountView_Deposit_1_2.setText("None");
		AccountView_Deposit_1_2.setInheritsPopupMenu(true);
		AccountView_Deposit_1_2.setForeground(Color.BLACK);
		AccountView_Deposit_1_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Deposit_1_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AccountView_Deposit_1_2.setBackground(new Color(255, 206, 206));
		AccountView_Deposit_1_2.setAutoscrolls(false);
		Withdrawal.add(AccountView_Deposit_1_2);
		
		JButton AccountView_Deposit_1_2_1 = new JButton();
		AccountView_Deposit_1_2_1.setBounds(207, 346, 246, 27);
		AccountView_Deposit_1_2_1.addMouseListener(new MouseAdapter() {
			
			public boolean sidebarOpen = false;
			@Override
			public void mouseClicked(MouseEvent e) 
			{
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
				
				sidebarOpen = !sidebarOpen;
			}
		});
		
		AccountView_Deposit_1_2_1.setText("Submit");
		AccountView_Deposit_1_2_1.setInheritsPopupMenu(true);
		AccountView_Deposit_1_2_1.setForeground(Color.BLACK);
		AccountView_Deposit_1_2_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Deposit_1_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AccountView_Deposit_1_2_1.setBackground(new Color(255, 206, 206));
		AccountView_Deposit_1_2_1.setAutoscrolls(false);
		Withdrawal.add(AccountView_Deposit_1_2_1);
		
		JPanel SideBar = new JPanel();
		SideBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		SideBar.setBounds(648, 0, 236, 422);
		SideBar.setBackground(new Color(255, 217, 217));
		SideBar.setForeground(new Color(252, 122, 122));
		Withdrawal.add(SideBar);
		
		JPanel ChangedStatus_1 = new JPanel();
		ChangedStatus_1.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		ChangedStatus_1.setLayout(null);
		
		JLabel MoneySignIconWithdrawal = new JLabel("$");
		MoneySignIconWithdrawal.setForeground(new Color(236, 119, 98));
		MoneySignIconWithdrawal.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIconWithdrawal.setBounds(15, 19, 15, 18);
		ChangedStatus_1.add(MoneySignIconWithdrawal);
		
		JLabel Amount = new JLabel("0.00");
		Amount.setBounds(20, 25, 196, 29);
		ChangedStatus_1.add(Amount);
		Amount.setForeground(new Color(233, 98, 73));
		Amount.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		
		JLabel MinusSymbol = new JLabel("-");
		MinusSymbol.setForeground(new Color(236, 119, 98));
		MinusSymbol.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol.setBounds(4, 32, 15, 18);
		ChangedStatus_1.add(MinusSymbol);
		
		JPanel Bar = new JPanel();
		Bar.setBackground(new Color(255, 217, 217));
		Bar.setBounds(0, 57, 216, 7);
		ChangedStatus_1.add(Bar);
		
		JLabel SelectedPerson = new JLabel("For: ?");
		SelectedPerson.setForeground(new Color(233, 98, 73));
		SelectedPerson.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		SelectedPerson.setBounds(4, 66, 208, 29);
		ChangedStatus_1.add(SelectedPerson);
		
		JButton Remove = new JButton();
		Remove.setText("x");
		Remove.setInheritsPopupMenu(true);
		Remove.setForeground(new Color(255, 0, 0));
		Remove.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Remove.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Remove.setBackground(new Color(255, 217, 217));
		Remove.setAutoscrolls(false);
		Remove.setBounds(186, 3, 26, 26);
		ChangedStatus_1.add(Remove);
		
		JPanel ChangedStatus_2 = new JPanel();
		ChangedStatus_2.setVisible(false);
		ChangedStatus_2.setLayout(null);
		ChangedStatus_2.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		
		JLabel MoneySignIconWithdrawal_2 = new JLabel("$");
		MoneySignIconWithdrawal_2.setForeground(new Color(236, 119, 98));
		MoneySignIconWithdrawal_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIconWithdrawal_2.setBounds(15, 19, 15, 18);
		ChangedStatus_2.add(MoneySignIconWithdrawal_2);
		
		JLabel Amount_2 = new JLabel("0.00");
		Amount_2.setForeground(new Color(233, 98, 73));
		Amount_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Amount_2.setBounds(20, 25, 196, 29);
		ChangedStatus_2.add(Amount_2);
		
		JLabel MinusSymbol_2 = new JLabel("-");
		MinusSymbol_2.setForeground(new Color(236, 119, 98));
		MinusSymbol_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol_2.setBounds(4, 32, 15, 18);
		ChangedStatus_2.add(MinusSymbol_2);
		
		JPanel Bar_2 = new JPanel();
		Bar_2.setBackground(new Color(255, 217, 217));
		Bar_2.setBounds(0, 57, 216, 7);
		ChangedStatus_2.add(Bar_2);
		
		JLabel SelectedPerson_2 = new JLabel("For: ?");
		SelectedPerson_2.setForeground(new Color(233, 98, 73));
		SelectedPerson_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		SelectedPerson_2.setBounds(4, 66, 208, 29);
		ChangedStatus_2.add(SelectedPerson_2);
		
		JButton Remove_2 = new JButton();
		Remove_2.setText("x");
		Remove_2.setInheritsPopupMenu(true);
		Remove_2.setForeground(Color.RED);
		Remove_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Remove_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Remove_2.setBackground(new Color(255, 217, 217));
		Remove_2.setAutoscrolls(false);
		Remove_2.setBounds(186, 3, 26, 26);
		ChangedStatus_2.add(Remove_2);
		
		JPanel ChangedStatus_3 = new JPanel();
		ChangedStatus_3.setVisible(false);
		ChangedStatus_3.setLayout(null);
		ChangedStatus_3.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		
		JLabel MoneySignIconWithdrawal_3 = new JLabel("$");
		MoneySignIconWithdrawal_3.setForeground(new Color(236, 119, 98));
		MoneySignIconWithdrawal_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIconWithdrawal_3.setBounds(15, 19, 15, 18);
		ChangedStatus_3.add(MoneySignIconWithdrawal_3);
		
		JLabel Amount_3 = new JLabel("0.00");
		Amount_3.setForeground(new Color(233, 98, 73));
		Amount_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Amount_3.setBounds(20, 25, 196, 29);
		ChangedStatus_3.add(Amount_3);
		
		JLabel MinusSymbol_3 = new JLabel("-");
		MinusSymbol_3.setForeground(new Color(236, 119, 98));
		MinusSymbol_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol_3.setBounds(4, 32, 15, 18);
		ChangedStatus_3.add(MinusSymbol_3);
		
		JPanel Bar_3 = new JPanel();
		Bar_3.setBackground(new Color(255, 217, 217));
		Bar_3.setBounds(0, 57, 216, 7);
		ChangedStatus_3.add(Bar_3);
		
		JLabel SelectedPerson_3 = new JLabel("For: ?");
		SelectedPerson_3.setForeground(new Color(233, 98, 73));
		SelectedPerson_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		SelectedPerson_3.setBounds(4, 66, 208, 29);
		ChangedStatus_3.add(SelectedPerson_3);
		
		JButton Remove_3 = new JButton();
		Remove_3.setText("x");
		Remove_3.setInheritsPopupMenu(true);
		Remove_3.setForeground(Color.RED);
		Remove_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Remove_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Remove_3.setBackground(new Color(255, 217, 217));
		Remove_3.setAutoscrolls(false);
		Remove_3.setBounds(186, 3, 26, 26);
		ChangedStatus_3.add(Remove_3);
		
		JPanel PageControls = new JPanel();
		
		JLabel SideBarTitle = new JLabel("Changes");
		SideBarTitle.setHorizontalAlignment(SwingConstants.CENTER);
		SideBarTitle.setForeground(new Color(202, 119, 119));
		SideBarTitle.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		GroupLayout gl_SideBar = new GroupLayout(SideBar);
		gl_SideBar.setHorizontalGroup(
			gl_SideBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SideBar.createSequentialGroup()
					.addGroup(gl_SideBar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SideBar.createSequentialGroup()
							.addGap(8)
							.addComponent(SideBarTitle, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_SideBar.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_SideBar.createParallelGroup(Alignment.TRAILING)
								.addComponent(ChangedStatus_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(ChangedStatus_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(ChangedStatus_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_SideBar.createSequentialGroup()
							.addGap(8)
							.addComponent(PageControls, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_SideBar.setVerticalGroup(
			gl_SideBar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_SideBar.createSequentialGroup()
					.addGap(6)
					.addComponent(SideBarTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(15)
					.addComponent(PageControls, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(ChangedStatus_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ChangedStatus_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ChangedStatus_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_SideBar.setHonorsVisibility(false);
		PageControls.setLayout(null);
		
		JButton Previous = new JButton();
		Previous.setEnabled(false);
		Previous.setText("→");
		Previous.setInheritsPopupMenu(true);
		Previous.setForeground(Color.RED);
		Previous.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		Previous.setBorder(null);
		Previous.setBackground(new Color(253, 234, 234));
		Previous.setAutoscrolls(false);
		Previous.setBounds(169, 0, 51, 36);
		PageControls.add(Previous);
		
		JButton Previous_1 = new JButton();
		Previous_1.setText("←");
		Previous_1.setInheritsPopupMenu(true);
		Previous_1.setForeground(Color.RED);
		Previous_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		Previous_1.setEnabled(false);
		Previous_1.setBorder(null);
		Previous_1.setBackground(new Color(253, 234, 234));
		Previous_1.setAutoscrolls(false);
		Previous_1.setBounds(0, 0, 51, 36);
		PageControls.add(Previous_1);
		
		JLabel PageNum = new JLabel("Page: 1");
		PageNum.setBounds(0, 0, 220, 36);
		PageControls.add(PageNum);
		PageNum.setHorizontalAlignment(SwingConstants.CENTER);
		PageNum.setForeground(new Color(233, 98, 73));
		PageNum.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		SideBar.setLayout(gl_SideBar);
		
		Panel AccountView = new Panel();
		AccountView.setVisible(false);
		AccountView.setLayout(null);
		AccountView.setBackground(Color.PINK);
		AccountView.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(AccountView);
		
		JLabel AccountView_Welcome = new JLabel("Welcome, [Place Holder]");
		AccountView_Welcome.setHorizontalTextPosition(SwingConstants.CENTER);
		AccountView_Welcome.setHorizontalAlignment(SwingConstants.CENTER);
		AccountView_Welcome.setForeground(Color.WHITE);
		AccountView_Welcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		AccountView_Welcome.setAlignmentX(0.5f);
		AccountView_Welcome.setBounds(136, 11, 383, 75);
		AccountView.add(AccountView_Welcome);
		
		JButton AccountView_Logout = new JButton();
		AccountView_Logout.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
		AccountView_Settings.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AccountView_Settings.setBackground(new Color(255, 206, 206));
		AccountView_Settings.setAutoscrolls(false);
		AccountView_Settings.setBounds(208, 312, 246, 27);
		AccountView.add(AccountView_Settings);
		
		JButton AccountView_Withdrawal = new JButton();
		AccountView_Withdrawal.setText("Withdrawal");
		AccountView_Withdrawal.setInheritsPopupMenu(true);
		AccountView_Withdrawal.setForeground(Color.BLACK);
		AccountView_Withdrawal.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Withdrawal.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AccountView_Withdrawal.setBackground(new Color(255, 206, 206));
		AccountView_Withdrawal.setAutoscrolls(false);
		AccountView_Withdrawal.setBounds(208, 220, 246, 27);
		AccountView.add(AccountView_Withdrawal);
		
		JButton AccountView_Deposit = new JButton();
		AccountView_Deposit.setText("Deposit");
		AccountView_Deposit.setInheritsPopupMenu(true);
		AccountView_Deposit.setForeground(Color.BLACK);
		AccountView_Deposit.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Deposit.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AccountView_Deposit.setBackground(new Color(255, 206, 206));
		AccountView_Deposit.setAutoscrolls(false);
		AccountView_Deposit.setBounds(208, 182, 246, 27);
		AccountView.add(AccountView_Deposit);
		
		JPanel BalanceHolder = new JPanel();
		BalanceHolder.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 206, 206), null));
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
		
		JLabel MoneySignIcon_1 = new JLabel("0.00");
		MoneySignIcon_1.setForeground(new Color(233, 98, 73));
		MoneySignIcon_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		MoneySignIcon_1.setBounds(36, 35, 285, 29);
		BalanceHolder.add(MoneySignIcon_1);
		
		JButton AccountView_Transactions = new JButton();
		AccountView_Transactions.setText("Transactions");
		AccountView_Transactions.setInheritsPopupMenu(true);
		AccountView_Transactions.setForeground(Color.BLACK);
		AccountView_Transactions.setFont(new Font("Verdana", Font.PLAIN, 16));
		AccountView_Transactions.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AccountView_Transactions.setBackground(new Color(255, 206, 206));
		AccountView_Transactions.setAutoscrolls(false);
		AccountView_Transactions.setBounds(208, 274, 246, 27);
		AccountView.add(AccountView_Transactions);
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
		EnterPassword_SignUp.setToolTipText("Enter the password to your account");
		EnterPassword_SignUp.setText("Enter Password");
		EnterPassword_SignUp.setSelectedTextColor(new Color(255, 159, 159));
		EnterPassword_SignUp.setForeground(Color.GRAY);
		EnterPassword_SignUp.setFont(new Font("Verdana", Font.PLAIN, 16));
		EnterPassword_SignUp.setColumns(10);
		EnterPassword_SignUp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		EnterPassword_SignUp.setBackground(new Color(255, 206, 198));
		EnterPassword_SignUp.setBounds(162, 200, 367, 27);
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
		ConfirmPassword.setToolTipText("Confirm the password to your account");
		ConfirmPassword.setText("Confirm Password");
		ConfirmPassword.setSelectedTextColor(new Color(255, 159, 159));
		ConfirmPassword.setForeground(Color.GRAY);
		ConfirmPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		ConfirmPassword.setColumns(10);
		ConfirmPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ConfirmPassword.setBackground(new Color(255, 206, 198));
		ConfirmPassword.setBounds(162, 239, 367, 27);
		
		SignUpScreen.add(ConfirmPassword);
		
		LoginScreen.setBackground(Color.PINK);
		LoginScreen.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(LoginScreen);
		LoginScreen.setLayout(null);
		
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
		LoginError.setBounds(162, 118, 367, 27);
		SignUpScreen.add(LoginError);
		
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
				IH.ChangeFocus(null);
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
					IH.ChangeFocus(EnterPassword);
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
					IH.ChangeFocus(ConfirmPassword);
				}
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
			}
		});
		
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
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
					Console.error("Sign Up Button", "Nothing entered for Username", UsernamebeingUsed);
					return;
				}
				
				if (!PasswordbeingUsed) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Please enter a Password.");
					Console.error("Sign Up Button", "Nothing entered for Password", PasswordbeingUsed);
					return;
				}
				
				if (!ConfirmPasswordbeingUsed) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Please re-enter the Password in Confirm Password.");
					Console.error("Sign Up Button", "Nothing entered for Confirm Password", ConfirmPasswordbeingUsed);
					return;
				}
				
				if (!ConfirmPassword.getText().equals(EnterPassword_SignUp.getText())) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Confirm Password isn't the same as Password.");
					Console.error("Sign Up Button", "Confirm Password isn't the same as Password", ConfirmPassword.getText().equals(EnterPassword_SignUp.getText()));
					return;
				}
				
				boolean AccountExists = MasteryData.LocalBankGUI_Data.createAccount(EnterUsername_SignUp.getText(), EnterPassword_SignUp.getText());
				
				if (AccountExists) 
				{
					LoginError.setVisible(true);
					LoginError.setText("Account Already Exists.");
					Console.error("Sign Up Button", "Account Already Exists", "Failed to create account", !AccountExists);
				}
				else 
				{
					MasteryData.LocalBankGUI_Data.getAccount(EnterUsername_SignUp.getText(), EnterPassword_SignUp.getText());
				}
			}
		});
		
		frame.setBounds(100, 100, 900, 461);
		Withdrawal.setBounds(0, 0, 884, 422);
		
		Recever = new JTextField(); 
		Recever.setToolTipText("The Individual the money is going to");
		Recever.setText("Recever");
		Recever.setSelectedTextColor(new Color(255, 159, 159));
		Recever.setForeground(Color.GRAY);
		Recever.setFont(new Font("Verdana", Font.PLAIN, 16));
		Recever.setColumns(10); 
		Recever.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Recever.setBackground(new Color(255, 217, 217));
		Recever.setBounds(159, 296, 342, 27);
		Withdrawal.add(Recever);
	}
}