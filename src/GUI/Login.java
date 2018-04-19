package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Controller;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class Login{

	private JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	Controller controller = new Controller();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();  
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {    
		initialize();
	}

	
		private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setTitle("StudentChallenger Login");
		frmLogin.setBounds(200, 100, 439, 665);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setLocationRelativeTo(null); // center okna do stredu 

		JLabel lblName = new JLabel("PRIHLASOVACIE MENO:");
		lblName.setBounds(75, 386, 136, 14);
		frmLogin.getContentPane().add(lblName);

		JLabel lblPassword = new JLabel("HESLO:");
		lblPassword.setBackground(new Color(255, 255, 255));
		lblPassword.setBounds(75, 446, 46, 14);
		frmLogin.getContentPane().add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(75, 400, 287, 35);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(75, 460, 287, 35);
		frmLogin.getContentPane().add(txtPassword);

		
		/*
		 * Button prihlasenie
		 * skontroluje platnost zadanych udajov
		 */
		
		JButton btnLogin = new JButton("Prihlasit "); 
		btnLogin.setBounds(75, 516, 287, 45);
		frmLogin.getContentPane().add(btnLogin);
		btnLogin.addActionListener(e -> {

				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
					int idUser = controller.checkLogin(username,password);
									new Main(idUser);
									frmLogin.dispose();													
				
			}
		);
		
				
		/*
		 * register button
		 * prepnutie do noveho okna Register
		 * zatvorenie okna Login
		 */
		JButton btnRegister = new JButton("Registracia");
		btnRegister.setBounds(75, 562, 287, 45);
		frmLogin.getContentPane().add(btnRegister);
		btnRegister.addActionListener(e -> {	
				try {
					new Register(); 
					frmLogin.dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		);
	
	
		/*
		 * Obrazok
		 */
		Panel panel = new Panel(); 
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 436, 331);
		frmLogin.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/LoginLogo.jpg")));
		panel.add(label);

	}
}
