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
		frmTestsystemLogin.setTitle("StudentChallenger Login");
		frmTestsystemLogin.setBounds(200, 100, 500, 300);
		frmTestsystemLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestsystemLogin.getContentPane().setLayout(null);
		frmTestsystemLogin.setLocationRelativeTo(null); // center okna do stredu 

		JLabel lblMeno = new JLabel("Meno");
		lblMeno.setBounds(23, 29, 46, 14);
		frmTestsystemLogin.getContentPane().add(lblMeno);

		JLabel lblHeslo = new JLabel("Heslo");
		lblHeslo.setBounds(23, 67, 46, 14);
		frmTestsystemLogin.getContentPane().add(lblHeslo);

		txtMeno = new JTextField();
		txtMeno.setBounds(79, 26, 136, 20);
		frmTestsystemLogin.getContentPane().add(txtMeno);
		txtMeno.setColumns(10);

		txtHeslo = new JPasswordField();
		txtHeslo.setBounds(79, 64, 136, 20);
		frmTestsystemLogin.getContentPane().add(txtHeslo);

		
		
		JButton btnLogin = new JButton("Login"); //// Login Button
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
		btnLogin.setBounds(23, 213, 89, 23);
		frmTestsystemLogin.getContentPane().add(btnLogin);

		
		
		
		/*
		 * reset button (vymazanie txt poli)
		 */
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMeno.setText(null);
				txtHeslo.setText(null);
			}
		});
		btnReset.setBounds(135, 213, 89, 23);
		frmTestsystemLogin.getContentPane().add(btnReset);
		
		
		
		
		/*
		 * register button
		 * prepnutie do noveho okna Register
		 * zatvorenie okna Login
		 */
		JButton btnRegister = new JButton("Register");
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
		btnRegister.setBounds(247, 213, 89, 23);
		frmTestsystemLogin.getContentPane().add(btnRegister);

	}
}
