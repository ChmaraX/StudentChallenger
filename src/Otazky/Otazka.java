package Otazky;
import java.util.Scanner;

public abstract class Otazka{

	public int maxBody;
	public String otazka = "";
	
	Scanner scanner = new Scanner(System.in);	
		
	public abstract boolean polozOtazku();
	
	public abstract boolean userOdpoved();
	
	
	
		
	
			
		
	
	
	
}
