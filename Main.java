import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        sc.nextLine();
        char[][] seriesS = new char[inptN][50];
        int[] lengthS = new int[inptN];
        for (int i = 0; i < inptN; i++) {
            seriesS[i] = sc.nextLine().toCharArray();
            lengthS[i] = seriesS[i].length;
        }
        sc.close();

        String ans = "";
        Arrays.sort(lengthS);
        for (int si : lengthS) {
            for (int j = 0; j < inptN; j++) {
                if (seriesS[j].length == si) {
                    ans += String.valueOf(seriesS[j]);
                }
            }
        }
        System.out.println(ans);
    }
}