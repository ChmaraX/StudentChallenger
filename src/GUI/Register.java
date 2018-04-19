package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Controller;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.io.IOException;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class Register{

	JFrame frmRegister;
	private JTextField txtRegName;
	private JPasswordField txtRegPassword;
	private JTextField regName;
	private JTextField regLastname;
	private JTextField regAge;

	Controller controller = new Controller();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frmRegister.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Register() {
		initialize();
	}
	
	
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setResizable(false);
		frmRegister.getContentPane().setBackground(Color.WHITE);
		frmRegister.setTitle("Registracia");
		frmRegister.setBounds(200, 100, 439, 665);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		frmRegister.setLocationRelativeTo(null); // center okna do stredu 

		JLabel lblRegName = new JLabel("Prihlasovacie meno:");
		lblRegName.setBounds(93, 268, 157, 14);
		frmRegister.getContentPane().add(lblRegName);

		JLabel lblRegLastname = new JLabel("Heslo:");
		lblRegLastname.setBounds(93, 319, 92, 14);
		frmRegister.getContentPane().add(lblRegLastname);

		JLabel lblName = new JLabel("Meno:");
		lblName.setBounds(93, 387, 69, 14);
		frmRegister.getContentPane().add(lblName);

		JLabel lblLastname = new JLabel("Priezvisko:");
		lblLastname.setBounds(93, 418, 92, 14);
		frmRegister.getContentPane().add(lblLastname);

		txtRegName = new JTextField();
		txtRegName.setBounds(93, 284, 253, 31);
		frmRegister.getContentPane().add(txtRegName);
		txtRegName.setColumns(10);

		txtRegPassword = new JPasswordField();
		txtRegPassword.setBounds(93, 333, 253, 31);
		frmRegister.getContentPane().add(txtRegPassword);

		regName = new JTextField();
		regName.setColumns(10);
		regName.setBounds(195, 381, 151, 20);
		frmRegister.getContentPane().add(regName);

		regLastname = new JTextField();
		regLastname.setColumns(10);
		regLastname.setBounds(195, 412, 151, 20);
		frmRegister.getContentPane().add(regLastname);

		regAge = new JTextField();
		regAge.setColumns(10);
		regAge.setBounds(195, 443, 151, 20);
		frmRegister.getContentPane().add(regAge);

		JLabel lblAge = new JLabel("Vek:");
		lblAge.setBounds(94, 449, 92, 14);
		frmRegister.getContentPane().add(lblAge);

					
		
							/* BUTTONS */
			
		JButton btnRegister = new JButton("Zaregistruj");
		btnRegister.setBounds(75, 516, 287, 45);
		frmRegister.getContentPane().add(btnRegister);
		btnRegister.addActionListener(e -> {
				try {
					
					@SuppressWarnings("deprecation")
					String password = txtRegPassword.getText();
					String username = txtRegName.getText();
					String name = regName.getText(); 
					String lastname = regLastname.getText(); 
					int age = Integer.parseInt(regAge.getText());
							
					controller.addStudent(username,password,age,name,lastname); //prida a ulozi udaje studenta 
					
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}	
			}
			
		);
		

		
		JButton btnLogin = new JButton("Prihlasenie");
		btnLogin.setBounds(75, 562, 287, 45);
		frmRegister.getContentPane().add(btnLogin);
		btnLogin.addActionListener(e -> {
				Login.main(null);
				frmRegister.dispose();
			}
		);
		
		
		
	
		Panel panelLogo = new Panel();
		panelLogo.setBackground(Color.LIGHT_GRAY);
		panelLogo.setBounds(0, 0, 436, 253);
		frmRegister.getContentPane().add(panelLogo);
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(Register.class.getResource("/images/LoginLogo.jpg")));
		panelLogo.add(labelLogo);
		
		
		
		
		
	}
}
