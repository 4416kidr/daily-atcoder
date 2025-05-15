import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final short inptN = sc.nextShort();
        final short inptM = sc.nextShort();
        sc.nextLine();
        System.out.println(inptN + ", " + inptM);
        final char[][] tableS = inputTable(inptN, sc);
        final char[][] tableT = inputTable(inptM, sc);
        sc.close();
    }
    private static char[][] inputTable(short n, Scanner sc) {
        char[][] array = new char[n][n];
        for (short i = 0; i < n; i++) {
            array[i] = String.join("", sc.nextLine().split(" ")).toCharArray();
        }
        Arrays.asList(array).forEach(l -> System.out.println(Arrays.toString(l)));
        return array;
    }
}