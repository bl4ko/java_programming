import java.lang.Math;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class DN9 {
    
    public static class Planet {
        private static final double PI = Math.PI;
        private String ime;
        private int radij;
    
        public Planet(String ime, int radij) {
            this.ime = ime;
            this.radij = radij;
        }
    
        public double povrstina() {
            // 4 * pi * r^ 2
            return 4 * PI * Math.pow(this.radij, 2);
        }
    
        @Override
        public String toString() {
            return String.format("[%s: r=%d]", this.ime, this.radij);
        }
    
        public boolean jeEnako(String ime) {
            if (this.ime.length() != ime.length())
                return false;
            return this.ime.toLowerCase().equals(ime.toLowerCase());
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException  {
        Planet[] planeti = planeti(new File(args[0]));
        String[] imena;
        try {
            imena = args[1].split("\\+");
        }
        catch (Exception PatternSyntaxExpetion) {
            imena = new String[1];
            imena[0] = args[1];
        }
        double skupnaPovrsina = 0;
        for (int i = 0; i < imena.length; i++) {
            String ime = imena[i];
            for (int j = 0; j < planeti.length && planeti[j] != null; j++) {
                if (planeti[j].jeEnako(ime)) {
                    skupnaPovrsina +=  planeti[j].povrstina();
                    break;
                }
            }
        }
        System.out.printf("Povrsina planetov \"%s\" je %d miljonov km2\n", args[1], (int)(skupnaPovrsina/(long)Math.pow(10,6)));
    }

    private static Planet[] planeti(File vnos) throws FileNotFoundException {
        Scanner input = new Scanner(vnos); 
        Planet[] planeti = new Planet[8];
        for (int i = 0; input.hasNext(); i++) {
            String[] vrstica = input.next().split(":");
            planeti[i] = new Planet(vrstica[0], Integer.parseInt(vrstica[1]));
        }
        return planeti;
    }
}