import java.util.Arrays;
import java.util.Scanner;

public class LeksiografskoUrejanje {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int[][] t = new int[n][d];

        for (int i = 0; i < n; i++) {
            int[] noviClen = new int[d];
            for (int j = 0; j < d; j++) {
                noviClen[j] = sc.nextInt();
            }

            //ga razvrstimo v array
            int stevec = i;
            while (stevec >= 1 && jeMansi(noviClen, t[stevec-1])) {
                t[stevec] = t[stevec-1];
                stevec--;
            }
            t[stevec] = noviClen;
        }

        for (int[] clen : t) {
            System.out.println(Arrays.toString(clen));
        }
    }

    private static boolean jeMansi(int[] prvi, int[] drugi) {
        for (int i = 0; i < prvi.length; i++) {
            if (drugi[i] < prvi[i]) {
                return false;
            }
            if (prvi[i] < drugi[i])
                return true;
        }
        return true;
    }
}
