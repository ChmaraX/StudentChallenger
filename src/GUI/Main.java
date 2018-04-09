package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;

import Odznaky.OdznakObserver;
import Uzivatelia.Student;
import main.Controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


public class Main {

	private JFrame frmMain;
	private int idUser;
	Controller controller = new Controller();

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Main(int idUser) {
		initialize();
		this.idUser = idUser;
		List<Student> studenti = controller.deserialize("studenti.ser"); 
		Student actUser = studenti.get(idUser);
		OdznakObserver odznakObserver = new OdznakObserver(actUser);
		actUser.addObserver(odznakObserver);
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
				controller.ukazProfil(idUser);
			}
		});
		btnProfil.setBounds(75, 436, 287, 45);
		frmMain.getContentPane().add(btnProfil);
		
		JButton btnLadderboard = new JButton("Ladderboard");
		btnLadderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.sortStudent();
			}
		});
		btnLadderboard.setBounds(75, 492, 287, 45);
		frmMain.getContentPane().add(btnLadderboard);
		
		JButton btnVytvorTest = new JButton("Vytvor test");
		btnVytvorTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller controller = new Controller();
					controller.vytvorTest();
			}
		});
		btnVytvorTest.setBounds(75, 548, 287, 45);
		frmMain.getContentPane().add(btnVytvorTest);
		
	}
}
