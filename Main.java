import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 379B
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int k = sc.nextInt();
        final String tStr = sc.nextLine();
        String series = sc.nextLine();
        sc.close();
        System.out.println(solve(series, k));
    }

    private static int block(String inpt, int threshold) {
        return inpt.length() / threshold;
    }

    private static int solve(String inpt, int threshold) {
        String tStr = inpt;
        if (!inpt.contains("X")) {
            return inpt.length() / threshold;
        }
        int count = 0;
        String[] splt = inpt.split("X");
        for (int i = 0; i < splt.length; i++) {
            int prevCount = count;
            count += splt[i].length() / threshold;
            System.out.printf("%d: %s, length(%d = %d / %d), count(%d -> %d)\n", i, splt[i], splt[i].length() / threshold, splt[i].length(), threshold, prevCount, count);
        }
        System.out.println("---");
        return count;
    }
}