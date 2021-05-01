import java.util.*;
public class MaksimumiPoStolpcihII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[][] matrika = new int[a][];
        int maxDolzinaVrstice = 0;
        for (int i = 0; i < a; i++) {
            int b = sc.nextInt();
            maxDolzinaVrstice = b > maxDolzinaVrstice ? b : maxDolzinaVrstice;
            matrika[i] = new int[b];
            for (int j = 0; j < b; j++) {
                matrika[i][j] = sc.nextInt();
            } 
        }
        System.out.println(Arrays.toString(maxStolpec(matrika, maxDolzinaVrstice)));
    }

    private static int[] maxStolpec(int[][] t, int maxL) {
        int[] max = new int[maxL];
        for (int i = 0; i < maxL; i++) {
            int prvi = 0;
            while (t[prvi].length -1 < i) {
                prvi++;
            }
            max[i] = t[prvi][i];
            for (int j = prvi + 1; j < t.length; j++) {
                if (t[j].length - 1 >= i) {
                    int trenutni = t[j][i];
                    if (trenutni > max[i])
                        max[i] = trenutni;
                }
            }
        }
        return max;
    }
}
