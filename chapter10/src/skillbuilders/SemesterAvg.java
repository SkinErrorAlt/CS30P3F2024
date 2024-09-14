package skillbuilders;

import java.awt.EventQueue;
import EasyKit.Text;

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
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 379, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Title = new JLabel("Average Grade Calculator");
		Title.setBounds(30, 0, 306, 22);
		Title.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Title.setBackground(new Color(255, 128, 128));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Title);
		
		Panel Semesters = new Panel();
	
		Semesters.setBackground(Color.GRAY);
		Semesters.setForeground(new Color(255, 128, 128));
		Semesters.setBounds(30, 47, 306, 383);
		frame.getContentPane().add(Semesters);
		Semesters.setLayout(null);
		
		JButton Calculate = new JButton("Calculate");
		Calculate.setEnabled(false);
		Calculate.setBounds(76, 297, 146, 35);
		Semesters.add(Calculate);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setToolTipText("Calculate Average");
		progressBar.setForeground(Color.DARK_GRAY);
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setBounds(76, 297, 146, 35);
		Semesters.add(progressBar);
		
		TextField FirstSemester = new TextField();

        FirstSemester.setSelectionStart(5);
        FirstSemester.setForeground(new Color(0, 0, 0));
        FirstSemester.setBackground(Color.WHITE);
        FirstSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
        FirstSemester.setBounds(89, 48, 194, 25);
        Semesters.add(FirstSemester);
		
		TextField SecondSemester = new TextField();
		SecondSemester.setSelectionStart(5);
		SecondSemester.setForeground(Color.BLACK);
		SecondSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		SecondSemester.setBackground(Color.WHITE);
		SecondSemester.setBounds(89, 90, 194, 25);
		Semesters.add(SecondSemester);
		
		TextField ThirdSemester = new TextField();
		ThirdSemester.setSelectionStart(5);
		ThirdSemester.setForeground(Color.BLACK);
		ThirdSemester.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		ThirdSemester.setBackground(Color.WHITE);
		ThirdSemester.setBounds(89, 133, 194, 25);
		Semesters.add(ThirdSemester);
		
		JLabel Semester1 = new JLabel("Semester 1");
		Semester1.setHorizontalAlignment(SwingConstants.CENTER);
		Semester1.setForeground(Color.WHITE);
		Semester1.setFont(new Font("Dialog", Font.BOLD, 13));
		Semester1.setBounds(10, 50, 73, 25);
		Semesters.add(Semester1);
		
		JLabel Semester2 = new JLabel("Semester 2");
		Semester2.setHorizontalAlignment(SwingConstants.CENTER);
		Semester2.setForeground(Color.WHITE);
		Semester2.setFont(new Font("Dialog", Font.BOLD, 13));
		Semester2.setBounds(10, 94, 73, 22);
		Semesters.add(Semester2);
		
		JLabel Semester3 = new JLabel("Semester 3");
		Semester3.setHorizontalAlignment(SwingConstants.CENTER);
		Semester3.setForeground(Color.WHITE);
		Semester3.setFont(new Font("Dialog", Font.BOLD, 13));
		Semester3.setBounds(10, 133, 71, 25);
		Semesters.add(Semester3);
	}
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
}