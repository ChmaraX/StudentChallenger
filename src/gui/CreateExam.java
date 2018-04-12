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

public class CreateExam {

	private JFrame frmCreateExam;
	private int idUser;
	public static JLabel lblStatus;
	Controller controller = new Controller();

	
	
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

	
	
	private void initialize() {
		
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
		
		JButton btnCreateExam = new JButton("Vytvor test");
		btnCreateExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		btnCreateExam.setBounds(131, 211, 167, 36);
		frmCreateExam.getContentPane().add(btnCreateExam);
		
		JLabel lblzatiaCezKonzolu = new JLabel("(zatia\u013E cez konzolu)");
		lblzatiaCezKonzolu.setHorizontalAlignment(SwingConstants.CENTER);
		lblzatiaCezKonzolu.setBounds(150, 258, 137, 14);
		frmCreateExam.getContentPane().add(lblzatiaCezKonzolu);
		
		lblStatus = new JLabel("test");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(83, 315, 272, 14);
		frmCreateExam.getContentPane().add(lblStatus);
		
		JButton btnBack = new JButton("Naspat");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.main(idUser);
				frmCreateExam.dispose();
			}
		});
		btnBack.setBounds(178, 382, 89, 23);
		frmCreateExam.getContentPane().add(btnBack);
		
		
		
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
					lblStatus.setText("Novy test bol uspesne vytvoreny.");
				}
						
		};
		
		worker.execute();
			
	}	
	
	
	
	
	
}
	
	
	



