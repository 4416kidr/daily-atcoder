import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 395A
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final List<Integer> list = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> list.add(sc.nextInt()));
        sc.close();
        boolean flag = IntStream.range(1, N).allMatch(i -> list.get(i-1) < list.get(i));
        System.out.println(flag ? "Yes" : "No");
    }
}
