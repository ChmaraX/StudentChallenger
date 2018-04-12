package questions;
import java.io.Serializable;


public abstract class Question implements Serializable{

	private static final long serialVersionUID = 1L;
	public int maxPoints;
	public String question = "";
			
	public abstract void askQuestion();
	
	public abstract boolean userAnswer();
	

	
	
		
	
			
		
	
	
	
}
