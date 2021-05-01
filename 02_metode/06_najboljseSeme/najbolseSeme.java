import java.util.Random;
import java.util.Scanner;

public class najbolseSeme {
	public static void main(String[] args) {
		// interval [a, b]  n = dolzina stevila
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		
		long max = 0;
		int indSeme = 0;
		for (int i = a; i <= b; i++) {
			Random rand = new Random(i);
			long trenutno = 0;
			for (int j = n - 1; j >= 0; j--) {
				trenutno += rand.nextInt(10) * Math.pow(10, j);
			}
			if (trenutno > max) {
				max = trenutno;
				indSeme = i;
			}
			
		}
		System.out.println(indSeme);
	}
}