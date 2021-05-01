import java.util.Scanner;
public class Voznired {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h1 = sc.nextInt();
		int m1 = sc.nextInt();
		int h2 = sc.nextInt();
		int m2 = sc.nextInt();
		int m = sc.nextInt();
		
		int minute1 = h1 * 60 + m1;
		int minute2 = h2 * 60 + m2;
		
		while (minute1 <= minute2) {
			System.out.printf("%02d:%02d%n", minute1 / 60, minute1 % 60);
			minute1 += m;
		}
		
	}
}



