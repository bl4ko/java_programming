public class Ulomek {

    private int a;
    private int b;
    private boolean predznak;

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public Ulomek(int a, int b) {
        this.a = (int) Math.abs(a);
        this.b = (int) Math.abs(b);
        this.predznak = (a * b > 0) ? true : false; 
    }

    public String toString() {
        int a = this.a;
        int b = this.b;
        for (int i = this.a; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        if (predznak)
            return String.format("%d/%d" , a, b);
        return String.format("-%d/%d" , a, b);
    }

    public boolean jeEnakKot(Ulomek u) {
        return (this.a * u.b == this.b * u.a && this.predznak == u.predznak);
    }

    public Ulomek negacija() {
        Ulomek negiran = new Ulomek(this.a, this.b);
        negiran.predznak = !this.predznak;
        return negiran;
    }

    public Ulomek obrat() {
        Ulomek obratni = new Ulomek(this.b, this.a);
        obratni.predznak = this.predznak;
        return obratni;
    }

    public Ulomek vsota(Ulomek u) {
        int b = this.b * u.b;
        if (this.predznak == u.predznak) {
            int a = b / this.b * this. a + b / u.b * u.a;
            Ulomek vsota = new Ulomek(a, b);
            vsota.predznak = this.predznak;
            return vsota;
        }
        else {
            int a = b / this.b * this. a - b / u.b * u.a;
            Ulomek vsota = new Ulomek(a, b);
            boolean predznak = (this.a/this.b > u.a/u.b) ? this.predznak : u.predznak;
            vsota.predznak = predznak;
            return vsota;
        }
    }

    public Ulomek razlika(Ulomek u) {
        return (u.negacija().vsota(this));
    }

    public Ulomek zmnozek(Ulomek u) {
        int a = this.a * u.a;
        int b = this.b * u.b;
        Ulomek zmnozek = new Ulomek(a, b);
        zmnozek.predznak = (this.predznak == u.predznak) ? true : false;
        return zmnozek;
    }

    public Ulomek kolicnik(Ulomek u) {
        return (u.obrat().zmnozek(this));
    }

    public Ulomek potenca(int eksponent) {
        int eks = (int) Math.abs(eksponent);
        int a = this.a;
        int b = this.b;
        for (int i = this.a; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        Ulomek potenca = new Ulomek((int)Math.pow(a, eks), (int)Math.pow(b, eks));
        potenca.predznak = (eksponent % 2 == 0) ? true : this.predznak;
        if (eksponent < 0) {
            return potenca.obrat();
        }
        return potenca;
    }

    public boolean jeManjsiOd(Ulomek u) {
        double a = this.a / this.b;
        a = (this.predznak) ? a : -a;
        double b = u.a / u.b;
        b = (u.predznak) ? b : -b;
        return (a < b);
    }
}