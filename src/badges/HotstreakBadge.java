package badges;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import users.Student;

public class HotstreakBadge implements Observer {

	private Student actUser;
	private int hotstreak;
	
	public HotstreakBadge(Student actUser) {
		this.actUser = actUser;
	}
	

	void podmienkaHS(int hotstreak) {
				
			if(hotstreak == 3) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: Hotstreak x3 (+5b)!");
					actUser.addBadge(new Badge("Hotstreak x3", 5));
				
				}
			if(hotstreak == 7) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: Hotstreak x7 (+10b)!");
					actUser.addBadge(new Badge("Hotstreak x7", 10));
				 }
			if(hotstreak == 10) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: Hotstreak x10 (+20b)!");
					actUser.addBadge(new Badge("Hotstreak x10", 20));
				 }
			if(hotstreak >= 20) {
				JOptionPane.showMessageDialog(null, "Ziskal si odznak: Hotstreak x???! (+5b)!");
					actUser.addBadge(new Badge("Hotstreak x???", 5));
				 }
		}
	
		

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Integer) {
			   hotstreak = (Integer) arg1;
			   podmienkaHS(hotstreak);
			  } 
	 }
	
	
	
}