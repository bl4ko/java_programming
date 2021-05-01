import java.util.*;

public class Pogostost {
   
    private static class Primerjalnik implements Comparator<String> {
        Map<String, Integer> map;
        public Primerjalnik(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String prvi, String drugi) {
            int c = map.get(drugi) - map.get(prvi);
            return (c==0) ? prvi.compareTo(drugi) : c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> string2numb = new TreeMap<String, Integer>();
        

        while (sc.hasNext()) {
            String beseda = sc.next();
            if (string2numb.containsKey(beseda)) 
                string2numb.put(beseda, string2numb.get(beseda) + 1);
            else
                string2numb.put(beseda, 1);
        }

        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(new Primerjalnik(string2numb));
        sortedMap.putAll(string2numb);
        for (String beseda : sortedMap.keySet()) {
            System.out.printf("%s (%d)%n", beseda, sortedMap.get(beseda));
        }
    }
}

