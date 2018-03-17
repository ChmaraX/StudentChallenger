import java.io.Serializable;
import java.util.Random;

public class Student implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private int ID; 
	private int vek; 
	private String meno; 
	private String priezvisko; 
	private int body; 
	
		
	
	public Student(int vek, String meno, String priezvisko) {
		super();
		Random rand = new Random();
		ID = rand.nextInt(100) + 1;
		this.vek = vek;
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.body = 0; 
	}
	

	public int getID() {
		return ID;
	}
	
		
	public int getVek() {
		return vek;
	}
	
	
	public String getMeno() {
		return meno;
	}
	

	public String getPriezvisko() {
		return priezvisko;
	}
	


	public int getBody() {
		return body;
	}


	public void setBody(int body) {
		this.body = body;
	}
	
	
	
	
}
