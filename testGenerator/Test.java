import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Test {
    private String path;
    private String ime;

    public Test(String path, String ime) {
        this.path = path;
        this.ime = ime;
    }

    public void makeTestIn() throws FileNotFoundException, IOException {
        File test = new File(this.path + "\\" + this.ime);
        napisi_vhod(test);
        test.createNewFile();
    }

    public void makeTestOut() throws FileNotFoundException, IOException {
        File test = new File(this.path + "\\" + this.ime);
        napisi_izhod(test);
        test.createNewFile();
    }

    private static void napisi_vhod(File file) throws IOException {
        FileWriter pisalec = new FileWriter(file);
        // KODA ZA POSAMEZEN TEST
        // 
        //
        int n = ThreadLocalRandom.current().nextInt(1, 10);
        pisalec.write(String.valueOf(n)+"\n");
        for (int i = 0; i < n; i++) {
            int a = ThreadLocalRandom.current().nextInt(1, 10);
            for (int j = 0; j < a; j++) {
                int charValue = ThreadLocalRandom.current().nextInt(33, 127);
                pisalec.write(Character.toString((char)charValue));
            }
            pisalec.write("\n");
        }
        //
        //
        //
        pisalec.close();
    }
    
    
    private static void napisi_izhod(File file) throws IOException {
        FileWriter pisalecIzhoda = new FileWriter(file);
        File vhod = new File(file.getPath().replace("out", "in"));
        Scanner sc = new Scanner(vhod);
        //input v scannerju
        // TUKAJ NAPISEMO KODO ZA PROGRAM
        //
        //
        int n = sc.nextInt();
        char[][] charArr = new char[n][42];
        char[] trenutnaBeseda = new char[n];
        for (int x = 0; x < n; x++)
            charArr[x] = sc.next().toCharArray();
        String[] rezultati = new String[10];
        rekurzija(charArr, 0, 0, trenutnaBeseda,rezultati ,0);
        for (int i = 0; i < rezultati.length; i++) {
            pisalecIzhoda.write(rezultati[i]);
            if (i != rezultati.length - 1) {
                pisalecIzhoda.write("\n");
            }
        }
        
        //
        //
        //
        sc.close();
        pisalecIzhoda.close();
    }
    
    //DODATNA KODA TESTNEGA PROGRAMA
    //
    private static void rekurzija(char[][] besede, int nivo, int n, char[] memo, String[] rezultati, int indeks) {
        if (nivo == n) {
            rezultati[indeks] = new String(memo);
            indeks++;
        }
        for (int i = 0; i < new String(besede[nivo]).length(); i++) {
            memo[nivo] = besede[nivo][i];
            rekurzija(besede, nivo+1, n, memo,rezultati, indeks);
        }
    }

}
