import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frmTestsystemLogin;
	private JTextField txtMeno;
	private JPasswordField txtHeslo;

	
	
	/*
	 * Spustac 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();       // vytvorenie okna login 
					window.frmTestsystemLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {      // constructor 
		initialize();
	}

	
	
	/*
	 * celkova funkcia a prostredie Login
	 */
		private void initialize() {
		frmTestsystemLogin = new JFrame();
		frmTestsystemLogin.getContentPane().setBackground(Color.WHITE);
		frmTestsystemLogin.setTitle("StudentChallenger Login");
		frmTestsystemLogin.setBounds(200, 100, 453, 665);
		frmTestsystemLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestsystemLogin.getContentPane().setLayout(null);
		frmTestsystemLogin.setLocationRelativeTo(null); // center okna do stredu 

		JLabel lblMeno = new JLabel("PRIHLASOVACIE MENO:");
		lblMeno.setBounds(75, 386, 136, 14);
		frmTestsystemLogin.getContentPane().add(lblMeno);

		JLabel lblHeslo = new JLabel("HESLO:");
		lblHeslo.setBackground(new Color(255, 255, 255));
		lblHeslo.setBounds(75, 446, 46, 14);
		frmTestsystemLogin.getContentPane().add(lblHeslo);

		txtMeno = new JTextField();
		txtMeno.setBounds(75, 400, 287, 35);
		frmTestsystemLogin.getContentPane().add(txtMeno);
		txtMeno.setColumns(10);

		txtHeslo = new JPasswordField();
		txtHeslo.setBounds(75, 460, 287, 35);
		frmTestsystemLogin.getContentPane().add(txtHeslo);

		
		
		JButton btnLogin = new JButton("Prihlasit "); //// Login Button
		btnLogin.setForeground(SystemColor.text);
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String password = txtHeslo.getText();
				String username = txtMeno.getText();

				Scanner x;
				String tempMeno = "";
				String tempHeslo = "";
				boolean found = false;

				try {
					x = new Scanner(new File("loginData.txt"));
					x.useDelimiter("[,\n]"); // prehladavanie po castiach s ","

					while (x.hasNext() && !found) {
						tempMeno = x.next();
						tempHeslo = x.next();

						if (tempMeno.trim().equals(username.trim()) && tempHeslo.trim().equals(password.trim())) {
							found = true;
							}}
					
					if (found == false) {
						JOptionPane.showMessageDialog(null, "Nespravne udaje", "Login Error",JOptionPane.ERROR_MESSAGE);
						txtHeslo.setText(null);
						txtMeno.setText(null);
					}

				} catch (Exception e1) {
					System.out.println("Nebola najdena databaza!");
				}

			}
		});
		btnLogin.setBounds(75, 516, 287, 45);
		frmTestsystemLogin.getContentPane().add(btnLogin);
		
		
		
		
		/*
		 * register button
		 * prepnutie do noveho okna Register
		 * zatvorenie okna Login
		 */
		JButton btnRegister = new JButton("Registracia");
		btnRegister.setForeground(SystemColor.text);
		btnRegister.setBackground(SystemColor.textHighlight);
		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					Register.main(null); // 
					frmTestsystemLogin.setVisible(false);

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnRegister.setBounds(75, 562, 287, 45);
		frmTestsystemLogin.getContentPane().add(btnRegister);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 436, 331);
		frmTestsystemLogin.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/obrazky/LoginLogo.jpg")));
		panel.add(label);

	}
}
