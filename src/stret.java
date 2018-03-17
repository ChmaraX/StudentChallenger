

public class stret {

	public static void main(String[] args) {
		
		
		Test[] t = new Test[5];
		t[0] = new Test("Prvy test");
		t[1] = new Test("Druhy test");
		
		
		
		
		System.out.println(t[0].getNazov());
		
		t[0].pridajOtazku(new Otazka("Haha","hehe"));
		t[0].pridajOtazku(new Otazka("Heeaha","hihi"));
		
		t[1].pridajOtazku(new Otazka("sadsd","dsads"));
		t[1].pridajOtazku(new Otazka("qweqwe","asdsad"));
		

		System.out.println(t[0].startTest());
		System.out.println(t[1].startTest());
	
		
	}

}
