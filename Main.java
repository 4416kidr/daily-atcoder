import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short inptA = sc.nextShort();
        sc.close();
        final short PEOPLE = 400;
        System.out.println(PEOPLE % inptA == 0 ? (short)(PEOPLE / inptA) : -1);
    }
}