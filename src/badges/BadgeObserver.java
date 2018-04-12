package badges;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import users.Student;

public class BadgeObserver implements Observer {

	private Student actUser;
	private int hotstreak;
	
	public BadgeObserver(Student actUser) {
		this.actUser = actUser;
	}
	

	void podmienka(int hotstreak) {
				
			if(hotstreak == 3) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: Hotstreak x3 (+5b)!");
					actUser.addBadge(new Badge("Hotstreak x3", 5));
				
				}
			if(hotstreak == 7) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: Hotstreak x7 (+10b)!");
					actUser.addBadge(new Badge("Hotstreak x7", 10));
				 }
			if(hotstreak >= 10) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: Hotstreak x10 (+20b)!");
					actUser.addBadge(new Badge("Hotstreak x10", 20));
				 }
		}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Integer) {
			   hotstreak = (Integer) arg1;
			   podmienka(hotstreak);
			  } 
	 }
	
	
	
}
