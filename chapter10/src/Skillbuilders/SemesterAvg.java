package Skillbuilders;

import java.awt.EventQueue;
import EasyKit.Text;
import SkillbuildersData.SemesterAvg_Data;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.color.ICC_ColorSpace;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JProgressBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Box;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.util.ArrayList;
import java.util.List;
import EasyKit.Ui;
@SuppressWarnings("unused")

public class SemesterAvg {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterAvg window = new SemesterAvg();
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
	
	public SemesterAvg() {
		initialize();
	}

	private static JLabel AvgGrade = new JLabel("Average Grade: 0");
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 379, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Title = new JLabel("Average Grade Calculator");
		Title.setForeground(Color.WHITE);
		Title.setBounds(30, 11, 306, 22);
		Title.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Title.setBackground(new Color(255, 128, 128));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Title);
		
		Panel Semesters = new Panel();
		Ui.UiSetup(Semesters);
		
		Semesters.setBackground(Color.PINK);
		Semesters.setForeground(new Color(255, 128, 128));
		Semesters.setBounds(30, 46, 306, 383);
		frame.getContentPane().add(Semesters);
		Semesters.setLayout(null);
		
		JTextField FirstSemester = new JTextField();
		FirstSemester.setFocusTraversalKeysEnabled(false);
		FirstSemester.setName("FirstSemester");
		FirstSemester.setText("Enter First Grade");
		FirstSemester.setBounds(89, 53, 140, 22);
        FirstSemester.setSelectionStart(5);
        FirstSemester.setForeground(Color.GRAY);
        FirstSemester.setBackground(Color.WHITE);
        FirstSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
        Semesters.add(FirstSemester);
        
        Ui.TextFieldSetup(FirstSemester, Ui.textFieldType.NumberRange, Color.black, true);
        
        FirstSemester.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				Ui.toggleTipText(FirstSemester);
			}
        	@Override
        	public void focusLost(FocusEvent e) 
        	{
        		Ui.toggleTipText(FirstSemester);
        	}
		});
		
        JTextField SecondSemester = new JTextField();
		SecondSemester.setFocusTraversalKeysEnabled(false);
		SecondSemester.setText("Enter Second Grade");
		SecondSemester.setName("SecondSemester");
		SecondSemester.setBounds(89, 105, 140, 22);
		SecondSemester.setForeground(Color.GRAY);
		SecondSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		SecondSemester.setBackground(Color.WHITE);
		Semesters.add(SecondSemester);
		
		Ui.TextFieldSetup(SecondSemester, Ui.textFieldType.NumberRange, Color.black, true);
		
		SecondSemester.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				Ui.toggleTipText(SecondSemester);
			}
        	@Override
        	public void focusLost(FocusEvent e) 
        	{
        		Ui.toggleTipText(SecondSemester);
        	}
		});
		
		JTextField ThirdSemester = new JTextField();
		ThirdSemester.setFocusTraversalKeysEnabled(false);
		ThirdSemester.setText("Enter Third Grade");
		ThirdSemester.setName("ThirdSemester");
		ThirdSemester.setBounds(89, 160, 140, 22);
		ThirdSemester.setForeground(Color.GRAY);
		ThirdSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		ThirdSemester.setBackground(Color.WHITE);
		Semesters.add(ThirdSemester);
		
		Ui.TextFieldSetup(ThirdSemester, Ui.textFieldType.NumberRange, Color.black, true);
		
		ThirdSemester.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				Ui.toggleTipText(ThirdSemester);
			}
        	@Override
        	public void focusLost(FocusEvent e) 
        	{
        		Ui.toggleTipText(ThirdSemester);
        	}
		});
		
		JLabel Semester1 = new JLabel("Semester 1");
		Semester1.setBounds(10, 50, 73, 25);
		Semester1.setBackground(Color.WHITE);
		Semester1.setHorizontalAlignment(SwingConstants.CENTER);
		Semester1.setForeground(Color.WHITE);
		Semester1.setFont(new Font("Dialog", Font.BOLD, 13));
		Semesters.add(Semester1);
		
		JLabel Semester2 = new JLabel("Semester 2");
		Semester2.setBounds(10, 105, 73, 22);
		Semester2.setBackground(Color.WHITE);
		Semester2.setHorizontalAlignment(SwingConstants.CENTER);
		Semester2.setForeground(Color.WHITE);
		Semester2.setFont(new Font("Dialog", Font.BOLD, 13));
		Semesters.add(Semester2);
		
		JLabel Semester3 = new JLabel("Semester 3");
		Semester3.setBounds(10, 160, 71, 25);
		Semester3.setBackground(Color.WHITE);
		Semester3.setHorizontalAlignment(SwingConstants.CENTER);
		Semester3.setForeground(Color.WHITE);
		Semester3.setFont(new Font("Dialog", Font.BOLD, 13));
		Semesters.add(Semester3);
		AvgGrade.setForeground(Color.WHITE);

		AvgGrade.setBackground(Color.WHITE);
		AvgGrade.setFont(new Font("Verdana", Font.BOLD, 15));
		AvgGrade.setBounds(44, 298, 209, 25);
		Semesters.add(AvgGrade);
		
		Ui.focusChange(null);
		
		FirstSemester.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				Object check = checkChar(FirstSemester, e.getKeyChar());
				
				if (check != null) 
				{
					if ((char) check == ' ') 
					{
						e.consume();
					}
					else 
					{
						int x = Integer.parseInt(FirstSemester.getText() + e.getKeyChar());
						System.out.println(x);
						if (x >= 0 && x <= 100) 
					    {
							SemesterAvg_Data.UpdateRating(FirstSemester, x);
					    	AvgGrade.setText("Average Grade: " + SemesterAvg_Data.GetAvg());
					    }
					}
				}
				else 
				{
					e.consume();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) // Checks if the user pressed Enter.
				{
					Ui.focusChange(SecondSemester);
				}
			}
		});
		
		SecondSemester.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				Object check = checkChar(SecondSemester, e.getKeyChar());
				
				if (check != null) 
				{
					if ((char) check == ' ') 
					{
						e.consume();
					}
					else 
					{
						int x = Integer.parseInt(SecondSemester.getText() + e.getKeyChar());
						System.out.println(x);
						if (x >= 0 && x <= 100) 
					    {
							SemesterAvg_Data.UpdateRating(SecondSemester, x);
					    	AvgGrade.setText("Average Grade: " + SemesterAvg_Data.GetAvg());
					    }
					}
				}
				else 
				{
					e.consume();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) // Checks if the user pressed Enter.
				{
					Ui.focusChange(ThirdSemester);
				}
			}
		});
		
		ThirdSemester.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				Object check = checkChar(ThirdSemester, e.getKeyChar());
				
				if (check != null) 
				{
					if ((char) check == ' ') 
					{
						e.consume();
					}
					else 
					{
						int x = Integer.parseInt(ThirdSemester.getText() + e.getKeyChar());
						System.out.println(x);
						if (x >= 0 && x <= 100) 
					    {
							SemesterAvg_Data.UpdateRating(ThirdSemester, x);
					    	AvgGrade.setText("Average Grade: " + SemesterAvg_Data.GetAvg());
					    }
					}
				}
				else 
				{
					e.consume();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) // Checks if the user pressed Enter.
				{
					Ui.focusChange(FirstSemester);
				}
			}
		});
	}
	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public static <c> Object checkChar(JTextField secondSemester, char Character) 
	{
		String fullText = secondSemester.getText() + Character;
	
		try 
		{
			char FirstChar = fullText.charAt(0);
	    	int x = Integer.parseInt(fullText);
	    	String fullNumberText = secondSemester.getText() + x;
	    	
		    if (!(secondSemester.getText() + Character).equals(""))
		    {
		    	if (FirstChar != '0') 
			    {
				    if (x >= 0 && x <= 100) 
				    {
				    	
				    	if (fullText.length() > 1) 
						{
							secondSemester.setBounds(secondSemester.getBounds().x, secondSemester.getBounds().y, 11 * fullText.length(), secondSemester.getBounds().height);
						}
						else 
						{
							secondSemester.setBounds(secondSemester.getBounds().x, secondSemester.getBounds().y, 15, secondSemester.getBounds().height);
						}
				    					    	
				    	return Character;
				    }
				    else 
				    {	    	
				    	return null;
				    }
			    }
			    else 
			    {
			    	if (!secondSemester.getText().equals("")) 
			    	{
			    		if (Character == '0') 
				    	{
				    		return ' '; // Stops the input.
				    	}
				    	else 
				    	{	
				    		SemesterAvg_Data.UpdateRating(secondSemester, x);
					    	AvgGrade.setText("Average Grade: " + SemesterAvg_Data.GetAvg());
					    	
				    		secondSemester.setText("" + Character);
				    		secondSemester.setCaretPosition(1);
				    		return ' ';
				    	}
			    	}
			    	else 
			    	{
			    		secondSemester.setBounds(secondSemester.getBounds().x, secondSemester.getBounds().y, 15, secondSemester.getBounds().height);
			    		return Character;
			    	}
			    }
		    }
		    else 
		    {
		    	System.out.println("Test");
		    	SemesterAvg_Data.UpdateRating(secondSemester, x);
		    	AvgGrade.setText("Average Grade: " + SemesterAvg_Data.GetAvg());
		    	
		    	return Character;
		    }
		    
		} 
		catch (NumberFormatException n) 
		{
		    if (Character == '') 
		    {
		    	if (fullText.length() > 0) 
				{
		    		if (fullText.length() > 1) 
		    		{
		    			SemesterAvg_Data.UpdateRating(secondSemester, Integer.parseInt(secondSemester.getText()));
				    	AvgGrade.setText("Average Grade: " + SemesterAvg_Data.GetAvg());
		    		}
		    		else 
		    		{
		    			SemesterAvg_Data.UpdateRating(secondSemester, -1);
				    	AvgGrade.setText("Average Grade: " + SemesterAvg_Data.GetAvg());
		    		}
			    	
		    		if (secondSemester.getText().equals("0")) 
					{
						secondSemester.setBounds(secondSemester.getBounds().x, secondSemester.getBounds().y, 15, secondSemester.getBounds().height);
					}
					else 
					{
						secondSemester.setBounds(secondSemester.getBounds().x, secondSemester.getBounds().y, 9 * fullText.length(), secondSemester.getBounds().height);
					}
				}
				else 
				{
					secondSemester.setBounds(secondSemester.getBounds().x, secondSemester.getBounds().y, 15, secondSemester.getBounds().height);
				}
		    	
		    	return null; // Stops the input.
		    }
	    	
		    return null; // Stops the input.
		}
	}
}