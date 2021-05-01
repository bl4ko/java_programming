import java.util.Scanner;
public class MedianaTrojiceII {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if (Max(a,b) == Min(b,c) || Max(c,b) == Min(a,b)) 
			System.out.print(b);
		
		else if (Max(b,a) == Min(a,c) || Max(a,c) == Min(b,a)) 
			System.out.print(a);
		
		else 
			System.out.print(c);
	}

	public static int Max(int a, int b) {
		return((a > b)) ?  a :  b;
	}

	public static int Min(int a, int b) {
		return((a > b)) ?  b :  a;
	}
}	



