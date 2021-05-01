public class Filozof {

    private String ime;
    private Filozof leviSosed;
    private Filozof desniSosed;
    private boolean levaPalcka = false;
    private boolean desnaPalcka = false;


    public Filozof(String ime) {
        this.ime = ime;
    }

    public String vrniIme() {
        return this.ime;
    }

    public void nastaviSoseda(Filozof levi, Filozof desni) {
        this.leviSosed = levi;
        this.desniSosed = desni;
    }

    public boolean jeLeviSosedOd(Filozof f) {
        return (f.leviSosed == this);
    }

    public boolean jeDesniSosedOd(Filozof f) {
        return (f.desniSosed == this);
    }

    public Filozof[] vrniSoseda() {
        Filozof[] sosedje = {this.leviSosed, this.desniSosed};
        return sosedje;
    }

    public int kolikoPalicicDrzi() {
        int stPalck = 0;
        if (this.levaPalcka)
            stPalck++;
        if (this.desnaPalcka)
            stPalck++;
        return stPalck;
        }

    public boolean primiLevo() {
        if (this.levaPalcka) {
            return true;
        }
        if (this.leviSosed.desnaPalcka) {
            return false;
        }
        this.levaPalcka = true;
        return true;
    }

    public boolean primiDesno() {
        if (this.desnaPalcka) {
            return true;
        }
        if (this.desniSosed.levaPalcka) {
            return false;
        }
        this.desnaPalcka = true;
        return true;
    }

    public void izpustiLevo() {
        if (this.levaPalcka)
            this.levaPalcka = false;
    }

    public void izpustiDesno() {
        if (this.desnaPalcka)
            this.desnaPalcka = false;
    }

    public static int steviloJedcev(Filozof[] filozofi) {
        int stJedcev = 0;
        for (Filozof vasja : filozofi) {
            if (vasja.desnaPalcka && vasja.levaPalcka)
                stJedcev++;
        }
        return stJedcev;
    }

    public int steviloFilozofov() {
        int stevec = 1;
        //In memory of one and only Vasja Stukelj
        Filozof vasja = this.desniSosed;
        while (vasja != this) {
            vasja = vasja.desniSosed;
            stevec++;
        }
        return stevec;
    }
}