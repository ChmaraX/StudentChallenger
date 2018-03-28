import java.io.Serializable;


public class Student implements Serializable, Body{
	

	private static final long serialVersionUID = 1L;
	private final String username;
	private final String password;
	private int vek; 
	private String meno; 
	private String priezvisko; 
	private int body; 
	private String[] odznaky;
	private int hotStreak;
	
		
	
	public Student(String username, String password, int vek, String meno, String priezvisko) {
		super();
		this.username = username;
		this.password = password;
		this.vek = vek;
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.body = 0;
		this.hotStreak = 0;
	}
		
	

	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
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
	
	
	public String[] getOdznaky() {
		return odznaky;
	}


	public int zistiBody() {
		return body;
	}
	
	
	public void nastavBody(int body) {
		this.body = body;
	}
	
	
	public void znizBody(int body) {
		this.body -= body;
	}
	
	
	public void zvysBody(int body) {
		this.body += body;
	}
	
	public void zvysHotstreak() {
		this.hotStreak++;
	}
	
	
	
	
}
