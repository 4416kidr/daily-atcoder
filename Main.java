import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        sc.nextLine();
        int[] seriesA = new int[inptN];
        for (int i = 0; i < inptN; i++) {
            seriesA[i] = sc.nextInt();
        }
        sc.close();

        long ansP = 0;
        for (int i = 0; i < inptN; i++) {
            // 要素1の配列は条件を満たす
            ansP++;
            // 要素2以上の配列で探索
            for (int j = i+1; j < inptN; j++) {
                if (seriesA[j-1] >= seriesA[j]) {
                    // 単調増加でなくなった場合、それ以降は単調増加配列という条件を満たさなくなるので探索を終了する
                    break;
                }
                ansP++;
            }
        }
        System.out.println(ansP);
    }
}