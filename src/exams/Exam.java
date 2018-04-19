package exams;
import java.io.Serializable;

import gui.ExamGUI;
import main.Points;
import questions.Question;

public class Exam implements Serializable,Points {

	
	private static final long serialVersionUID = 1L;
	private String name;
	private int points;
	private int questionCount = 0;
	private int examCount = 0;
	private Question[] qt = new Question[100]; // maximum otazok
		
	
	public Exam(String name) {
		super();
		this.name = name;
		this.examCount++;
		}

		
	public Question getQuestion(int num) {
	    return qt[num]; 
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuestionCount() {
		return questionCount;
	}
	
	public int getExamCount() {
		return examCount;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void decPoints(int points) {
		this.points -= points;
	}
	
	public void incPoints(int points) {
		this.points += points;
	}


	public void addQuestion(Question q) {
		qt[questionCount++] = q;
		incPoints(1);
	}
		
	
	public int startExam()  {
			ExamGUI.lblExamName.setText(getName());
			ExamGUI.progressBar.setMaximum(this.questionCount);
				
		
        for (int i = 0; i < this.questionCount; i++) {
            Question qt = this.qt[i];
            	qt.askQuestion();
            		
            if(!qt.userAnswer())
            	decPoints(1);    
           
            ExamGUI.progressBar.setValue(i+1);
        }
               
       return getPoints();
       
    }
	
	
	
	
}
