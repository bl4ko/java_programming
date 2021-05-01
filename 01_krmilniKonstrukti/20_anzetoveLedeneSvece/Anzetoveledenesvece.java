import java.util.Scanner;
public class Anzetoveledenesvece {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dolzina_vrstice = Rekurzija(n);
		int presledek = 1;
		
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < dolzina_vrstice; j++) {
				if (j % presledek == 0) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}	
			}
			presledek*=2;
			System.out.println();			
		}
	}
	
	private static int Rekurzija(int n) {
		if (n==1) {
			return 2;
		}
		else {
			return Rekurzija(n-1)*2 -1;
		}
	}
}	



