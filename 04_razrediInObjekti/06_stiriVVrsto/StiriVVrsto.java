import java.util.Arrays;
public class StiriVVrsto {

    private int[][] polje;
    private boolean poteza;

    public StiriVVrsto(int stVrstic, int stStolpcev) {
        this.polje = new int[stVrstic][stStolpcev];
        this.poteza = false;
    }

    public void getPolje() {
        for (int i = 0; i < this.polje.length; i++) {
            System.out.println(Arrays.toString(this.polje[i]));
        }
        
    }

    public int vrniSteviloVrstic() {
        return this.polje.length;
    }

    public int vrniSteviloStolpcev() {
        return this.polje[0].length;
    }

    public boolean vrzi(int stolpec) {
        if (this.polje[this.vrniSteviloVrstic() - 1][stolpec] > 0)
            return false;
        
        for (int i = 0; i < this.vrniSteviloVrstic(); i++) {
            if (this.polje[i][stolpec] == 0) {
                this.polje[i][stolpec] = this.naPotezi() + 1;
                break;
            }
        }
        this.poteza = !this.poteza;
        return true;
    }

    public int naPotezi() {
        return (this.poteza) ? 1 : 0;
    }

    public int vsebina(int vrstica, int stolpec) {
        return (this.polje[vrstica][stolpec] == 0) ? -1 : this.polje[vrstica][stolpec] - 1;
    }

 
    public int najdaljseZaporedje(int igralec) {
        int najdalsi = 0;
        
        //gledamo dolzine zaporenih po vrsticah
        for (int i =0; i < this.polje.length; i++) {
            int trenutni = 0;
            for (int j =0; j < this.polje[i].length; j++) {
                if (this.polje[i][j] == igralec + 1) {
                    trenutni++;
                    if (trenutni > najdalsi)
                        najdalsi = trenutni;
                }
                else
                    trenutni = 0;
            }
        }

        //gledamo dolzine zaporednih po stolpcih
        for (int i = 0; i < this.polje[0].length; i++) {
            int trenutni = 0;
            for (int j = 0; j < this.polje.length; j++) {
                if (this.polje[j][i] == igralec + 1) {
                    trenutni++;
                    if (trenutni > najdalsi)
                        najdalsi = trenutni;
                }
                else
                    trenutni = 0;
            }
        }

        //gledamo dolzine po levi diagonali
        for (int i = 0; i < this.polje[0].length; i++) {
            int trenutni = 0;
            for (int j = 0, k = i; j<this.polje.length && k < this.polje[0].length; j++, k++) {
                if (this.polje[j][k] == igralec+1) {
                    trenutni++;
                    if (trenutni > najdalsi)
                        najdalsi = trenutni;
                }
                else
                    trenutni = 0;
            }
        }
        for (int i = this.polje.length-1; i >= 0; i--) {
            int trenutni = 0;
            for (int j = i, k = 0; j<this.polje.length && k < this.polje[0].length; j++, k++) {
                if (this.polje[j][k] == igralec+1) {
                    trenutni++;
                    if (trenutni > najdalsi)
                        najdalsi = trenutni;
                }
                else
                    trenutni = 0;
            }
        }

        //gledamo dolzine po desni diagonali
        for (int i = this.polje[0].length-1; i >= 0; i--) {
            int trenutni = 0;
            for (int j = 0, k = i; j<this.polje.length && k >= 0; j++, k--) {
                if (this.polje[j][k] == igralec+1) {
                    trenutni++;
                    if (trenutni > najdalsi)
                        najdalsi = trenutni;
                }
                else
                    trenutni = 0;
            }
        }
        for (int i = 0; i <= this.polje.length - 1; i++) {
            int trenutni = 0;
            for (int j = i, k = this.polje[0].length - 1; j<this.polje.length && k >= 0; j++, k--) {
                if (this.polje[j][k] == igralec+1) {
                    trenutni++;
                    if (trenutni > najdalsi)
                        najdalsi = trenutni;
                }
                else
                    trenutni = 0;
            }
        }
        return najdalsi;
    }

    public int izid() {
        int prvi = najdaljseZaporedje(0);
        int drugi = najdaljseZaporedje(1);
        if (prvi >= 4 && drugi < 4)
            return 0;
        if (drugi >= 4 && prvi < 4)
            return 1;
        return - 1;
    }
 
}

