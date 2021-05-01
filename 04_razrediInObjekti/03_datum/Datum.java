public class Datum {
//nepoplen algoritem za racunanje s st dni v datumu ter pretvarjanju rip
    private int dan;
    private int mesec;
    private int leto;

    private Datum(int x, int y, int z) {
        this.dan = x;
        this.mesec = y;
        this.leto = z;
    }

    public static Datum ustvari(int dan, int mesec, int leto) {
        if (leto >= 1583 && leto <= 2999 && mesec >= 1 && mesec <= 12) {
            if (preveriStDni(dan, mesec, leto)) {
                Datum datum = new Datum(dan, mesec, leto);
                return datum;
            }
        }
        return null;
    }

    private static boolean preveriStDni(int dan, int mesec, int leto) {
        if (mesec == 2) {
            if (prestopnoLeto(leto))
                return(dan >= 1 && dan <= 29);
            else
                return(dan >= 1 && dan <= 28);
        }
        int[] meseci = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return (dan <= meseci[mesec-1] && dan >=  1);
    }

    private static boolean prestopnoLeto(int leto) {
        return (leto % 400 == 0 || (leto % 4 ==0 && leto % 100 !=0));
    }

    public String toString() {
        return String.format("%02d.%02d.%d", this.dan, this.mesec, this.leto);
    }

    public boolean jeEnakKot(Datum datum) {
        return(this.toString().equals(datum.toString()));
    }

    public boolean jePred(Datum datum) {
        return (this.stDni() < datum.stDni());
    }

    public int stDni() {
        int[] meseci = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int stDni = this.leto * 365 + this.leto / 4 - this.leto / 100 + (this.leto / 400) + meseci[this.mesec - 1] + this.dan;
        return stDni;  
    }

    public static Datum izDnivDatum(int stDni) { //tuki je problem
        int dni = stDni;
        int leta = (dni / 146097) * 400;
        dni %= 146097;
        leta += (dni / 36524) * 100;
        dni %= 36524;
        leta += (dni / 1461) * 4;
        dni %= 1461;
        leta += (dni / 365);
        dni %= 365;
        //System.out.printf("Dnevi:%d Leta:%d%n", dni, leta);

        int mesec = 12;
        if (dni == 0) 
            return (leta > 1583) ? Datum.ustvari(31, mesec, leta - 1) : null;
    
        int[] meseci = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        for (int i = 0; i <= 11; i++) {
            if (meseci[i] >= dni) {
                mesec = i+1;
                dni -= (mesec == 1) ? 0 : meseci[i-1];
                break;
            }
        }
        if (prestopnoLeto(leta) && mesec == 2 && dni == 28)
            return Datum.ustvari(29, 2, leta);
        return Datum.ustvari(dni, mesec, leta);
    }

    public Datum naslednik() {
        return(Datum.izDnivDatum(this.stDni()+ 1));
    }

    public Datum predhodnik() {
        return(Datum.izDnivDatum(this.stDni()-1));
    }
    
    public Datum cez(int stDni) {
        return(Datum.izDnivDatum(this.stDni()+stDni));
    }

    public int razlika(Datum datum) {
        return(this.stDni() - datum.stDni());
    }  
}