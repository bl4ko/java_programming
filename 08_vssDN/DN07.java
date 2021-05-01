import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class DN07 {

    private static void razporedi(int t[], int kandidat, int stKandidatov) {
        for (int i = 0; i < stKandidatov; i++)
            if (kandidat > t[i]) {
                for (int j = stKandidatov-1; j > i; j--)
                    t[j] = t[j-1];
                t[i] = kandidat; break;
            }
    }
    public static void main(String[] args) throws FileNotFoundException {
            Scanner vnos = new Scanner(new File(args[0]));
            int stKandidatov = Integer.parseInt(args[1]);
            int maxVrednosti[] = new int[stKandidatov];
            while (vnos.hasNextInt()) {
                int kandidat = vnos.nextInt();
                if (kandidat > maxVrednosti[stKandidatov-1])
                    razporedi(maxVrednosti, kandidat, stKandidatov);
            }
            for (int num : maxVrednosti)
                System.out.println(num);
    }
}
