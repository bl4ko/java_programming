import java.util.*;
public class TelefonskiImenik {
	//ilegalen nacin xD, spodi legalen
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String, String> imenik = new HashMap<>();
		for (int i = 0; i <n ; i++) {
			String ime = sc.next();
			String tel = sc.next();
			imenik.put(ime,tel);
		}
		int k = sc.nextInt();
		for (int i =0 ; i < k; i++) {
			String ime = sc.next();
			String fonska = imenik.get(ime);
			System.out.println(fonska!=null ? fonska : "NEZNANA");
		}
	}

	// public static void main(String[] args) {
	// 	Scanner sc = new Scanner(System.in);
	// 	int n = sc.nextInt();
	// 	if (n==0) {
	// 		int n2 = sc.nextInt();
	// 		while (n2 > 0) {
	// 			System.out.println("NEZNANA");
	// 			n2--;
	// 		}
	// 		return;
	// 	}
	// 	String[][] imenik = new String[n][n];
		
		
	// 	for (int i = 0; i < n; i++) {
	// 		imenik[0][i] = sc.next();
	// 		imenik[1][i] = sc.next();
	// 	}
		
	// 	int n2 = sc.nextInt();
	// 	for (int i = 0; i < n2; i++) {
	// 		String b = sc.next();
	// 		if (indeks(b, imenik) >=0) {
	// 			System.out.println(imenik[1][indeks(b, imenik)]);
	// 		}
	// 		else {
	// 			System.out.println("NEZNANA");
	// 		}
	// 	}
	// }
	
	// public static int indeks(String a,String[][] t) {
	// 	for (int i = t[0].length - 1; i >= 0; i--) {
	// 		if (a.equals(t[0][i])) {
	// 			return i;
	// 		}
	// 	}
	// 	return -1;
	// }
	
}



