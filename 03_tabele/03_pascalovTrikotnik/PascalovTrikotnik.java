import java.util.Scanner;
public class PascalovTrikotnik {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] tprejsna = {1};
		for (int i = 0; i <= n; i++) {
			for (int k = 0; k < tprejsna.length - 1; k++) {
				System.out.print(tprejsna[k] + " ");
			}
			System.out.println(1);
			int[] tnova = new int[i + 2];
			tnova[0] = 1;
			tnova[i+1] = 1;
			for (int j = 1; j <= i; j++) {
				tnova[j] = tprejsna[j-1] + tprejsna[j];	
			}
			tprejsna = tnova;	
		}	
	}		
}



