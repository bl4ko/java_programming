import java.util.Scanner;
public class Smucanje {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int najbolsi_cas = 0, najbols_indeks = 0;
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			if (a==0) continue;
			int b = sc.nextInt();
			if (a > 0 && b > 0) {
				if (najbolsi_cas == 0 || a + b < najbolsi_cas) {
					najbols_indeks = i;
					najbolsi_cas = a+b;
				}
			}
		}
		System.out.println(najbols_indeks == 0 ? "NIHCE" : String.format("%d%n%d", najbols_indeks, najbolsi_cas));
	}
}


