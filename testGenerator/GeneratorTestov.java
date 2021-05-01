import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.StringBuilder;

public class GeneratorTestov {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        int stTestov = Integer.parseInt(args[1]);

        String nova_mapa = args[0];
        String path = System.getProperty("user.dir") + "\\" + nova_mapa;

        File newDir = new File(path);
        if (!newDir.exists()) {
            newDir.mkdirs();
        }
        else {
            System.out.println("Folder already exists");
            return;
        }

        for (int i = 0; i < stTestov; i++) {
            StringBuilder name = new StringBuilder("test");
            if (stTestov <= 100) 
                name.append(String.format("%02d", i));
            else if (stTestov <= 1000) 
                name.append(String.format("%03d", i));
            else if (stTestov <= 10000)
                name.append(String.format("%04d", i));
            else {
                System.out.println("Preveliko stevilo testov!");
                return;
            }
            Test vhod = new Test(path, name.toString() + ".in");
            vhod.makeTestIn();
            Test izhod = new Test(path, name.toString() + ".out");
            izhod.makeTestOut();
        }
    }
}