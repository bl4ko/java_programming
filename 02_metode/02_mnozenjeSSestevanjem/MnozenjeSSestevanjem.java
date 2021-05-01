import java.util.Scanner;
public class MnozenjeSSestevanjem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		System.out.print(Zmnozek(a,b));
	}
	
	public static int Zmnozek(int a, int b) {
		int vsota = 0;
		for (int i = 1; i <= b; i++) {
			vsota += a;
		}
		return vsota;
	}
	
}	



