import java.util.Objects;

public class SlovnaOtazka implements Otazka {

	private String otazka = ""; 
	private String odpoved = ""; 
		
	
	public SlovnaOtazka(String otazka, String odpoved) {
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

	
	@Override
	public boolean polozOtazku() {
		System.out.println(getOtazka());
		
		if(userOdpoved()) {
			System.out.println("Spravna odpoved! \n");
			return true; 
			}
		else	{
			System.out.println("Nespravne! Spravna odpoved -> " + (getOdpoved()) + "\n" );
			return false; 
			}
	}
	
	
	@Override
	public boolean userOdpoved() {
		String userInput = scanner.nextLine();
				/*
		 * Zisti ci sa uzivatelov vstup zhoduje
		 * so spravnou odpovedou
		 */
		if( Objects.equals(getOdpoved(),userInput) ) 
			return true;
						
		return false;
				
	}
	




	
	
	
	
	
}
