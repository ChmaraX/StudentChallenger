package main;

import java.util.List;

import Odznaky.Odznak;
import Odznaky.OdznakObserver;
import Otazky.MultipleOtazka;
import Otazky.SlovnaOtazka;
import Otazky.ZoradOtazka;
import Testy.Test;
import Uzivatelia.Student;

public class stret {

	public static void main(int idUser) {
		
		/*
		 * inicializacia potrebnych veci
		 */
		Controller controller = new Controller();
		Test[] t = new Test[100];
		List<Student> studenti = controller.deserialize("studenti.ser"); 
		Student actUser = studenti.get(idUser);
		OdznakObserver odznakObserver = new OdznakObserver(actUser);
		actUser.addObserver(odznakObserver);
		
				
		System.out.println("Vitaj v StudentChallenger" + actUser.getMeno() + "!\n");
		
		
		//vytvorenie testu
	
		
		t[0].pridajOtazku(new SlovnaOtazka("1 Prva otazka","prva odpoved"));
		t[0].pridajOtazku(new SlovnaOtazka("1 Druha otazka","druha odpoved"));
		t[0].pridajOtazku(new MultipleOtazka("1 Tretia otazka", new String[] {"nespravna","nespravna","spravna"},2));
		t[0].pridajOtazku(new ZoradOtazka("Zorad od najmensieho", new String[] {"3","1","7","4"},new int[] {2,1,4,3} ));
				
		// start testu + pripocitanie bodov
		
		for(int j = 0; j < 3; j++) {
			
		int vysledok = t[0].startTest();				
		actUser.zvysBody(vysledok); 
		actUser.zvysPocetTestov();
		
		actUser.zvysHotstreak();
		
		
	/*	if(vysledok == t[0].getPocetOtazok()) 
			actUser.zvysHotstreak();
		else
			actUser.zmazHotStreak(); */
		
			
			System.out.println("Celkovy pocet bodov pre " + actUser.getUsername() + " je " + actUser.zistiBody());
		}
		
		System.out.println(actUser.getMeno());
		System.out.println("/// Celkovy pocet bodov: " + actUser.zistiBody());
		System.out.println("/// Odznaky: " );
		
		
		for(Odznak i : actUser.getOdznaky()){
				if(i != null)
			System.out.println(i.getNazov());
			}
		
		
	
		
	}

}
