package Otazky;
import java.awt.Color;
import java.util.Arrays;
import java.util.Objects;


import GUI.TestGUI;

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

	public String getMoznost(int i) {
		return moznosti[i];
	}
	
	public int getOdpoved() {
		return odpoved;
	}


	@Override
	public void polozOtazku() {
		TestGUI.lblOtazka.setText(getOtazka());
		TestGUI.lblPomtext.setText(Arrays.toString(getMoznosti()));
		TestGUI.txtHint.setText("Pomôcka: Napíš správnu odpoveï.");
		
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
				
		if( Objects.equals(getMoznost(getOdpoved()),userInput) ) {
			TestGUI.lblIndicator.setText("Spravna odpoved!");
			TestGUI.lblIndicator.setForeground(Color.GREEN);
			TestGUI.txtHint.setText("");
			return true; }
			
		TestGUI.lblIndicator.setText("Nespravne! Spravna odpoved -> " + moznosti[getOdpoved()] + "\n" );
		TestGUI.lblIndicator.setForeground(Color.RED);
		return false;
	}
	
	

}
