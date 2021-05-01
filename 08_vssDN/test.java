import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;

public class test {

    private static final String[] tipiParcel = {"TRAVNATA POVRSINA", "GOZDNA POVRSINA", "OBDELOVALNA POVRSINA", "BIVALNO POSLOPJE", "INDUSTRIJSKO POSLOPJE"};
    private static final double[] vrednostiTipovParcel = {500.0, 750.0, 1000.0, 10000.0, 50000.0};

    private static final char oznakeObjektov[] = {' ', '.', ':', '-', '=', '+', '*', '#', '%', '@'};

    public static int[][] preberiTeren(String datoteka) throws FileNotFoundException {
        Scanner input = new Scanner(new File(datoteka));
        int h = input.nextInt(); //height
        int w = input.nextInt(); //width
        int teren[][] = new int[h][w];  //ustavrimo teren velikosti H * W
        for (int vrstica = 0; vrstica < h; vrstica++) //preberemo elemente za vsako vrstico posebi
            for (int stolpec = 0; stolpec < w; stolpec++)
                teren[vrstica][stolpec] = input.nextInt();
        input.close();
        return teren;
    }

    public static int[][] preberiTipParcel(String datoteka) throws FileNotFoundException {
        Map<Character, Integer> char2num = Map.of('T', 0, 'G', 1, 'O', 2, 'B', 3, 'I', 4);
        Scanner input = new Scanner(new File(datoteka));
        int h = input.nextInt(); //height
        int w = input.nextInt(); //width
        int parcele[][] = new int[h][w];
        for (int vrstica = 0; vrstica < h; vrstica++) {
            String inputLine = input.next();
            for (int stolpec = 0; stolpec < w; stolpec++) {
                parcele[vrstica][stolpec] = char2num.get(inputLine.charAt(stolpec));
            }
        }
        return parcele;
    }

    public static void izrisTerena(int[][] teren) {
        for (int vrstica = 0; vrstica < teren.length; vrstica++, System.out.println()) //sprehod cez elemnte v terenu
            for(int stolpec = 0; stolpec < teren[vrstica].length; stolpec++) 
                System.out.print(oznakeObjektov[teren[vrstica][stolpec]]);
    }

    public static void izrisiPoplavo(int[][] teren, boolean[][] poplava) {
        for (int i = 0; i < teren.length; i++, System.out.println())
            for (int j = 0; j < teren[i].length; j++) 
                System.out.print(poplava[i][j] ? '~' : oznakeObjektov[teren[i][j]]);
    }

    public static int[] prestejVisine(int[][] teren) {
        int visine[] = new int[10];
        for (int vrstica = 0; vrstica < teren.length; vrstica++)
            for (int stolpec = 0; stolpec < teren[vrstica].length; stolpec++) 
                visine[teren[vrstica][stolpec]]++;
        return visine;
    }

    public static double povprecnaVisina(int[][] teren) {
        int visine[] = prestejVisine(teren);
        double vsotaVisin = 0;
        double stVisin = 0;
        for (int i = 0; i < visine.length; i++) {
            stVisin += visine[i];
            vsotaVisin += i * visine[i];
        }
        return vsotaVisin / stVisin;
    }

    public static boolean[][] visinskaPoplava(int[][] teren, double visinaPoplave) {
        boolean poplava[][] = new boolean[teren.length][teren[0].length];
        for (int i = 0; i < teren.length; i ++)
            for (int j = 0; j < teren[i].length; j++) 
                poplava[i][j] = (teren[i][j] < visinaPoplave) ? true : false;
        return poplava;
    }

