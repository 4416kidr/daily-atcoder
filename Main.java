import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // ABC390B
    // ?H?M
    static final boolean isDebugMode = true;
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
        int first = list.get(0);
        int second = list.get(1);
        debug("first(%d), second(%d)", first, second);
        int gcd = greatest_common_divisor(first, second);
        debug("gcd: %d\n", gcd);
        // 約分して公比ratioを求める
        int numerator = second / gcd;
        int denominator = first / gcd;
        debug("ratio: %d / %d", numerator, denominator);
        // for文
        boolean notOK = false;
        for (int i = 1; i < list.size(); i++) {
            int preV = list.get(i-1);
            int value = list.get(i);
            debug("[%d] -%d- * (%d/%d) -> [%d] == -%d-", i, preV, numerator, denominator, preV / denominator * numerator, value);
            if ((preV / denominator * numerator) != value) {
                notOK = true;
                break;
            }
        }
        return !notOK;
    }

    // 最大公約数を求める
    public static int greatest_common_divisor(int left, int right) {
        int big = left < right ? right : left;
        int small = left < right ? left : right;
        // r1 = a % b
        // r2 = b % r1
        // r3 = r1 % r2
        int count = 0;
        while (small != 0) {
            count++;
            debug("[%d] before: %d / %d = %d ... %d", count, big, small, big / small, big % small);
            int res = big % small;
            big = small;
            small = res;
            debug("[%d] after: %d, %d", count, big, small);
        }
        debug("[GCD] big: %d", big);
        return big;
    }

    public static void debug(String format, Object... args) {
        if (isDebugMode) {
            System.out.printf("[DEBUG] " + format + "\n", args);
        }
    }
}