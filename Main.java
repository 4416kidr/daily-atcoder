import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final short inptN = sc.nextShort();
        final short inptM = sc.nextShort();
        sc.nextLine();
        final String[] tableS = inputTable(inptN, sc);
        final String[] tableT = inputTable(inptM, sc);
        sc.close();

        boolean isNG = false;
        short[] ans = new short[2];
        for (short i = 0; i < inptN - inptM + 1; i++) {
            if (!tableS[i].contains(tableT[0]))
                continue;
            // 1行目ヒット -> 列を調べる
            for (short j = 0; j < inptN - inptM + 1; j++) {
                if (!tableS[i].substring(j).startsWith(tableT[0]))
                    continue;
                ans[1] = j;
                ans[0] = i;
                // 2行目以降の等価チェック
                for (short k = 1; k < inptM; k++) {
                    if (!tableS[i+k].substring(j).startsWith(tableT[k])) {
                        isNG = true;
                        break;
                    }
                }
                if (!isNG)
                    System.out.println(i+1 + " " + (j+1));
                isNG = false;

            }
        }
    }
    private static String[] inputTable(short n, Scanner sc) {
        String[] array = new String[n];
        for (short i = 0; i < n; i++) {
            array[i] = sc.nextLine();
        }
        return array;
    }
}