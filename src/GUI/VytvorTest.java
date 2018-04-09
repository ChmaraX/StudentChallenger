package GUI;

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

public class VytvorTest {

	private JFrame frmVytvor;
	private int idUser;
	public static JLabel lblStatus;
	Controller controller = new Controller();

	
	
	public static void main(int idUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VytvorTest window = new VytvorTest(idUser);
					window.frmVytvor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public VytvorTest(int idUser) {
		initialize();
		this.idUser = idUser;
		
	}

	
	
	private void initialize() {
		
		frmVytvor = new JFrame();
		frmVytvor.setResizable(false);
		frmVytvor.getContentPane().setBackground(Color.WHITE);
		frmVytvor.setTitle("Vytvor test");
		frmVytvor.setBounds(200, 100, 439, 665);
		frmVytvor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVytvor.getContentPane().setLayout(null);
		frmVytvor.setLocationRelativeTo(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 436, 157);
		panel.setBackground(Color.LIGHT_GRAY);
		frmVytvor.getContentPane().add(panel);
		
		JLabel picture = new JLabel("");
		picture.setIcon(new ImageIcon(TestGUI.class.getResource("/obrazky/Test.jpg")));
		panel.add(picture);
		
		JButton btnVytvorTest = new JButton("Vytvor test");
		btnVytvorTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		btnVytvorTest.setBounds(131, 211, 167, 36);
		frmVytvor.getContentPane().add(btnVytvorTest);
		
		JLabel lblzatiaCezKonzolu = new JLabel("(zatia\u013E cez konzolu)");
		lblzatiaCezKonzolu.setHorizontalAlignment(SwingConstants.CENTER);
		lblzatiaCezKonzolu.setBounds(150, 258, 137, 14);
		frmVytvor.getContentPane().add(lblzatiaCezKonzolu);
		
		lblStatus = new JLabel("test");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(83, 315, 272, 14);
		frmVytvor.getContentPane().add(lblStatus);
		
		JButton btnNaspat = new JButton("Naspat");
		btnNaspat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.main(idUser);
				frmVytvor.dispose();
			}
		});
		btnNaspat.setBounds(178, 382, 89, 23);
		frmVytvor.getContentPane().add(btnNaspat);
		
		
		
	}

	
	
	
	private void start() {
		SwingWorker<String, String> worker = new SwingWorker<String, String>() {

			@Override
			protected String doInBackground() throws Exception {							
					controller.vytvorTest();			
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
	
	
	



