package Odznaky;
import java.io.Serializable;

import main.Body;

public class Odznak implements Serializable,Body{


	private static final long serialVersionUID = 1L;
	private String nazov = "";
	private int body;
	

	public Odznak(String nazov, int body) {
	this.nazov = nazov;
	this.body = body;
}

	public String getNazov() {
		return nazov;
	} 
	
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	
	

	@Override
	public int zistiBody() {
		return body;
	}

	@Override
	public void nastavBody(int body) {
		this.body = body;
		
	}

	@Override
	public void zvysBody(int body) {
		this.body += body;
		
	}

	@Override
	public void znizBody(int body) {
		this.body -= body;
		
	}

	
	
}


