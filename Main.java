import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // 24m55s
    // ABC390A
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = IntStream.range(0, 5).map(i -> sc.nextInt()).boxed().toList();
        sc.close();
        boolean ans = solve(list);
        System.out.println(ans ? "Yes" : "No");
    }

    private static boolean solve(List<Integer> list) {
        // 実際にスワップしてみる
        if (isSorted(list)) {
            return false;
        }
        return (int)IntStream.range(0, 4).filter(i -> isSorted(swap2At(list, i))).count() == 1;
    }

    private static boolean isSorted(List<Integer> list) {
        return list.stream().allMatch(v -> v == (list.indexOf(v)+1));
    }

    private static List<Integer> swap2At(List<Integer> list, int ind) {
        return IntStream.range(0, 5).map(i -> i == ind ? list.get(i+1) : i-1 == ind ? list.get(i-1) : list.get(i)).boxed().toList();
    }
}