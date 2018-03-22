
public class Test {

	private String nazov; 
	private int totalScore; 
	private int actScore = 0; 
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


	public int getTotalScore() {
		return totalScore;
	}


	public int getActScore() {
		return actScore;
	}



	public void pridajOtazku(Otazka ot) {
		o[pocetOtazok++] = ot;
		this.totalScore++;
	}
	  
	
	public void startTest() {
        for (int i = 0; i < this.pocetOtazok; i++) {
            Otazka ot = this.o[i];
            ot.polozOtazku();
           
            if(ot.userOdpoved())
            	this.actScore += 1;          
      
        }
        
        System.out.println("Finalne skore: " + actScore + "/" + totalScore);
        System.out.println("Nespravne odpovede: " + actScore + "/" + totalScore);
       
    }
	
	
	
	
}
