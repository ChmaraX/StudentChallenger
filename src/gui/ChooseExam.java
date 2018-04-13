package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	
	

	public static void main(int idUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseExam window = new ChooseExam(idUser);
					window.frmExams.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public ChooseExam(int idUser) {
		initialize();
		this.idUser = idUser;
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
		 * Prida nazvy testov do Jlistu 
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
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//prepne do TestGUI s indexom vybraneho testu
				int index = list.getSelectedIndex();
				@SuppressWarnings("unused")
				ExamGUI window = new ExamGUI(index, idUser);
											
			}
		});
		frmExams.getContentPane().add(btnChoose);
		
		JButton btnBack = new JButton("Naspat");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main(idUser);
				frmExams.dispose();
			}
		});
		btnBack.setBounds(164, 540, 89, 23);
		frmExams.getContentPane().add(btnBack);
		
	
		
		
		
	}
}
