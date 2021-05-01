import java.util.Scanner;
public class Najblizjielement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int indeksMin = 0;
		int minRazdalja  = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int razdalja = Math.abs(a-k);
			if (minRazdalja == 0 || razdalja < minRazdalja) {
				minRazdalja = razdalja;
				indeksMin = i;
			}
		}
		System.out.println(indeksMin);
	}		
}



