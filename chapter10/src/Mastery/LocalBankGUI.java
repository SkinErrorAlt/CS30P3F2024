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

	private JFrame frame;
	private JTextField EnterUsername;
	private JTextField EnterPassword;
	private JLabel SwitchOverToSignUp;
	private JTextField EnterUsername_SignUp;
	private JTextField EnterPassword_SignUp;
	private JTextField ConfirmPassword;
	private static JLabel Withdrawal_CurrentBalance;
	@SuppressWarnings("unused")
	public static MasteryData.LocalBankGUI_Data.NewAccount currentAccount;
	private static JLabel MoneySignIcon_1;
	private JTextField Withdrawal_Amount;
	private JTextField Withdrawal_Recever;
	private JPanel Withdrawal_Trans_1;
	private JPanel ChangeStatus_1_1;
	private JPanel ChangeStatus_1_1_1;

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

		Panel SignUpScreen = new Panel();
		SignUpScreen.setVisible(false);
		
		Panel Withdrawal = new Panel();
		Withdrawal.setVisible(false);
		
		Withdrawal.setBackground(Color.PINK);
		Withdrawal.setBounds(0, 0, 650, 422); // SideBar = Withdrawal.setBounds(0, 0, 884, 422); | UnSideBar = Withdrawal.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(Withdrawal);
		Withdrawal.setLayout(null);
		
		Withdrawal_Amount = new JTextField();
		Withdrawal_Amount.setBounds(154, 234, 342, 27);
		Withdrawal_Amount.setToolTipText("Amount you wish to Withdrawal from your account");
		Withdrawal_Amount.setText("Enter Withdrawal Amount");
		Withdrawal_Amount.setSelectedTextColor(new Color(255, 159, 159));
		Withdrawal_Amount.setForeground(Color.GRAY);
		Withdrawal_Amount.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_Amount.setColumns(10);
		Withdrawal_Amount.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		Withdrawal_Amount.setBackground(new Color(255, 217, 217));
		Withdrawal.add(Withdrawal_Amount); // 
		
		Ui.TextFieldSetup(Withdrawal_Amount, Ui.textFieldType.Text, Color.DARK_GRAY, false);
		
		Input.TextField_Click.ClickEventSetup(Withdrawal_Amount);
		
		Gui_Handler.TextFieldSetup(Withdrawal_Amount);
		
		Gui_Handler.getTextField(Withdrawal_Amount).addSetting(Gui_Handler.TextFieldSettings.Char_Range, 1, 25);
		Gui_Handler.getTextField(Withdrawal_Amount).addSetting(Gui_Handler.TextFieldSettings.Number_Range, 1, 25);
		Gui_Handler.getTextField(Withdrawal_Amount).addSetting(Gui_Handler.TextFieldSettings.Number_Only, true);
		
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
		Withdrawal_Title.setBounds(136, 11, 383, 75);
		Withdrawal_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Withdrawal_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Withdrawal_Title.setForeground(Color.WHITE);
		Withdrawal_Title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		Withdrawal_Title.setAlignmentX(0.5f);
		Withdrawal.add(Withdrawal_Title);
		
		JButton Withdrawal_Withdrawal = new JButton();
		Withdrawal_Withdrawal.setEnabled(false);
		Withdrawal_Withdrawal.setBounds(207, 384, 246, 27);
		Withdrawal_Withdrawal.setText("Withdrawal");
		Withdrawal_Withdrawal.setInheritsPopupMenu(true);
		Withdrawal_Withdrawal.setForeground(Color.BLACK);
		Withdrawal_Withdrawal.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_Withdrawal.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Withdrawal_Withdrawal.setBackground(new Color(255, 206, 206));
		Withdrawal_Withdrawal.setAutoscrolls(false);
		Withdrawal.add(Withdrawal_Withdrawal);
		
		JButton Withdrawal_Half = new JButton();
		Withdrawal_Half.setBounds(295, 265, 70, 27);
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
		
		JLabel MoneySignIcon_2 = new JLabel("$");
		MoneySignIcon_2.setForeground(new Color(236, 119, 98));
		MoneySignIcon_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIcon_2.setBounds(28, 37, 15, 18);
		BalanceHolder_1.add(MoneySignIcon_2);
		
		Withdrawal_CurrentBalance = new JLabel("0.00");
		Withdrawal_CurrentBalance.setForeground(new Color(233, 98, 73));
		Withdrawal_CurrentBalance.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Withdrawal_CurrentBalance.setBounds(36, 35, 285, 29);
		BalanceHolder_1.add(Withdrawal_CurrentBalance);
		
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
		
		JButton Withdrawal_Half_1 = new JButton();
		Withdrawal_Half_1.setBounds(154, 265, 70, 27);
		Withdrawal_Half_1.setText("All");
		Withdrawal_Half_1.setInheritsPopupMenu(true);
		Withdrawal_Half_1.setForeground(Color.BLACK);
		Withdrawal_Half_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_Half_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Withdrawal_Half_1.setBackground(new Color(255, 206, 206));
		Withdrawal_Half_1.setAutoscrolls(false);
		Withdrawal.add(Withdrawal_Half_1);
		
		JButton Withdrawal_Half_2 = new JButton();
		Withdrawal_Half_2.setBounds(426, 265, 70, 27);
		Withdrawal_Half_2.setText("None");
		Withdrawal_Half_2.setInheritsPopupMenu(true);
		Withdrawal_Half_2.setForeground(Color.BLACK);
		Withdrawal_Half_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		Withdrawal_Half_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Withdrawal_Half_2.setBackground(new Color(255, 206, 206));
		Withdrawal_Half_2.setAutoscrolls(false);
		Withdrawal.add(Withdrawal_Half_2);
		
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
		Withdrawal_Trans_1.setLayout(null);
		
		JLabel MoneySignIconWithdrawal = new JLabel("$");
		MoneySignIconWithdrawal.setForeground(new Color(236, 119, 98));
		MoneySignIconWithdrawal.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIconWithdrawal.setBounds(15, 19, 15, 18);
		Withdrawal_Trans_1.add(MoneySignIconWithdrawal);
		
		JLabel Amount = new JLabel("0.00");
		Amount.setBounds(20, 25, 196, 29);
		Withdrawal_Trans_1.add(Amount);
		Amount.setForeground(new Color(233, 98, 73));
		Amount.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		
		JLabel MinusSymbol = new JLabel("-");
		MinusSymbol.setForeground(new Color(236, 119, 98));
		MinusSymbol.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol.setBounds(4, 32, 15, 18);
		Withdrawal_Trans_1.add(MinusSymbol);
		
		JPanel Bar = new JPanel();
		Bar.setBackground(new Color(255, 217, 217));
		Bar.setBounds(0, 57, 216, 7);
		Withdrawal_Trans_1.add(Bar);
		
		JLabel SelectedPerson = new JLabel("For: Joe");
		SelectedPerson.setForeground(new Color(233, 98, 73));
		SelectedPerson.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		SelectedPerson.setBounds(4, 66, 208, 29);
		Withdrawal_Trans_1.add(SelectedPerson);
		
		JButton Remove = new JButton();
		Remove.setText("x");
		Remove.setInheritsPopupMenu(true);
		Remove.setForeground(new Color(255, 0, 0));
		Remove.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Remove.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Remove.setBackground(new Color(255, 217, 217));
		Remove.setAutoscrolls(false);
		Remove.setBounds(186, 3, 26, 26);
		Withdrawal_Trans_1.add(Remove);
		
		JPanel Withdrawal_Trans_2 = new JPanel();
		Withdrawal_Trans_2.setVisible(false);
		Withdrawal_Trans_2.setLayout(null);
		Withdrawal_Trans_2.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		
		JLabel MoneySignIconWithdrawal_1 = new JLabel("$");
		MoneySignIconWithdrawal_1.setForeground(new Color(236, 119, 98));
		MoneySignIconWithdrawal_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIconWithdrawal_1.setBounds(15, 19, 15, 18);
		Withdrawal_Trans_2.add(MoneySignIconWithdrawal_1);
		
		JLabel Amount_1 = new JLabel("0.00");
		Amount_1.setForeground(new Color(233, 98, 73));
		Amount_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Amount_1.setBounds(20, 25, 196, 29);
		Withdrawal_Trans_2.add(Amount_1);
		
		JLabel MinusSymbol_1 = new JLabel("-");
		MinusSymbol_1.setForeground(new Color(236, 119, 98));
		MinusSymbol_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol_1.setBounds(4, 32, 15, 18);
		Withdrawal_Trans_2.add(MinusSymbol_1);
		
		JPanel Bar_1 = new JPanel();
		Bar_1.setBackground(new Color(255, 217, 217));
		Bar_1.setBounds(0, 57, 216, 7);
		Withdrawal_Trans_2.add(Bar_1);
		
		JLabel SelectedPerson_1 = new JLabel("For: Joe");
		SelectedPerson_1.setForeground(new Color(233, 98, 73));
		SelectedPerson_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		SelectedPerson_1.setBounds(4, 66, 208, 29);
		Withdrawal_Trans_2.add(SelectedPerson_1);
		
		JButton Remove_1 = new JButton();
		Remove_1.setText("x");
		Remove_1.setInheritsPopupMenu(true);
		Remove_1.setForeground(Color.RED);
		Remove_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Remove_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Remove_1.setBackground(new Color(255, 217, 217));
		Remove_1.setAutoscrolls(false);
		Remove_1.setBounds(186, 3, 26, 26);
		Withdrawal_Trans_2.add(Remove_1);
		
		JPanel Withdrawal_Trans_3 = new JPanel();
		Withdrawal_Trans_3.setVisible(false);
		Withdrawal_Trans_3.setLayout(null);
		Withdrawal_Trans_3.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		
		JLabel MoneySignIconWithdrawal_1_1 = new JLabel("$");
		MoneySignIconWithdrawal_1_1.setForeground(new Color(236, 119, 98));
		MoneySignIconWithdrawal_1_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		MoneySignIconWithdrawal_1_1.setBounds(15, 19, 15, 18);
		Withdrawal_Trans_3.add(MoneySignIconWithdrawal_1_1);
		
		JLabel Amount_1_1 = new JLabel("0.00");
		Amount_1_1.setForeground(new Color(233, 98, 73));
		Amount_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		Amount_1_1.setBounds(20, 25, 196, 29);
		Withdrawal_Trans_3.add(Amount_1_1);
		
		JLabel MinusSymbol_1_1 = new JLabel("-");
		MinusSymbol_1_1.setForeground(new Color(236, 119, 98));
		MinusSymbol_1_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		MinusSymbol_1_1.setBounds(4, 32, 15, 18);
		Withdrawal_Trans_3.add(MinusSymbol_1_1);
		
		JPanel Bar_1_1 = new JPanel();
		Bar_1_1.setBackground(new Color(255, 217, 217));
		Bar_1_1.setBounds(0, 57, 216, 7);
		Withdrawal_Trans_3.add(Bar_1_1);
		
		JLabel SelectedPerson_1_1 = new JLabel("For: Joe");
		SelectedPerson_1_1.setForeground(new Color(233, 98, 73));
		SelectedPerson_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		SelectedPerson_1_1.setBounds(4, 66, 208, 29);
		Withdrawal_Trans_3.add(SelectedPerson_1_1);
		
		JButton Remove_1_1 = new JButton();
		Remove_1_1.setText("x");
		Remove_1_1.setInheritsPopupMenu(true);
		Remove_1_1.setForeground(Color.RED);
		Remove_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Remove_1_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(252, 218, 218), new Color(253, 227, 227), new Color(252, 216, 216), new Color(251, 200, 200)));
		Remove_1_1.setBackground(new Color(255, 217, 217));
		Remove_1_1.setAutoscrolls(false);
		Remove_1_1.setBounds(186, 3, 26, 26);
		Withdrawal_Trans_3.add(Remove_1_1);
		
		Panel AccountView = new Panel();
		AccountView.setLayout(null);
		AccountView.setBackground(Color.PINK);
		AccountView.setBounds(0, 0, 650, 422);
		frame.getContentPane().add(AccountView);
		AccountView.setVisible(false);
		
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
		
		//frame.setBounds(100, 100, 900, 461);
		//Withdrawal.setBounds(0, 0, 884, 422);
		
		// Account View Events
		Withdrawal_SubmitAmount.addMouseListener(new MouseAdapter() {
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
		
		// Withdrawal Events
		Withdrawal_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdrawal.setVisible(false);
				AccountView.setVisible(true);
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
		
		Panel LoginScreen = new Panel();
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
					
					UpdateAccountViewBalance();
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
				UpdateAccountViewBalance();
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
		
		class EnterUsernameClick 
		{
			void ClickCustomEvent() 
			{
				Console.print("Got it!");
			}
		}
		
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
					
					UpdateAccountViewBalance();
				}
				else 
				{
					LoginError.setVisible(true);
					LoginError.setText("Username or Password is incorrect.");
				}
			}
		});
		
		Withdrawal_SubmitAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OtherSystems.CreateLookingChar('1', 1, '2');
			}
		});
	}
	
	public static void UpdateAccountViewBalance() 
	{
		MoneySignIcon_1.setText(String.format("%,.2f", currentAccount.Balance));
		Withdrawal_CurrentBalance.setText(String.format("%,.2f", currentAccount.Balance));
	}
	
	public static void UpdateWithdrawalTransactionSideBar() 
	{
		
	}
}

class F 
{
	
}