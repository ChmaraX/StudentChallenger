import java.util.Objects;
import java.util.Scanner;

public class Otazka {

	private String otazka = ""; 
	private String odpoved = ""; 
	public boolean userOdpoved;
	Scanner scanner = new Scanner(System.in);
	
	
	public Otazka(String otazka, String odpoved) {
		super();
		this.otazka = otazka;
		this.odpoved = odpoved;
		}


	public String getOtazka() {
		return otazka;
	}
	
	public String getOdpoved() {
		return odpoved;
	}

	public boolean userOdpoved() {
		String userInput = scanner.nextLine();
		/*
		 * Zisti ci sa uzivatelov vstup zhoduje
		 * so spravnou odpovedou
		 */
		if( Objects.equals(getOdpoved(),userInput) ) {
			userOdpoved = true;
		}
		return userOdpoved;
		
	}
	
	public void polozOtazku() {
		System.out.println(getOtazka());
		
		if(userOdpoved()) 
			System.out.println("Spravna odpoved!");
		else
			System.out.println("Nespravna odpoved.");
			
	}


	
	
	
	
	
}
