package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.SwingConstants;

import main.Controller;


import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profil {

	private JFrame frmProfil;
	private int idUser;
	public static JTextArea txtOdznaky;
	Controller controller = new Controller();
	public static JLabel lblNickname;
	public static JLabel txtMeno;
	public static JLabel txtPriezvisko;
	public static JLabel txtBody;
	public static JLabel txtOdzCount;
	public static JLabel txtTestCount;
	
	
	
	
	public static void main(int idUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profil window = new Profil(idUser);
					window.frmProfil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Profil(int idUser) {
		initialize();
		this.idUser = idUser;
		controller.ukazProfil(idUser);
	}

	
	
	
	private void initialize() {
		
				
		frmProfil = new JFrame();
		frmProfil.setResizable(false);
		frmProfil.getContentPane().setBackground(Color.WHITE);
		frmProfil.setTitle("Student Challenger");
		frmProfil.setBounds(200, 100, 439, 665);
		frmProfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfil.getContentPane().setLayout(null);
		frmProfil.setLocationRelativeTo(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 436, 157);
		panel.setBackground(Color.LIGHT_GRAY);
		frmProfil.getContentPane().add(panel);
		
		JLabel picture = new JLabel("");
		picture.setIcon(new ImageIcon(TestGUI.class.getResource("/obrazky/Profil.jpg")));
		panel.add(picture);
		
		lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(Color.BLUE);
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNickname.setBounds(130, 186, 187, 43);
		frmProfil.getContentPane().add(lblNickname);
		
		JLabel lblMeno = new JLabel("Meno: ");
		lblMeno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMeno.setBounds(98, 242, 90, 14);
		frmProfil.getContentPane().add(lblMeno);
		
		JLabel lblPriezvisko = new JLabel("Priezvisko:");
		lblPriezvisko.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPriezvisko.setBounds(98, 268, 90, 14);
		frmProfil.getContentPane().add(lblPriezvisko);
		
		JLabel lblBody = new JLabel("Celkov\u00E9 body: ");
		lblBody.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBody.setBounds(98, 296, 90, 14);
		frmProfil.getContentPane().add(lblBody);
		
		JLabel lblOdznaky = new JLabel("Odznaky:");
		lblOdznaky.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOdznaky.setHorizontalAlignment(SwingConstants.CENTER);
		lblOdznaky.setBounds(98, 364, 57, 14);
		frmProfil.getContentPane().add(lblOdznaky);
		
		txtOdznaky = new JTextArea();
		txtOdznaky.setEditable(false);
		txtOdznaky.setBackground(Color.LIGHT_GRAY);
		txtOdznaky.setBounds(238, 330, 90, 157);
		frmProfil.getContentPane().add(txtOdznaky);
		
		JScrollPane scrollable = new JScrollPane(txtOdznaky);
		scrollable.setBounds(81, 389, 90, 99);
		frmProfil.getContentPane().add(scrollable);
		
		
		JButton btnNaspat = new JButton("Naspat");
		btnNaspat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main(idUser);
				frmProfil.dispose();
			}
		});
		btnNaspat.setBounds(184, 580, 89, 23);
		frmProfil.getContentPane().add(btnNaspat);
		
		txtMeno = new JLabel("New label");
		txtMeno.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMeno.setBounds(198, 242, 130, 14);
		frmProfil.getContentPane().add(txtMeno);
		
		txtPriezvisko = new JLabel("New label");
		txtPriezvisko.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPriezvisko.setBounds(198, 268, 130, 14);
		frmProfil.getContentPane().add(txtPriezvisko);
		
		txtBody = new JLabel("New label");
		txtBody.setForeground(new Color(50, 205, 50));
		txtBody.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBody.setBounds(198, 296, 130, 14);
		frmProfil.getContentPane().add(txtBody);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(108, 351, 209, 2);
		frmProfil.getContentPane().add(separator);
		
		txtOdzCount = new JLabel("0");
		txtOdzCount.setHorizontalAlignment(SwingConstants.CENTER);
		txtOdzCount.setBounds(103, 494, 46, 14);
		frmProfil.getContentPane().add(txtOdzCount);
		
		JLabel lblDokonenTesty = new JLabel("Dokon\u010Den\u00E9 testy:");
		lblDokonenTesty.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDokonenTesty.setBounds(98, 321, 105, 14);
		frmProfil.getContentPane().add(lblDokonenTesty);
		
		txtTestCount = new JLabel("New label");
		txtTestCount.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTestCount.setForeground(Color.ORANGE);
		txtTestCount.setBounds(198, 326, 130, 14);
		frmProfil.getContentPane().add(txtTestCount);
		
		
		
	}
}
