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
        System.out.println(solve(list) ? "Yes" : "No");
    }

    public static boolean solve(List<Integer> list) {
        // System.out.println(list);
        if (list.size() != 3) {
            return false;
        }
        final boolean three = list.get(0) == list.get(1) && list.get(0) == list.get(2);
        // System.out.println(three);
        if (three) {
            return true;
        };
        list.sort((a, b) -> a-b);
        // System.out.println(list);
        final boolean two = list.get(0) + list.get(1) == list.get(2);
        // System.out.println(two);
        return two;
    }
}
