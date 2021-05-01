// 	public static void main(String[] args) {
// 		Scanner sc= new Scanner(System.in);
// 		int a = sc.nextInt(), b = sc.nextInt(), m = sc.nextInt();
// 		if (a ==1 || b==0) {
// 			System.out.println(1); return;
// 		}
		
// 		int potenca = phi(m);
// 		b = (potenca <= b) ? b-potenca*(b/potenca) : b;
// 		a %= m;
// 		Double eksp = Math.log(m) / Math.log(a);
// 		System.out.println((long) razbijanje(a, b, m, (int) Math.ceil(eksp)));
// 	}

// 	private static double razbijanje(int a, int b, int m, int eks) {
// 		return Math.pow(Math.pow(a,eks) % m, b/eks) * Math.pow(a, b%eks)%m;
// 	}

// 	//EULER
// 	private static int phi(int n) {
//     	int result = n;  
// 		for (int p = 2; p * p <= n; ++p) {
// 			if (n % p == 0)  {
// 				while (n % p == 0) 
// 					n /= p; 
// 				result -= result / p; 
// 			} 
// 		} 
// 		if (n > 1) 
// 			result -= result / n; 
// 		return result; 
// 	} 

import java.util.Scanner;
public class PotencaPoModulu {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = 1;
		sc.close();
		System.out.println(Zmansanje(a,b,c,d));
	}

	public static long Zmansanje(long a, long b, long c, long d) {
		if (Math.pow(a, b) < c) {
			return (long) ((Math.pow(a, b)) * d) % c;
		}
		else {
			int eksponent = (int)log(a,c);
			if (log(a,c) > eksponent) {
				eksponent++;
			}
			long range = b / eksponent;
			long ostanek = b - range*eksponent;
			ostanek = (long)Math.pow(a,ostanek);
			d *= ostanek;
			if (d > c) {
				d %= c;
			}
			return Zmansanje((long)(Math.pow(a, eksponent) % c), range, c, d);
		}
	}
	public static float log(long n, long N) {
        float result = (float)(Math.log(N) / Math.log(n)); 
        return result; 
    } 
}	



      