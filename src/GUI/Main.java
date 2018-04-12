package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import badges.HotstreakBadge;
import main.Controller;
import users.Student;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


public class Main {

	private JFrame frmMain;
	private int idUser;
	Controller controller = new Controller();

	
	
	public static void main(int idUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main(idUser);
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Main(int idUser) {
		initialize();
		this.idUser = idUser;
		List<Student> studenti = controller.deserialize("students.ser"); 
		Student actUser = studenti.get(idUser);
		HotstreakBadge badgeObserver = new HotstreakBadge(actUser);
		actUser.addObserver(badgeObserver);
	}

	
	
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setResizable(false);
		frmMain.getContentPane().setBackground(Color.WHITE);
		frmMain.setTitle("Student Challenger");
		frmMain.setBounds(200, 100, 439, 665);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		frmMain.setLocationRelativeTo(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 436, 331);
		frmMain.getContentPane().add(panel);
		
		JLabel picture = new JLabel("");
		picture.setIcon(new ImageIcon(ExamGUI.class.getResource("/images/Main.jpg")));
		panel.add(picture);
		
		
		JButton btnExams = new JButton("Testy");
		btnExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseExam.main(idUser);
				frmMain.dispose();
			}
		});
		btnExams.setBounds(75, 380, 287, 45);
		frmMain.getContentPane().add(btnExams);
		
		
		JButton btnProfile = new JButton("Profil");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile.main(idUser);
				frmMain.dispose();
				}
		});
		btnProfile.setBounds(75, 436, 287, 45);
		frmMain.getContentPane().add(btnProfile);
		
		
		JButton btnLadderboard = new JButton("Ladderboard");
		btnLadderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ladderboard.main(idUser);
				frmMain.dispose();
			}
		});
		btnLadderboard.setBounds(75, 492, 287, 45);
		frmMain.getContentPane().add(btnLadderboard);
		
		
		JButton btnCreateExam = new JButton("Vytvor test");
		btnCreateExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateExam.main(idUser);
				frmMain.dispose();
			}
		});
		btnCreateExam.setBounds(75, 548, 287, 45);
		frmMain.getContentPane().add(btnCreateExam);
		
	}
}
