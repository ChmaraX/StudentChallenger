package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import main.Controller;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;

public class CreateExam {

	private JFrame frmCreateExam;
	private int idUser;
	Controller controller = new Controller();
	public static JTextField txtNazovTestu;
	public static JLabel lblZadajNazovTestu;
	public static JButton btnCreateExam;
	public static JButton btnPotvrd;
	public static boolean clicked;
	public static JLabel lblPom;
	

	
	
	public static void main(int idUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateExam window = new CreateExam(idUser);
					window.frmCreateExam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public CreateExam(int idUser) {
		initialize();
		this.idUser = idUser;
		
	}

	
	
	public void initialize() {
		
		frmCreateExam = new JFrame();
		frmCreateExam.setResizable(false);
		frmCreateExam.getContentPane().setBackground(Color.WHITE);
		frmCreateExam.setTitle("Vytvor test");
		frmCreateExam.setBounds(200, 100, 439, 665);
		frmCreateExam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateExam.getContentPane().setLayout(null);
		frmCreateExam.setLocationRelativeTo(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 436, 157);
		panel.setBackground(Color.LIGHT_GRAY);
		frmCreateExam.getContentPane().add(panel);
		
		JLabel picture = new JLabel("");
		picture.setIcon(new ImageIcon(ExamGUI.class.getResource("/images/Exam.jpg")));
		panel.add(picture);
		
		btnCreateExam = new JButton("Vytvor test");
		btnCreateExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		btnCreateExam.setBounds(131, 173, 167, 36);
		frmCreateExam.getContentPane().add(btnCreateExam);
		
		JButton btnBack = new JButton("Naspat");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.main(idUser);
				frmCreateExam.dispose();
			}
		});
		btnBack.setBounds(177, 602, 89, 23);
		frmCreateExam.getContentPane().add(btnBack);
		
		lblZadajNazovTestu = new JLabel("Zadaj nazov testu:");
		lblZadajNazovTestu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblZadajNazovTestu.setHorizontalAlignment(SwingConstants.CENTER);
		lblZadajNazovTestu.setBounds(57, 259, 325, 14);
		lblZadajNazovTestu.setVisible(false);
		frmCreateExam.getContentPane().add(lblZadajNazovTestu);
		
		txtNazovTestu = new JTextField();
		txtNazovTestu.setBounds(131, 319, 167, 20);
		txtNazovTestu.setVisible(false);
		frmCreateExam.getContentPane().add(txtNazovTestu);
		txtNazovTestu.setColumns(10);
		
		btnPotvrd = new JButton("Potvrd");
		btnPotvrd.setVisible(false);
		btnPotvrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicked = true;
			}
		});
		btnPotvrd.setBounds(177, 350, 89, 23);
		frmCreateExam.getContentPane().add(btnPotvrd);
		
		lblPom = new JLabel("");
		lblPom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPom.setBounds(57, 284, 325, 23);
		frmCreateExam.getContentPane().add(lblPom);
		
		
		
	}

	
	
	
	private void start() {
		SwingWorker<String, String> worker = new SwingWorker<String, String>() {

			@Override
			protected String doInBackground() throws Exception {							
							
				
					controller.createExam();			
				return null;
			}
				
			@Override
			protected void done() {	
				btnCreateExam.setVisible(false);
				btnPotvrd.setVisible(false);
				txtNazovTestu.setVisible(false);
				lblPom.setVisible(false);
				
				lblZadajNazovTestu.setText("Test bol úspešne vytvorený.");
				lblZadajNazovTestu.setForeground(Color.GREEN);
					
				}
						
		};
		
		worker.execute();
			
	}	
}
	
	
	



