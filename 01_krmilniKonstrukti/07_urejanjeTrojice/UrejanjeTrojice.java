import java.util.Scanner;
public class UrejanjeTrojice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//Treba mal ternary povadt xD
		System.out.printf("%d %d %d", a>= b ? (a>=c ? (b>= c ? c : b ): b) : (b>=c ? (c>= a ? a : c ): a), a>=b ?  (a>=c ? (b>=c ? b : c) : a) : (b>=c ? (c>=a ? c : a) : b), a>= b ? (a>=c ? a : c) : (b>=c ? b : c));
	}
}


