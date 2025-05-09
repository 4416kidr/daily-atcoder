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
        int endPointer = 1;
        int count = 0;
        int loopCount = 0;
        while(endPointer < inptN) {
            System.out.println(String.format("  [%1$d] [%2$d, %3$d]: %4$d, %5$d", ++loopCount, startPointer, endPointer, seriesA[startPointer], seriesA[endPointer]));
            if (seriesA[startPointer] != seriesA[endPointer]) {
                // 区切りに到達
                // countの更新: combination(同じ値の個数, 2)
                count += (endPointer - startPointer) * (endPointer - startPointer - 1) / 2;
                System.out.println(String.format("--------- sameCount(%1$d) updated(%2$d) ---------", endPointer - startPointer, count));
                // Pointerの更新と次の探索へ
                startPointer = endPointer;
            }
            // 区切り探索時はもちろん、区切りに到達後も更新が必要
            endPointer++;
        }
        System.out.println(count);
    }
}