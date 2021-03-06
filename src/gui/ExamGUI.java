package gui;

import java.awt.Color;
import java.awt.Panel;
import main.Controller;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JCheckBox;




public class ExamGUI {

	public static JFrame frmTest;
	public int idUser;
	public int index;
	public static boolean clicked;
	public static JTextField textField;
	public static JLabel lblQuestion;
	public static JButton btnNext;
	public static JLabel lblExamName;
	public static JLabel lblPomtext;
	public static JLabel lblIndicator;
	public static JButton btnStart;
	public static JLabel txtHint;
	public static JProgressBar progressBar;
	public static JLabel lblTimer;
	public static JCheckBox chckbxCasovacMin;
	public static JButton btnNaspat;
	Controller controller = new Controller();
	private JLabel picture;
	private JLabel lblTime;
	
	
	
	public ExamGUI(int index, int idUser) {
		initialize();
		this.idUser = idUser;
		this.index = index;	
		frmTest.setVisible(true);
		
	}

	
	
	private void initialize() {
		
		frmTest = new JFrame();
		frmTest.setResizable(false);
		frmTest.getContentPane().setBackground(Color.WHITE);
		frmTest.setTitle("Student Challenger");
		frmTest.setBounds(200, 100, 439, 665);
		frmTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTest.getContentPane().setLayout(null);
		frmTest.setLocationRelativeTo(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 436, 157);
		panel.setBackground(Color.LIGHT_GRAY);
		frmTest.getContentPane().add(panel);
		
		picture = new JLabel("");
		picture.setIcon(new ImageIcon(ExamGUI.class.getResource("/images/Exam.jpg")));
		panel.add(picture);
		
		/// Buttons ////
		
		btnNext = new JButton("Dalej");
		btnNext.setBounds(135, 454, 173, 47);
		btnNext.setVisible(false);
		frmTest.getContentPane().add(btnNext);
		btnNext.addActionListener(e -> {
				clicked = true;
			}
		);
		frmTest.getContentPane().add(btnNext);
			
				
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(e -> {
				start();  // new thread - SwingWorker
			}
		);
		btnStart.setBounds(135, 209, 173, 101);
		frmTest.getContentPane().add(btnStart);
		
		
		
		/// Dynamically changing units ///
		
		textField = new JTextField();
		textField.setBounds(90, 352, 258, 33);
		textField.setVisible(false);
		frmTest.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		lblQuestion = new JLabel("");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(49, 264, 340, 33);
		frmTest.getContentPane().add(lblQuestion);
		
		
		lblExamName = new JLabel("");
		lblExamName.setHorizontalAlignment(SwingConstants.CENTER);
		lblExamName.setBounds(90, 165, 258, 33);
		frmTest.getContentPane().add(lblExamName);
		
		
		lblPomtext = new JLabel("");
		lblPomtext.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomtext.setBounds(49, 308, 340, 33);
		frmTest.getContentPane().add(lblPomtext);
		
		
		lblIndicator = new JLabel("");
		lblIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndicator.setBounds(49, 396, 340, 23);
		frmTest.getContentPane().add(lblIndicator);
		
		txtHint = new JLabel("");
		txtHint.setHorizontalAlignment(SwingConstants.CENTER);
		txtHint.setBounds(90, 512, 258, 23);
		frmTest.getContentPane().add(txtHint);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setBounds(145, 429, 146, 14);
		frmTest.getContentPane().add(progressBar);
		progressBar.setVisible(false);
		
		lblTimer = new JLabel("");
		lblTimer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(135, 557, 173, 33);
		frmTest.getContentPane().add(lblTimer);
		
		lblTime = new JLabel("Ostavajuci cas:");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTime.setToolTipText("");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(135, 538, 173, 14);
		frmTest.getContentPane().add(lblTime);
		lblTime.setVisible(false);
		
		chckbxCasovacMin = new JCheckBox("Casovac (2x body)");
		chckbxCasovacMin.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCasovacMin.setBounds(135, 317, 173, 23);
		frmTest.getContentPane().add(chckbxCasovacMin);
		chckbxCasovacMin.setVisible(true);
		
		btnNaspat = new JButton("Naspat");
		btnNaspat.addActionListener(e -> {
				frmTest.dispose();
			}
		);
		btnNaspat.setBounds(184, 601, 89, 23);
		frmTest.getContentPane().add(btnNaspat);
		
		
		
		
		
	}
	
	/*
	 * Starts a new thread with 
	 * loop method going on background
	 */
	private void start() {
		SwingWorker<String, String> worker = new SwingWorker<String, String>() {

			@Override
			protected String doInBackground() throws Exception {
				btnStart.setVisible(false);
				chckbxCasovacMin.setVisible(false);
				btnNaspat.setVisible(false);
				btnNext.setVisible(true);
				textField.setVisible(true);
				progressBar.setVisible(true);
				lblTime.setVisible(true);
				
				
				controller.startExam(index, idUser);
				return null;
			}
			
			/*
			 * After startExam method is finished
			 * shows user profile stats
			 */
			@Override
			protected void done() {				
				controller.showProfileStats(idUser);
			}
						
		};
		
		worker.execute();
			
	}	
}
