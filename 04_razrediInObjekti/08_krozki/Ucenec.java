public class Ucenec{

    private String ime;
    private String priimek;
    private Krozek[] krozki;
    private boolean[][] prosteUre = new boolean[7][24];

    private static int maksObremenitev;
    
    public Ucenec(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
        this.krozki = new Krozek[maksObremenitev];
    }

    public static void nastaviMaksObremenitev(int maksObremenitev) {
        setm(maksObremenitev);
    }

    public static void setm(int x) {
        maksObremenitev = x;
    }

    public String vrniIP() {
        return String.format("%s %s", this.ime, this.priimek);
    }

    private boolean jeProsto(int[] date) {
        if (!prosteUre[date[0]][date[1]] && !prosteUre[date[0]][date[1]+1]) {
            prosteUre[date[0]][date[1]] = true;
            prosteUre[date[0]][date[1]+1] = true;
            return true;
        }
        return false;
    }

    public boolean vclani(Krozek krozek) {
        for (int i = 0; i < krozki.length; i++) {
            if (this.krozki[i] == null) {
                if (krozek.DodatniClan() && jeProsto(krozek.getDate())) {
                    krozek.setStClanov(1);
                    this.krozki[i] = krozek;
                    return true;
                }
                return false;
            }
            if (this.krozki[i] == krozek) {
                return true;
            }
        }
        return false;
    }

    private void premakniVLevo(int indeks) {
        while (indeks < this.krozki.length- 1) {
            this.krozki[indeks] = this.krozki[indeks+1];
            indeks++;
        }
        this.krozki[this.krozki.length-1] = null;
    }

    private void sprostiUrnik(Krozek krozek, int date[]) {
        prosteUre[date[0]][date[1]] = false;
        prosteUre[date[0]][date[1]+1] = false;
    }

    public void izclani(Krozek krozek) {
        for (int i = 0; i < this.krozki.length; i++) {
            if (this.krozki[i] == krozek) {
                this.krozki[i] = null;
                this.premakniVLevo(i);
                this.sprostiUrnik(krozek, krozek.getDate());
                krozek.setStClanov(-1);
                return;
            }
            if (this.krozki[i] == null)
                return;
        }
    }

    public int steviloKrozkov() {
        int stKrozkov = 0;
        for (int i = 0; i < this.krozki.length; i++) {
            if (this.krozki[i] != null)
                stKrozkov++;
            else 
                return stKrozkov;
        }
        return stKrozkov;
    }
}