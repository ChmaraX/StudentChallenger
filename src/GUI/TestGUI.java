package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.Controller;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;




public class TestGUI {

	public static JFrame frmTest;
	public int idUser;
	public int index;
	public static boolean clicked;
	public static JTextField textField;
	public static JLabel lblOtazka;
	public static JButton btnDalej;
	public static JLabel lblNazovtestu;
	public static JLabel lblPomtext;
	public static JLabel lblIndicator;
	public static JButton btnStart;
	public static JLabel txtHint;
	public static JProgressBar progressBar;
	Controller controller = new Controller();
	private JLabel picture;
	

	
	public static void main(int index, int idUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					TestGUI window = new TestGUI(index, idUser);
					TestGUI.frmTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public TestGUI(int index, int idUser) {
		initialize();
		this.idUser = idUser;
		this.index = index;		
		
	}

	
	
	public void initialize() {
		
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
		picture.setIcon(new ImageIcon(TestGUI.class.getResource("/obrazky/Test.jpg")));
		panel.add(picture);
		
		/// Buttons ////
		
		btnDalej = new JButton("Dalej");
		btnDalej.setBounds(135, 454, 173, 47);
		btnDalej.setVisible(false);
		frmTest.getContentPane().add(btnDalej);
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicked = true;
			}
		});
		frmTest.getContentPane().add(btnDalej);
			
				
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();  // novy thread - SwingWorker
			}
		});
		btnStart.setBounds(135, 209, 173, 101);
		frmTest.getContentPane().add(btnStart);
		
		
		
		/// Prvy ktore sa budu dynamicky menit ///
		
		textField = new JTextField();
		textField.setBounds(90, 352, 258, 33);
		textField.setVisible(false);
		frmTest.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		lblOtazka = new JLabel("");
		lblOtazka.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtazka.setBounds(49, 264, 340, 33);
		frmTest.getContentPane().add(lblOtazka);
		
		
		lblNazovtestu = new JLabel("");
		lblNazovtestu.setHorizontalAlignment(SwingConstants.CENTER);
		lblNazovtestu.setBounds(90, 165, 258, 33);
		frmTest.getContentPane().add(lblNazovtestu);
		
		
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
		
		
		
	}
	
	/*
	 * Zacne novy thread s aplikacnou logikou testu
	 * dynamicky meni GUI podla potreby
	 */
	private void start() {
		SwingWorker<String, String> worker = new SwingWorker<String, String>() {

			@Override
			protected String doInBackground() throws Exception {
				btnStart.setVisible(false);
				btnDalej.setVisible(true);
				textField.setVisible(true);
				progressBar.setVisible(true);
				
				controller.zacniTest(index, idUser);
				return null;
			}
			
			/*
			 * Po dokonceni doInBackground procesu
			 * vypise zmeneni stav profilu uzivatela
			 */
			@Override
			protected void done() {				
				controller.vypisStavProfilu(idUser);
			}
						
		};
		
		worker.execute();
			
	}	
}
