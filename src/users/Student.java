package users;
import java.io.Serializable;
import java.util.Observable;

import badges.Badge;
import main.Points;


public class Student extends Observable implements Serializable, Points{
	

	private static final long serialVersionUID = 1L;
	private final String username;
	private final String password;
	private int age; 
	private String name; 
	private String lastname; 
	private int points; 
	private Badge[] badges = new Badge[100];
	private int hotstreakCount;
	private int examCount;
	private int badgesCount;
	private String skillLevel;
	
		
	
	public Student(String username, String password, int age, String name, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.name = name;
		this.lastname = lastname;
		this.points = 0;
		this.hotstreakCount = 0;
		this.examCount = 0;
		this.badgesCount = 0;
		this.skillLevel = "Zaciatocnik";

	}
		
	

	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}

		
	public int getAge() {
		return age;
	}
	
	
	public String getName() {
		return name;
	}
	

	public String getLastname() {
		return lastname;
	}
	
	public void setSkillLevel(String level) {
		this.skillLevel = level;
	}
	
	public String getSkillLevel() {
		return skillLevel;
	}
	
	
	public void addBadge(Badge od) {
		badges[badgesCount++] = od;
		incPoints(od.getPoints());
	}
	
	public int getBadgesCount() {
		return badgesCount;
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
		setChanged();
		notifyObservers(points);
	}
	
	
	public void incHotstreakCount() {
		this.hotstreakCount++;
		setChanged();
		notifyObservers(hotstreakCount);
	}
	
	public void nullHotstreakCount() {
		this.hotstreakCount = 0;
		setChanged();
		notifyObservers(hotstreakCount);
	}
	
	
	public int getHotstreakCount() {
		return hotstreakCount;
	}
	

	public int getExamCount() {
		return examCount;
	}
	

	public void incExamCount() {
		this.examCount++;
		setChanged();
		notifyObservers(examCount);
	}


	public Badge[] getBadges() {
		return badges;
	}


	

	
	
}
