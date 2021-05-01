import java.util.Scanner;
public class IgorjeviBloki {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int max = (n > m) ? Math.max(n,k) : Math.max(m,k);
		for (int i = 1; i <= max; i++) {
			System.out.print(n >= i ? String.valueOf(n).repeat(n): " ".repeat(n));
			System.out.print(m >= i ? " " + String.valueOf(m).repeat(m): (k >=i) ? " ".repeat(m+1) : "");
			System.out.println(k >= i ? " " + String.valueOf(k).repeat(k) : "");
		} 
	}		
}



