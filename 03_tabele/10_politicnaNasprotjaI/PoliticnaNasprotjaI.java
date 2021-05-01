import java.util.*;

//DRUGI SEMESTER, PREMAL ZNAM REKURZIJO TRENUTNO :(
public class PoliticnaNasprotjaI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int d = sc.nextInt();
        int c = sc.nextInt();
        List<String> politiki = new ArrayList<>();
        for (int i = 0; i <l; i++) {
            politiki.add("l");
        }
        for (int i = 0; i <d; i++) {
            politiki.add("d");
        }
        for (int i = 0; i <c; i++) {
            politiki.add("c");
        }
        System.out.println(rekurzija(politiki, 0, new String[l+d+c], 0));

    }
    
    private static int rekurzija(List<String> stranke, int nivo, String[] t, int izloceni) {
        if (nivo == t.length) {
            return jePravilno(t) ? 1 : 0;
        }

        int vsota = 0;
        List<String> noveStranke = new ArrayList<>(stranke);
        if (nivo != 0) 
            noveStranke.remove(izloceni);
        
        for (int i =0; i < noveStranke.size(); i++) {
            t[nivo] = noveStranke.get(i);
            if (jePravilno(t)) {
                System.out.println(Arrays.toString(t));
                vsota += rekurzija(noveStranke, nivo + 1, t, i);
            }
        }
        return vsota;
    }


    private static boolean jePravilno(String[] t) {
        for (int i = 0; i < t.length - 1 && t[i+1] != null; i++) {
            if (t[i].equals("l") && t[i+1].equals("d") || t[i].equals("d") && t[i+1].equals("l"))
                return false;
        }
        return true;
    }
}


