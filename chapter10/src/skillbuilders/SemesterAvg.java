package skillbuilders;

import java.awt.EventQueue;
import EasyKit.Text;
import skillbuilders.SemesterAvg_Data;

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
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(panel);
		
		JLabel Title = new JLabel("Average Grade Calculator");
		Title.setForeground(Color.WHITE);
		Title.setBounds(30, 11, 306, 22);
		Title.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Title.setBackground(new Color(255, 128, 128));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Title);
		
		Panel Semesters = new Panel();
	
		Semesters.setBackground(Color.LIGHT_GRAY);
		Semesters.setForeground(new Color(255, 128, 128));
		Semesters.setBounds(30, 47, 306, 383);
		frame.getContentPane().add(Semesters);
		Semesters.setLayout(null);
		
		JButton Calculate = new JButton("Calculate");
		Calculate.setToolTipText("Calulates your avarage");
		Calculate.setBackground(Color.DARK_GRAY);
		Calculate.setForeground(Color.LIGHT_GRAY);
		Calculate.setBounds(89, 337, 146, 35);
		Calculate.setVisible(false);
		Semesters.add(Calculate);
		
		TextField FirstSemester = new TextField();
		FirstSemester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object check = checkChar(FirstSemester, e);
				
				if (check != null) 
				{
					if (check.equals(' ')) 
					{
						e.consume();
						EasyKit.Text.print("0 Already there. No changes made.");
					}
					EasyKit.Text.print("Worked");
				}
				else 
				{
					e.consume();
					EasyKit.Text.print("Failed");
				}
				
				if (SemesterAvg_Data.getSem() == 3) 
		    	{
					Calculate.setVisible(true);
		    	}
		    	else 
		    	{
		    		Calculate.setVisible(false);
		    	}
			}
		});

        FirstSemester.setSelectionStart(5);
        FirstSemester.setForeground(new Color(0, 0, 0));
        FirstSemester.setBackground(Color.WHITE);
        FirstSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
        FirstSemester.setBounds(89, 48, 194, 25);
        Semesters.add(FirstSemester);
		
		TextField SecondSemester = new TextField();
		SecondSemester.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				int x = 0;
				try 
				{
				    if (!SecondSemester.getText().equals("")) 
				    {
				    	char FirstChar = SecondSemester.getText().charAt(0);
				    	
				    	if (FirstChar != '0') 
					    {
				    		x = Integer.parseInt(SecondSemester.getText() + e.getKeyChar());
						    
						    if (x >= 0 && x <= 100) 
						    {
						    	Text.print("Just Right");
						    	SemesterAvg_Data.changeSem(1);
						    }
						    else 
						    {
						    	e.consume();
						    	Text.print("Above 100%");
						    }
					    }
					    else 
					    {
					    	SecondSemester.setText("");
					    }
				    }
				    
				} 
				catch (NumberFormatException n) 
				{
					e.consume();
				    System.out.println("Not a number");
				}
				
				if (SemesterAvg_Data.getSem() == 3) 
		    	{
					Calculate.setVisible(true);
		    	}
		    	else 
		    	{
		    		Calculate.setVisible(false);
		    	}
			}
		});
		SecondSemester.setSelectionStart(5);
		SecondSemester.setForeground(Color.BLACK);
		SecondSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		SecondSemester.setBackground(Color.WHITE);
		SecondSemester.setBounds(89, 101, 194, 25);
		Semesters.add(SecondSemester);
		
		TextField ThirdSemester = new TextField();
		ThirdSemester.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				int x = 0;
				try 
				{
				    if (!ThirdSemester.getText().equals("")) 
				    {
				    	char FirstChar = ThirdSemester.getText().charAt(0);
				    	
				    	if (FirstChar != '0') 
					    {
				    		x = Integer.parseInt(ThirdSemester.getText() + e.getKeyChar());
						    
						    if (x >= 0 && x <= 100) 
						    {
						    	Text.print("Just Right");
						    	SemesterAvg_Data.changeSem(1);
						    }
						    else 
						    {
						    	e.consume();
						    	Text.print("Above 100%");
						    }
					    }
					    else 
					    {
					    	ThirdSemester.setText("");
					    }
				    }
				    
				} 
				catch (NumberFormatException n) 
				{
					e.consume();
				    System.out.println("Not a number");
				}
				
				if (SemesterAvg_Data.getSem() == 3) 
		    	{
					Calculate.setVisible(true);
		    	}
		    	else 
		    	{
		    		Calculate.setVisible(false);
		    	}
			}
		});
		ThirdSemester.setSelectionStart(5);
		ThirdSemester.setForeground(Color.BLACK);
		ThirdSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		ThirdSemester.setBackground(Color.WHITE);
		ThirdSemester.setBounds(89, 160, 194, 25);
		Semesters.add(ThirdSemester);
		
		JLabel Semester1 = new JLabel("Semester 1");
		Semester1.setBackground(Color.DARK_GRAY);
		Semester1.setHorizontalAlignment(SwingConstants.CENTER);
		Semester1.setForeground(Color.DARK_GRAY);
		Semester1.setFont(new Font("Dialog", Font.BOLD, 13));
		Semester1.setBounds(10, 50, 73, 25);
		Semesters.add(Semester1);
		
		JLabel Semester2 = new JLabel("Semester 2");
		Semester2.setBackground(Color.DARK_GRAY);
		Semester2.setHorizontalAlignment(SwingConstants.CENTER);
		Semester2.setForeground(Color.DARK_GRAY);
		Semester2.setFont(new Font("Dialog", Font.BOLD, 13));
		Semester2.setBounds(10, 105, 73, 22);
		Semesters.add(Semester2);
		
		JLabel Semester3 = new JLabel("Semester 3");
		Semester3.setBackground(Color.DARK_GRAY);
		Semester3.setHorizontalAlignment(SwingConstants.CENTER);
		Semester3.setForeground(Color.DARK_GRAY);
		Semester3.setFont(new Font("Dialog", Font.BOLD, 13));
		Semester3.setBounds(10, 160, 71, 25);
		Semesters.add(Semester3);
		
		JLabel Sem1_ErrorMessage = new JLabel("");
		Sem1_ErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		Sem1_ErrorMessage.setForeground(Color.DARK_GRAY);
		Sem1_ErrorMessage.setFont(new Font("Dialog", Font.BOLD, 13));
		Sem1_ErrorMessage.setBackground(Color.DARK_GRAY);
		Sem1_ErrorMessage.setBounds(89, 70, 194, 25);
		Semesters.add(Sem1_ErrorMessage);
		
		JLabel Sem2_ErrorMessage = new JLabel("");
		Sem2_ErrorMessage.setEnabled(false);
		Sem2_ErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		Sem2_ErrorMessage.setForeground(Color.DARK_GRAY);
		Sem2_ErrorMessage.setFont(new Font("Dialog", Font.BOLD, 13));
		Sem2_ErrorMessage.setBackground(Color.DARK_GRAY);
		Sem2_ErrorMessage.setBounds(89, 129, 194, 25);
		Semesters.add(Sem2_ErrorMessage);
		
		JLabel Sem3_ErrorMessage = new JLabel("");
		Sem3_ErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		Sem3_ErrorMessage.setForeground(Color.DARK_GRAY);
		Sem3_ErrorMessage.setFont(new Font("Dialog", Font.BOLD, 13));
		Sem3_ErrorMessage.setBackground(Color.DARK_GRAY);
		Sem3_ErrorMessage.setBounds(89, 185, 194, 25);
		Semesters.add(Sem3_ErrorMessage);
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
	
	public static <c> Object checkChar(TextField semester, ActionEvent e) 
	{
		List<Character> blockedCharacters = new ArrayList<>();
		
		String fullText = semester.getText() + e.getKeyChar();
		
		System.out.println("");
		
		try 
		{
		    if (!semester.getText().equals(""))
		    {
		    	char FirstChar = fullText.charAt(0);
		    	System.out.println("FirstChar = [ " + e.getKeyChar() + " ]");
		    	
		    	if (FirstChar != '0') 
			    {
		    		int x = Integer.parseInt(fullText);
				    
				    if (x >= 0 && x <= 100) 
				    {
				    	Text.print("Just Right");
				    	return e.getKeyChar();
				    }
				    else 
				    {
				    	Text.print("Above 100%");
				    	return null;
				    }
			    }
			    else 
			    {
			    	EasyKit.Text.print("Replace Nothing");
			    	return ' ';
			    }
		    }
		    else 
		    {
		    	return e.getKeyChar();
		    }
		    
		} 
		catch (NumberFormatException n) 
		{
		    System.out.println("Not a number");
		    return null; // Stops the input.
		}
	}
}