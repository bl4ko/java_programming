import java.util.Scanner;
import java.util.Random;
public class Vrazeverniboris {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int n = sc.nextInt();
		Random rand = new Random(s);
		for (int i = 1; i <=n; i++) {
			System.out.println(kockanje(i%7==0, rand, i));
		}
	}

	private static String kockanje(boolean nedelja, Random rand, int i) {
		StringBuilder str = new StringBuilder(String.format("%4d (%s): ", i, nedelja ? "N" : "D"));
		int stevec = 0;
		int stevec2 = 0;
		while (stevec < (nedelja ? 5 : 3)) {
			int stPik = rand.nextInt(6) + 1;
			if (stPik % 2 == 1) {
				stevec++;
			}
			str.append(stPik + " ");
			stevec2++;
		}
		str.append(String.format("[%d]", stevec2));
		return str.toString();
	}
}
		




