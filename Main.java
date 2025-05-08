import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        int inptM = sc.nextInt();
        int[] seriesA = new int[inptM];
        for (int i = 0; i < inptM; i++) {
            seriesA[i] = sc.nextInt();
        }
        sc.close();
        
        Arrays.sort(seriesA);
        int ap = 0;
        int bp = 0;
        int[] seriesAns = new int[inptN];
        for (int i = 1; i <= inptN; i++) {
            // out of index
            if (ap >= inptM) {
                seriesAns[bp++] = i;
                continue;
            }
            // hit
            if (seriesA[ap] == i) {
                ap++;
                continue;
            }
            // add to ans
            seriesAns[bp++] = i;
        }

        // output
        String ans = bp == 0 ? "" : Integer.toString(seriesAns[0]);
        for (int i = 1; i < bp; i++) {
            ans += " " + seriesAns[i];
        }
        System.out.println(bp + "\n" + ans);
    }
}