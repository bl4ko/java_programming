import java.util.Scanner;
public class Evrosop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int enke = 0;
		int dvojke = 0;
		while (sc.hasNext()) {
			int a = sc.nextInt();
			switch (a) {
				case 1:
					enke++;
					break;
				case 2:
					enke--;
					if (enke == -1) {
						System.out.println("BANKROT");
						return;
					}
					dvojke++;
			}
		}
		System.out.printf("%d%n%d", enke, dvojke);
	}
}


