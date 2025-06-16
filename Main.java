import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 385A
        // 0857-0906
        final Scanner sc = new Scanner(System.in);
        final List<Integer> list = List.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println(solve(list) ? "Yes" : "No");
        sc.close();
    }

    public static boolean solve(List<Integer> list) {
        final boolean three = list.stream().allMatch(v -> list.get(0) == v);
        if (three) return true;
        final List<Boolean> flags = IntStream.range(0, 3)
                                        .mapToObj(i -> list.get(i) == (list.get((i+1) % 3) + list.get((i+2) % 3)))
                                        .toList();
        return flags.contains(true);
    }
}