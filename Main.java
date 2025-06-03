import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 378B
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final List<Trash> seriesN = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> seriesN.add(new Trash(sc.nextInt(), sc.nextInt())));
        final int Q = sc.nextInt();
        final List<Question> seriesQ = new ArrayList<>();
        IntStream.range(0, Q).forEach(i -> seriesQ.add(new Question(sc.nextInt(), sc.nextInt())));
        sc.close();
        solve(seriesN, seriesQ);
    }

    private static void solve(List<Trash> listN, List<Question> listQ) {
        listQ.stream().forEach(q -> {
            int res = listN.get(q.getTypeIndex()).dayRemain(q.getDay());
            System.out.println(res);
        });
    }
}

class Trash {
    final int q;
    final int r;

    public Trash(int q, int r) {
        this.q = q;
        this.r = r;
    }

    public int dayRemain(int day) {
        int adj = day-this.r+this.q-1;
        int step = adj/this.q;
        return step * this.q + this.r;
    }

    @Override
    public String toString() {
        return String.format("Trash(%d, %d)", q, r);
    }
}

class Question {
    final int t;
    final int d;

    public Question(int t, int d) {
        this.t = t;
        this.d = d;
    }

    public int getTypeIndex() {
        return this.t-1;
    }

    public int getDay() {
        return this.d;
    }
    
    @Override
    public String toString() {
        return String.format("Question(%d, %d)", t, d);
    }
}