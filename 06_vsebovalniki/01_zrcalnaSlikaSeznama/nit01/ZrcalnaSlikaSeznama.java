import java.util.*;
public class ZrcalnaSlikaSeznama {

    public static <T> List<T> zrcalnaSlika(List<T> seznam) {
        int dolzina = seznam.size();
        List<T> zrcalniSeznam = new ArrayList<>();
        for (int i = dolzina - 1; i >= 0; i--) {
            T element = seznam.get(i);
            zrcalniSeznam.add(element);
        }
        return zrcalniSeznam;
    }


}