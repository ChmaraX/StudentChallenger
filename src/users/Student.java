package users;
import badges.Badge;


public class Student extends User{
	

	private static final long serialVersionUID = 1L;
	private int points; 
	private Badge[] badges = new Badge[100];
	private int hotstreakCount;
	private short examCount;
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
