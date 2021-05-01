import java.util.Scanner;
public class Glavni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Telo[] telesa = new Telo[n];

        for (int i = 0; i < n; i++) {
            switch (sc.nextInt()) {
                case 1: {
                    Kvader novi = new Kvader("kvader",sc.nextInt(), sc.nextInt(), sc.nextInt());
                    int volumen = novi.volumen();
                    telesa[indeksNovi(volumen, telesa, i)] = novi;
                    break;
                }
                case 2: {
                    Kocka novi = new Kocka("kocka",sc.nextInt());
                    int volumen = novi.volumen();
                    telesa[indeksNovi(volumen, telesa, i)] = novi;
                    break;
                }
                case 3: {
                    Krogla novi = new Krogla("krogla",sc.nextInt());
                    int volumen = novi.volumen();
                    telesa[indeksNovi(volumen, telesa, i)] = novi;
                }
            }
        }

        for (Telo telo : telesa) { 
            System.out.println(telo.toString());
        }
    }

    private static int indeksNovi(int volumen, Telo[] telesa, int indeks) {
        int stevec = indeks;
        while (stevec >= 1 && telesa[stevec-1].volumen() < volumen) {
            telesa[stevec] = telesa[stevec-1];
            stevec--;
        }
        return stevec;
    }
}
