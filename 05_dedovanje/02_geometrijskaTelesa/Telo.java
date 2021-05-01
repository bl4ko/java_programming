public abstract class Telo {
    private String ime;

    public Telo(String ime) {
        this.ime = ime;
    }

    public String toString() {
        return String.format("%s%n%s======", this.ime, this.vstavi());
    }

    public String getIme() {
        return this.ime;
    }

    public abstract String vstavi();
    public abstract int volumen();
    public abstract int povrsina();
}
