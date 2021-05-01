import java.util.Scanner;
public class DigitalneCrtice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] crtice = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6}; 
		int steviloMax = 0;
		int steviloMaxCrtic = 0; 
		for (int i = 1; i <= n; i++) {
			String trenutnoStevilo = sc.next();
			int trenutnoSteviloCrtic = 0; 
			for (int j = 0; j < stevilo.length(); j++) {
				int stevka = (int) stevilo.charAt(j) - 48; stevka -= 48; 
				trenutnoSteviloCrtic += stevka;
			}
			if (trenutnoSteviloCrtic > steviloMaxCrtic) {
				maxCrtic = trenutnoSteviloCrtic;
				steviloMax = Integer.parseInt(trenutnoStevilo); 
			}
		}
		System.out.println(steviloMax);
	}		
}



