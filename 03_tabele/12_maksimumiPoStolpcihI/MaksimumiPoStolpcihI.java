import java.util.*;
public class MaksimumiPoStolpcihI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] matrika = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matrika[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.toString(maxStolpec(matrika)));
    }

    private static int[] maxStolpec(int[][] t) {
        int[] max = new int[t[0].length];
        for (int i = 0; i < t[0].length; i++) {
            int maxElement = t[0][i];
            for (int j = 0; j < t.length; j++) {
                if (t[j][i] > maxElement) {
                    maxElement = t[j][i];
                }
            }
            max[i] = maxElement;
        }
        return max;
    }
}
