package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;


import main.Controller;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ladderboard {

	private JFrame frmLdr;
	private JTable table;
	private int idUser;
	Controller controller = new Controller();

	
	
	public static void main(int idUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ladderboard window = new Ladderboard(idUser);
					window.frmLdr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	public Ladderboard(int idUser) {
		initialize();
		this.idUser = idUser;
	}

	
	
	
	private void initialize() {
		
		frmLdr = new JFrame();
		frmLdr.setResizable(false);
		frmLdr.getContentPane().setBackground(Color.WHITE);
		frmLdr.setTitle("Ladderboard");
		frmLdr.setBounds(200, 100, 439, 665);
		frmLdr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLdr.getContentPane().setLayout(null);
		frmLdr.setLocationRelativeTo(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 436, 157);
		panel.setBackground(Color.LIGHT_GRAY);
		frmLdr.getContentPane().add(panel);
		
		JLabel picture = new JLabel("");
		picture.setIcon(new ImageIcon(ExamGUI.class.getResource("/images/Ladder.jpg")));
		panel.add(picture);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 192, 384, 402);
		frmLdr.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String[] columns = { "Username", "Meno", "Priezvisko", "Body", "Odznaky", "Testy"};	
				
		DefaultTableModel tableModel = new DefaultTableModel(controller.studentTableData(), columns);
		table.setModel(tableModel);
		
		table.setAutoCreateRowSorter(true); // sortuje tabulku podla vybraneho parametra
		
		JLabel lblLdr = new JLabel("Ladderboard");
		lblLdr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLdr.setHorizontalAlignment(SwingConstants.CENTER);
		lblLdr.setBounds(133, 163, 165, 31);
		frmLdr.getContentPane().add(lblLdr);
		
		JButton btnBack = new JButton("Naspat");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main(idUser);
				frmLdr.dispose();
			}
		});
		btnBack.setBounds(175, 605, 89, 23);
		frmLdr.getContentPane().add(btnBack);
		
		

		
	}
}
