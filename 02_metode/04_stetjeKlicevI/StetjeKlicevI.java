import java.util.Scanner;
public class StetjeKlicevI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		System.out.print(Stetjeklicev(a,b,n));
	}

	public static int Stetjeklicev(int a, int b, int n) {
		return (n == 0) ? 1 : 1+ (Stetjeklicev(a,b, n/a) + Stetjeklicev(a,b, n/b));
	}	
}	



