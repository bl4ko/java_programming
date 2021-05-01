public class PPismo extends Pismo{
    
    private String Posiljatelj;

    public PPismo(int[] koeficienti, String naslovnik, String vsebina, String znak, int razdalja, String Posiljatelj) {
        super(koeficienti, naslovnik, vsebina, znak, razdalja);
        this.Posiljatelj = Posiljatelj;
    }

    public String getPosiljatelj() {
        return this.Posiljatelj;
    }

    public void setPosiljatej(String y) {
        this.Posiljatelj = y;
    }

    @Override 
    public int cena() {
        return super.cena() * this.getKoeficient(3);
    }

    @Override
    public String vstavi() {
        return String.format("%d | %s | ", this.getRazdalja(), this.Posiljatelj);
    }

    public PPismo povratnica(int[] t){
        return new PPismo(t, this.getPosiljatelj(), "povratnica", "PP", this.getRazdalja(), this.getNaslovnik());
    }
}
