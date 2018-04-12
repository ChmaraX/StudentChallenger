package badges;
import java.io.Serializable;

import main.Points;

public class Badge implements Serializable,Points{


	private static final long serialVersionUID = 1L;
	private String name = "";
	private int points;
	

	public Badge(String name, int points) {
	this.name = name;
	this.points = points;
}

	public String getName() {
		return name;
	} 
	
	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
		
	}

	@Override
	public void incPoints(int points) {
		this.points += points;
		
	}

	@Override
	public void decPoints(int points) {
		this.points -= points;
		
	}

	
	
}


