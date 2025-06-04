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

    private static boolean solve(List<Integer> list) {
        return IntStream.range(1, list.size()).reduce(1, (acc, i) -> acc >= 3 ? 3 : (list.get(i-1) == list.get(i) ? acc+1 : 1)) >= 3;
    }
}