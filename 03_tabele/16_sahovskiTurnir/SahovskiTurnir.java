import java.util.*;

public class SahovskiTurnir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] razultati = new int[n][2];
        for (int i = 1; i <= n; i++) {
            razultati[i-1][0] = i;
        }

        while (sc.hasNextInt()) {
            int indeksPrvi = sc.nextInt();
            int indeksDrugi = sc.nextInt();
            int razultat = sc.nextInt();
            switch (razultat) {
                case 0:
                    razultati[indeksPrvi-1][1]++;
                    razultati[indeksDrugi-1][1]++;
                    break;
                case 1:
                    razultati[indeksPrvi-1][1]+=2;
                    break;
                case -1:
                    razultati[indeksDrugi-1][1]+=2;
            }
        }
        //System.out.println(Arrays.deepToString(razultati));
        //sortirat
        for (int i = 1; i < n; i++) {
            int stevec = i;
            int[] trenutno = razultati[stevec];
            while (stevec > 0 && razultati[stevec- 1][1] <= trenutno[1]) {
                if (razultati[stevec - 1][1] == trenutno[1]) {
                    if (razultati[stevec-1][0] <= trenutno[0])
                        break;
                }
                razultati[stevec] = razultati[stevec-1];
                stevec--;
            }
            razultati[stevec] = trenutno;
        }

        for (int[] razultat : razultati) {
            System.out.printf("%d %d%n", razultat[0], razultat[1]);
        }
    }    
}
