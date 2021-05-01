import java.util.Scanner;
public class MedianaTrojiceI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		int mediana = (a < b) ? (a > c ? a : (c > b ? b : c)) : (b > c ? b : (c > a ? a : c));
		System.out.println(mediana);
	}
}


