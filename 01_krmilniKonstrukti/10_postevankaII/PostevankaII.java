import java.util.Scanner;
public class PostevankaII {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		
		for (int i = 1; i <= b; i++) {
		System.out.printf("%d * %d = %d%n", a, i, i*a);
		}
	}
}


