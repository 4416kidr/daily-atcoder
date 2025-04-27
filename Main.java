import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seriesA = new int[7];
        Arrays.setAll(seriesA, i -> sc.nextInt());

        final int CardNum = 13;
        
        int[] cardsCount = new int[CardNum];
        Arrays.fill(cardsCount, 0);
        boolean[] flags3 = new boolean[CardNum];
        boolean[] flags2 = new boolean[CardNum];
        Arrays.fill(flags2, false);
        Arrays.fill(flags3, false);
        for (int a : seriesA) {
            int ind = a-1;
            cardsCount[ind] += 1;
            if (cardsCount[ind] >= 3) {
                flags3[ind] = true;
                flags2[ind] = true;
            } else if (cardsCount[ind] >= 2) {
                flags2[ind] = true;
            }
        }

        // 判定準備
        int[] counts = {0, 0};
        for (int i = 0; i < CardNum; i++) {
            counts[0] += flags2[i] ? 1 : 0;
            counts[1] += flags3[i] ? 1 : 0;
        }

        // 判定 (c2 >= 2 && c3 >= 1 ---> true)
        if (counts[0] > 1 && counts[1] > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}