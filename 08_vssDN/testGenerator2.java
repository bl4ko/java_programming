import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileWriter;
public class testGenerator2 {
    public static void main(String[] args) throws IOException {
        File newFile = new File(args[0]);
        if (newFile.createNewFile())
            System.out.println("File created: " + newFile.getName());
        else {
            System.out.println("File already exists.");
            return;
        }
         
        FileWriter fr = new FileWriter(newFile, true);
        int arrSize = Integer.parseInt(args[1]);
        fr.write(String.valueOf(arrSize) + " " + String.valueOf(arrSize) + "\n");
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
                switch (randomNum) {
                    case 0:
                        fr.write("T");
                        break;
                    case 1:
                        fr.write("G");
                        break;
                    case 2:
                        fr.write("O");
                        break;
                    case 3:
                        fr.write("B");
                        break;
                    case 4:
                        fr.write("I");
                        break;
                    default:
                        System.out.println("RANDOM ERROR");
                        return;
                }
            }
            fr.write('\n');
        }
        fr.close();
    }
}
