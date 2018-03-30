package Testy;
import Otazky.Otazka;
import main.Body;

public class Test implements Body {

	private String nazov;
	private int body;
	private int pocetOtazok = 0;
	private int pocetTestov = 0;
	private Otazka[] o = new Otazka[100]; // maximum otazok
	

	
	
	public Test(String nazov) {
		super();
		this.nazov = nazov;
		this.pocetTestov++;
		}

		
	public Otazka getOtazka(int poradie) {
	    return o[poradie]; 
	}
	
	public String getNazov() {
		return nazov;
	}
	
	public int getPocetOtazok() {
		return pocetOtazok;
	}
	
	public int getPocetTestov() {
		return pocetTestov;
	}
	
	public int zistiBody() {
		return body;
	}
	
	public void nastavBody(int body) {
		this.body = body;
	}
	
	public void znizBody(int body) {
		this.body -= body;
	}
	
	public void zvysBody(int body) {
		this.body += body;
	}


	public void pridajOtazku(Otazka ot) {
		o[pocetOtazok++] = ot;
		zvysBody(1);
	}
	
 
	
	public int startTest() {
		System.out.println(getNazov());
        for (int i = 0; i < this.pocetOtazok; i++) {
            Otazka ot = this.o[i];
            
            if(!ot.polozOtazku())
            	znizBody(1);          
      
        }
        /* kazda otazka je za defaultne za 1 bod -> max body = pocet otazok */ 
        System.out.println("Finalne skore: " + zistiBody() + "/" + pocetOtazok);
        
       return zistiBody();
       
    }
	
	
	
	
}
