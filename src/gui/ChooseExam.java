package gui;

import java.awt.Color;
import java.awt.Panel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import main.Controller;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ChooseExam {

	private JFrame frmExams;
	private JList<String> list;
	private JButton btnChoose;
	private JLabel picture;
	private int idUser;
	DefaultListModel<String> model;
	Controller controller = new Controller();
	
	
	public ChooseExam(int idUser) {
		initialize();
		this.idUser = idUser;
		frmExams.setVisible(true);
	}

	
	
	private void initialize() {
		
		frmExams = new JFrame();
		frmExams.setResizable(false);
		frmExams.getContentPane().setBackground(Color.WHITE);
		frmExams.setTitle("Student Challenger");
		frmExams.setBounds(200, 100, 439, 665);
		frmExams.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExams.getContentPane().setLayout(null);
		frmExams.setLocationRelativeTo(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 436, 157);
		frmExams.getContentPane().add(panel);
		
		picture = new JLabel("");
		picture.setIcon(new ImageIcon(ChooseExam.class.getResource("/images/ChooseExam.jpg")));
		panel.add(picture);
		
	
		/*
		 * Adds exam names into Jlist
		 */	
		String[] examNames = controller.examNames();
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(50, 196, 333, 281);
		for(int j = 0; j < examNames.length; j++ )
			model.add(j, examNames[j]);
		frmExams.getContentPane().add(list);
			
				
		btnChoose = new JButton("Vyber");
		btnChoose.setBounds(164, 506, 89, 23);
		btnChoose.addActionListener(e -> {
				//opens ExamGUI thread with selected exam as parameter
				int index = list.getSelectedIndex();
					new ExamGUI(index, idUser);
				//frmExams.dispose();
											
			}
		);
		frmExams.getContentPane().add(btnChoose);
		
		JButton btnBack = new JButton("Naspat");
		btnBack.addActionListener(e -> {
				new Main(idUser);
				frmExams.dispose();
			}
		);
		btnBack.setBounds(164, 540, 89, 23);
		frmExams.getContentPane().add(btnBack);
		
	
		
		
		
	}
}
