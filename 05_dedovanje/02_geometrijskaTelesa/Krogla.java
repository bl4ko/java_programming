public class Krogla extends Telo {
    private int r;

    public Krogla(String ime, int r) {
        super(ime);
        this.r = r;
    }

    @Override
    public int volumen() {
        return (int) Math.round((4 * Math.PI * Math.pow(this.r,3))/3);
    }

    @Override
    public int povrsina() {
        return (int) Math.round(4 * Math.PI * Math.pow(this.r, 2));
    }

    @Override 
    public String vstavi() {
        return String.format("r = %d%nV = %d%nP = %d%n", this.r, this.volumen(), this.povrsina());
    }
}
