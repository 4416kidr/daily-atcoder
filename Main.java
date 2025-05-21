import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // ??m??s
    // ABC066C
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        List<Integer> list = new ArrayList<>(N);
        IntStream.range(0, N).forEach(i -> list.add(sc.nextInt()));
        sc.close();
        System.out.println(N + ", " + list);
    }
}