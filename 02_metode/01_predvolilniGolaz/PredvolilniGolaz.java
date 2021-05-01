import java.util.Scanner;
public class PredvolilniGolaz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int budget = sc.nextInt();
		
		while (sc.hasNextInt()) {
			int cenakosila = sc.nextInt();
			int stevilokosila = sc.nextInt();
			int izbranovino = sc.nextInt();
			int Skupnacena = Cena(cenakosila, stevilokosila, izbranovino);
			budget -= Skupnacena;
			if (budget > 0) 
				System.out.printf("%d %d%n", Skupnacena, budget);
			else {
				System.out.printf("%d %s", Skupnacena, budget < 0 ? "-" : "0"); break;
			}
		}
	}

	private static int Cena(int a, int b, int c) {
		int trenutna_vsota = a * b;
		return (c==1) ? (int) Math.round(trenutna_vsota*1.5) : trenutna_vsota;
	}
}	



