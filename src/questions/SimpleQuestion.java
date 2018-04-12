package questions;

import java.awt.Color;
import java.util.Objects;

import gui.ExamGUI;




public class SimpleQuestion extends Question {


	private static final long serialVersionUID = 1L;
	private String answer = ""; 
		
	
	public SimpleQuestion(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
		}


	public String getQuestion() {
		return question;
	}
	
	public String getAnswer() {
		return answer;
	}

	
	@Override
	public void askQuestion() {
		ExamGUI.lblQuestion.setText(getQuestion());
		ExamGUI.txtHint.setText("");
		
			
	}
	
	
	@Override
	public boolean userAnswer() {
		
		String userInput = null;
		
		do {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}while(!ExamGUI.clicked);
	
		
		userInput = ExamGUI.textField.getText();
		ExamGUI.textField.setText("");
		ExamGUI.clicked = false;
			/*
		 * Zisti ci sa uzivatelov vstup zhoduje
		 * so spravnou odpovedou
		 */
		if( Objects.equals(getAnswer(),userInput) ) {
			ExamGUI.lblIndicator.setText("Spravna odpoved!");
			ExamGUI.lblIndicator.setForeground(Color.GREEN);
			return true;
		}
			
		ExamGUI.lblIndicator.setText("Nespravna odpoved! Spravna odpoved -> " + getAnswer() );		
		ExamGUI.lblIndicator.setForeground(Color.RED);
		return false;
				
	}
	




	
	
	
	
	
}
