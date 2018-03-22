import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Controller {

		
	
	public void serialize(List<Student> sList, String fileName) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(sList);
		} catch(IOException ex) {
			System.out.println("Problem pri serializacii");
			System.out.println(ex.getMessage());
		}
	} 
	
	
	@SuppressWarnings("unchecked")
	public List<Student> deserialize(String fileName) {
		List<Student> sList = null; 
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			sList = (List<Student>) in.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.printf("Problem pri deserializacii", fileName); 
			System.out.println(ex.getMessage());
		}
		return sList;
	}
	
	
	public void addStudent(int vek, String meno, String priezvisko) 
			throws FileNotFoundException, IOException, ClassNotFoundException {
						
	
		List<Student> studenti = deserialize("studenti.ser"); 
		studenti.add(new Student(vek, meno, priezvisko));
		
		// studenti.clear(); --- vycistenie db
		
		serialize(studenti,"studenti.ser");
				
		
		List<Student> newList = deserialize("studenti.ser");
		System.out.println("Novy list:  " + newList);
	
	}
	
	public void addLogin(String username, String password) {
		
		try {
		    Files.write(Paths.get("loginData.txt"), username.getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("loginData.txt"), ",".getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("loginData.txt"), password.getBytes(), StandardOpenOption.APPEND);
		    Files.write(Paths.get("loginData.txt"), "\n".getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e1) {
		    //pre pripad nenajdenia txt suboru
		}
		
	}
	
	public void checkLogin(String username, String password) {
		
		Scanner x;
		String tempMeno = "";
		String tempHeslo = "";
		boolean found = false;
		
		try {
			x = new Scanner(new File("loginData.txt"));
			x.useDelimiter("[,\n]"); // prehladavanie po castiach s ","

			while (x.hasNext() && !found) {
				tempMeno = x.next();
				tempHeslo = x.next();

				if (tempMeno.trim().equals(username.trim()) && tempHeslo.trim().equals(password.trim())) {
					found = true;
					}}
			
			if (found == false) {
				JOptionPane.showMessageDialog(null, "Nespravne udaje", "Login Error",JOptionPane.ERROR_MESSAGE);
					}

			} 
			catch (Exception e1) {
			System.out.println("Nebola najdena databaza!");
				}
	}
	 
}
