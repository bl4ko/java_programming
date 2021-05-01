import java.util.Scanner;

public class StetjeKlicev {
    /* I. verzija
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(rekurzija(a, b, n, new int[n+1])+1);
    }

    private static int rekurzija(int a, int b, int n, int[] memo) {
        if (n==0) 
            return 0;
        int noviKlici = 0;
        if (memo[n] == 0) {
            memo[n]++;
            noviKlici++;
        }
        return noviKlici + rekurzija(a,b, n/a, memo) + rekurzija(a, b, n/b, memo);
    } */

    
    /* II. verzija
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        // rekurzija(n=0) mi nesteje zato pristejemo se eno
        System.out.println(rekurzija(a, b, n, new int[n+1], 0));
    }

    private static int rekurzija(int a, int b, int n, int[] memo, int vsota) {
        if (memo[n] == 0) {
            memo[n]++;
            vsota += 1 + rekurzija(a,b, n/a, memo, 0) + rekurzija(a, b, n/b, memo, 0);
        }
        return vsota;
    } */


    //III. verzija
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        // rekurzija(n=0) mi nesteje zato pristejemo se eno
        System.out.println(rekurzija(a, b, n, new boolean[n+1]));
    }

    private static int rekurzija(int a, int b, int n, boolean[] memo) {
        if (!memo[n]) {
            memo[n] = !memo[n];
            return 1 + rekurzija(a,b, n/a, memo) + rekurzija(a, b, n/b, memo);
        }
        return 0;
    }
}


