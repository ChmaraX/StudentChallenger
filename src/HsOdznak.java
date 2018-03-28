
public class HsOdznak extends Odznak{

	private String nazov = "Hotstreak Odznak";
	
	public String getNazov() {
		return nazov;
	} 
	
	
	@Override
	int podmienka(int hotstreak) {
		
			if(hotstreak == 3) {
				System.out.println("Ziskal si odznak: Hotstreak x3 (+5b)!");
					return 5; }
			if(hotstreak == 7) {
				System.out.println("Ziskal si odznak: Hotstreak x7 (+10b)!");
				 	return 10; }
			if(hotstreak == 10) {
				System.out.println("Ziskal si odznak: Hotstreak x10 (+20b)!");
					return 20; }
			if(hotstreak > 10) {
				System.out.println("Ziskal si odznak: Ultra Hotstreak (+40b)!");
					return 40; }
			return 0;
		
	}


	
	

}
