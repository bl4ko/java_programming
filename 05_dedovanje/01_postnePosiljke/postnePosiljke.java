import java.util.Scanner;
public class postnePosiljke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] t = new int[6];
        for (int i = 0; i < 6; i++) {
            t[i] = sc.nextInt();
        }

        Telegram[] vsaPosta = new Telegram[t[5]];
        for (int i =0; i < t[5]; i++) {
            switch (sc.next()) {
                case "telegram":
                    vsaPosta[i] = new Telegram(t, sc.next(), sc.next(), "T");
                    break;
            
                case "navadnoPismo":
                    vsaPosta[i] = new Pismo(t, sc.next(), sc.next(), "NP", sc.nextInt());
                    break;
            
                default :
                    vsaPosta[i] = new PPismo(t, sc.next(), sc.next(), "PP", sc.nextInt(), sc.next());
            }
        }

        int x = sc.nextInt();
        switch (x) {
            case 1:
                for (Telegram posta : vsaPosta)
                    System.out.println(posta.toString());
                break;
            case 2:
                Telegram max = null;
                int cenaMax = 0;
                for (Telegram joze : vsaPosta) {
                    if (joze.cena() > cenaMax) {
                        max = joze;
                        cenaMax = joze.cena();
                    }
                }
                System.out.println(max.toString());
                break;
            default:
                for (int i = 0; i < vsaPosta.length; i++) {
                    if (vsaPosta[i] instanceof PPismo) {
                        PPismo pov = (PPismo) vsaPosta[i];
                        System.out.println(pov.povratnica(t));
                    }
                }
        }
    }
}
