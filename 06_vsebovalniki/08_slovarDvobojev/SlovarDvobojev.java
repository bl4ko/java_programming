import java.util.*;

public class SlovarDvobojev {
    
    public static NavigableMap<String, NavigableMap<String, Integer>> partije2slovar(List<Partija> partije) {
        NavigableMap<String, NavigableMap<String, Integer>> partijeVseh = new TreeMap<>();
        int stevec = 1;
        for (Partija partija : partije) {
            String beli = partija.vrniBelega();
            String crni = partija.vrniCrnega();
            int izid = partija.vrniIzid();

            //belega igralca
            if (partijeVseh.get(beli) == null) {
                TreeMap<String, Integer> dvoboji = new TreeMap<>();
                dvoboji.put(crni, izid);  
                partijeVseh.put(beli, dvoboji);
                TreeMap<String, Integer> dvobojiCrni = new TreeMap<>();
                dvobojiCrni.put(beli, 2 - izid);
                partijeVseh.put(crni, dvobojiCrni);

            }
            else {
                NavigableMap<String, Integer> dvoboji = partijeVseh.get(beli);
                dvoboji.put(crni, izid);
                partijeVseh.put(beli, dvoboji);
                if (partijeVseh.get(crni)==null) {
                    TreeMap<String, Integer> dvobojiCrni = new TreeMap<>();
                    dvobojiCrni.put(beli, 2 - izid);
                    partijeVseh.put(crni, dvobojiCrni);
                }
                else {
                NavigableMap<String, Integer> dvobojiCrni = partijeVseh.get(crni);
                dvobojiCrni.put(beli, 2 -izid);
                partijeVseh.put(crni, dvoboji);
                }
            }
            System.out.println(partijeVseh);
            stevec++;
            System.out.println(stevec);
        }
        return partijeVseh;
    }
}
