

public class Test implements Body {

	private String nazov;
	private int body;
	private int pocetOtazok = 0;
	private Otazka[] o = new Otazka[100]; // maximum otazok
	

	
	
	public Test(String nazov) {
		super();
		this.nazov = nazov;
		}

		
	public Otazka getOtazka(int poradie) {
	    return o[poradie]; 
	}

	
	public String getNazov() {
		return nazov;
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
	
 
	
	public int startTest(int idUser) {
		System.out.println(getNazov());
        for (int i = 0; i < this.pocetOtazok; i++) {
            Otazka ot = this.o[i];
            
            if(!ot.polozOtazku())
            	znizBody(1);          
      
        }
        /* kazda otazka je za defaultne za 1 bod -> max body = pocet otazok*/ 
        System.out.println("Finalne skore: " + zistiBody() + "/" + pocetOtazok);
        
       return zistiBody();
       
    }
	
	
	
	
}
