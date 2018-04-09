package Uzivatelia;
import java.io.Serializable;
import java.util.Observable;

import Odznaky.Odznak;
import main.Body;


public class Student extends Observable implements Serializable, Body{
	

	private static final long serialVersionUID = 1L;
	private final String username;
	private final String password;
	private int vek; 
	private String meno; 
	private String priezvisko; 
	private int body; 
	private Odznak[] odznaky = new Odznak[100];
	private int hotStreak;
	private int pocetTestov;
	private int pocetOdznakov;
	
		
	
	public Student(String username, String password, int vek, String meno, String priezvisko) {
		super();
		this.username = username;
		this.password = password;
		this.vek = vek;
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.body = 0;
		this.hotStreak = 0;
		this.pocetTestov = 0;
		this.pocetOdznakov = 0;

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
	
	
	public void pridajOdznak(Odznak od) {
		odznaky[pocetOdznakov++] = od;
		zvysBody(od.zistiBody());
	}
	
	public int getPocetOdznakov() {
		return pocetOdznakov;
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
		setChanged();
		notifyObservers(hotStreak);
	}
	
	public void zmazHotStreak() {
		this.hotStreak = 0;
		setChanged();
		notifyObservers(hotStreak);
	}
	
	
	public int getHotStreak() {
		return hotStreak;
	}
	

	public int getPocetTestov() {
		return pocetTestov;
	}
	

	public void zvysPocetTestov() {
		this.pocetTestov++;
	}


	public Odznak[] getOdznaky() {
		return odznaky;
	}


	

	
	
}
