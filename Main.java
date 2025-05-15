import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final short inptN = sc.nextShort();
        final short inptM = sc.nextShort();
        sc.nextLine();
        System.out.println(inptN + ", " + inptM);
        final String[] tableS = inputTable(inptN, sc);
        final String[] tableT = inputTable(inptM, sc);
        sc.close();

        // 縦検査
        for (short i = 0; i < inptN - inptM + 1; i++) {
            if (!tableS[i].contains(tableT[0]))
                continue;
            System.out.println("line" + i);
            // 列を調べる
            // 各行の含有チェック
            for (short j = 1; j < inptM; j++) {
                if (tableS[i+j].contains(tableS[j]))
                    System.out.println(String.format("%1$d %2$d", i, j));
                
            }
        }
    }
    private static String[] inputTable(short n, Scanner sc) {
        String[] array = new String[n];
        for (short i = 0; i < n; i++) {
            array[i] = sc.nextLine();
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}