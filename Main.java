import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 396A
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final List<Integer> seriesN = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> seriesN.add(sc.nextInt()));
        sc.close();
        System.out.println(solve(seriesN) ? "Yes" : "No");
    }

    private static boolean solve(List<Integer> listN) {
        int prev = listN.get(0);
        int count = 1;
        for (int i = 0; i < listN.size(); i++) {
            int v = listN.get(i);
            if (prev == v) {
                count++;
            } else {
                count = 1;
            }
            if (count >= 3) {
                return true;
            }
            prev = v;
        }
        return false;
    }
}