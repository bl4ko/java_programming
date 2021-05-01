import java.util.Scanner;
public class RazbijanjeStevil {
    public static void main(String[] args) { //brez math funkcij nekoliko vec zank....
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b = sc.nextInt();
        int stevecA = (int) Math.log10(a);
        int stevec = (int) Math.log10(b);
        
        for (int i = stevec; i >0; i--, b/=10) {
            int stevka = b % (int)Math.pow(10, i);
            for (int j = 0; j < stevka; j++, stevecA--) {
                System.out.print(a%(int)Math.pow(10, stevecA));
            }
        }
    }
}
