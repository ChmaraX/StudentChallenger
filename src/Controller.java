import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


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
	
	
	public void addStudent(String username, String password, int vek, String meno, String priezvisko) 
			throws FileNotFoundException, IOException, ClassNotFoundException {
						
	
		List<Student> studenti = deserialize("studenti.ser"); 
		studenti.add(new Student(username, password, vek, meno, priezvisko));
		
		/* studenti.clear();  /*--- vycistenie db*/ 
		
		serialize(studenti,"studenti.ser");
				
		
		List<Student> newList = deserialize("studenti.ser");
		System.out.println("Novy list:  " + newList);
	
	}
	
	
	public int checkLogin(String username, String password) {
		/*
		 * overí èi dany uzivatel existuje 
		 * ak ano tak vrati jeho poradove cislo v liste
		 */
		List<Student> studenti = deserialize("studenti.ser"); 
			
		for (int i = 0; i < studenti.size(); i++) {
			
		if (studenti.get(i).getUsername().contains(username) 
		&&  studenti.get(i).getPassword().contains(password)) 
				return i;
											
				}
		return -1;
			}
	
	
	
	
	
	
	

}
	
	 

