import java.util.Scanner;
import java.util.Arrays;

public class IzstopajociElement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n];
		t[0] = sc.nextInt();
		boolean nic = true;
		
		for (int i = 1; i < n; i++) {
			t[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			int kandidat = t[i];
			int[] t2 = new int[n-1];
			for (int j = 0 , k = 0; j<n && k <n-1; j++ , k++) {
				if (j == i) {
					t2[k] = t[j+1];
					j++;
				}
				else {
					t2[k] = t[j];
				}
			}
			
			int gcd = findGCD(t2, t2.length);
			if (kandidat % gcd != 0) {
				System.out.println(kandidat);
				nic = false;
			}
		}
		if (nic) {
			System.out.println("NIC");
		}
	}
	
	public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
	
	public static int findGCD(int arr[], int n) {
        int result = 0;
        for (int element: arr){
            result = gcd(result, element);

            if(result == 1)
            {
               return 1;
            }
        }
        return result;
    }
}