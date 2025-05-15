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
        boolean isNG = false;
        short[] ans = new short[2];
        for (short i = 0; i < inptN - inptM + 1; i++) {
            if (!tableS[i].contains(tableT[0]))
                continue;
            // 1行目ヒット
            System.out.println("--- line" + i + " ---");
            // 列を調べる
            for (short j = 0; j < inptN - inptM + 1; j++) {
                System.out.println(i + ", " + j + ", " + tableS[i].substring(j, j+inptM));
                if (!tableS[i].substring(j).startsWith(tableT[0]))
                    continue;
                ans[1] = j;
                ans[0] = i;
                System.out.println(String.format("first line match: (%1$d, %2$d)", ans[0]+1, ans[1]+1));
                // 2行目以降の等価チェック
                for (short k = 1; k < inptM; k++) {
                    System.out.println("start checking after line 2: " + (j+1));
                    if (!tableS[i+k].substring(j).startsWith(tableT[k])) {
                        isNG = true;
                        break;
                    }
                }
                System.out.println(i+1 + " " + (j+1) + "? " + isNG);
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
        System.out.println(Arrays.toString(array));
        return array;
    }
}