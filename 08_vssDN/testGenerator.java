import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileWriter;

class testGenerator {
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
                int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
                if (randomNum <= 30)
                    fr.write("0");
                else if (randomNum <= 50) 
                    fr.write("1");
                else if (randomNum <= 60) 
                    fr.write("2");
                else if (randomNum <= 69) 
                    fr.write("3");
                else if (randomNum <= 77) 
                    fr.write("4");
                else if (randomNum <= 84) 
                    fr.write("5");
                else if (randomNum <= 90) 
                    fr.write("6");
                else if (randomNum <= 95) 
                    fr.write("7");
                else if (randomNum <= 98) 
                    fr.write("8");
                else  
                    fr.write("9");
                if (j != arrSize-1)
                    fr.write(" ");
            }
            fr.write('\n');
        }
        fr.close();
    }
}
