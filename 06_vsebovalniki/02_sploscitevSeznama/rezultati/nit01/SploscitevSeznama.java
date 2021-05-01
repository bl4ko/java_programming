import java.util.*;

public class SploscitevSeznama {
    
    public static <T> List<T> splosci(List<List<T>> seznami) {
        List<T> splosceniList = new ArrayList<T>();
        for (List<T> podSeznam : seznami) {
            for (T element : podSeznam) {
                splosceniList.add(element);
            }
        }
        return splosceniList;
    }
}
