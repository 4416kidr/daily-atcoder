import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // ABC390B
    // ?H?M
    static final boolean isDebugMode = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final List<Integer> list = new ArrayList<>(N);
        IntStream.range(0, N).forEach(i -> list.add(sc.nextInt()));
        sc.close();
        debug("list %s", list);
        System.out.println(solve(list) ? "Yes" : "No");
    }

    public static boolean solve(List<Integer> list) {
        if (list.size() == 2) {
            return true;
        }
        // for文
        boolean notOK = false;
        for (int i = 2; i < list.size(); i++) {
            long a1 = list.get(i-2);
            long a2 = list.get(i-1);
            long a3 = list.get(i);
            // (a1/a2) == (a2/a3) -> (a1a3) == (a2a2)
            debug("[%d, %d, %d] %d, %d", a1, a2, a3, a1 * a3, a2 * a2);
            if (a1 * a3 != a2 * a2) {
                notOK = true;
            }
        }
        return !notOK;
    }

    public static void debug(String format, Object... args) {
        if (isDebugMode) {
            System.out.printf("[DEBUG] " + format + "\n", args);
        }
    }
}