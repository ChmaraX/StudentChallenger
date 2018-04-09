package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Controller;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class Login{

	private JFrame frmLogin;
	private JTextField txtMeno;
	private JPasswordField txtHeslo;

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

		JLabel lblMeno = new JLabel("PRIHLASOVACIE MENO:");
		lblMeno.setBounds(75, 386, 136, 14);
		frmLogin.getContentPane().add(lblMeno);

		JLabel lblHeslo = new JLabel("HESLO:");
		lblHeslo.setBackground(new Color(255, 255, 255));
		lblHeslo.setBounds(75, 446, 46, 14);
		frmLogin.getContentPane().add(lblHeslo);

		txtMeno = new JTextField();
		txtMeno.setBounds(75, 400, 287, 35);
		frmLogin.getContentPane().add(txtMeno);
		txtMeno.setColumns(10);

		txtHeslo = new JPasswordField();
		txtHeslo.setBounds(75, 460, 287, 35);
		frmLogin.getContentPane().add(txtHeslo);

		
		/*
		 * Button prihlasenie
		 * skontroluje platnost zadanych udajov
		 */
		
		JButton btnLogin = new JButton("Prihlasit "); 
		btnLogin.setBounds(75, 516, 287, 45);
		frmLogin.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				@SuppressWarnings("deprecation")
				String password = txtHeslo.getText();
				String username = txtMeno.getText();
				
					int idUser = controller.checkLogin(username,password);
									Main.main(idUser);
									frmLogin.dispose();													
				
			}
		});
		
				
		/*
		 * register button
		 * prepnutie do noveho okna Register
		 * zatvorenie okna Login
		 */
		JButton btnRegister = new JButton("Registracia");
		btnRegister.setBounds(75, 562, 287, 45);
		frmLogin.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Register.main(null); // 
					frmLogin.dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	
	
		/*
		 * Obrazok
		 */
		Panel panel = new Panel(); 
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 436, 331);
		frmLogin.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/obrazky/LoginLogo.jpg")));
		panel.add(label);

	}
}
