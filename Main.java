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
        System.out.println(Arrays.toString(seriesA));

        // 最初に単調増加判定した配列を用意するのもあり
        int[][] ans = new int[1][2];
        int ansP = 0;
        for (int i = 0; i < inptN; i++) {
            System.out.println("--- [i:" + (i+1) + "] ---");
            // 要素1の配列は条件を満たす
            ans[ansP] = new int[]{i+1, i+1};
            ansP++;
            // 最後の要素の場合はindexOutOfRangeを防ぐためにいらない
            if (i == inptN - 1) {
                continue;
            }
            // inptN-i-1 -> 全てが代入された場合の値
            // 次の要素数1配列の代入のために空要素を一つだけ置いておく
            ans = Arrays.copyOf(ans, ans.length + (inptN - i - 1) + 1);
            for (int j = i+1; j < inptN; j++) {
                System.out.println("--- [j:" + (j+1) + "] ---");
                System.out.println(seriesA[j-1] + " <?> " + seriesA[j]);
                if (seriesA[j-1] >= seriesA[j]) {
                    break;
                }
                ans[ansP] = new int[]{i+1, j+1};
                ansP++;
            }
            for (int k = 0; k < ansP; k++){
                System.out.println(Arrays.toString(ans[k]));
            }
        }
        System.out.println("--- final ans (" + ansP + ") ---");
        for (int i = 0; i < ansP; i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}