package badges;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import users.Student;

public class ExamBadge implements Observer {

	private Student actUser;
	private int examCount;
	
	public ExamBadge(Student actUser) {
		this.actUser = actUser;
	}
	

	void podmienkaEX(int examCount) {
				
			if(examCount == 3) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: First three! (+5b)!");
					actUser.addBadge(new Badge("First three!", 5));
				
				}
			if(examCount == 20) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: Twenty down! (+10b)!");
					actUser.addBadge(new Badge("Twenty down!", 10));
				 }
			if(examCount == 100) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: 100 Breaker! (+100b)!");
					actUser.addBadge(new Badge("100 Breaker!", 100));
				 }
		}
	
		

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Integer) {
			   examCount = (Integer) arg1;
			   podmienkaEX(examCount);
			  } 
	 }
	
}
