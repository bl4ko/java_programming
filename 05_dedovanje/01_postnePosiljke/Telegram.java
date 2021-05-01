public class Telegram {
    
    private String naslovnik;
    private String vsebina;
    private String znak;
    private int[] t;

    public Telegram(int[] koeficienti, String naslovnik, String vsebina,String znak) {
        this.t = koeficienti;
        this.naslovnik = naslovnik;
        this.vsebina = vsebina;
        this.znak = znak;
    }

    public int cena() {
        int stCrk = 0;
        for (char ch : this.vsebina.toCharArray()) {
            int valueAscii = (int) ch;
            if (valueAscii >= 65 && valueAscii <= 122 && valueAscii!= 95) {
                stCrk++;
            }
        }
        return (stCrk * this.t[4]);
    }

    public int getKoeficient(int x) {
        return this.t[x]; 
    }

    public String toString() {
        return String.format("%s | %s | %s | %s%d", this.znak, this.naslovnik, this.vsebina, this.vstavi(), this.cena());
    }

    public String vstavi() {
        return String.format("");
    }

    public String getNaslovnik() {
        return this.naslovnik;
    }

    public void setNaslovnik(String naslovnik) {
        this.naslovnik = naslovnik;
    }

    public void setVsebina(String vsebina) {
        this.vsebina = vsebina;
    }
}