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
        System.out.println(Arrays.toString(seriesA));
        int startPointer = 0;
        int endPointer = 1;
        int count = 0;
        int loopCount = 0;
        while(endPointer < inptN) {
            System.out.print(String.format("[%1$d] [%2$d, %3$d]: %4$d, %5$d", ++loopCount, startPointer, endPointer, seriesA[startPointer], seriesA[endPointer]));
            if (seriesA[startPointer] == seriesA[endPointer]) {
                // 区切りの探索
                System.out.println();
                endPointer++;
            } else {
                // countの更新: combination(同じ値の個数, 2)
                for (int i = 1; i < endPointer - startPointer; i++) {
                    count += i;
                }
                // Pointerの更新と次の探索へ
                System.out.println(String.format("\n--------- updated(%1$d) ---------", count));
                startPointer = endPointer++;
            }
        }
        System.out.println(count);
    }
}