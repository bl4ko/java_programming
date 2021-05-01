import java.util.*;
public class MankajoceBesede {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dolzinaPrva = sc.nextInt();
        Set<String> prvaMnozica = new TreeSet<String>();
        for (int i =0; i < dolzinaPrva; i++) {
            prvaMnozica.add(sc.next());
        }

        int dolzinaDruga = sc.nextInt();
        Set<String> drugaMnozica = new HashSet<String>();
        for (int i =0; i < dolzinaDruga; i++) {
            drugaMnozica.add(sc.next());
        }

        prvaMnozica.removeAll(drugaMnozica);
        for (String beseda : prvaMnozica)
            System.out.println(beseda);
    }
}
