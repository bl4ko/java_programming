import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class DN08 {

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
        return teren;
    }

    public static int[][] preberiTipParcel(String datoteka) throws FileNotFoundException {
        Map<Character, Integer> c2n = new HashMap<>(); //fucking java 8 // JAVA9: Map<Character, Integer> c2n = Map.of('T', 0, 'G', 1, 'O', 2, 'B', 3, 'I', 4);
        c2n.put('T', 0); c2n.put('G', 1); c2n.put('O', 2); c2n.put('B', 3); c2n.put('I', 4);
        Scanner input = new Scanner(new File(datoteka));
        int h = input.nextInt(); //height
        int w = input.nextInt(); //width
        int parcele[][] = new int[h][w];
        for (int vrstica = 0; vrstica < h; vrstica++) {
            String inputLine = input.next();
            for (int stolpec = 0; stolpec < w; stolpec++) {
                parcele[vrstica][stolpec] = c2n.get(inputLine.charAt(stolpec));
            }
        }   input.close();
        return parcele;
    }

    public static void izrisTerena(int[][] teren) {
        for (int vrstica = 0; vrstica < teren.length; vrstica++, System.out.println()) 
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
        System.out.print("          Tip parcele    Stevilo       Ocenjena skoda\n");
        double vsota = 0;
        int stPoskodovanihParcel = 0;
        for (int i = -1; i <= poskodovaneParcele.length; i++) {
            if (i == - 1 || i == poskodovaneParcele.length)
                System.out.println("-----------------------------------------------------");
            else {
            double delnaVsota = poskodovaneParcele[i] * vrednostiTipovParcel[i];
            System.out.printf("%21s %10d %16s EUR\n", tipiParcel[i], poskodovaneParcele[i], formatDouble(delnaVsota));
            vsota += delnaVsota;
            stPoskodovanihParcel += poskodovaneParcele[i];
            }
        }
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
        while (kolicina > 0 && visina < stHis.length) {
            stZalitih += stHis[visina];
            kolicina -= stZalitih;
            visina++;
        }
        return visinskaPoplava(teren, visina);
    }

    private static boolean lahkoPobegne(int[][] teren, boolean[][] poplava, int i, int j) {
        if (!poplava[i][j])
            return true;
        int kandidati[][] = {{-1+i, 0+i, 1+i, 0+i, teren.length}, {0+j, 1+j, 0+j, -1+j, teren[0].length}};
        int maxVisinaKandidat = 0;
        int iKandidat = 0, jKandidat = 0;
        for (int kandidat = 0; kandidat < 4; kandidat++) {
            int i2 = kandidati[0][kandidat];
            int j2 = kandidati[1][kandidat];
                if (j2 >= 0 && j2 < kandidati[1][4] && i2 >= 0 &&  i2 < kandidati[0][4] && (teren[i2][j2] > teren[i][j]) && teren[i2][j2] > maxVisinaKandidat) {
                    iKandidat = i2; jKandidat = j2;
                    maxVisinaKandidat = teren[i2][j2];
                }
        }
        if (maxVisinaKandidat > 0)
            return lahkoPobegne(teren, poplava, iKandidat, jKandidat);
        return false;
    }   

    public static void nacrtPobega(int[][] teren, int[][] tipParcel, boolean[][] poplava) {
        int safeHouse = 0, canEscape = 0, needHelp = 0;
        for (int i = 0; i < tipParcel.length; i++) 
            for (int j = 0; j < tipParcel[i].length; j++) {
                if (tipParcel[i][j] == 3) {
                    if (poplava[i][j]) {
                        if (lahkoPobegne(teren, poplava, i, j)) 
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
        if (args[0].equals("analiza")) {
            int teren[][] = preberiTeren(args[1]);
            izrisTerena(teren);
            int visine[] = prestejVisine(teren);
            for (int i = 0; i < 10; i++) 
                System.out.printf("Visina %d: %dx\n", i, visine[i]);
            double avg = povprecnaVisina(teren);
            int carryBit = ((int)((avg-(int)avg)*1000)) % 10 > 4 ? 1 : 0;
            System.out.printf("Povprecna visina: %d,%2d\n", (int)avg, (int)((avg-(int)avg)*100) + carryBit);
        }
        else if (args[0].equals("izrisi_poplavo")) {
            int teren[][] = preberiTeren(args[2]);
            if (args[1].equals("visinska")) {
                izrisiPoplavo(teren, visinskaPoplava(teren, (double)Double.parseDouble(args[3])));
            }
            else if (args[1].equals("kolicinska")) {
                izrisiPoplavo(teren, kolicinskaPoplava(teren,(double)Double.parseDouble(args[3])));
            }
        }
        else if (args[0].equals("porocilo_skode")) {
            int teren[][] = preberiTeren(args[2]);
            if (args[1].equals("visinska")) {
                int tipiParcel[][] = preberiTipParcel(args[3]);
                boolean poplava[][] = visinskaPoplava(teren, (double) Double.parseDouble(args[4]));
                porociloSkode(teren, tipiParcel, poplava);
            }
            else if (args[1].equals("kolicinska")) {
                int tipiParcel[][] = preberiTipParcel(args[3]);
                boolean poplava[][] = kolicinskaPoplava(teren, (double) Double.parseDouble(args[4]));
                porociloSkode(teren, tipiParcel, poplava);
            }
        }
        else if (args[0].equals("nacrt_pobega")) {
            int teren[][] = preberiTeren(args[2]);
            if (args[1].equals("visinska")) {
                int tipiParcel[][] = preberiTipParcel(args[3]);
                boolean poplava[][] = visinskaPoplava(teren, (double) Double.parseDouble(args[4]));
                nacrtPobega(teren, tipiParcel, poplava);
            }
            else if (args[1].equals("kolicinska")) {
                int tipiParcel[][] = preberiTipParcel(args[3]);
                boolean poplava[][] = kolicinskaPoplava(teren, (double) Double.parseDouble(args[4]));
                nacrtPobega(teren, tipiParcel, poplava);
            }
        }
    }
}