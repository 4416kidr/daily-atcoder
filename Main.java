import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inpt = new int[2];
        Arrays.setAll(inpt, i -> sc.nextInt());
        sc.close();
        int inptN = inpt[0];
        int inptM = inpt[1];

        int[] series = new int[inptM+1];
        series[0] = 1;
        final int BILLION = 1_000_000_000;
        // i == 0 はtempに格納
        for (int i = 1; i <= inptM; i++) {
            series[i] = series[i-1] * inptN;
            if (series[i] < 0 || BILLION < series[i]) {
                System.out.println("inf");
                return;
            }
        }
        int ans = Arrays.stream(series).sum();
        if (ans < 0 || BILLION < ans) {
            System.out.println("inf");
        } else {
            System.out.println(ans);
        }
    }
}