package main;

import java.util.ArrayList;
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
		List<Test> testy = controller.deserializeTest("testy.ser");
		List<Student> studenti = controller.deserialize("studenti.ser"); 
		Student actUser = studenti.get(idUser); // priradenie prihlaseneho uzivatela
		OdznakObserver odznakObserver = new OdznakObserver(actUser);
		actUser.addObserver(odznakObserver);
		
		//controller.vytvorTest();
		
		
				
		System.out.println("Vitaj v StudentChallenger  " + actUser.getMeno() + "!\n");
		
		//testy.get(7).startTest();
		
		
		
		//vytvorenie testu
		
				
		// start testu + pripocitanie bodov
		
		/*for(int j = 0; j < 3; j++) {
			
		int vysledok = testy.get(0).startTest();				
		actUser.zvysBody(vysledok); 
		actUser.zvysPocetTestov();
		
		actUser.zvysHotstreak();
		
		
	/*	if(vysledok == t[0].getPocetOtazok()) 
			actUser.zvysHotstreak();
		else
			actUser.zmazHotStreak(); */
		
			
			/*System.out.println("Celkovy pocet bodov pre " + actUser.getUsername() + " je " + actUser.zistiBody());
		}
		
		System.out.println(actUser.getMeno());
		System.out.println("/// Celkovy pocet bodov: " + actUser.zistiBody());
		System.out.println("/// Odznaky: " );
		
		
		for(Odznak i : actUser.getOdznaky()){
				if(i != null)
			System.out.println(i.getNazov());
			}*/
		
		//controller.serialize(studenti, "studenti.ser");
	
		
	}

}
