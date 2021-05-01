import java.util.*;
public class PresekMnozic {
    
    public static <T> Set<T> presek(Collection<Set<T>> mnozice) {
        Set<T> presek = new HashSet<T>();
        boolean prvi = true;
        for (Set<T> mnozica : mnozice) {
            if (prvi) {
                prvi = !prvi;
                presek.addAll(mnozica);
            }
            else {
                presek.retainAll(mnozica);
            }
        }
        return presek;
    }
}
