package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Odznaky.OdznakObserver;
import Uzivatelia.Student;
import main.Controller;

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
		List<Student> studenti = controller.deserialize("studenti.ser"); 
		Student actUser = studenti.get(idUser);
		OdznakObserver odznakObserver = new OdznakObserver(actUser);
		actUser.addObserver(odznakObserver);
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
		picture.setIcon(new ImageIcon(TestGUI.class.getResource("/obrazky/Main.jpg")));
		panel.add(picture);
		
		
		JButton btnTesty = new JButton("Testy");
		btnTesty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VyberTestu.main(idUser);
				frmMain.dispose();
			}
		});
		btnTesty.setBounds(75, 380, 287, 45);
		frmMain.getContentPane().add(btnTesty);
		
		
		JButton btnProfil = new JButton("Profil");
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profil.main(idUser);
				frmMain.dispose();
				}
		});
		btnProfil.setBounds(75, 436, 287, 45);
		frmMain.getContentPane().add(btnProfil);
		
		
		JButton btnLadderboard = new JButton("Ladderboard");
		btnLadderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ladderboard.main(idUser);
				frmMain.dispose();
			}
		});
		btnLadderboard.setBounds(75, 492, 287, 45);
		frmMain.getContentPane().add(btnLadderboard);
		
		
		JButton btnVytvorTest = new JButton("Vytvor test");
		btnVytvorTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VytvorTest.main(idUser);
				frmMain.dispose();
			}
		});
		btnVytvorTest.setBounds(75, 548, 287, 45);
		frmMain.getContentPane().add(btnVytvorTest);
		
	}
}
