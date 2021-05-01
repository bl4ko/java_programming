import java.util.Scanner;
public class Potenca {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		
		int vsota = 1;
		for (int i = 1; i <= b; i++) {
			vsota *= a ;
		}
		System.out.println(vsota);
		
	}
}


