public class Ptabela {

    //PRELJUBA REKURZIJA :sadface: 

    private Ptabela[] podTabele;
    private int vrednost = 0; 

    public Ptabela(int[] dimenzije) {
        this(0, dimenzije);
    }

    private Ptabela(int dimenzija, int[] x) {
        if (dimenzija == x.length) {
            return;
        }
        this.podTabele = new Ptabela[x[dimenzija]];
        
        for (Ptabela podTabela : this.podTabele) {
            podTabela = new Ptabela(dimenzija + 1, x);
        }
    }


    public void nastavi(int[] indeksi, int vrendost) {
        Ptabela trenutna = this;
        for (int i = 0; i < indeksi.length; i++) {
            trenutna = trenutna.podTabele[indeksi[i]];
        }
        trenutna.vrednost = vrednost;
    }

    public int vrni(int[] indeksi) {
        Ptabela trenutna = this;
        for (int i = 0; i < indeksi.length; i++) {
            trenutna = trenutna.podTabele[indeksi[i]];
        }
        return trenutna.vrednost;
    }

    public Ptabela podtabela(int[] indeksi) {
        Ptabela trenutna = this;
        for (int i = 0; i < indeksi.length; i++) {
            trenutna = trenutna.podTabele[indeksi[i]];
        }
        return trenutna;
    }
}