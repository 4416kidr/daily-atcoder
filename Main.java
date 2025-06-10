import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 375B
        // 1901-1930
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final List<Point> list = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> list.add(new Point(sc.nextLong(), sc.nextLong())));
        list.add(0, new Point(0, 0));
        list.add(list.size(), new Point(0, 0));
        sc.close();
        // System.out.println(solve(list)); // 583ms, 72,684KiB
        // System.out.println(solve2(list)); // 600ms, 73,484KiB
        System.out.println(solve3(list)); // 640ms, 73,576KiB
    }

    private static double solve(List<Point> list) {
        double res = 0;
        for (int i = 1; i < list.size(); i++) {
            res += list.get(i-1).calcEuclidDistance(list.get(i));
        }
        return res;
    }

    private static double solve2(List<Point> list) {
        return IntStream.range(1, list.size())
            .mapToObj(i -> new Pair(list.get(i-1), list.get(i)))
            .reduce(0.0, (sum, v) -> sum + v.calcEuclidDistance(), (a, b) -> b);
    }

    private static double solve3(List<Point> list) {
        return IntStream.range(1, list.size())
            .boxed()
            .mapToDouble(i -> list.get(i-1).calcEuclidDistance(list.get(i)))
            .sum();
    }
}

class Point {
    final long x;
    final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public double calcEuclidDistance(Point right) {
        return Math.hypot(this.x - right.x, this.y - right.y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
}

class Pair {
    final Point left;
    final Point right;

    public Pair(Point l, Point r) {
        this.left = l;
        this.right = r;
    }

    public double calcEuclidDistance() {
        return this.left.calcEuclidDistance(this.right);
    }
}
