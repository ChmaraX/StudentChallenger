import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Controller {

	public static void main(String[] args) {
		
		
		Login.main(null);
		
	}
	
	
	
	
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
	
	
	 
}
