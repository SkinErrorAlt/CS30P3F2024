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
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

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
		
		JButton Calculate = new JButton("Calculate");
		Calculate.setBounds(89, 337, 146, 35);
		Calculate.setToolTipText("Calulates your avarage");
		Calculate.setBackground(Color.DARK_GRAY);
		Calculate.setForeground(Color.LIGHT_GRAY);
		Calculate.setVisible(false);
		Semesters.setLayout(null);
		Semesters.add(Calculate);
		
		TextField FirstSemester = new TextField();
		FirstSemester.setFocusTraversalKeysEnabled(false);
		FirstSemester.setName("FirstSemester");
		FirstSemester.setText("Enter First Grade");
		FirstSemester.setBounds(89, 53, 140, 22);
        FirstSemester.setSelectionStart(5);
        FirstSemester.setForeground(Color.GRAY);
        FirstSemester.setBackground(Color.WHITE);
        FirstSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
        Semesters.add(FirstSemester);
        
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
						System.out.println("Key pressed: [" + e.getKeyChar() + "]");
					}
				}
				else 
				{
					e.consume();
				}
			}
		});
        
        FirstSemester.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				toggleTipText(FirstSemester);
			}
        	@Override
        	public void focusLost(FocusEvent e) 
        	{
        		toggleTipText(FirstSemester);
        	}
		});
		
		TextField SecondSemester = new TextField();
		SecondSemester.setFocusTraversalKeysEnabled(false);
		SecondSemester.setText("Enter Second Grade");
		SecondSemester.setName("SecondSemester");
		SecondSemester.setBounds(89, 105, 140, 22);
		SecondSemester.setForeground(Color.GRAY);
		SecondSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		SecondSemester.setBackground(Color.WHITE);
		Semesters.add(SecondSemester);
		
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
						System.out.println("Key pressed: [" + e.getKeyChar() + "]");
					}
				}
				else 
				{
					e.consume();
				}
			}
		});
		
		SecondSemester.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				toggleTipText(SecondSemester);
			}
        	@Override
        	public void focusLost(FocusEvent e) 
        	{
        		toggleTipText(SecondSemester);
        	}
		});
		
		TextField ThirdSemester = new TextField();
		ThirdSemester.setFocusTraversalKeysEnabled(false);
		ThirdSemester.setText("Enter Third Grade");
		ThirdSemester.setName("ThirdSemester");
		ThirdSemester.setBounds(89, 160, 140, 22);
		ThirdSemester.setForeground(Color.GRAY);
		ThirdSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		ThirdSemester.setBackground(Color.WHITE);
		Semesters.add(ThirdSemester);
		
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
						System.out.println("Key pressed: [" + e.getKeyChar() + "]");
					}
				}
				else 
				{
					e.consume();
				}
			}
		});
		
		ThirdSemester.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				toggleTipText(ThirdSemester);
			}
        	@Override
        	public void focusLost(FocusEvent e) 
        	{
        		toggleTipText(ThirdSemester);
        	}
		});
		
		JLabel Semester1 = new JLabel("Semester 1");
		Semester1.setBounds(10, 50, 73, 25);
		Semester1.setBackground(Color.DARK_GRAY);
		Semester1.setHorizontalAlignment(SwingConstants.CENTER);
		Semester1.setForeground(Color.DARK_GRAY);
		Semester1.setFont(new Font("Dialog", Font.BOLD, 13));
		Semesters.add(Semester1);
		
		JLabel Semester2 = new JLabel("Semester 2");
		Semester2.setBounds(10, 105, 73, 22);
		Semester2.setBackground(Color.DARK_GRAY);
		Semester2.setHorizontalAlignment(SwingConstants.CENTER);
		Semester2.setForeground(Color.DARK_GRAY);
		Semester2.setFont(new Font("Dialog", Font.BOLD, 13));
		Semesters.add(Semester2);
		
		JLabel Semester3 = new JLabel("Semester 3");
		Semester3.setBounds(10, 160, 71, 25);
		Semester3.setBackground(Color.DARK_GRAY);
		Semester3.setHorizontalAlignment(SwingConstants.CENTER);
		Semester3.setForeground(Color.DARK_GRAY);
		Semester3.setFont(new Font("Dialog", Font.BOLD, 13));
		Semesters.add(Semester3);
		
		JLabel Sem1_ErrorMessage = new JLabel("");
		Sem1_ErrorMessage.setBounds(89, 70, 194, 25);
		Sem1_ErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		Sem1_ErrorMessage.setForeground(Color.DARK_GRAY);
		Sem1_ErrorMessage.setFont(new Font("Dialog", Font.BOLD, 13));
		Sem1_ErrorMessage.setBackground(Color.DARK_GRAY);
		Semesters.add(Sem1_ErrorMessage);
		
		JLabel Sem2_ErrorMessage = new JLabel("");
		Sem2_ErrorMessage.setBounds(89, 129, 194, 25);
		Sem2_ErrorMessage.setEnabled(false);
		Sem2_ErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		Sem2_ErrorMessage.setForeground(Color.DARK_GRAY);
		Sem2_ErrorMessage.setFont(new Font("Dialog", Font.BOLD, 13));
		Sem2_ErrorMessage.setBackground(Color.DARK_GRAY);
		Semesters.add(Sem2_ErrorMessage);
		
		JLabel Sem3_ErrorMessage = new JLabel("");
		Sem3_ErrorMessage.setBounds(89, 185, 194, 25);
		Sem3_ErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		Sem3_ErrorMessage.setForeground(Color.DARK_GRAY);
		Sem3_ErrorMessage.setFont(new Font("Dialog", Font.BOLD, 13));
		Sem3_ErrorMessage.setBackground(Color.DARK_GRAY);
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
	
	public static <c> Object checkChar(TextField semester, char Character) 
	{
		String fullText = semester.getText() + Character;
		
		System.out.println("Testing: " + Character);
		
		try 
		{
		    if (!(semester.getText() + Character).equals(""))
		    {
		    	char FirstChar = fullText.charAt(0);
		    	int x = Integer.parseInt(fullText);
		    	
		    	System.out.println("FirstChar = [ " + x + " ]");
		    	
		    	if (FirstChar != '0') 
			    {
				    
				    if (x >= 0 && x <= 100) 
				    {
				    	return Character;
				    }
				    else 
				    {
				    	return null;
				    }
			    }
			    else 
			    {
			    	if (!semester.getText().equals("")) 
			    	{
			    		if (Character == '0') 
				    	{
				    		return ' '; // Stops the input.
				    	}
				    	else 
				    	{
				    		semester.setText("" + Character);
				    		semester.setCaretPosition(1);
				    		return ' ';
				    	}
			    	}
			    	else 
			    	{
			    		return Character;
			    	}
			    }
		    }
		    else 
		    {
		    	return Character;
		    }
		    
		} 
		catch (NumberFormatException n) 
		{
		    System.out.println("Not a number");
		    return null; // Stops the input.
		}
	}
	
	public static void toggleTipText(TextField semester) 
	{
		String text = semester.getText();
		boolean focused = semester.hasFocus();
		
		if (focused) 
		{
			if (text.equals("Enter First Grade") || text.equals("Enter Second Grade") || text.equals("Enter Third Grade") || text.equals("Null")) 
			{
				semester.setText("");
			}
			
			semester.setBounds(semester.getBounds().x, semester.getBounds().y, 29, semester.getBounds().height);
			semester.setForeground(Color.black);
		}
		else 
		{
			if (text.equals("")) 
			{
				if (semester.getName() == "FirstSemester") 
				{
					semester.setText("Enter First Grade");
				}
				else if (semester.getName() == "SecondSemester")
				{
					semester.setText("Enter Second Grade");
				}
				else if (semester.getName() == "ThirdSemester")
				{
					semester.setText("Enter Third Grade");
				}
				else 
				{
					semester.setText("Null");
				}
				
				semester.setBounds(semester.getBounds().x, semester.getBounds().y, 140, semester.getBounds().height);
			}
			else 
			{
				semester.setBounds(semester.getBounds().x, semester.getBounds().y, 29, semester.getBounds().height);
			}
			
			semester.setForeground(Color.gray);
		}
		
	}
}