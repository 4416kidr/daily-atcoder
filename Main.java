import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        sc.nextLine();
        int[] seriesP = new int[inptN];
        for (int i = 0; i < inptN; i++) {
            seriesP[i] = sc.nextInt();
        }
        int[] seriesQ = new int[inptN];
        for (int i = 0; i < inptN; i++) {
            seriesQ[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(abs(func(seriesP, 1), func(seriesQ, 1)));
    }
    private static int permutation(int n) {
        int res = 1;
        for (int i = n; i > 0; i--) {
            res *= i;
        }
        return res;
    }
    private static int func(int[] series, int v) {
        if (series.length == 1) {
            return v;
        }
        // インデックス検索の準備
        int[] sortedArray = Arrays.copyOf(series, series.length);
        Arrays.sort(sortedArray);
        
        // index of
        final int a = series[0];
        int ind = -1;
        for (int i = 0; i < series.length; i++) {
            if (a == sortedArray[i]) {
                ind = i;
                break;
            }
        }
        return func(Arrays.copyOfRange(series, 1, series.length), v + ind * permutation(series.length-1));
    }
    private static int abs(int a, int b) {
        // Math.abs(a-b);
        return a - b < 0 ? -(a-b) : a-b;
    }
}