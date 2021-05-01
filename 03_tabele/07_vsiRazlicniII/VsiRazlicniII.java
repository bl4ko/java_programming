import java.util.*;

public class VsiRazlicniII {
    private static final int MAKS_STEVILO = 10000;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
		int n = sc.nextInt();
        int[] t = new int[20001];
    
        Random random = new Random(s);
		for (int i =0; i<n; i++) {
            int clen = random.nextInt(2* MAKS_STEVILO + 1) -MAKS_STEVILO;
            t[clen+10000]++;
        }

        int indeksMaks = -1;
        int vrednostMaks = 1;
        for (int i = 0; i < 20001; i++) {
            int vrednost = t[i];
            if (vrednost > vrednostMaks) {
                vrednostMaks = vrednost;
                indeksMaks = i;
            }
        }
        System.out.println(vrednostMaks == 1 ? "RAZLICNI" : indeksMaks-10000); 
	}
}