    public static void porociloSkode(int[][] teren, int[][] tipParcele, boolean[][] poplava) {
        int poskodovaneParcele[] = new int[5];
        for (int i = 0; i < poplava.length; i++)
            for (int j = 0; j < poplava[0].length; j++)
                if (poplava[i][j])
                    poskodovaneParcele[tipParcele[i][j]]++;
        System.out.println("          Tip parcele    Stevilo       Ocenjena skoda");
        System.out.println("-----------------------------------------------------");
        double vsota = 0;
        int stPoskodovanihParcel = 0;
        for (int i = 0; i < poskodovaneParcele.length; i++) {
            double delnaVsota = poskodovaneParcele[i] * vrednostiTipovParcel[i];
            System.out.printf("%21s %10d %16s EUR\n", tipiParcel[i], poskodovaneParcele[i], formatDouble(delnaVsota));
            vsota += delnaVsota;
            stPoskodovanihParcel += poskodovaneParcele[i];
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("%21s %10d %16s EUR\n", "SKUPAJ", stPoskodovanihParcel, formatDouble(vsota));
    }

    private static String formatDouble(double num) {
        int celiDel = (int) num;  
        int decimalniDel = (int)((num - celiDel)*100);
        int predPiko = celiDel / 1000, zaPiko = celiDel % 1000;
        return String.format("%d.%03d,%02d", predPiko, zaPiko, decimalniDel);
    }

    public static boolean[][] kolicinskaPoplava(int[][] teren, double kolicina) {
        int stHis[] = prestejVisine(teren);
        int visina = 0;
        int stZalitih = 0;
        while (kolicina > 0) {
            stZalitih += stHis[visina];
            kolicina -= stZalitih;
            visina++;
        }
        return visinskaPoplava(teren, visina);
    }

    private static boolean lahkoPobegne(int[][] teren, int[][] tipParcel, boolean[][] poplava, int i, int j) {
        if (tipParcel[i][j] == 3 && !poplava[i][j])
            return true;
        int kandidati[][] = {{-1+i, 0+i, 1+i, 0+i, tipParcel.length}, {0+j, 1+j, 0+j, -1+j, tipParcel[0].length}};
        for (int kandidat = 0; kandidat < 4; kandidat++) {
            int y = kandidati[0][kandidat];
            int x = kandidati[0][kandidat];
                if (x >= 0 && x < kandidati[1][4] && y >= 0 &&  y < kandidati[0][4] && (teren[y][x] > teren[i][j]))
                    return lahkoPobegne(teren, tipParcel, poplava, y, x);
        }
        return false;
    }   

    public static void nacrtPobega(int[][] teren, int[][] tipParcel, boolean[][] poplava) {
        int safeHouse = 0, canEscape = 0, needHelp = 0;
        for (int i = 0; i < tipParcel.length; i++) 
            for (int j = 0; j < tipParcel[i].length; j++) {
                if (tipParcel[i][j] == 3) {
                    if (poplava[i][j]) {
                        if (lahkoPobegne(teren, tipParcel, poplava, i, j))
                            canEscape++;
                        else
                            needHelp++;
                    }
                    else 
                        safeHouse++;
                }
            }
        System.out.printf("Varne hise: %d\nLahko pobegnejo: %d\nPotrebujejo pomoc: %d\n",
        safeHouse, canEscape,needHelp);
    }

    public static void main(String[] args) throws FileNotFoundException {
        switch (args[0]) {
            case "analiza": {
                int teren[][] = preberiTeren(args[1]);
                izrisTerena(teren);
                int visine[] = prestejVisine(teren);
                for (int i = 0; i < 10; i++) 
                    System.out.printf("Visina %d: %dx\n", i, visine[i]);
                System.out.printf("Poveprecna visina: %.2f\n", povprecnaVisina(teren));
                break; 
            }
            case "izrisi_poplavo": {
                int teren[][] = preberiTeren(args[2]);
                switch (args[1]) {
                    case "visinska":
                        izrisiPoplavo(teren, visinskaPoplava(teren, (double)Double.parseDouble(args[3])));
                        break;
                    case "kolicinska":
                        izrisiPoplavo(teren, kolicinskaPoplava(teren,(double)Double.parseDouble(args[3])));
                        break;
                    default:
                        System.out.println("Wrong args");
                }
                break;
            }
            case "porocilo_skode": {
                int teren[][] = preberiTeren(args[2]);
                switch(args[1]) {
                    case "visinska": {
                        boolean poplava[][] = visinskaPoplava(teren, (double) Double.parseDouble(args[4]));
                        porociloSkode(teren, preberiTipParcel(args[3]), poplava);  
                        break; }
                    case "kolicinska":
                        boolean poplava[][] = kolicinskaPoplava(teren, (double) Double.parseDouble(args[4]));
                        porociloSkode(teren, preberiTipParcel(args[3]), poplava);
                        break;
                    default:
                        System.out.println("Wrong args");
                }
                break;
            }
            case "nacrt_pobega":
                int teren[][] = preberiTeren(args[2]);
                switch (args[1]) {
                    case "visinska": {
                        int tipiParcel[][] = preberiTipParcel(args[3]);
                        boolean poplava[][] = visinskaPoplava(teren, (double) Double.parseDouble(args[4]));
                        nacrtPobega(teren, tipiParcel, poplava);
                        break;  }
                    case "kolicinska":
                        int tipiParcel[][] = preberiTipParcel(args[3]);
                        boolean poplava[][] = kolicinskaPoplava(teren, (double) Double.parseDouble(args[4]));
                        izrisiPoplavo(teren, poplava);
                        System.out.printf("ja\n");
                        nacrtPobega(teren, tipiParcel, poplava);
                    default:
                        System.out.println("Wrong args");
                }    
            default:
                System.out.println("Wrong args");
        }   
    }
}

