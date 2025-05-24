import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // 26m
    // ABC384B
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int R = sc.nextInt();
        List<ARC> inptArc = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> inptArc.add(new ARC(sc.nextInt(), sc.nextInt())));
        sc.close();
        solve(R, inptArc);
    }

    public static void solve(int rate, List<ARC> arcs) {
        for (ARC arc : arcs) {
            rate += arc.isTarget(rate) ? arc.getScore() : 0;
        }
        System.out.println(rate);
    }
}

class ARC {
    private final int div;
    private final int score;

    public ARC(int div, int score) {
        this.div = div;
        this.score = score;
    }

    public boolean isTarget(int beforeScore) {
        boolean isDiv1Target = this.div == 1 && 1600 <= beforeScore && beforeScore < 2800;
        boolean isDiv2Target = this.div == 2 && 1200 <= beforeScore && beforeScore < 2400;
        return isDiv1Target || isDiv2Target;
    }

    public int getScore() {
        return this.score;
    }
    
    @Override
    public String toString() {
        return String.format("Div.%1$d: %2$d", this.div, this.score);
    }
}