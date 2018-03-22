

public class stret {

	public static void main(String[] args) {
		
		
		Test[] t = new Test[5];
		t[0] = new Test("Prvy test");
		t[1] = new Test("Druhy test");
		
		
		
		
		System.out.println(t[0].getNazov());
		
		t[0].pridajOtazku(new Otazka("1 Prva otazka","prva odpoved"));
		t[0].pridajOtazku(new Otazka("2 Druha otazka","druha odpoved"));
		
		t[1].pridajOtazku(new Otazka("2 Prva","prva"));
		t[1].pridajOtazku(new Otazka("2 Druha","druha"));
		

		t[0].startTest();
		
	
		
	}

}
