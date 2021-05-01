public class Krozek {
    private String naziv;
    private int dan;
    private int ura;
    private int kvota;
    private int stClanov = 0;

    public Krozek(String naziv, int dan, int ura, int kvota) {
        this.naziv = naziv;
        this.dan = dan;
        this.ura = ura;
        this.kvota = kvota;
    }

    public int steviloClanov() {
        return this.stClanov;
    }

    public void setStClanov(int x) {
        this.stClanov = stClanov + x;
    }
    public String vrniNaziv() {
        return this.naziv;
    }

    public boolean DodatniClan() {
        return (this.kvota > this.stClanov) ? true : false;
    }

    public int[] getDate() {
        int[] date = {this.dan, this.ura};
        return date;
    }
 
}
