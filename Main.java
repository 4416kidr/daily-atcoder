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
        List<Data> list = new ArrayList<>(N);
        IntStream.range(0, N).forEach(i -> list.add(new Data(sc.nextInt())));
        sc.close();
        System.out.println(N + ", " + list);
        solve(list);
    }

    public static void solve(List<Data> list) {
        System.out.println("solve");
    }
}

class Data extends Object {
    private int abs;

    public Data(int abs) {
        this.abs = abs;
    }

    public int getAbs() {
        return this.abs;
    }

    @Override
    public String toString() {
        return String.format("%1$d", this.abs);
    }
}