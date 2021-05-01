import java.util.Random;
import java.util.Scanner;
public class ZdolgocasenaMojca {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int k = sc.nextInt();
		int d = sc.nextInt();

		Random rand = new Random(s);
		for (int i = 1; i <= d; i++) {
			System.out.println(i + ". dan:");
			int vsota = 0;
			for (int j = 1; !prastevilo(vsota); j++) {
				vsota = 0;
				System.out.printf("    %d. met: ", j);
				for (int l = 1; l <= k; l++) {
					int met = rand.nextInt(6)+1;
					vsota+= met;
					System.out.print(met + " ");
				}
				System.out.println("| vsota = " + vsota);
			}
		}
	}
	
	public static boolean prastevilo(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
}


