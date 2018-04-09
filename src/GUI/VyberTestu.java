package GUI;

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

public class VyberTestu {

	private JFrame frmTesty;
	private JList<String> list;
	private JButton btnVyber;
	private JLabel picture;
	private int idUser;
	DefaultListModel<String> model;
	Controller controller = new Controller();
	
	
	

	public static void main(int idUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VyberTestu window = new VyberTestu(idUser);
					window.frmTesty.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public VyberTestu(int idUser) {
		initialize();
		this.idUser = idUser;
	}

	
	
	private void initialize() {
		frmTesty = new JFrame();
		frmTesty.setResizable(false);
		frmTesty.getContentPane().setBackground(Color.WHITE);
		frmTesty.setTitle("Student Challenger");
		frmTesty.setBounds(200, 100, 439, 665);
		frmTesty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTesty.getContentPane().setLayout(null);
		frmTesty.setLocationRelativeTo(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 436, 157);
		frmTesty.getContentPane().add(panel);
		
		picture = new JLabel("");
		picture.setIcon(new ImageIcon(VyberTestu.class.getResource("/obrazky/VyberTestu.jpg")));
		panel.add(picture);
		
	
		/*
		 * Prida nazvy testov do Jlistu 
		 */
		String[] nazvyTestov = controller.nazvyTestov();
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(50, 196, 333, 281);
		for(int j = 0; j < nazvyTestov.length; j++ )
			model.add(j, nazvyTestov[j]);
		frmTesty.getContentPane().add(list);
			
				
		btnVyber = new JButton("Vyber");
		btnVyber.setBounds(164, 506, 89, 23);
		btnVyber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//prepne do TestGUI s indexom vybraneho testu
				int index = list.getSelectedIndex();
				TestGUI.main(index, idUser);
							
			}
		});
		frmTesty.getContentPane().add(btnVyber);
		
		JButton btnNasp = new JButton("Naspat");
		btnNasp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main(idUser);
				frmTesty.dispose();
			}
		});
		btnNasp.setBounds(164, 540, 89, 23);
		frmTesty.getContentPane().add(btnNasp);
		
	
		
		
		
	}
}
