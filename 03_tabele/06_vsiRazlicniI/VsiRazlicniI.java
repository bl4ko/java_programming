import java.util.Scanner;
import java.util.Arrays;

public class VsiRazlicniI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tapravaDolzina = 1;
		int[] t = new int[n];
		int dvakratNastopa = 0;
		for (int i =0; i<n; i++) {
			int a = sc.nextInt();
			for (int j = 0; j<tapravaDolzina;j++) {
				if (t[j] == a) {
					if (dvakratNastopa == 0 || a < dvakratNastopa)
						dvakratNastopa = a;
				}
			}
			t[i] = a;
			tapravaDolzina++;
		}
		System.out.println((dvakratNastopa == 0) ? "RAZLICNI" : dvakratNastopa);
	}
}