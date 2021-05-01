import java.util.Scanner;
import java.util.Arrays;

//REKURZIJA :sadface:
public class Determinanta {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] matrika = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				matrika[i][j] = sc.nextInt(); 
		}

		System.out.println(razvojVrstica(matrika, n, n));
	}
	
	
	//razvijamo determinanto po vrstici
	private static int razvojVrstica(int[][] matrika, int dimenzija, int trenutnaDimenzija) {
		int vsota = 0;
		if (trenutnaDimenzija==1) {
			return matrika[dimenzija-1][dimenzija-1];
		}
		int i = dimenzija-trenutnaDimenzija;
		for (int j = dimenzija-trenutnaDimenzija; j < dimenzija; j++) {
			vsota += (int) Math.pow(-1, i + j) * razvojVrstica(matrika, dimenzija, trenutnaDimenzija-1) * matrika[i][j];
		}
		return vsota;
	}
}
