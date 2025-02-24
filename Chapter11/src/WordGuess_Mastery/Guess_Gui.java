package WordGuess_Mastery;

import WordGuess_OtherSystems.*;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;

public class Guess_Gui {

	private JFrame frame;
	
	// Menus
	public static JPanel MainMenu;
	public static JPanel SettingsMenu;
	
	// Sub-Menus | Settings Menu \\
	public static JTabbedPane Settings_Tabs; // Contains the tabs for Settings/Menus
	// -------------------------- \\
	
	public static JPanel ApplicationSettings; // Contains changes to some (UI elements, Customization to personal preference, and Some changes to overall look of the menus)
	public static JPanel Exit_Mark_Settings; // This is used for adding a tab with an X allowing the user to go back.
	
	// Main Menu | Buttons
	public static JButton Play_MainMenu;
	public static JButton Settings_MainMenu;
	public static JButton Exit_MainMenu;

	/**
	 * Launch the application.
	 */
	public static void MainStart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guess_Gui window = new Guess_Gui();
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
	public Guess_Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.getContentPane().setFocusable(false);
		frame.setBounds(100, 100, 921, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		MainMenu = new JPanel(); // Main Menu
		MainMenu.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		MainMenu.setFocusable(false);
		MainMenu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(37, 137, 175), new Color(37, 137, 175), null, null));
		MainMenu.setBackground(new Color(18, 165, 162));
		MainMenu.setBounds(0, 0, 905, 520);
		frame.getContentPane().add(MainMenu);
		MainMenu.setLayout(null);
		
		JLabel Title_MainMenu = new JLabel("Word Guesser");
		Title_MainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		Title_MainMenu.setForeground(new Color(199, 240, 248));
		Title_MainMenu.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		Title_MainMenu.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(37, 137, 175), null)));
		Title_MainMenu.setBackground(new Color(37, 137, 175));
		Title_MainMenu.setBounds(164, 99, 576, 48);
		MainMenu.add(Title_MainMenu);
		
		// Main Menu | Buttons
		Play_MainMenu = new JButton("PLAY");
		Play_MainMenu.setRequestFocusEnabled(false);
		Play_MainMenu.setFocusable(false);
		Play_MainMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Play_MainMenu.setFocusPainted(false);
		Play_MainMenu.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		Play_MainMenu.setBackground(new Color(37, 137, 175));
		Play_MainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		Play_MainMenu.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		Play_MainMenu.setForeground(new Color(199, 240, 248));
		Play_MainMenu.setBounds(328, 201, 248, 38);
		
		Gui_Handler.GuiObjectSetup(Play_MainMenu, Gui_Handler.GetButtonConfig().Click_Effects, false);
		
		MainMenu.add(Play_MainMenu);
		
		Settings_MainMenu = new JButton("SETTINGS");
		Settings_MainMenu.setRequestFocusEnabled(false);
		Settings_MainMenu.setFocusable(false);
		Settings_MainMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Settings_MainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		Settings_MainMenu.setForeground(new Color(199, 240, 248));
		Settings_MainMenu.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		Settings_MainMenu.setFocusPainted(false);
		Settings_MainMenu.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		Settings_MainMenu.setBackground(new Color(37, 137, 175));
		Settings_MainMenu.setBounds(328, 284, 248, 38);
		
		MainMenu.add(Settings_MainMenu);
		
		Exit_MainMenu = new JButton("EXIT");
		Exit_MainMenu.setRequestFocusEnabled(false);
		Exit_MainMenu.setFocusable(false);
		Exit_MainMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exit_MainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		Exit_MainMenu.setForeground(new Color(199, 240, 248));
		Exit_MainMenu.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		Exit_MainMenu.setFocusPainted(false);
		Exit_MainMenu.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		Exit_MainMenu.setBackground(new Color(37, 137, 175));
		Exit_MainMenu.setBounds(328, 333, 248, 38);
		MainMenu.add(Exit_MainMenu);
		
		// Main Menu | Details
		JLabel Detail_1_MainMenu = new JLabel("--------------");
		Detail_1_MainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		Detail_1_MainMenu.setForeground(new Color(17, 198, 189));
		Detail_1_MainMenu.setFont(new Font("OCR A Extended", Font.BOLD, 38));
		Detail_1_MainMenu.setBorder(null);
		Detail_1_MainMenu.setBackground(new Color(37, 137, 175));
		Detail_1_MainMenu.setBounds(238, 249, 428, 22);
		MainMenu.add(Detail_1_MainMenu);
		
		SettingsMenu = new JPanel();
		SettingsMenu.setRequestFocusEnabled(false);
		SettingsMenu.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		SettingsMenu.setFocusable(false);
		SettingsMenu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(37, 137, 175), new Color(37, 137, 175), null, null));
		SettingsMenu.setBackground(new Color(18, 165, 162));
		SettingsMenu.setBounds(0, 0, 905, 520);
		frame.getContentPane().add(SettingsMenu);
		SettingsMenu.setLayout(null);
		
		Settings_Tabs = new JTabbedPane(JTabbedPane.TOP);
		Settings_Tabs.setRequestFocusEnabled(false);
		Settings_Tabs.setFocusable(false);
		Settings_Tabs.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Settings_Tabs.setBackground(new Color(166, 28, 77));
		Settings_Tabs.setForeground(new Color(166, 28, 77));
		Settings_Tabs.setFont(new Font("Lucida Console", Font.BOLD, 12));
		Settings_Tabs.setBounds(0, 0, 905, 520);
		SettingsMenu.add(Settings_Tabs);
		
		Exit_Mark_Settings = new JPanel();
		Exit_Mark_Settings.setBackground(new Color(0, 0, 0));
		Settings_Tabs.addTab("X", null, Exit_Mark_Settings, null);
		Settings_Tabs.setForegroundAt(0, new Color(238, 172, 189));
		Settings_Tabs.setEnabledAt(0, true);
		Settings_Tabs.setDisplayedMnemonicIndexAt(0, 0);
		Exit_Mark_Settings.setLayout(null);
		
		ApplicationSettings = new JPanel();
		ApplicationSettings.setFont(new Font("Lucida Console", Font.BOLD, 12));
		ApplicationSettings.setBackground(new Color(217, 36, 100));
		Settings_Tabs.addTab("Application Settings", null, ApplicationSettings, null);
		Settings_Tabs.setForegroundAt(1, new Color(238, 172, 189));
		Settings_Tabs.setEnabledAt(1, true);
		ApplicationSettings.setLayout(null);
		
		JLabel title_ApplicationSettings_Settings = new JLabel("Application Settings");
		title_ApplicationSettings_Settings.setHorizontalAlignment(SwingConstants.CENTER);
		title_ApplicationSettings_Settings.setForeground(new Color(242, 208, 215));
		title_ApplicationSettings_Settings.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		title_ApplicationSettings_Settings.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		title_ApplicationSettings_Settings.setBackground(new Color(204, 64, 88));
		title_ApplicationSettings_Settings.setBounds(159, 11, 576, 66);
		ApplicationSettings.add(title_ApplicationSettings_Settings);
		
		JLabel sub_title_ApplicationSettings_Settings = new JLabel("Blink, Blink, Blink, Blink, and Blink");
		sub_title_ApplicationSettings_Settings.setHorizontalAlignment(SwingConstants.CENTER);
		sub_title_ApplicationSettings_Settings.setForeground(new Color(242, 208, 215));
		sub_title_ApplicationSettings_Settings.setFont(new Font("Lucida Console", Font.BOLD, 12));
		sub_title_ApplicationSettings_Settings.setBorder(null);
		sub_title_ApplicationSettings_Settings.setBackground(new Color(37, 137, 175));
		sub_title_ApplicationSettings_Settings.setBounds(159, 34, 576, 57);
		ApplicationSettings.add(sub_title_ApplicationSettings_Settings);
		
		JPanel SettingName_ApplicationSettings = new JPanel();
		SettingName_ApplicationSettings.setBackground(new Color(217, 36, 100));
		SettingName_ApplicationSettings.setBounds(11, 118, 331, 57);
		SettingName_ApplicationSettings.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		ApplicationSettings.add(SettingName_ApplicationSettings);
		SettingName_ApplicationSettings.setLayout(null);
		
		JButton SettingName_Toggle = new JButton("OFF");
		SettingName_Toggle.setBounds(12, 11, 69, 38);
		SettingName_Toggle.setRequestFocusEnabled(false);
		SettingName_Toggle.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Toggle.setForeground(new Color(138, 32, 62));
		SettingName_Toggle.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		SettingName_Toggle.setFocusable(false);
		SettingName_Toggle.setFocusPainted(false);
		SettingName_Toggle.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		SettingName_Toggle.setBackground(new Color(204, 64, 88));
		SettingName_ApplicationSettings.add(SettingName_Toggle);
		
		JLabel SettingName_Title = new JLabel("Setting  -[ Name Here ]-");
		SettingName_Title.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title.setForeground(new Color(242, 208, 215));
		SettingName_Title.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_Title.setBackground(new Color(204, 64, 88));
		SettingName_Title.setBounds(79, 12, 239, 36);
		SettingName_ApplicationSettings.add(SettingName_Title);
		
		JPanel SettingName_ApplicationSettings_1 = new JPanel();
		SettingName_ApplicationSettings_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_ApplicationSettings_1.setLayout(null);
		SettingName_ApplicationSettings_1.setBackground(new Color(217, 36, 100));
		SettingName_ApplicationSettings_1.setBounds(10, 186, 332, 193);
		ApplicationSettings.add(SettingName_ApplicationSettings_1);
		
		JButton SettingName_Toggle_1 = new JButton("OFF");
		SettingName_Toggle_1.setRequestFocusEnabled(false);
		SettingName_Toggle_1.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Toggle_1.setForeground(new Color(138, 32, 62));
		SettingName_Toggle_1.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		SettingName_Toggle_1.setFocusable(false);
		SettingName_Toggle_1.setFocusPainted(false);
		SettingName_Toggle_1.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		SettingName_Toggle_1.setBackground(new Color(204, 64, 88));
		SettingName_Toggle_1.setBounds(12, 58, 69, 38);
		SettingName_ApplicationSettings_1.add(SettingName_Toggle_1);
		
		JLabel SettingName_Title_1 = new JLabel("Setting -[ Name Here ]-");
		SettingName_Title_1.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title_1.setForeground(new Color(242, 208, 215));
		SettingName_Title_1.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_Title_1.setBackground(new Color(143, 16, 54));
		SettingName_Title_1.setBounds(46, 11, 239, 36);
		SettingName_ApplicationSettings_1.add(SettingName_Title_1);
		
		JLabel SettingName_Title_1_1 = new JLabel("Sub-Setting (1) -[ Name Here ]-");
		SettingName_Title_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title_1_1.setForeground(new Color(242, 208, 215));
		SettingName_Title_1_1.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title_1_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_Title_1_1.setBackground(new Color(204, 64, 88));
		SettingName_Title_1_1.setBounds(79, 59, 239, 36);
		SettingName_ApplicationSettings_1.add(SettingName_Title_1_1);
		
		JLabel SettingName_Title_1_1_1 = new JLabel("Sub-Setting (2) -[ Name Here ]-");
		SettingName_Title_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title_1_1_1.setForeground(new Color(242, 208, 215));
		SettingName_Title_1_1_1.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title_1_1_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, new Color(170, 47, 71), null)));
		SettingName_Title_1_1_1.setBackground(new Color(204, 64, 88));
		SettingName_Title_1_1_1.setBounds(79, 100, 239, 36);
		SettingName_ApplicationSettings_1.add(SettingName_Title_1_1_1);
		
		JButton SettingName_Toggle_1_1 = new JButton("ON");
		SettingName_Toggle_1_1.setRequestFocusEnabled(false);
		SettingName_Toggle_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Toggle_1_1.setForeground(new Color(238, 172, 189));
		SettingName_Toggle_1_1.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		SettingName_Toggle_1_1.setFocusable(false);
		SettingName_Toggle_1_1.setFocusPainted(false);
		SettingName_Toggle_1_1.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		SettingName_Toggle_1_1.setBackground(new Color(204, 64, 88));
		SettingName_Toggle_1_1.setBounds(12, 99, 69, 38);
		SettingName_ApplicationSettings_1.add(SettingName_Toggle_1_1);
		
		JLabel SettingName_Title_1_1_2 = new JLabel("Sub-Setting (3) -[ Name Here ]-");
		SettingName_Title_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title_1_1_2.setForeground(new Color(242, 208, 215));
		SettingName_Title_1_1_2.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title_1_1_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_Title_1_1_2.setBackground(new Color(204, 64, 88));
		SettingName_Title_1_1_2.setBounds(79, 142, 239, 36);
		SettingName_ApplicationSettings_1.add(SettingName_Title_1_1_2);
		
		JButton SettingName_Toggle_1_2 = new JButton("OFF");
		SettingName_Toggle_1_2.setRequestFocusEnabled(false);
		SettingName_Toggle_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Toggle_1_2.setForeground(new Color(138, 32, 62));
		SettingName_Toggle_1_2.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		SettingName_Toggle_1_2.setFocusable(false);
		SettingName_Toggle_1_2.setFocusPainted(false);
		SettingName_Toggle_1_2.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		SettingName_Toggle_1_2.setBackground(new Color(204, 64, 88));
		SettingName_Toggle_1_2.setBounds(12, 141, 69, 38);
		SettingName_ApplicationSettings_1.add(SettingName_Toggle_1_2);
		
		JPanel UserSettings = new JPanel();
		UserSettings.setLayout(null);
		UserSettings.setFont(new Font("Lucida Console", Font.BOLD, 12));
		UserSettings.setBackground(new Color(217, 36, 100));
		Settings_Tabs.addTab("User Settings", null, UserSettings, null);
		Settings_Tabs.setForegroundAt(2, new Color(238, 172, 189));
		Settings_Tabs.setEnabledAt(2, true);
		
		JLabel title_UserSettings_Settings = new JLabel("User Settings");
		title_UserSettings_Settings.setHorizontalAlignment(SwingConstants.CENTER);
		title_UserSettings_Settings.setForeground(new Color(242, 208, 215));
		title_UserSettings_Settings.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		title_UserSettings_Settings.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		title_UserSettings_Settings.setBackground(new Color(204, 64, 88));
		title_UserSettings_Settings.setBounds(159, 11, 576, 66);
		UserSettings.add(title_UserSettings_Settings);
		
		JLabel sub_title_UserSettings_Settings = new JLabel("Blink, Blink, Blink, Blink, and Blink");
		sub_title_UserSettings_Settings.setHorizontalAlignment(SwingConstants.CENTER);
		sub_title_UserSettings_Settings.setForeground(new Color(242, 208, 215));
		sub_title_UserSettings_Settings.setFont(new Font("Lucida Console", Font.BOLD, 12));
		sub_title_UserSettings_Settings.setBorder(null);
		sub_title_UserSettings_Settings.setBackground(new Color(37, 137, 175));
		sub_title_UserSettings_Settings.setBounds(159, 34, 576, 57);
		UserSettings.add(sub_title_UserSettings_Settings);
		
		JPanel SettingName_UserSettings_2 = new JPanel();
		SettingName_UserSettings_2.setLayout(null);
		SettingName_UserSettings_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_UserSettings_2.setBackground(new Color(217, 36, 100));
		SettingName_UserSettings_2.setBounds(11, 118, 331, 57);
		UserSettings.add(SettingName_UserSettings_2);
		
		JButton SettingName_Toggle_2 = new JButton("OFF");
		SettingName_Toggle_2.setRequestFocusEnabled(false);
		SettingName_Toggle_2.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Toggle_2.setForeground(new Color(138, 32, 62));
		SettingName_Toggle_2.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		SettingName_Toggle_2.setFocusable(false);
		SettingName_Toggle_2.setFocusPainted(false);
		SettingName_Toggle_2.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		SettingName_Toggle_2.setBackground(new Color(204, 64, 88));
		SettingName_Toggle_2.setBounds(12, 11, 69, 38);
		SettingName_UserSettings_2.add(SettingName_Toggle_2);
		
		JLabel SettingName_Title_2 = new JLabel("Setting  -[ Name Here ]-");
		SettingName_Title_2.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title_2.setForeground(new Color(242, 208, 215));
		SettingName_Title_2.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_Title_2.setBackground(new Color(204, 64, 88));
		SettingName_Title_2.setBounds(79, 12, 239, 36);
		SettingName_UserSettings_2.add(SettingName_Title_2);
		
		JPanel SettingName_UserSettings_1 = new JPanel();
		SettingName_UserSettings_1.setLayout(null);
		SettingName_UserSettings_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_UserSettings_1.setBackground(new Color(217, 36, 100));
		SettingName_UserSettings_1.setBounds(10, 186, 332, 193);
		UserSettings.add(SettingName_UserSettings_1);
		
		JButton SettingName_Toggle_1_3 = new JButton("OFF");
		SettingName_Toggle_1_3.setRequestFocusEnabled(false);
		SettingName_Toggle_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Toggle_1_3.setForeground(new Color(138, 32, 62));
		SettingName_Toggle_1_3.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		SettingName_Toggle_1_3.setFocusable(false);
		SettingName_Toggle_1_3.setFocusPainted(false);
		SettingName_Toggle_1_3.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		SettingName_Toggle_1_3.setBackground(new Color(204, 64, 88));
		SettingName_Toggle_1_3.setBounds(12, 58, 69, 38);
		SettingName_UserSettings_1.add(SettingName_Toggle_1_3);
		
		JLabel SettingName_Title_1_2 = new JLabel("Setting -[ Name Here ]-");
		SettingName_Title_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title_1_2.setForeground(new Color(242, 208, 215));
		SettingName_Title_1_2.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title_1_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_Title_1_2.setBackground(new Color(143, 16, 54));
		SettingName_Title_1_2.setBounds(46, 11, 239, 36);
		SettingName_UserSettings_1.add(SettingName_Title_1_2);
		
		JLabel SettingName_Title_1_1_3 = new JLabel("Sub-Setting (1) -[ Name Here ]-");
		SettingName_Title_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title_1_1_3.setForeground(new Color(242, 208, 215));
		SettingName_Title_1_1_3.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title_1_1_3.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_Title_1_1_3.setBackground(new Color(204, 64, 88));
		SettingName_Title_1_1_3.setBounds(79, 59, 239, 36);
		SettingName_UserSettings_1.add(SettingName_Title_1_1_3);
		
		JLabel SettingName_Title_1_1_1_1 = new JLabel("Sub-Setting (2) -[ Name Here ]-");
		SettingName_Title_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title_1_1_1_1.setForeground(new Color(242, 208, 215));
		SettingName_Title_1_1_1_1.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title_1_1_1_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, new Color(170, 47, 71), null)));
		SettingName_Title_1_1_1_1.setBackground(new Color(204, 64, 88));
		SettingName_Title_1_1_1_1.setBounds(79, 100, 239, 36);
		SettingName_UserSettings_1.add(SettingName_Title_1_1_1_1);
		
		JButton SettingName_Toggle_1_1_1 = new JButton("ON");
		SettingName_Toggle_1_1_1.setRequestFocusEnabled(false);
		SettingName_Toggle_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Toggle_1_1_1.setForeground(new Color(238, 172, 189));
		SettingName_Toggle_1_1_1.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		SettingName_Toggle_1_1_1.setFocusable(false);
		SettingName_Toggle_1_1_1.setFocusPainted(false);
		SettingName_Toggle_1_1_1.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		SettingName_Toggle_1_1_1.setBackground(new Color(204, 64, 88));
		SettingName_Toggle_1_1_1.setBounds(12, 99, 69, 38);
		SettingName_UserSettings_1.add(SettingName_Toggle_1_1_1);
		
		JLabel SettingName_Title_1_1_2_1 = new JLabel("Sub-Setting (3) -[ Name Here ]-");
		SettingName_Title_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Title_1_1_2_1.setForeground(new Color(242, 208, 215));
		SettingName_Title_1_1_2_1.setFont(new Font("Lucida Console", Font.BOLD, 12));
		SettingName_Title_1_1_2_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(170, 47, 71), null)));
		SettingName_Title_1_1_2_1.setBackground(new Color(204, 64, 88));
		SettingName_Title_1_1_2_1.setBounds(79, 142, 239, 36);
		SettingName_UserSettings_1.add(SettingName_Title_1_1_2_1);
		
		JButton SettingName_Toggle_1_2_1 = new JButton("OFF");
		SettingName_Toggle_1_2_1.setRequestFocusEnabled(false);
		SettingName_Toggle_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		SettingName_Toggle_1_2_1.setForeground(new Color(138, 32, 62));
		SettingName_Toggle_1_2_1.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		SettingName_Toggle_1_2_1.setFocusable(false);
		SettingName_Toggle_1_2_1.setFocusPainted(false);
		SettingName_Toggle_1_2_1.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		SettingName_Toggle_1_2_1.setBackground(new Color(204, 64, 88));
		SettingName_Toggle_1_2_1.setBounds(12, 141, 69, 38);
		SettingName_UserSettings_1.add(SettingName_Toggle_1_2_1);
		
		Settings_Tabs.setSelectedIndex(1);
		
		JPanel Presets = new JPanel();
		Presets.setEnabled(false);
		Presets.setLayout(null);
		Presets.setFont(new Font("SimSun-ExtB", Font.BOLD, 12));
		Presets.setFocusable(false);
		Presets.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(37, 137, 175), new Color(37, 137, 175), null, null));
		Presets.setBackground(new Color(18, 165, 162));
		Presets.setBounds(0, 0, 905, 520);
		frame.getContentPane().add(Presets);
		
		JLabel Detail_1 = new JLabel("--------------");
		Detail_1.setHorizontalAlignment(SwingConstants.CENTER);
		Detail_1.setForeground(new Color(17, 198, 189));
		Detail_1.setFont(new Font("OCR A Extended", Font.BOLD, 38));
		Detail_1.setBorder(null);
		Detail_1.setBackground(new Color(37, 137, 175));
		Detail_1.setBounds(0, 0, 428, 22);
		Presets.add(Detail_1);
		
		JButton ButtonDefault_1 = new JButton("Text");
		ButtonDefault_1.setFocusable(false);
		ButtonDefault_1.setFocusTraversalKeysEnabled(false);
		ButtonDefault_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonDefault_1.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonDefault_1.setForeground(new Color(199, 240, 248));
		ButtonDefault_1.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		ButtonDefault_1.setFocusPainted(false);
		ButtonDefault_1.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		ButtonDefault_1.setBackground(new Color(37, 137, 175));
		ButtonDefault_1.setBounds(10, 471, 154, 38);
		Presets.add(ButtonDefault_1);
		
		JLabel TextDefault_1 = new JLabel("Text");
		TextDefault_1.setHorizontalAlignment(SwingConstants.CENTER);
		TextDefault_1.setForeground(new Color(199, 240, 248));
		TextDefault_1.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		TextDefault_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, new Color(37, 137, 175), null)));
		TextDefault_1.setBackground(new Color(37, 137, 175));
		TextDefault_1.setBounds(174, 471, 154, 38);
		Presets.add(TextDefault_1);
	}
}