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
        for (int i = 0; i <= inptN; i++) {
            if (0 <= i && i < inptK) {
                series[i] = 1;
                continue;
            }
            int[] temp = Arrays.copyOfRange(series, i - inptK, i);
            // System.out.println("temp:" + Arrays.toString(temp) + Integer.toString(i-inptK) + Integer.toString(i-1));
            series[i] = Arrays.stream(temp).sum();
        }
        // for (int i : series) {
        //     System.out.println(i);
        // }
        int billion = 1_000_000_000;
        System.out.println(series[series.length - 1] % billion);

    }
}