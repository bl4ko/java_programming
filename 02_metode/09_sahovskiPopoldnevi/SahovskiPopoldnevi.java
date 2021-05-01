import java.util.Random;
import java.util.Scanner;
public class SahovskiPopoldnevi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int p = sc.nextInt();
		int z = sc.nextInt();
		int d = sc.nextInt();
		Random rand = new Random(s);
		
		for (int i = 1; i <= d; i++) {
			System.out.printf("%d. dan: ", i);
			int stDvobojev = 0;
			int zmagA = 0;
			int zmagB = 0;
			while (stDvobojev < p && zmagA < z && zmagB < z) {
				int stPik = rand.nextInt(100);
				if (stPik < a) {
					zmagA++;
					System.out.print("A");
				}
				else if (stPik >= a && stPik < a + b) {
					zmagB++;
					System.out.print("B");
				}
				else {
					System.out.print("r");
				}
				stDvobojev++;
			}
			System.out.printf(" (%d)%n" , stDvobojev);
		}
	}
}


