import java.util.Scanner;

public class ZlataSredina {
	//pr furstku smo sam navadno urejanje delal ?? -> time limit dj 2s
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int k2 = 2 * k  + 1;
		int[] t = new int[k2];
		t[0] = sc.nextInt();
		for (int i = 1; i < k2; i++) {
			int a = sc.nextInt();
			int stevec = i - 1;
			while (stevec >= 0 && a < t[stevec]) {
				t[stevec + 1] = t[stevec];
				stevec--;
			}
			t[stevec + 1] = a;
		}
		System.out.print(t[(2*k + 1)/ 2]);
	}	
}
