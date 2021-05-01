public class Pismo {
	private Posta post;
	private Posta targetPost;
	private boolean recommend;
	private int distance; //v km
	
	private static int enotaRazdalje;
	private static int enotaCene;
	private static int priporocnina;
	
	public Pismo(Posta izvorna, Posta ciljna, boolean jePriporoceno, int razdalja) {
		this.post = izvorna;
		this.targetPost = ciljna;
		this.recommend = jePriporoceno;
		this.distance = razdalja;
	}
	
	public String toString() {
		if (this.recommend) 
			return String.format("%d %s -> %d %s (%d km) [P]" , this.post.postNum, this.post.postName , this.targetPost.postNum, this.targetPost.postName,distance);
		else
			return String.format("%d %s -> %d %s (%d km) [N]" , this.post.postNum, this.post.postName , this.targetPost.postNum, this.targetPost.postName,distance);
	}
	
	public boolean izviraOd(Posta posta) {
		return (this.post.postName == posta.postName);
	}
	
	public boolean staIzvorInCiljIsta() {
		return (this.post == this.targetPost);
	}
	
	public boolean imaIstiCiljKot(Pismo pismo) {
		return (this.targetPost == pismo.targetPost);
	}
	
	public static boolean imataIstiCilj(Pismo p1, Pismo p2) {
		return (p1.targetPost == p2.targetPost);
	}
	
	public int cena() {
		int cena = 1;
		if (enotaRazdalje >0 && this.distance >= enotaRazdalje) {
			cena += this.distance / enotaRazdalje;
		}
		if (this.recommend) {
			return (cena * enotaCene + priporocnina);
		}
		return (cena * enotaCene);
	}
	
	public static void nastaviKonstanteZaCeno(int razdalja, int cena, int reccomend) {
		Pismo.enotaRazdalje = razdalja;
		Pismo.enotaCene = cena;
		Pismo.priporocnina = reccomend;
	}
	
	public boolean jeDrazjeOd(Pismo pismo) {
		return (this.cena() > pismo.cena());
	}
	
	public static Pismo vrniDrazje(Pismo p1, Pismo p2) {
		if (p1.cena() > p2.cena()) {
			return p1;
		}
		else
			return p2;
	}
	
	public Pismo izdelajPovratno() {
		Pismo povratno = new Pismo(this.targetPost, this.post, this.recommend, this.distance);
		return povratno;
	}
	
}
	