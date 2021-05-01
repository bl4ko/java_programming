public class Kvader extends Telo {
    private int a;
    private int b;
    private int c;
    
    public Kvader(String ime, int a, int b, int c) {
        super(ime);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int volumen() {
        return this.a * this.b * this.c;
    }

    @Override
    public int povrsina() {
        return 2 * this.a * this.b + 2 * this.b * this.c + 2 * this.a * this.c;
    }

    @Override
    public String vstavi() {
        StringBuilder str = new StringBuilder(this.getIme().equals("kvader") ? 
        String.format("a = %d%nb = %d%nc = %d%nV = %d%nP = %d%n", this.a, this.b, this.c, this.volumen(), this.povrsina()) : 
        String.format("a = %d%nV = %d%nP = %d%n", this.a, this.volumen(), this.povrsina()));
        stranskaPloskev(str, this.c, this.b);
        sredinskaPloskev(str, this.a, this.b, this.c);
        stranskaPloskev(str, this.c, this.b);
        osnovnaPloskev(str, this.c, this.b, this.a);
        return str.toString();
    }

    private static void stranskaPloskev(StringBuilder str, int c, int b) {
        for (int i =0; i < c; i++) {
            str.append(" ".repeat(2*c) + "* ".repeat(b-1) + "*" + "\n" );
        }
    }

    private static void sredinskaPloskev(StringBuilder str, int a, int b, int c) {
        for (int i = 0; i < a; i++) {
            str.append("+ ".repeat(c) + "o ".repeat(b) + "+ ".repeat(c-1) + "+" + "\n");
        }
    }

    private static void osnovnaPloskev(StringBuilder str, int c, int b, int a) {
        for (int i = 0; i < a; i++) {
            str.append("  ".repeat(c) + "o ".repeat(b-1) + "o" + "\n");
        }
    }
}
