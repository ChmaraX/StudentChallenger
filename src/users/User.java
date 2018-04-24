package users;

import java.io.Serializable;
import java.util.Observable;

import main.Points;

public abstract class User extends Observable implements Serializable, Points {


	private static final long serialVersionUID = 1L;
	protected String username;
	protected String password;
	protected String name; 
	protected String lastname; 
	protected int age; 
	
	
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
	
	
	
	
	
	
}
