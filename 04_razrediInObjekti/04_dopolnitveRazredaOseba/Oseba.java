public class Oseba {

    private String ime;
    private String priimek;
    private char spol;
    private int letoRojstva;
    private Oseba oce;
    private Oseba mati;

    // stevec ustvarjenih oseb
    private static int stUstvarjenih = 0;

    /** Ustvari osebo s podanim imenom, priimkom, spolom, letom rojstva,
     * ocetom in materjo. */
    public Oseba(String ime, String priimek, char spol, int letoRojstva, Oseba oce, Oseba mati) {
        this.ime = ime;
        this.priimek = priimek;
        this.spol = spol;
        this.letoRojstva = letoRojstva;
        this.oce = oce;
        this.mati = mati;
        stUstvarjenih++;
    }

    /** Vrne ime osebe `this'. */
    public String vrniIme() {
        return this.ime;
    }

    /** Nastavi ime osebe `this' na `novoIme'. */
    public void nastaviIme(String novoIme) {
        this.ime = novoIme;
    }

    /** Vrne predstavitev osebe `this' v obliki niza. */
    public String toString() {
        return String.format("%s %s (%c), %d", 
                this.ime, this.priimek, this.spol, this.letoRojstva);
    }

    /** Vrne starost osebe v podanem letu. */
    public int starost(int leto) {
        return (leto - this.letoRojstva);
    }

    /** Vrne `true' natanko v primeru, ce je dana oseba (torej oseba `this')
     * starejsa od osebe `os'. */
    public boolean jeStarejsaOd(Oseba os) {
        if (this.letoRojstva < os.letoRojstva) {
            return true;
        } else {
            return false;
        }
        // kraj"se: return (this.letoRojstva < os.letoRojstva);
        // ali: return (this.starost(0) > os.starost(0));
    }

    /** Vrne ime oceta osebe `this' oziroma `null', ce oce ni znan. */
    public String imeOceta() {
        if (this.oce == null) {
            return null;
        }
        return this.oce.ime;
    }

    /** Vrne `true' natanko v primeru, ce je oseba `this' brat ali sestra
     * osebe `os'. */
    public boolean jeBratAliSestraOd(Oseba os) {
        return (this != os && this.oce != null && this.mati != null &&
                this.oce == os.oce && this.mati == os.mati);
    }

    /** Vrne `true' natanko v primeru, ce je oseba `this' sestra osebe `os'. */
    public boolean jeSestraOd(Oseba os) {
        return (this.jeBratAliSestraOd(os) && this.spol == 'Z');
    }

    /* Vrne `true' natanko v primeru, ce je oseba `this' teta osebe `os'. */
    public boolean jeTetaOd(Oseba os) {
        return (os.oce != null && this.jeSestraOd(os.oce) || 
                os.mati != null && this.jeSestraOd(os.mati));
    }

    

    /** Vrne stevilo doslej ustvarjenih oseb. */
    public static int steviloUstvarjenih() {
        return stUstvarjenih;
    }

    private int stOcetovskihPrednikov(Oseba os) {
        Oseba p = os.oce;
        int stevec = 1;
        while (p != null && p != this) {
            p = p.oce;
            stevec++;
        }
        return stevec;
    }

    public int ocetovskaGeneracijskaRazlika(Oseba os) {
        if (this == os) {
            return 0;
        }
        if (this.jeOcetovskiPrednikOd(os)) {
            return this.stOcetovskihPrednikov(os);
        }
        if (os.jeOcetovskiPrednikOd(this)) {
            return -os.stOcetovskihPrednikov(this);
        }
        throw new IllegalArgumentException();
    }

    /* Vrne `true' natanko v primeru, ce je oseba `this' o"cetovski prednik osebe `os'. */
    public boolean jeOcetovskiPrednikOd(Oseba os) {
        Oseba p = os.oce;
        while (p != null && p != this) {
            p = p.oce;
        }
        return (p == this);
    }

    public boolean jePrednikOd(Oseba os) {
        if (os == null)
            return false;
        if (os == this) 
            return true;
        return this.jePrednikOd(os.oce) || this.jePrednikOd(os.mati);
    }

    public boolean jeSorodnikOd(Oseba os) {
        if (os == null)
            return false;
        if (os.jePrednikOd(this))
            return true;
        return this.jeSorodnikOd(os.oce) || this.jeSorodnikOd(os.mati);
    }

    private void printAncestor(String x) {
        System.out.printf("%s: %s %s (%c), %d%n", x, this.ime, this.priimek, this.spol, this.letoRojstva);
        if (this.oce != null) {
            this.oce.printAncestor(x + ".oce");
            this.mati.printAncestor(x + ".mati");
        }
    }

    public void nastejPrednike() {
        System.out.printf("%s: %s %s (%c), %d%n", "this", this.ime, this.priimek, this.spol, this.letoRojstva);
        this.oce.printAncestor("this.oce");
        this.mati.printAncestor("this.mati");
    }

}
