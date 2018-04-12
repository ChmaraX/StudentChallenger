package questions;
import java.awt.Color;
import java.util.Arrays;
import java.util.Objects;

import gui.ExamGUI;

public class MultipleQuestion extends Question {


	private static final long serialVersionUID = 1L;
	private String[] options;
	private int answer; 
		
	
	public MultipleQuestion(String question, String[] options, int answer) {
		super();
		this.question = question;
		this.options = options;
		this.answer = answer;
	}
	
	
	public String getQuestion() {
		return question;
	}
	
	public String[] getOptions() {
		return options;
	}

	public String getSingleOption(int i) {
		return options[i];
	}
	
	public int getAnswer() {
		return answer;
	}


	@Override
	public void askQuestion() {
		ExamGUI.lblQuestion.setText(getQuestion());
		ExamGUI.lblPomtext.setText(Arrays.toString(getOptions()));
		ExamGUI.txtHint.setText("Pomôcka: Napíš správnu odpoveï.");
		
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
				
		if( Objects.equals(getSingleOption(getAnswer()),userInput) ) {
			ExamGUI.lblIndicator.setText("Spravna odpoved!");
			ExamGUI.lblIndicator.setForeground(Color.GREEN);
			ExamGUI.txtHint.setText("");
			return true; }
			
		ExamGUI.lblIndicator.setText("Nespravne! Spravna odpoved -> " + options[getAnswer()] + "\n" );
		ExamGUI.lblIndicator.setForeground(Color.RED);
		return false;
	}
	
	

}
