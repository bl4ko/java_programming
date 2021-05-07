import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

interface Lik {
    public double ploscina();
}

public class DN10 {
    static ArrayList<Lik> Liki = new ArrayList<Lik>();
    
    public static void preberi(String datoteka) throws FileNotFoundException {
        Scanner input = new Scanner(new File(datoteka));
        while (input.hasNext()) {
            String[] lik = input.next().split(":");
            switch (lik[0]) {
                case "kvadrat":
                    Liki.add(new Kvadrat(Integer.parseInt(lik[1])));
                    break;
                case "krog":
                    Liki.add(new Krog(Integer.parseInt(lik[1])));
                    break;
                case "pravokotnik":
                    Liki.add(new Pravokotnik(Integer.parseInt(lik[1]), Integer.parseInt(lik[2])));
                    break;
                default:
                    System.out.println("Napacen input");
                    System.exit(0);
            }
        }
        input.close();
    }

    public static double ploscina() {
        double skupna_ploscina = 0;
        for (Lik lik : Liki) {
            skupna_ploscina+=lik.ploscina();
        }
        return skupna_ploscina;
    }

    public static void main(String[] args) throws FileNotFoundException {
        preberi(args[0]);
        System.out.printf("%.2f", ploscina());
    }
}

class Krog implements Lik {
    private double r;
    public Krog(int radij) {
        this.r = radij;
    }

    @Override
    public double ploscina() {
        return Math.PI * r * r;
    }
}

class Pravokotnik implements Lik {
    private int a;
    private int b;

    public Pravokotnik(int stranica_prva, int stranica_druga) {
        this.a = stranica_prva;
        this.b = stranica_druga;
    }

    @Override
    public double ploscina() {
        return a * b;
    }
}

class Kvadrat implements Lik {
    private int a;

    public Kvadrat(int stranica) {
        this.a = stranica;
    }
    
    @Override
    public double ploscina() {
        return a * a;
    }
}