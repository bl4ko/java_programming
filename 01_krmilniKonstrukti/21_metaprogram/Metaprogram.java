import java.util.Scanner;
public class Metaprogram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int presledek = 0;
		for (int i =0; i < (n+2)*2+1; i++) {
			if (i == 0) {
				System.out.println("public class Nizi {");
				presledek += 4;
			}
			else if (i == 1) {
				System.out.println(" ".repeat(presledek) + "public static void main(String[] args) {");
				presledek += 4;
			}
			else if (i < 2+n) {
				System.out.printf("%sfor (char c%d = 'A';  c%d <= 'Z';  c%d++) {%n", " ".repeat(presledek), i-1, i-1,i-1);
				presledek+=4;
			}
			else if (i == 2+n) {
				StringBuilder str = new StringBuilder(" ".repeat(presledek) + "System.out.println(\"\"");
				for (int j = 1; j <= n; j++) {
					str.append(" + c"+j);
				}
				System.out.println(str + ");");
			}
			else {
				presledek-=4;
				System.out.println(" ".repeat(presledek) +"}");
			}
		}
	}
}	



