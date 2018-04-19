package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import badges.BadgeObserver;
import main.Controller;
import users.Student;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.List;



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
		BadgeObserver badgeObserver = new BadgeObserver(actUser);
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
		btnExams.addActionListener(e -> {
				ChooseExam.main(idUser);
				frmMain.dispose();
			}
		);
		btnExams.setBounds(75, 380, 287, 45);
		frmMain.getContentPane().add(btnExams);
		
		
		JButton btnProfile = new JButton("Profil");
		btnProfile.addActionListener(e -> {
				controller.showProfile(idUser);
				frmMain.dispose();
				}
		);
		btnProfile.setBounds(75, 436, 287, 45);
		frmMain.getContentPane().add(btnProfile);
		
		
		JButton btnLadderboard = new JButton("Ladderboard");
		btnLadderboard.addActionListener(e -> {
				Ladderboard.main(idUser);
				frmMain.dispose();
			}
		);
		btnLadderboard.setBounds(75, 492, 287, 45);
		frmMain.getContentPane().add(btnLadderboard);
		
		
		JButton btnCreateExam = new JButton("Vytvor test");
		btnCreateExam.addActionListener(e -> {
				CreateExam.main(idUser);
				frmMain.dispose();
			}
		);
		btnCreateExam.setBounds(75, 548, 287, 45);
		frmMain.getContentPane().add(btnCreateExam);
		
	}
}
