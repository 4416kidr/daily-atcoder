import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String series = sc.nextLine();
        sc.close();

        System.out.println(series);
        int indA = -1;
        int indB = -1;
        int indC = -1;
        int count = 0;
        for (int i = 0; i < series.length(); i++) {
            if (series.charAt(i) != 'A') {
                continue;
            }
            indA = i;
            for (int j = i+1; j < series.length(); j++) {
                if (series.charAt(j) != 'B') {
                    continue;
                }
                indB = j;
                indC = j + (j-i);
                System.out.println(indA + "(" + series.charAt(indA) + "), " + indB + "(" + series.charAt(indB) + "), " + indC + "(" + series.charAt(indC) + ")");
                if (series.charAt(indC) == 'C') {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}