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
        // listQ.stream().forEach(q -> {
        //     int res = listN.get(q.getTypeIndex()).dayRemain(q.getDay());
        //     System.out.println(res);
        // });
        IntStream.range(0, 7).forEach(i -> {
            Trash t = new Trash(7, i);
            System.out.printf("--- %s ---\n", t);
            IntStream.range(1, 20).forEach(j -> {
                System.out.printf("[%d]: old(%d) ?? new(%d)\n", j, t.dayRemain(j), t.dayRemain2(j));
            });
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
        int step = (day+this.r)/this.q;
        int res = step * this.q + this.r;
        // System.out.printf("dayRemain(%d): res(%d) = step(%d) * q(%d) + r(%d)\n", day, res, step, this.q, this.r);
        return res;
    }

    public int dayRemain2(int day) {
        //     (00, 00): 01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        //  adj( 3,  7): 05, 06, 07, 08, 09, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24
        // step( 3,  7): 00, 00, 00, 01, 01, 01, 01, 01, 01, 01, 08, 09, 10, 11, 12, 13, 14, 15, 16, 17
        // ( 3,  7): 03, 03, 03, 10, 10, 10, 10, 10, 10, 10, 17, 17, 17, 17, 17, 17, 17, 24, 24, 24
        // ()
        int adj = day-this.r+this.q-1;
        int step = adj/this.q;
        int res = step * this.q + this.r;
        // System.out.printf("dayRemain(%d): res(%d) = step(%d) * q(%d) + r(%d)\n", day, res, step, this.q, this.r);
        return res;
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