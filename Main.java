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
        System.out.println(inptN + ", " + inptM);
        System.out.println(Arrays.toString(seriesA));

        int ap = 0;
        int bp = 0;
        boolean isHit = false;
        int[] seriesAns = new int[inptN];
        for (int i = 1; i <= inptN; i++) {
            // out of index
            if (ap >= inptM) {
                System.out.println("ap >= inptM");
                seriesAns[bp] = i;
                bp++;
                continue;
            }
            isHit = false;
            for (int j = ap; j < inptM; j++) {
                System.out.println("[" + i + ", " + j + "]: " + seriesA[j] + ", " + isHit);
                if (seriesA[j] == i) {
                    isHit = true;
                    ap += 1;
                    break;
                }
            }
            System.out.println("isHit: " + isHit);
            if (!isHit) {
                System.out.println("add");
                seriesAns[bp] = i;
                bp++;
            }
        }
        System.out.println("length: " + seriesAns.length + ", " + bp);
        String ans = "";
        for (int i = 0; i < bp; i++) {
            if (i == 0) {
                ans += seriesAns[i];
                continue;
            }
            ans += " " + seriesAns[i];
        }
        System.out.println(bp + "\n" + ans);
    }
}