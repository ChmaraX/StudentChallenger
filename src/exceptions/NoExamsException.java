package exceptions;

public class NoExamsException extends Exception{

	
	static String notification = "There are no existing exams yet.";
	private static final long serialVersionUID = 1L;
	
	public NoExamsException() {
		super(notification);
	}

}
