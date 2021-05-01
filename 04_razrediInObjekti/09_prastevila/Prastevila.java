public class Prastevila {
    private int trenutnoPrastevilo;

    public Prastevila() {
        this.trenutnoPrastevilo = 2;
    }

    public void nastaviTrenutno(int prastevilo) {
        this.trenutnoPrastevilo = prastevilo;
    }

    public int vrniTrenutno() {
        return this.trenutnoPrastevilo;
    }

    public int naslednje() {
        int iskalec = this.trenutnoPrastevilo;
        if (iskalec == 2) {
            this.trenutnoPrastevilo = 3;
            return 3;
        }
        boolean prastevilo = false;
        while (!prastevilo) {
            iskalec +=2;
            if (jePrastevilo(iskalec)) {
                prastevilo = true;
                this.trenutnoPrastevilo = iskalec;
            }
        }
        return iskalec;
    }

    public int prejsnje() {
        int iskalec = this.trenutnoPrastevilo;
        boolean prastevilo = false;
        if (iskalec == 3 || iskalec == 2) {
            this.trenutnoPrastevilo = 2;
            return 2;
        }
        while (!prastevilo) {
            iskalec -=2;
            if (jePrastevilo(iskalec)) {
                prastevilo = true;
                this.trenutnoPrastevilo = iskalec;
            }
        }
        return iskalec;
    }

    private static boolean jePrastevilo(int x) {
        for (int i =2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}