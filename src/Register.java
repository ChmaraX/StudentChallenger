import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.awt.event.ActionEvent;

public class Register {

	JFrame frmTestsystemRegister;
	private JTextField txtRegMeno;
	private JPasswordField txtRegHeslo;
	private JTextField MenoReg;
	private JTextField PriezviskoReg;
	private JTextField VekReg;

	/**
	 * Spustac 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frmTestsystemRegister.setVisible(true);
					window.frmTestsystemRegister.setLocationRelativeTo(null); 
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
		frmTestsystemRegister = new JFrame();
		frmTestsystemRegister.setTitle("Registracia");
		frmTestsystemRegister.setBounds(100, 100, 538, 334);
		frmTestsystemRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestsystemRegister.getContentPane().setLayout(null);

		JLabel lblRegMeno = new JLabel("Prihlasovacie meno:");
		lblRegMeno.setBounds(30, 32, 157, 14);
		frmTestsystemRegister.getContentPane().add(lblRegMeno);

		JLabel lblRegHeslo = new JLabel("Heslo:");
		lblRegHeslo.setBounds(30, 66, 92, 14);
		frmTestsystemRegister.getContentPane().add(lblRegHeslo);

		JLabel label_Meno = new JLabel("Meno:");
		label_Meno.setBounds(29, 124, 69, 14);
		frmTestsystemRegister.getContentPane().add(label_Meno);

		JLabel label_Priezvisko = new JLabel("Priezvisko:");
		label_Priezvisko.setBounds(30, 149, 92, 14);
		frmTestsystemRegister.getContentPane().add(label_Priezvisko);

		txtRegMeno = new JTextField();
		txtRegMeno.setBounds(163, 29, 138, 20);
		frmTestsystemRegister.getContentPane().add(txtRegMeno);
		txtRegMeno.setColumns(10);

		txtRegHeslo = new JPasswordField();
		txtRegHeslo.setBounds(163, 63, 138, 20);
		frmTestsystemRegister.getContentPane().add(txtRegHeslo);

		MenoReg = new JTextField();
		MenoReg.setColumns(10);
		MenoReg.setBounds(138, 118, 138, 20);
		frmTestsystemRegister.getContentPane().add(MenoReg);

		PriezviskoReg = new JTextField();
		PriezviskoReg.setColumns(10);
		PriezviskoReg.setBounds(138, 143, 138, 20);
		frmTestsystemRegister.getContentPane().add(PriezviskoReg);

		VekReg = new JTextField();
		VekReg.setColumns(10);
		VekReg.setBounds(138, 170, 138, 20);
		frmTestsystemRegister.getContentPane().add(VekReg);

		JLabel label_Vek = new JLabel("Vek:");
		label_Vek.setBounds(30, 176, 92, 14);
		frmTestsystemRegister.getContentPane().add(label_Vek);

		JLabel label_Stupen = new JLabel("Stupen studia:");
		label_Stupen.setBounds(30, 210, 92, 14);
		frmTestsystemRegister.getContentPane().add(label_Stupen);

		JComboBox comboBoxReg = new JComboBox();
		comboBoxReg.setModel(new DefaultComboBoxModel(new String[] { "Bakalarsky\t", "Inziniersky", "Doktorantsky" }));
		comboBoxReg.setMaximumRowCount(4);
		comboBoxReg.setBounds(138, 207, 138, 20);
		frmTestsystemRegister.getContentPane().add(comboBoxReg);

		
		/*
		 * button Zaregistruj
		 * funkcia ktora zapise udaje do txt dokumentu
		 * vytvory objekt noveho uzivatela v spajanom zozname 
		 */
		
		JButton btnZaregistruj = new JButton("Zaregistruj");
		btnZaregistruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtRegHeslo.getText();
				String username = txtRegMeno.getText();
				
				try {
				    Files.write(Paths.get("loginData.txt"), username.getBytes(), StandardOpenOption.APPEND);
				    Files.write(Paths.get("loginData.txt"), ",".getBytes(), StandardOpenOption.APPEND);
				    Files.write(Paths.get("loginData.txt"), password.getBytes(), StandardOpenOption.APPEND);
				    Files.write(Paths.get("loginData.txt"), "\n".getBytes(), StandardOpenOption.APPEND);
				}catch (IOException e1) {
				    //pre pripad nenajdenia txt suboru
				}
				

			}
		});
		btnZaregistruj.setBounds(30, 253, 109, 31);
		frmTestsystemRegister.getContentPane().add(btnZaregistruj);

		
		
		
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRegMeno.setText(null);
				txtRegHeslo.setText(null);
				PriezviskoReg.setText(null);
				MenoReg.setText(null);
				VekReg.setText(null);

			}
		});
		btnReset.setBounds(155, 253, 109, 31);
		frmTestsystemRegister.getContentPane().add(btnReset);

		
		
		
		JButton btnPrihlasenie = new JButton("Prihlasenie");
		btnPrihlasenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frmTestsystemRegister.setVisible(false);
			}
		});
		btnPrihlasenie.setBounds(278, 253, 109, 31);
		frmTestsystemRegister.getContentPane().add(btnPrihlasenie);
		
		
		
		
		
	}
}
