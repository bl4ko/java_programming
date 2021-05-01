public class Posta {
	int postNum;
	String postName;
	
	//konstrutor
	public Posta(int num, String postname) {
		this.postNum = num;
		this.postName = postname;
	}
	
	public int vrniStevilko() {
		return this.postNum;
	}
	
	public String vrniNaziv() {
		return this.postName;
	}
	
	public String toString() {
		return String.format("%d %s" , this.postNum, this.postName);
	}
	
}
	