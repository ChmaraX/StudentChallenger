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
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.JOptionPane;

import badges.Badge;
import badges.BadgeObserver;
import exams.Exam;
import exceptions.NoExamsException;
import gui.Profile;
import gui.CreateExam;
import gui.ExamGUI;
import questions.MultipleQuestion;
import questions.SimpleQuestion;
import questions.OrderQuestion;
import users.Student;
import users.User;



public class Controller {

		
	/**
	 * Saves user data 
	 * @param sList - List of all students
	 * @param fileName - file where the data is stored
	 */
	public void serialize(List<User> sList, String fileName) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(sList);
		} catch(IOException ex) {
			System.out.println("Problem pri serializacii uzivatelov");
			System.out.println(ex.getMessage());
		}
	} 
	
	/**
	 * Loads user data
	 * @param fileName - file where the data is stored
	 * @return List of all users
	 */
	@SuppressWarnings("unchecked")
	public List<User> deserialize(String fileName) {
		List<User> sList = null; 
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			sList = (List<User>) in.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.printf("Problem pri deserializacii uzivatelov", fileName); 
			System.out.println(ex.getMessage());
		}
		return sList;
	}
	
	
	/**
	 * Creates a new user object
	 * @param username 
	 * @param password
	 * @param age
	 * @param name
	 * @param lastname
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void addStudent(String username, String password, int age, String name, String lastname) 
			throws FileNotFoundException, IOException, ClassNotFoundException {
						
	

		List<User> studenti = deserialize("students.ser"); 
		studenti.add(new Student(username, password, age, name, lastname));
		
		
		//studenti.clear();  /*--- clears list*/ 
		
		serialize(studenti,"students.ser");
				
		
		List<User> newList = deserialize("students.ser");
		System.out.println("Novy list:  " + newList);
	
	}
	
	
	/**
	 * Checks if user input match user data / login
	 * @param username
	 * @param password
	 * @return index of user if true
	 */
	public int checkLogin(String username, String password) {
		
		List<User> studenti = deserialize("students.ser"); 
			
		for (int i = 0; i < studenti.size(); i++) {
			
		if (studenti.get(i).getUsername().contains(username) 
		&&  studenti.get(i).getPassword().contains(password)) 
				return i;
											
				}
		return -1;
			}

	/*
	 * Saves exam data
	 */
	public void serializeExam(List<Exam> tList, String fileName) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(tList);
		} catch(IOException ex) {
			System.out.println("Problem pri serializacii testov");
			System.out.println(ex.getMessage());
		}
	} 
	
	/*
	 * Loads exam data
	 */
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
	
	/**
	 * Creates a new exam with chosen questions,
	 * question type, and name.
	 * @throws InterruptedException
	 */
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
		// Waits for button to be clicked
		String examName = CreateExam.txtNazovTestu.getText(); 				
		testy.add(new Exam(examName));
		CreateExam.txtNazovTestu.setText("");
		CreateExam.clicked = false;
		
		
		Exam currTest = testy.get(testy.size() - 1); 
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
	
	/*
	 * Temporary function
	 * creates new exam without typing
	 * in GUI
	 */
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
	
	/**
	 * Iterates exam object names into string array
	 * @return Array of strings with exam names
	 */
	public String[] examNames()  {
		
		List<Exam> testy = deserializeExam("exams.ser");
		String[] examNames = new String[testy.size()];
		
		/*
		 * Catching created exception if there
		 * are no exams available
		 */
		if(testy.size() == 0) {
			try {
				throw new NoExamsException();
			} catch (NoExamsException e) {
				e.printStackTrace();
			}
		}
				
		for(int i = 0 ; i < testy.size(); i++) {
			examNames[i] = testy.get(i).getName();
				}
		return examNames;
}
	

	/**
	 * Starts and exam and adds results 
	 * (badges,points,hotstreaks...) to the user
	 * @param testIndex index of selected exam
	 * @param idUser id of current logged user
	 */
	public void startExam(int testIndex, int idUser) {
		
		
		List<Exam> testy = deserializeExam("exams.ser");
		int result;

		/*
		 * Toggling timer doubles the final amount
		 * of points
		 */
		if(ExamGUI.chckbxCasovacMin.isSelected()) {
			timer(20);
			result = 2 * testy.get(testIndex).startExam();
		}
		else {
			result = testy.get(testIndex).startExam(); 
		}
		
		JOptionPane.showMessageDialog(null, "Vysledny pocet bodov: " + result + "/" + testy.get(testIndex).getQuestionCount());

		List<User> studenti = deserialize("students.ser"); 
		Student actUser = (Student) studenti.get(idUser);
		
		BadgeObserver badgeObserver = new BadgeObserver(actUser);
		actUser.addObserver(badgeObserver);

		
		actUser.incPoints(result);
		actUser.incExamCount();
		skill(actUser);
		
		if(result >= testy.get(testIndex).getQuestionCount()) 
			actUser.incHotstreakCount();
		else
			actUser.nullHotstreakCount();
		
		
		serialize(studenti,"students.ser");
		
		
		
	}
	
	
	/**
	 * Stars a new TimerTask countdown with seconds as a parameter
	 */
	static int seconds = 0;
	public void timer(int duration) {
		
		seconds = duration;
		
		Timer timer = new Timer();
		 TimerTask task = new TimerTask() {
		 
		        @Override
		        public void run() { 
		        	
		            if (seconds > 0) {
		                ExamGUI.lblTimer.setText("" + seconds);
		                seconds--;
		            } else {
		            	ExamGUI.lblTimer.setText("Vyprsal cas.");
		            	ExamGUI.frmTest.dispose();
		            	cancel();
		            }
		        }
		    };
		    timer.schedule(task, 0, 1000);
	}
	
	/**
	 * Set user skill level according to actual points
	 * @param actUser current logged user
	 */
	public void skill(Student actUser) {
		
		int points = actUser.getPoints();
		
			if(points >= 15) {
					actUser.setSkillLevel("Pokrocily");				
				}
			if(points >= 100 ) {	
					actUser.setSkillLevel("Veteran");
				 }
			if(points >= 200 ) {		
					actUser.setSkillLevel("Master");
				 }
	}
	
	
	
	/**
	 * Shows user profile stats at the end of the exam
	 * @param idUser id of current logged user
	 */
	public void showProfileStats(int idUser) {
		
		List<User> studenti = deserialize("students.ser"); 
		Student actUser = (Student) studenti.get(idUser);
		
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
		
		
		
		if(close == 0) {
			ExamGUI.frmTest.dispose();
		}
	}
	
	 
	/**
	 * Shows actual user profile
	 * @param idUser id of current logged user
	 */
	public void showProfile(int idUser) {
		
		Profile profile = new Profile(idUser);
		List<User> studenti = deserialize("students.ser"); 
		Student actUser = (Student)studenti.get(idUser);
		
		
		profile.lblNickname.setText(actUser.getUsername());
	    profile.txtName.setText(actUser.getName());
	    profile.txtLastname.setText(actUser.getLastname());
	    profile.txtPoints.setText(Integer.toString(actUser.getPoints()));
	    profile.txtBadgeCount.setText(Integer.toString(actUser.getBadgesCount()));
	    profile.txtExamCount.setText(Integer.toString(actUser.getExamCount()));
	    profile.txtAge.setText(Integer.toString(actUser.getAge()));
	    profile.lblSkill.setText(actUser.getSkillLevel());
	    
		for(Badge i : actUser.getBadges()){
			if(i != null)
				profile.txtBadges.append(i.getName() + "\n");
			}
		
	}
	
	/**
	 * @return matrix for Table used in Ladderboard
	 */
	public String[][] studentTableData() {
		
		List<User> studenti = deserialize("students.ser"); 

		
		String[][] studentData = new String[studenti.size()][7];
		int i = 0;
		for (User sd : studenti) {
			
		
	        String[] stdata = new String[7];
	        stdata[0] = sd.getUsername();
	        stdata[1] = sd.getName();
	        stdata[2] = sd.getLastname();
	        stdata[3] = Integer.toString(sd.getPoints());
	        stdata[4] = Integer.toString(((Student) sd).getBadgesCount());
	        stdata[5] = Integer.toString(((Student) sd).getExamCount());

	        studentData[i++] = stdata;
	    }

		return studentData;
		
	}
}
