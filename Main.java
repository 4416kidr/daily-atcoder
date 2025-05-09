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
        int count = 0;
        for (int i = 0; i < inptN; i++) {
            for (int j = i+1; j < inptN; j++) {
                if (seriesA[i] != seriesA[j]) {
                    break;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}