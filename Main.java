import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // 16m45s
    // ABC388B
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int D = sc.nextInt();
        List<Snake> snakes = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> snakes.add(new Snake(sc.nextInt(), sc.nextInt())));
        sc.close();
        solve(D, snakes);
    }
    private static void solve(int D, List<Snake> snakes) {
        IntStream.range(1, D+1).forEach(i -> {
            snakes.forEach(s -> s.incrementLength());
            System.out.println(Collections.max(snakes).getWeight());
        });
    }
}

class Snake extends Object implements Comparable<Snake> {
    private final int thick;
    private int length;

    public Snake(int thick, int length) {
        this.thick = thick;
        this.length = length;
    }

    public int getThick() {
        return this.thick;
    }

    public int getLength() {
        return this.length;
    }

    public void incrementLength() {
        this.length++;
    }

    public int getWeight() {
        return this.thick * this.length;
    }

    @Override
    public String toString() {
        return String.format("thick(%1$d) * length(%2$d) = weight(%3$d)", this.thick, this.length, this.getWeight());
    }

    @Override
    public int compareTo(Snake sn) {
        return Integer.compare(this.getWeight(), sn.getWeight());
    }
}