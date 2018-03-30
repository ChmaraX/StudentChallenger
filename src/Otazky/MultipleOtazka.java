package Otazky;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class MultipleOtazka extends Otazka {


	private static final long serialVersionUID = 1L;
	private String[] moznosti;
	private int odpoved; 
		
	
	public MultipleOtazka(String otazka, String[] moznosti, int odpoved) {
		super();
		this.otazka = otazka;
		this.moznosti = moznosti;
		this.odpoved = odpoved;
	}
	
	
	public String getOtazka() {
		return otazka;
	}


	public String[] getMoznosti() {
		return moznosti;
	}
	
	public int getOdpoved() {
		return odpoved;
	}


	@Override
	public boolean polozOtazku() {
		System.out.println(getOtazka());
		System.out.println(Arrays.toString(getMoznosti()));
		
		if(userOdpoved()) {
			System.out.println("Spravna odpoved! \n");
			return true; 
			}
		else	{
			System.out.println("Nespravne! Spravna odpoved -> " + moznosti[getOdpoved()] + "\n" );
			return false;
			}
	}

	@Override
	public boolean userOdpoved() {
		@SuppressWarnings("resource") // scanner nieje uzavrety
		Scanner scanner = new Scanner(System.in);
		Integer userInput = scanner.nextInt();
		
		
		if( Objects.equals(getOdpoved(),userInput) ) 
			return true;
		
		return false;
	}
	
	

}
