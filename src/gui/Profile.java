package gui;

import java.awt.Color;
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


public class Profile {

	private JFrame frmProfile;
	private int idUser;
	public JLabel lblNickname;
	public JLabel txtName;
	public JLabel txtLastname;
	public JLabel txtPoints;
	public JLabel txtBadgeCount;
	public JLabel txtExamCount;
	public JLabel txtAge;
	public JTextArea txtBadges;
	public JLabel lblSkill;
	Controller controller = new Controller();

	
	
	
	public Profile(int idUser) {
		initialize();
		this.idUser = idUser;
		frmProfile.setVisible(true);
	
	}

	
	
	
	private void initialize() {
		
				
		frmProfile = new JFrame();
		frmProfile.setResizable(false);
		frmProfile.getContentPane().setBackground(Color.WHITE);
		frmProfile.setTitle("Student Challenger");
		frmProfile.setBounds(200, 100, 439, 665);
		frmProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfile.getContentPane().setLayout(null);
		frmProfile.setLocationRelativeTo(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 436, 157);
		panel.setBackground(Color.LIGHT_GRAY);
		frmProfile.getContentPane().add(panel);
		
		JLabel picture = new JLabel("");
		picture.setIcon(new ImageIcon(ExamGUI.class.getResource("/images/Profile.jpg")));
		panel.add(picture);
		
		lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(Color.BLUE);
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNickname.setBounds(130, 186, 187, 43);
		frmProfile.getContentPane().add(lblNickname);
		
		JLabel lblName = new JLabel("Meno: ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(98, 242, 90, 14);
		frmProfile.getContentPane().add(lblName);
		
		JLabel lblLastname = new JLabel("Priezvisko:");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastname.setBounds(98, 268, 90, 14);
		frmProfile.getContentPane().add(lblLastname);
		
		JLabel lblPoints = new JLabel("Celkov\u00E9 body: ");
		lblPoints.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPoints.setBounds(98, 324, 90, 14);
		frmProfile.getContentPane().add(lblPoints);
		
		JLabel lblBadges = new JLabel("Odznaky:");
		lblBadges.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBadges.setHorizontalAlignment(SwingConstants.CENTER);
		lblBadges.setBounds(98, 392, 57, 14);
		frmProfile.getContentPane().add(lblBadges);
		
		txtBadges = new JTextArea();
		txtBadges.setEditable(false);
		txtBadges.setBackground(Color.LIGHT_GRAY);
		txtBadges.setBounds(238, 330, 90, 157);
		frmProfile.getContentPane().add(txtBadges);
		
		JScrollPane scrollable = new JScrollPane(txtBadges);
		scrollable.setBounds(81, 417, 90, 99);
		frmProfile.getContentPane().add(scrollable);
		
		
		JButton btnBack = new JButton("Naspat");
		btnBack.addActionListener(e -> {
				Main.main(idUser);
				frmProfile.dispose();
			}
		);
		btnBack.setBounds(184, 580, 89, 23);
		frmProfile.getContentPane().add(btnBack);
		
		txtName = new JLabel("New label");
		txtName.setHorizontalAlignment(SwingConstants.RIGHT);
		txtName.setBounds(198, 242, 130, 14);
		frmProfile.getContentPane().add(txtName);
		
		txtLastname = new JLabel("New label");
		txtLastname.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLastname.setBounds(198, 268, 130, 14);
		frmProfile.getContentPane().add(txtLastname);
		
		txtPoints = new JLabel("New label");
		txtPoints.setForeground(new Color(50, 205, 50));
		txtPoints.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPoints.setBounds(198, 324, 130, 14);
		frmProfile.getContentPane().add(txtPoints);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(108, 379, 209, 2);
		frmProfile.getContentPane().add(separator);
		
		txtBadgeCount = new JLabel("0");
		txtBadgeCount.setHorizontalAlignment(SwingConstants.CENTER);
		txtBadgeCount.setBounds(103, 522, 46, 14);
		frmProfile.getContentPane().add(txtBadgeCount);
		
		JLabel lblExamCount = new JLabel("Dokon\u010Den\u00E9 testy:");
		lblExamCount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExamCount.setBounds(98, 349, 105, 14);
		frmProfile.getContentPane().add(lblExamCount);
		
		txtExamCount = new JLabel("New label");
		txtExamCount.setHorizontalAlignment(SwingConstants.RIGHT);
		txtExamCount.setForeground(Color.ORANGE);
		txtExamCount.setBounds(198, 354, 130, 14);
		frmProfile.getContentPane().add(txtExamCount);
		
		JLabel lblAge = new JLabel("Vek:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(98, 293, 90, 14);
		frmProfile.getContentPane().add(lblAge);
		
		txtAge = new JLabel("New label");
		txtAge.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAge.setBounds(198, 293, 130, 14);
		frmProfile.getContentPane().add(txtAge);
		
		JLabel lblSkillLevel = new JLabel("Skill level:");
		lblSkillLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkillLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSkillLevel.setBounds(248, 392, 57, 14);
		frmProfile.getContentPane().add(lblSkillLevel);
		
		lblSkill = new JLabel("");
		lblSkill.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkill.setBounds(229, 418, 99, 14);
		frmProfile.getContentPane().add(lblSkill);
		
		
		
	}
}
