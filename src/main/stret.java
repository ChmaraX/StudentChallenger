package main;


import java.util.List;
import Odznaky.OdznakObserver;
import Uzivatelia.Student;

public class stret {

	public static void main(String[] args) {
		
	}
	
	public static void run(int idUser) {
		
		/*
		 * inicializacia potrebnych veci
		 */
		Controller controller = new Controller();
		List<Student> studenti = controller.deserialize("studenti.ser"); 
		Student actUser = studenti.get(idUser); // priradenie prihlaseneho uzivatela
		OdznakObserver odznakObserver = new OdznakObserver(actUser);
		actUser.addObserver(odznakObserver);
		
		//controller.vytvorTest();     //--> vytvory novy test
		
		
				
		System.out.println("Vitaj v StudentChallenger  " + actUser.getMeno() + "!\n");
		
	
	
	
		
	}

}
