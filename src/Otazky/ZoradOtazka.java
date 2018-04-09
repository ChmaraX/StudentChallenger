package Otazky;
import java.awt.Color;
import java.util.Arrays;
import java.util.Objects;


import GUI.TestGUI;

public class ZoradOtazka extends Otazka{

	
	private static final long serialVersionUID = 1L;
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
	public void polozOtazku() {
		TestGUI.lblOtazka.setText(getOtazka());
		TestGUI.lblPomtext.setText(Arrays.toString(getOdpoved()));
		TestGUI.txtHint.setText("Pomôcka: Napíš èíslo a stlaè -Potvrï- ");
		
		
	}

	@Override
	public boolean userOdpoved() {
		int[] userInput = new int[odpoved.length];
		int pom = 0; 
		boolean rightInput = true;
		
		for(int i = 0; i < odpoved.length; i++ ) {
			TestGUI.btnDalej.setText("Potvrd :" + i);
		/*
		 * cyklus ktori po stlaceni tlacidla 
		 * overuje ci je vstup cislo 
		 */
		do {	
			do {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}while(!TestGUI.clicked);
		
			try {
				userInput[i] = Integer.parseInt(TestGUI.textField.getText());
				rightInput = true;
			} catch (NumberFormatException e) {
				TestGUI.lblIndicator.setText("Zadaj cislo!");
				rightInput = false;
			}
		}while(rightInput == false);
			
			TestGUI.textField.setText("");
			TestGUI.lblIndicator.setText("");
			TestGUI.clicked = false;
		
			
			
		if( Objects.equals(zoradenie[i],userInput[i]) ) 
				pom++; 		
		}
		
		if(pom == odpoved.length) {
			TestGUI.btnDalej.setText("Dalej");
			TestGUI.lblIndicator.setText("Spravna odpoved! \n");
			TestGUI.lblIndicator.setForeground(Color.GREEN);
			TestGUI.txtHint.setText("");
			TestGUI.lblPomtext.setText("");
			return true; }
		
		TestGUI.lblIndicator.setText("Nespravne! Spravna odpoved -> " + Arrays.toString(getZoradenie()) + "\n" );
		TestGUI.lblIndicator.setForeground(Color.RED);
		TestGUI.lblPomtext.setText("");
		return false;
	}

}
