import java.util.Scanner;

public class PravilniTrikotniki {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int[][] tocke = new int[n][2];

        for (int i = 0; i < n; i++) {
            tocke[i][0] = sc.nextInt();
            tocke[i][1] = sc.nextInt();
        }

        boolean obstaja = false;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (preveriTrikontik(tocke[i], tocke[j], tocke[k], d)) {
                        obstaja = true;
                        System.out.printf("%d %d %d%n", i, j, k);
                    }
                }
            }
        }
        if (!obstaja)
            System.out.println("BREZ");
    }
 
    private static boolean preveriTrikontik(int[] prvaTocka, int[] drugaTocka, int[] tretjaTocka, int d) {
        double a = razdaljaMedTockama(prvaTocka, drugaTocka);
        double b = razdaljaMedTockama(prvaTocka, tretjaTocka);
        double c = razdaljaMedTockama(tretjaTocka, drugaTocka);
        double max = Math.max(Math.max(a, b), c);
        double min = Math.min(Math.min(a, b), c);
        return (max - min < min * Math.pow(10, -d));
    }

    private static double razdaljaMedTockama(int[] prvaTocka, int[] drugaTocka) {
        return Math.sqrt(Math.pow(prvaTocka[0] - drugaTocka[0],2) + Math.pow(prvaTocka[1] - drugaTocka[1], 2));
    }
}
