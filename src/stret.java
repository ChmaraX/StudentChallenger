import java.util.List;

public class stret {

	public static void main(int idUser) {
		
		Controller controller = new Controller();
		Test[] t = new Test[5];
		
		
		//zistenie ktory uzivatel je prihlaseny
		List<Student> studenti = controller.deserialize("studenti.ser"); 
		String actUser = studenti.get(idUser).getUsername();
		
		System.out.println("Vitaj v StudentChallenger" + actUser + "!\n");
		
		
		//vytvorenie testu
		t[0] = new Test("Prvy test");
		
		t[0].pridajOtazku(new SlovnaOtazka("1 Prva otazka","prva odpoved"));
		t[0].pridajOtazku(new SlovnaOtazka("1 Druha otazka","druha odpoved"));
		t[0].pridajOtazku(new MultipleOtazka("1 Tretia otazka", new String[] {"nespravna","nespravna","spravna"},2));
		t[0].pridajOtazku(new ZoradOtazka("Zorad od najmensieho", new String[] {"3","1","7","4"},new int[] {2,1,4,3} ));
				
		// start testu + pripocitanie bodov
		studenti.get(idUser).zvysBody(t[0].startTest(idUser)); // pripocita body studentovi podla uspesnosti testu
		System.out.println("Celkovy pocet bodov pre " + actUser + " je " + studenti.get(idUser).zistiBody());
		
		studenti.get(idUser).zvysBody(t[0].startTest(idUser));
		System.out.println("Celkovy pocet bodov pre " + actUser + " je " + studenti.get(idUser).zistiBody());
		
	
		
	}

}
