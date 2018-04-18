package users;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;


public class SkillLevel implements Observer {

	private Student actUser;
	private int points;
	
	public SkillLevel(Student actUser) {
		this.actUser = actUser;
	}
	
	
	void podmienka(int points) {
		
		if(points == 50) {
			JOptionPane.showMessageDialog(null, "Pokrocil si na novy level: Pokrocily!");
				actUser.setSkillLevel("Pokrocily");				
			}
		if(points == 100 ) {
			JOptionPane.showMessageDialog(null, "Pokrocil si na novy level: Veteren!");
				actUser.setSkillLevel("Veteran");
			 }
		if(points > 200 ) {
			JOptionPane.showMessageDialog(null, "Pokrocil si na novy level: Master!!");
				actUser.setSkillLevel("Master");
			 }
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Integer) {
			   points = (Integer) arg1;
			   podmienka(points);
			  } 
		
	}
	

}
