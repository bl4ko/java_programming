import java.util.Scanner;
public class AbsolutnaVrednost {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); sc.close();
		System.out.println((n>=0) ? (n) : (-n));
	}
}


