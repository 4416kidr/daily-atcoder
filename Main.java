import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        int[] seriesA = new int[inptN];
        for (int i = 0; i < inptN; i++) {
            // 基数200の世界を扱う
            seriesA[i] = sc.nextInt() % 200;
        }
        sc.close();
        
        Arrays.sort(seriesA);
        int startPointer = 0;
        int count = 0;
        for (int endPointer = 1; endPointer < inptN; endPointer++) {
            if (seriesA[startPointer] == seriesA[endPointer]) {
                // まだ区切りではない
                continue;
            }
            // countの更新: combination(同じ値の個数, 2)
            count += (endPointer - startPointer) * (endPointer - startPointer - 1) / 2;
            // Pointerの更新と次の探索へ
            startPointer = endPointer;
        }
        System.out.println(count);
    }
}