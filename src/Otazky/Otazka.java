package Otazky;
import java.io.Serializable;


public abstract class Otazka implements Serializable{

	private static final long serialVersionUID = 1L;
	public int maxBody;
	public String otazka = "";
			
	public abstract boolean polozOtazku();
	
	public abstract boolean userOdpoved();
	

	
	
		
	
			
		
	
	
	
}
