import java.util.Scanner;
public class Sahovnica {
	//Grda koda - furst me je zjebu z presledki :(
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		for (int i = -1; i < n*k+1; i++) {
			if (i == -1 || i == n*k) {
				System.out.println(String.format("+%s +"," -".repeat(m*k)));
			}
			else {
				System.out.print("| ");
				for (int j = 0; j < m*k*2; j+=2) {
					if (i % (2*k) < k && j % (k*4) < k*2 || i % (2*k) >= k && j % (k*4) >=k *2)
						System.out.print("  ");
					else {
						System.out.print("* ");
					}
				}
				System.out.println("|");
			}
		}
	}	
}



