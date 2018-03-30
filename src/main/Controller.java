package main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Otazky.MultipleOtazka;

import Otazky.SlovnaOtazka;
import Otazky.ZoradOtazka;
import Testy.Test;
import Uzivatelia.Student;



public class Controller {

		
	
	public void serialize(List<Student> sList, String fileName) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(sList);
		} catch(IOException ex) {
			System.out.println("Problem pri serializacii studentov");
			System.out.println(ex.getMessage());
		}
	} 
	
	
	@SuppressWarnings("unchecked")
	public List<Student> deserialize(String fileName) {
		List<Student> sList = null; 
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			sList = (List<Student>) in.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.printf("Problem pri deserializacii studentov", fileName); 
			System.out.println(ex.getMessage());
		}
		return sList;
	}
	
	
	public void addStudent(String username, String password, int vek, String meno, String priezvisko) 
			throws FileNotFoundException, IOException, ClassNotFoundException {
						
	
		List<Student> studenti = deserialize("studenti.ser"); 
		//List<Student> studenti = new ArrayList<Student>();
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

	
	public void serializeTest(List<Test> tList, String fileName) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(tList);
		} catch(IOException ex) {
			System.out.println("Problem pri serializacii testov");
			System.out.println(ex.getMessage());
		}
	} 
	
	
	@SuppressWarnings("unchecked")
	public List<Test> deserializeTest(String fileName) {
		List<Test> tList = null; 
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			tList = (List<Test>) in.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.printf("Problem pri deserializacii testov", fileName); 
			System.out.println(ex.getMessage());
		}
		return tList;
	}
	
	
	public void vytvorTest() {
		
		List<Test> testy = deserializeTest("testy.ser");
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Zadaj nazov testu: ");
		String nazovTestu = sc.nextLine(); 
		testy.add(new Test(nazovTestu));
		
		Test currTest = testy.get(testy.size() - 1); // zisti poradie posledneho testu
		int moznost = -1;
			
		while(moznost != 0) {
			
			System.out.println("Aky typ otazky chces pridat?: \n");
			System.out.println("1. Slovna \n2. Multiple \n3. Zoradovacia \n0. Vytvor test");	
			moznost = sc.nextInt();
			sc.nextLine();
			
		if(moznost == 1) {
			System.out.println("Zadaj znenie otazky: ");
					String znenie = sc.nextLine();
					
			System.out.println("Zadaj odpoved: ");
					String odpoved = sc.nextLine();
				
					currTest.pridajOtazku(new SlovnaOtazka(znenie, odpoved)); 
		}
		if(moznost == 2) {
			System.out.println("Zadaj znenie otazky: \n");
					String znenie = sc.nextLine();
					
			System.out.println("Zadaj moznosti: \n");
			String[] moznosti = new String[4];
						for (int i = 0; i < 4; i ++) 
								moznosti[i] = sc.nextLine();
						
			System.out.println("Zadaj cislo spravnej moznosti: \n");
						Integer spravna = sc.nextInt();
						sc.nextLine();
					
					currTest.pridajOtazku(new MultipleOtazka(znenie, moznosti, spravna));
		}
		if(moznost == 3) {
			System.out.println("Zadaj znenie otazky: \n");
					String znenie = sc.nextLine();
					
			System.out.println("Zadaj odpovede na zoradenie: \n");
					String[] odpovede = new String[4];
						for (int i = 0; i < 4; i ++) 
								odpovede[i] = sc.nextLine();
							
			System.out.println("Zadaj spravnu postupnost cisiel: \n");
					int[] postupnost = new int[4];
						for (int i = 0; i < 4; i ++) 
								postupnost[i] = sc.nextInt();
							
					
						currTest.pridajOtazku(new ZoradOtazka(znenie, odpovede, postupnost));	
					
		}
	}
		sc.close();
		serializeTest(testy, "testy.ser");		
	}
	
	public void docasnaFunkcia() {
		List<Test> testy = new ArrayList<Test>();
		
		testy.add(new Test("Prvy test"));
		
		testy.get(0).pridajOtazku(new SlovnaOtazka("1 Prva otazka","prva odpoved"));
		testy.get(0).pridajOtazku(new SlovnaOtazka("1 Druha otazka","druha odpoved"));
		testy.get(0).pridajOtazku(new MultipleOtazka("1 Tretia otazka", new String[] {"nespravna","nespravna","spravna"},2));
		testy.get(0).pridajOtazku(new ZoradOtazka("Zorad od najmensieho", new String[] {"3","1","7","4"},new int[] {2,1,4,3} ));
			
		
		
		serializeTest(testy, "testy.ser");
	
		List<Test> testy2 = deserializeTest("testy.ser");
		System.out.println(testy2);
	}
	

}
	
	 

