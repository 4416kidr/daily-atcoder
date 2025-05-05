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


        int a = func(seriesP, 1);
        System.out.println("lastP: " + a + " >>>");
        int b = func(seriesQ, 1);
        System.out.println("lastQ: " + b + " >>>");
        System.out.println(abs(a, b));
    }
    private static int permutation(int n) {
        int res = 1;
        for (int i = n; i > 0; i--) {
            res *= i;
        }
        return res;
    }
    private static int func(int[] series, int v) {
        System.out.println("--- func(" + v + "): " + Arrays.toString(series) + " ---");
        if (series.length == 1) {
            return v;
        }
        int[] sortedArray = Arrays.copyOf(series, series.length);
        Arrays.sort(sortedArray);
        System.out.println("  sorted: " + Arrays.toString(sortedArray));
        
        int a = series[0];
        int ind = -1;
        for (int i = 0; i < series.length; i++) {
            if (a == sortedArray[i]) {
                ind = i;
            }
        }
        int diff = ind * permutation(series.length-1);
        System.out.println("  = v(" + v + ") + diff(" + diff + ", ind(" + ind + "))");
        return func(Arrays.copyOfRange(series, 1, series.length), v + diff);
    }
    private static int abs(int a, int b) {
        // Math.abs(a-b);
        return a - b < 0 ? -(a-b) : a-b;
    }
}