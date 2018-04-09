package Otazky;

import java.awt.Color;
import java.util.Objects;


import GUI.TestGUI;




public class SlovnaOtazka extends Otazka {


	private static final long serialVersionUID = 1L;
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
	public void polozOtazku() {
		TestGUI.lblOtazka.setText(getOtazka());
		TestGUI.txtHint.setText("");
		
			
	}
	
	
	@Override
	public boolean userOdpoved() {
		
		String userInput = null;
		
		do {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}while(!TestGUI.clicked);
	
		
		userInput = TestGUI.textField.getText();
		TestGUI.textField.setText("");
		TestGUI.clicked = false;
			/*
		 * Zisti ci sa uzivatelov vstup zhoduje
		 * so spravnou odpovedou
		 */
		if( Objects.equals(getOdpoved(),userInput) ) {
			TestGUI.lblIndicator.setText("Spravna odpoved!");
			TestGUI.lblIndicator.setForeground(Color.GREEN);
			return true;
		}
			
		TestGUI.lblIndicator.setText("Nespravna odpoved! Spravna odpoved -> " + getOdpoved() );		
		TestGUI.lblIndicator.setForeground(Color.RED);
		return false;
				
	}
	




	
	
	
	
	
}
