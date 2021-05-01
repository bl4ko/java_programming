import java.util.Scanner;

public class Razbijanjestevil {
	// public static void main(String[] args) {
	// 	Scanner sc = new Scanner(System.in);
		
	// 	long n = sc.nextLong();
	// 	int m = sc.nextInt();
	// 	long dolzina_n = 1;
	// 	int dolzina_m = 1;
		
	// 	while (dolzina_n < n/10) {
	// 		dolzina_n *= 10;
	// 	}
	// 	while (dolzina_m < m/10) {
	// 		dolzina_m *= 10;
	// 	}
		
	
	// 	while (m >= 1) {
	// 		int trenutni_m = m / dolzina_m;
	// 		m = m % dolzina_m;
	// 		dolzina_m /= 10;
	// 		for (int i = 1; i <= trenutni_m; i++) {
	// 			System.out.print(n / dolzina_n);
	// 			n = n % dolzina_n;
	// 			dolzina_n /= 10;
	// 		}
	// 		System.out.println();
	// 	}
	// }

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();
		sc.close();

        int prejsni = 0;
        for (char c : b) {
            for (int i = prejsni; i < Character.getNumericValue(c) + prejsni; i++) {
                System.out.print(a[i]);
            }
            prejsni += Character.getNumericValue(c);
            System.out.println();
        }
    }
}	



