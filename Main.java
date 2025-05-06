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

        int ra = 1;
        int rb = 1;
        for (int i = 0; i < inptN; i++) {
            int[] sortedArrayP = Arrays.copyOfRange(seriesP, i, inptN);
            Arrays.sort(sortedArrayP);
            int[] sortedArrayQ = Arrays.copyOfRange(seriesQ, i, inptN);
            Arrays.sort(sortedArrayQ);

            boolean[] flags = new boolean[]{false, false};
            int[] inds = new int[]{-1, -1};
            for (int j = 0; j < sortedArrayP.length; j++) {
                if (seriesP[i] == sortedArrayP[j]) {
                    inds[0] = j;
                    flags[0] = true;
                }
                if (seriesQ[i] == sortedArrayQ[j]) {
                    inds[1] = j;
                    flags[1] = true;
                }
                if (flags[0] && flags[1]) {
                    break;
                }
            }
            ra += inds[0] * permutation(inptN - 1 - i);
            rb += inds[1] * permutation(inptN - 1 - i);
        }
        System.out.println(Math.abs(ra-rb));
    }
    private static int permutation(int n) {
        int res = 1;
        for (int i = n; i > 0; i--) {
            res *= i;
        }
        return res;
    }
}