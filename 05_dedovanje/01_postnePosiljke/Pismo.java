public class Pismo extends Telegram {
    
    private int razdaljaDoNaslovnika;

    public Pismo(int[] koeficienti, String naslovnik, String vsebina, String znak, int razdalja) {
        super(koeficienti, naslovnik, vsebina, znak);
        this.razdaljaDoNaslovnika = razdalja;
    }

    @Override
    public int cena() {
        int cena =0;
        int razdalja = razdaljaDoNaslovnika;
        while (razdalja >= this.getKoeficient(1)) {
            cena++;
            razdalja -= this.getKoeficient(1);
        }
        return cena * this.getKoeficient(2) + this.getKoeficient(0);
    }

    @Override
    public String vstavi() {
        return String.format("%d | ", this.razdaljaDoNaslovnika);
    }

    public int getRazdalja() {
        return this.razdaljaDoNaslovnika;
    }

}
