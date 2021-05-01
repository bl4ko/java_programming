import java.util.Scanner;
public class PostevankaIII {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		
		for (int i = 1; i * a <= b; i++) 
			System.out.printf("%d * %d = %d%n", a, i, i*a);
	}
}


