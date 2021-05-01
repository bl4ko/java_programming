import java.util.Scanner;
public class CasovnaRazlikaI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h1 = sc.nextInt();
		int m1 = sc.nextInt();
		int h2 = sc.nextInt();
		int m2 = sc.nextInt();
		sc.close();
		
		int minute1 = h1 * 60 + m1;
		int minute2 = h2 * 60 + m2;
		
		int razlike = (minute1 >= minute2) ? (minute1 - minute2) : (minute2 - minute1);
		System.out.println(razlike);
	}
}


