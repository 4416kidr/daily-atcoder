import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        
        int groupSize = 20;
        int[][] grouped = new int[groupSize][inptN];
        int[] gPointer = new int[groupSize];
        int tempInpt = -1;
        for (int i = 0; i < inptN; i++) {
            tempInpt = sc.nextInt();
            // 降順を可能にするために符号を逆転する
            grouped[tempInpt % groupSize][gPointer[tempInpt % groupSize]++] = -tempInpt;
        }
        sc.close();
        
        int[] countA = new int[groupSize];
        int tempCount = -1;
        for (int i = 0; i < groupSize; i++) {
            Arrays.sort(grouped[i]);
            // calc length
            tempCount = 0;
            for (tempCount = 0; tempCount < inptN; tempCount++) {
                if (grouped[i][tempCount] == 0)
                    break;
            }
            countA[i] = tempCount;
        }

        int count = 0;
        int tempSize = -1;
        for (int i = 0; i < groupSize; i++) {
            tempSize = countA[i];
            if (tempSize <= 1) {
                continue;
            }
            for (int j = 0; j < tempSize; j++) {
                for (int k = j+1; k < tempSize; k++) {
                    if ((-grouped[i][j] - -grouped[i][k]) % 200 == 0) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}