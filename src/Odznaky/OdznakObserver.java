package Odznaky;
import java.util.Observable;
import java.util.Observer;

import Uzivatelia.Student;

public class OdznakObserver implements Observer {

	private Student actUser;
	private int hotstreak;
	
	public OdznakObserver(Student actUser) {
		this.actUser = actUser;
	}
	

	void podmienka(int hotstreak) {
				
			if(hotstreak == 3) {
				System.out.println("Ziskal si odznak: Hotstreak x3 (+5b)!");
					actUser.pridajOdznak(new Odznak("Hotstreak x3", 5));
				
				}
			if(hotstreak == 7) {
				System.out.println("Ziskal si odznak: Hotstreak x7 (+10b)!");
					actUser.pridajOdznak(new Odznak("Hotstreak x7", 10));
				 }
			if(hotstreak >= 10) {
				System.out.println("Ziskal si odznak: Hotstreak x10 (+20b)!");
					actUser.pridajOdznak(new Odznak("Hotstreak x10", 20));
				 }
		}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Integer) {
			   hotstreak = (Integer) arg1;
			   System.out.println("Hotstreak: " + hotstreak);
			   podmienka(hotstreak);
			  } 
	 }
	
	
	
}
