import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;


import java.awt.Panel;
import javax.swing.ImageIcon;

public class Register extends Controller{

	JFrame frmTestsystemRegister;
	private JTextField txtRegMeno;
	private JPasswordField txtRegHeslo;
	private JTextField MenoReg;
	private JTextField PriezviskoReg;
	private JTextField VekReg;

	
	
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


	
	private void addStudent() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		String password = txtRegHeslo.getText();
		String username = txtRegMeno.getText();
		String meno = MenoReg.getText(); 
		String priezvisko = PriezviskoReg.getText(); 
		int vek = Integer.parseInt(VekReg.getText());
				
		try {
		    Files.write(Paths.get("loginData.txt"), username.getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("loginData.txt"), ",".getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("loginData.txt"), password.getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("loginData.txt"), "\n".getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e1) {
		    //pre pripad nenajdenia txt suboru
		}
				
	
		List<Student> studenti = deserialize("studenti.ser"); 
		studenti.add(new Student(vek, meno, priezvisko));
		
		// studenti.clear(); --- vycistenie db
		
		serialize(studenti,"studenti.ser");
				
		
		List<Student> newList = deserialize("studenti.ser");
		System.out.println("Novy list:  " + newList);
	
	   		
	
	}
	
	
	private void initialize() {
		frmTestsystemRegister = new JFrame();
		frmTestsystemRegister.getContentPane().setBackground(Color.WHITE);
		frmTestsystemRegister.setTitle("Registracia");
		frmTestsystemRegister.setBounds(200, 100, 453, 665);
		frmTestsystemRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestsystemRegister.getContentPane().setLayout(null);
		frmTestsystemRegister.setLocationRelativeTo(null); // center okna do stredu 

		JLabel lblRegMeno = new JLabel("Prihlasovacie meno:");
		lblRegMeno.setBounds(93, 268, 157, 14);
		frmTestsystemRegister.getContentPane().add(lblRegMeno);

		JLabel lblRegHeslo = new JLabel("Heslo:");
		lblRegHeslo.setBounds(93, 319, 92, 14);
		frmTestsystemRegister.getContentPane().add(lblRegHeslo);

		JLabel label_Meno = new JLabel("Meno:");
		label_Meno.setBounds(93, 387, 69, 14);
		frmTestsystemRegister.getContentPane().add(label_Meno);

		JLabel label_Priezvisko = new JLabel("Priezvisko:");
		label_Priezvisko.setBounds(93, 418, 92, 14);
		frmTestsystemRegister.getContentPane().add(label_Priezvisko);

		txtRegMeno = new JTextField();
		txtRegMeno.setBounds(93, 284, 253, 31);
		frmTestsystemRegister.getContentPane().add(txtRegMeno);
		txtRegMeno.setColumns(10);

		txtRegHeslo = new JPasswordField();
		txtRegHeslo.setBounds(93, 333, 253, 31);
		frmTestsystemRegister.getContentPane().add(txtRegHeslo);

		MenoReg = new JTextField();
		MenoReg.setColumns(10);
		MenoReg.setBounds(195, 381, 151, 20);
		frmTestsystemRegister.getContentPane().add(MenoReg);

		PriezviskoReg = new JTextField();
		PriezviskoReg.setColumns(10);
		PriezviskoReg.setBounds(195, 412, 151, 20);
		frmTestsystemRegister.getContentPane().add(PriezviskoReg);

		VekReg = new JTextField();
		VekReg.setColumns(10);
		VekReg.setBounds(195, 443, 151, 20);
		frmTestsystemRegister.getContentPane().add(VekReg);

		JLabel label_Vek = new JLabel("Vek:");
		label_Vek.setBounds(94, 449, 92, 14);
		frmTestsystemRegister.getContentPane().add(label_Vek);

		JLabel label_Stupen = new JLabel("Stupen studia:");
		label_Stupen.setBounds(93, 477, 92, 14);
		frmTestsystemRegister.getContentPane().add(label_Stupen);

				
			
		JButton btnZaregistruj = new JButton("Zaregistruj");
		btnZaregistruj.setForeground(SystemColor.text);
		btnZaregistruj.setBackground(SystemColor.textHighlight);
		btnZaregistruj.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					addStudent();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				}
		});
		btnZaregistruj.setBounds(75, 516, 287, 45);
		frmTestsystemRegister.getContentPane().add(btnZaregistruj);

		
		
		
		JButton btnPrihlasenie = new JButton("Prihlasenie");
		btnPrihlasenie.setForeground(SystemColor.text);
		btnPrihlasenie.setBackground(SystemColor.textHighlight);
		btnPrihlasenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frmTestsystemRegister.setVisible(false);
			}
		});
		btnPrihlasenie.setBounds(75, 562, 287, 45);
		frmTestsystemRegister.getContentPane().add(btnPrihlasenie);
		
		
		/*
		 * Obrazok v log/reg
		 */
		Panel panelLogo = new Panel();
		panelLogo.setBackground(Color.LIGHT_GRAY);
		panelLogo.setBounds(0, 0, 436, 253);
		frmTestsystemRegister.getContentPane().add(panelLogo);
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(Register.class.getResource("/obrazky/LoginLogo.jpg")));
		panelLogo.add(labelLogo);
		
		
		
		
		
	}
}
