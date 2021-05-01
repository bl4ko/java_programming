import java.util.Scanner;
public class Piramidastevil {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.print(" ".repeat(n-i));
			for (int j = i; j <= 3*i-2; j++) {
				System.out.print(j%10);
			}
			System.out.println();
		}	
	}
}



