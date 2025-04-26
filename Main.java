import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inpt = new int[2];
        Arrays.setAll(inpt, i -> sc.nextInt());
        sc.close();
        int inptN = inpt[0];
        int inptK = inpt[1];

        int[] series = new int[inptN+1];
        int cache = 0;
        final int billion = 1_000_000_000;
        for (int i = 0; i <= inptN; i++) {
            if (0 <= i && i < inptK) {
                series[i] = 1;
                continue;
            }
            if (i == inptK) {
                series[i] = Arrays.stream(Arrays.copyOfRange(series, i - inptK, i)).sum() % billion;
            } else {
                series[i] = (cache + series[i-1]) % billion;
            }
            cache = series[i] - series[i - inptK];
        }
        System.out.println(series[series.length - 1]);
    }
}