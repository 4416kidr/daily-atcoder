import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // ABC390B
    // ?H?M
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final List<Integer> list = new ArrayList<>(N);
        IntStream.range(0, N).forEach(i -> list.add(sc.nextInt()));
        sc.close();
        System.out.printf("list %s\n", list);
        System.out.println(solve(list) ? "Yes" : "No");
    }

    public static boolean solve(List<Integer> list) {
        if (list.size() == 2) {
            return true;
        }
        int first = list.get(0);
        int second = list.get(1);
        System.out.printf("first(%d), second(%d)\n", first, second);
        int gcd = greatest_common_divisor(first, second);
        System.out.println("gcd: " + gcd);
        // 約分して公比ratioを求める
        int numerator = second / gcd;
        int denominator = first / gcd;
        System.out.printf("ratio: %d / %d\n", numerator, denominator);
        // for文
        return IntStream.range(1, list.size()).allMatch(i -> {
            int preV = list.get(i-1);
            int value = list.get(i);
            if (preV % denominator != 0) {
                return false;
            }
            System.out.printf("[%d] -%d- * (%d/%d) -> [%d] == -%d-\n", i, preV, numerator, denominator, preV / denominator * numerator, value);
            return (preV / denominator * numerator) == value;
        });
    }

    // 最大公約数を求める
    public static int greatest_common_divisor(int left, int right) {
        int big = left < right ? right : left;
        int small = left < right ? left : right;
        // r1 = a % b
        // r2 = b % r1
        // r3 = r1 % r2
        int count = 0;
        while (true) {
            count++;
            System.out.printf("[%d] before: %d / %d = %d ... %d\n", count, big, small, big / small, big % small);
            int res = big % small;
            big = small;
            small = res;
            System.out.printf("[%d] after: %d, %d\n", count, big, small);
            if (small == 0) {
                return big;
            }
        }
    }
}