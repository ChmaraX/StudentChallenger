package questions;
import java.awt.Color;
import java.util.Arrays;
import java.util.Objects;

import gui.ExamGUI;

public class OrderQuestion extends Question{

	
	private static final long serialVersionUID = 1L;
	private	String[] answer;
	private int[] order; 
		
	
	public OrderQuestion(String question, String[] answer, int[] order) {
		super();
		this.question = question;
		this.answer = answer;
		this.order = order;
	}
	
	

	public String getQuestion() {
		return question;
	}


	public String[] getAnswer() {
		return answer;
	}


	public int[] getOrder() {
		return order;
	}


	@Override
	public void askQuestion() {
		ExamGUI.lblQuestion.setText(getQuestion());
		ExamGUI.lblPomtext.setText(Arrays.toString(getAnswer()));
		ExamGUI.txtHint.setText("Pomôcka: Napíš èíslo a stlaè -Potvrï- ");
		
		
	}

	@Override
	public boolean userAnswer() {
		int[] userInput = new int[answer.length];
		int pom = 0; 
		boolean rightInput = true;
		
		for(int i = 0; i < answer.length; i++ ) {
			ExamGUI.btnNext.setText("Potvrd :" + i);
		/*
		 * cyklus ktori po stlaceni tlacidla 
		 * overuje ci je zadany vstup cislo 
		 */
		do {	
			do {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}while(!ExamGUI.clicked);
		
			try {
				userInput[i] = Integer.parseInt(ExamGUI.textField.getText());
				rightInput = true;
			} catch (NumberFormatException e) {
				ExamGUI.lblIndicator.setText("Zadaj cislo!");
				rightInput = false;
			}
		}while(rightInput == false);
			
			ExamGUI.textField.setText("");
			ExamGUI.lblIndicator.setText("");
			ExamGUI.clicked = false;
		
			
			
		if( Objects.equals(order[i],userInput[i]) ) 
				pom++; 		
		}
		
		if(pom == answer.length) {
			ExamGUI.btnNext.setText("Dalej");
			ExamGUI.lblIndicator.setText("Spravna odpoved! \n");
			ExamGUI.lblIndicator.setForeground(Color.GREEN);
			ExamGUI.txtHint.setText("");
			ExamGUI.lblPomtext.setText("");
			return true; }
		
		ExamGUI.lblIndicator.setText("Nespravne! Spravna odpoved -> " + Arrays.toString(getOrder()) + "\n" );
		ExamGUI.lblIndicator.setForeground(Color.RED);
		ExamGUI.lblPomtext.setText("");
		return false;
	}

}
