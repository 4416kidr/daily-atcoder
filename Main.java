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
        int tempSameCount = 1;
        System.out.println(Arrays.toString(seriesA));
        for (int endPointer = 1; endPointer < inptN; endPointer++) {
            System.out.println(String.format("  [%1$d] [%2$d, %3$d]: %4$d, %5$d (%6$d)", endPointer, startPointer, endPointer, seriesA[startPointer], seriesA[endPointer], tempSameCount));
            if (seriesA[startPointer] == seriesA[endPointer]) {
                tempSameCount++;
                continue;
            }
            // Pointerの更新と次の探索へ
            startPointer = endPointer;
            if (tempSameCount <= 1) {
                System.out.println("--------- same count <= 1 ---------");
                continue;
            }
            // countの更新: combination(同じ値の個数, 2)
            count += tempSameCount * (tempSameCount - 1) / 2;
            System.out.println(String.format("--------- sameCount(%1$d) updated(%2$d) ---------", tempSameCount, count));
            tempSameCount = 1;
        }
        System.out.println(String.format("\n--- final(%1$d) ---", tempSameCount));

        if (tempSameCount > 1) {
            count += tempSameCount * (tempSameCount - 1) / 2;
            System.out.println(String.format("  updated(%1$d)", count));
        }


        System.out.println(count);
    }
}