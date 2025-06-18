import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 385A
        // 0857-0906
        final Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> list.add(sc.nextInt()));
        sc.close();
        System.out.println(solve(list.get(0), list.get(1), list.get(2)) ? "Yes" : "No");
    }

    public static boolean solve(int a, int b, int c) {
        final boolean all = a == b && a == c;
        final boolean ab = a + b == c;
        final boolean bc = b + c == a;
        final boolean ca = c + a == b;
        return all || ab || bc || ca;
    }
}
