package main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import badges.Badge;
import badges.HotstreakBadge;
import badges.ExamBadge;
import exams.Exam;
import gui.Profile;
import gui.CreateExam;
import gui.ExamGUI;
import questions.MultipleQuestion;
import questions.SimpleQuestion;
import questions.OrderQuestion;
import users.Student;



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
	
	
	public void addStudent(String username, String password, int age, String name, String lastname) 
			throws FileNotFoundException, IOException, ClassNotFoundException {
						
	
		List<Student> studenti = deserialize("students.ser"); 
		//List<Student> studenti = new ArrayList<Student>();
		studenti.add(new Student(username, password, age, name, lastname));
		
		/* studenti.clear();  /*--- vycistenie db*/ 
		
		serialize(studenti,"students.ser");
				
		
		List<Student> newList = deserialize("students.ser");
		System.out.println("Novy list:  " + newList);
	
	}
	
	
	public int checkLogin(String username, String password) {
		/*
		 * overí èi dany uzivatel existuje 
		 * ak ano tak vrati jeho poradove cislo v liste
		 */
		
		
		List<Student> studenti = deserialize("students.ser"); 
			
		for (int i = 0; i < studenti.size(); i++) {
			
		if (studenti.get(i).getUsername().contains(username) 
		&&  studenti.get(i).getPassword().contains(password)) 
				return i;
											
				}
		return -1;
			}

	
	public void serializeExam(List<Exam> tList, String fileName) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(tList);
		} catch(IOException ex) {
			System.out.println("Problem pri serializacii testov");
			System.out.println(ex.getMessage());
		}
	} 
	
	
	@SuppressWarnings("unchecked")
	public List<Exam> deserializeExam(String fileName) {
		List<Exam> tList = null; 
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			tList = (List<Exam>) in.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.printf("Problem pri deserializacii testov", fileName); 
			System.out.println(ex.getMessage());
		}
		return tList;
	}
	
	
	public void createExam() throws InterruptedException {
		
		List<Exam> testy = deserializeExam("exams.ser");
					
		CreateExam.btnCreateExam.setVisible(false);
		CreateExam.lblZadajNazovTestu.setVisible(true);
		CreateExam.btnPotvrd.setVisible(true);
		CreateExam.txtNazovTestu.setVisible(true);
		
		CreateExam.lblZadajNazovTestu.setText("Zadaj nazov testu: ");
		
		do{
		Thread.sleep(500);	
		}while(CreateExam.clicked == false);
		//caka na kliknutie tlacidla pre vytvorenie testu
		String examName = CreateExam.txtNazovTestu.getText(); 				
		testy.add(new Exam(examName));
		CreateExam.txtNazovTestu.setText("");
		CreateExam.clicked = false;
		
		
		Exam currTest = testy.get(testy.size() - 1); // zisti poradie aktualneho testu
		int option = -1;
			
		while(option != 0) {
			
			CreateExam.lblZadajNazovTestu.setText("Aky typ otazky chces pridat?");
			CreateExam.lblPom.setText("1. Slovna \n2. Multiple \n3. Zoradovacia \n0. Vytvor test");	
			do{
				Thread.sleep(500);	
				}while(CreateExam.clicked == false);
			option = Integer.parseInt(CreateExam.txtNazovTestu.getText());
			CreateExam.clicked = false;
			CreateExam.txtNazovTestu.setText("");
			CreateExam.lblPom.setText("");
			
			
		if(option == 1) {
			CreateExam.lblZadajNazovTestu.setText("Zadaj znenie otazky: ");
					
			do{
				Thread.sleep(500);	
				}while(CreateExam.clicked == false);
			String question =  CreateExam.txtNazovTestu.getText();
			CreateExam.clicked = false;
			CreateExam.txtNazovTestu.setText("");
					
			CreateExam.lblZadajNazovTestu.setText("Zadaj odpoved:");
			do{
				Thread.sleep(500);	
				}while(CreateExam.clicked == false);
					String answer = CreateExam.txtNazovTestu.getText();
					CreateExam.clicked = false;
					CreateExam.txtNazovTestu.setText("");
				
					currTest.addQuestion(new SimpleQuestion(question, answer)); 
		}
		if(option == 2) {
			CreateExam.lblZadajNazovTestu.setText("Zadaj znenie otazky: \n");
			do{
				Thread.sleep(500);	
				}while(CreateExam.clicked == false);
						String question = CreateExam.txtNazovTestu.getText();
						CreateExam.clicked = false;
						CreateExam.txtNazovTestu.setText("");
						
					CreateExam.lblZadajNazovTestu.setText("Zadaj moznosti: \n");
				String[] options = new String[4];
				
						for (int i = 0; i < 4; i ++) {
							do{
								Thread.sleep(500);	
								}while(CreateExam.clicked == false);
								
							options[i] = CreateExam.txtNazovTestu.getText();
							CreateExam.clicked = false;
							CreateExam.txtNazovTestu.setText("");
						}
						
						CreateExam.lblZadajNazovTestu.setText("Zadaj cislo spravnej moznosti: \n");
						do{
							Thread.sleep(500);	
							}while(CreateExam.clicked == false);
						Integer correctAnswer = Integer.parseInt(CreateExam.txtNazovTestu.getText());
						CreateExam.clicked = false;
						CreateExam.txtNazovTestu.setText("");
					
					currTest.addQuestion(new MultipleQuestion(question, options, correctAnswer));
		}
		if(option == 3) {
			CreateExam.lblZadajNazovTestu.setText("Zadaj znenie otazky: \n");
			do{
				Thread.sleep(500);	
				}while(CreateExam.clicked == false);
					String question = CreateExam.txtNazovTestu.getText();
					CreateExam.clicked = false;
					CreateExam.txtNazovTestu.setText("");
					
					CreateExam.lblZadajNazovTestu.setText("Zadaj odpovede na zoradenie: \n");
					String[] answers = new String[4];
						for (int i = 0; i < 4; i ++) {
							do{
								Thread.sleep(500);	
								}while(CreateExam.clicked == false);
							
								answers[i] = CreateExam.txtNazovTestu.getText();
								CreateExam.clicked = false;
								CreateExam.txtNazovTestu.setText("");
								
						}
							
				CreateExam.lblZadajNazovTestu.setText("Zadaj spravnu postupnost cisiel: \n");
					int[] order = new int[4];
						for (int i = 0; i < 4; i ++) {
							
							do{
								Thread.sleep(500);	
								}while(CreateExam.clicked == false);
							
								order[i] = Integer.parseInt(CreateExam.txtNazovTestu.getText());
								CreateExam.clicked = false;
								CreateExam.txtNazovTestu.setText("");
						}
					
						currTest.addQuestion(new OrderQuestion(question, answers, order));	
					
		}
	}
	
		serializeExam(testy, "exams.ser");		
	}
	
	public void docasnaFunkcia() {
		//List<Exam> testy = new ArrayList<Exam>();
		
		List<Exam> testy = deserializeExam("exams.ser");
			
		testy.add(new Exam("Matematicky test"));
		
		Exam currTest = testy.get(testy.size() - 1);
		
		currTest.addQuestion(new SimpleQuestion("Aky typ funkcie je y = x + 1?","linearna"));
		currTest.addQuestion(new MultipleQuestion("Funkcia sinus je pomer protilahlej na:", new String[] {"vysku","taznicu","preponu","uhol"},2));
		currTest.addQuestion(new OrderQuestion("Zorad od najmensieho:", new String[] {"log 10","2pi","0","-e"},new int[] {4,3,1,2} ));
		currTest.addQuestion(new SimpleQuestion("Meno slavneho matematika na P.","Pytagoras"));	
		
		
		serializeExam(testy, "exams.ser");
	
		List<Exam> testy2 = deserializeExam("exams.ser");
		System.out.println(testy2);
	}
	

	public String[] examNames() {
		
		List<Exam> testy = deserializeExam("exams.ser");
		String[] examNames = new String[testy.size()];
				
		for(int i = 0 ; i < testy.size(); i++) {
			examNames[i] = testy.get(i).getName();
				}
		return examNames;
}
	
	
	/*
	 * Zacne a vyhodnoti vybrany test 
	 * pre vybraneho studnta
	 */
	public void startExam(int testIndex, int idUser) {
		
		
		List<Exam> testy = deserializeExam("exams.ser");
		
		int result = testy.get(testIndex).startExam(); 
		
		JOptionPane.showMessageDialog(null, "Vysledny pocet bodov: " + result + "/" + testy.get(testIndex).getQuestionCount());

		List<Student> studenti = deserialize("students.ser"); 
		Student actUser = studenti.get(idUser);
		
		HotstreakBadge badgeObserver = new HotstreakBadge(actUser);
		ExamBadge examObserver = new ExamBadge(actUser);
		actUser.addObserver(badgeObserver);
		actUser.addObserver(examObserver);
		
		
		actUser.incPoints(result);
		actUser.incExamCount();
		
		if(result == testy.get(testIndex).getQuestionCount()) 
			actUser.incHotstreakCount();
		else
			actUser.nullHotstreakCount();
		
		
		serialize(studenti,"students.ser");
		
		
		
	}
	
	
	public void showProfileStats(int idUser) {
		
		List<Student> studenti = deserialize("students.ser"); 
		Student actUser = studenti.get(idUser);
		
		ArrayList<String> list = new ArrayList<String>();
		for(Badge i : actUser.getBadges()){
			if(i != null)
		list.add(i.getName());
				} 
				
		int close = JOptionPane.showOptionDialog(ExamGUI.frmTest, 
				"Celkove skore uzivatela - " + actUser.getUsername() + " je: " + actUser.getPoints() + 
				"\n Hotstreak: " + actUser.getHotstreakCount() +
				"\n Odznaky: " 	+ Arrays.toString(list.toArray())			
				,"Vysledok testu",
				JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.INFORMATION_MESSAGE,
				null, null, null);
		
		
		
		if(close == 0) 
			ExamGUI.frmTest.dispose();
	}
	
	 

	public void showProfile(int idUser) {
		
		Profile profile = new Profile(idUser);
		List<Student> studenti = deserialize("students.ser"); 
		Student actUser = studenti.get(idUser);
		
		
		profile.lblNickname.setText(actUser.getUsername());
	    profile.txtName.setText(actUser.getName());
	    profile.txtLastname.setText(actUser.getLastname());
	    profile.txtPoints.setText(Integer.toString(actUser.getPoints()));
	    profile.txtBadgeCount.setText(Integer.toString(actUser.getBadgesCount()));
	    profile.txtExamCount.setText(Integer.toString(actUser.getExamCount()));
	    profile.txtAge.setText(Integer.toString(actUser.getAge()));
	    
		for(Badge i : actUser.getBadges()){
			if(i != null)
				profile.txtBadges.append(i.getName() + "\n");
			}
		
	}
	
	
	public String[][] studentTableData() {
		
		List<Student> studenti = deserialize("students.ser"); 

		
		String[][] studentData = new String[studenti.size()][7];
		int i = 0;
		for (Student sd : studenti) {
			//udaje kazdeho ziaka zvlast v cykle
			
		
	        String[] stdata = new String[7];
	        stdata[0] = sd.getUsername();
	        stdata[1] = sd.getName();
	        stdata[2] = sd.getLastname();
	        stdata[3] = Integer.toString(sd.getPoints());
	        stdata[4] = Integer.toString(sd.getBadgesCount());
	        stdata[5] = Integer.toString(sd.getExamCount());

	        studentData[i++] = stdata;
	        //premiestni 6 udajov o jednom studentovi do prislusneho riadku matice
	    }


		return studentData;
		
	}
}
