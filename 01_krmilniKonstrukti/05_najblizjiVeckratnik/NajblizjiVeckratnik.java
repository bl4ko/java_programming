import java.util.Scanner;
public class NajblizjiVeckratnik {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int koeficient = b / a;
		if (b % a > a/2) {
			koeficient++;
		}
		System.out.println(koeficient * a);
		
		
		
		
	}
}


