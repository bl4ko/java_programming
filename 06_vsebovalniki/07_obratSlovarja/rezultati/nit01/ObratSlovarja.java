import java.util.*;

public class ObratSlovarja {
    
    public static <K, V> Map<V, Set<K>> obrni(Map<K, V> slovar) {
        Map<V, Set<K>> slovarReverse = new TreeMap<V, Set<K>>();
        for (K element : slovar.keySet()) {
            if (slovarReverse.containsKey(slovar.get(element))) {
                HashSet<K> newValue = new HashSet<>(slovarReverse.get(slovar.get(element)));
                newValue.add(element);
                slovarReverse.put(slovar.get(element), newValue);
            }
            else {
                Set<K> newValue = new HashSet<>();
                newValue.add(element);
                slovarReverse.put(slovar.get(element), newValue);
            }
        }
        return slovarReverse;
    }
}
