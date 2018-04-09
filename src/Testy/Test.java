package Testy;
import java.io.Serializable;

import GUI.TestGUI;
import Otazky.Otazka;
import main.Body;

public class Test implements Serializable,Body {

	
	private static final long serialVersionUID = 1L;
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
		
	
	public int startTest()  {
			TestGUI.lblNazovtestu.setText(getNazov());
			TestGUI.progressBar.setMaximum(this.pocetOtazok);
		
        for (int i = 0; i < this.pocetOtazok; i++) {
            Otazka ot = this.o[i];
            	ot.polozOtazku();
                       	
            if(!ot.userOdpoved())
            	znizBody(1);    
           
            TestGUI.progressBar.setValue(i+1);
        }
               
       return zistiBody();
       
    }
	
	
	
	
}
