import java.util.Scanner;
public class Stevilskazaporedja {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();
		
		if (k == 0 || k > 0 ? (b>=a ? false : true) : (b>a ? true : false)) {
			System.out.println("NAPAKA");
		}
		else {
			int razdalja = Math.abs((b-a) / (k));
			for (int i = 0; i <= razdalja; i++, a+=k) {
				System.out.println(a);
			} 
		}
	}
}


