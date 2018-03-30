package Otazky;
import java.util.Arrays;
import java.util.Objects;

public class ZoradOtazka extends Otazka{

	private	String[] odpoved;
	private int[] zoradenie; 
		
	
	public ZoradOtazka(String otazka, String[] odpoved, int[] zoradenie) {
		super();
		this.otazka = otazka;
		this.odpoved = odpoved;
		this.zoradenie = zoradenie;
	}
	
	

	public String getOtazka() {
		return otazka;
	}


	public String[] getOdpoved() {
		return odpoved;
	}


	public int[] getZoradenie() {
		return zoradenie;
	}


	@Override
	public boolean polozOtazku() {
		System.out.println(getOtazka());
		System.out.println(Arrays.toString(getOdpoved()));
		
		if(userOdpoved()) {
			System.out.println("Spravna odpoved! \n");
			return true; 
			}
		else	{
			System.out.println("Nespravne! Spravna odpoved -> " + Arrays.toString(getZoradenie()) + "\n" );
			return false;
			}
	}

	@Override
	public boolean userOdpoved() {
		
		int pom = 0; 
		for(int i = 0; i < odpoved.length; i++ ) {
		
			Integer[] userInput = new Integer[odpoved.length];
			userInput[i] = scanner.nextInt();
		
		if( Objects.equals(zoradenie[i],userInput[i]) ) 
				pom++; 		
		}
		if(pom == odpoved.length)
			return true;
		
		
		return false;
	}

}
