import java.util.*;

public class Kombinacije { //rip
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //do kok grejo stevila
		int k = sc.nextInt(); // kok je array dolg
		sc.close();
		int[] array = new int[k];
		
		for (int i = 0, j = 1; i < k; i++, j++ ) {
			array[i] = j;
		}
		rekurzija(array, n, k, 0);
	}	
		
	public static void rekurzija(int[] t, int n, int k, int nivo) {
		if (nivo == k) {
			System.out.println(Arrays.toString(t));
			return;
		}

		int zacetek = (nivo == 0) ? 1 : t[nivo-1]+1;
		for (int i = zacetek; i <= n - (k-nivo) + 1; i++) {
			t[nivo] = i;
			rekurzija(t,n,k, nivo + 1);
		}
	}
}
