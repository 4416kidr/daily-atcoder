import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        List<ScoreRank> scores = new ArrayList<>();
        IntStream.range(0, N).forEach(v -> scores.add(new ScoreRank(sc.nextInt())));
        sc.close();
        System.out.println(N + ", " + scores);
        solve(N, scores);
        output(scores);
    }
    private static void solve(int n, List<ScoreRank> scores) {
        IntStream.range(1, n+1).forEach(i -> {
            int countHasRank = scores.size() - countRemain(scores);
            if (countHasRank >= i) {
                System.out.println(String.format("[%1$d] skip rank: %2$d(%3$d) <= %4$d", i, countHasRank, countRemain(scores), i));
                return;
            }
            ScoreRank maxScoreRank = scores.stream().filter(sr -> !sr.hasRank()).max(ScoreRank::compareTo).orElse(null);
            if (maxScoreRank == null) {
                return;
            }
            System.out.println(String.format("[%1$d] max: %2$s", i, maxScoreRank));
            scores.stream().filter(sr -> sr.getScore() == maxScoreRank.getScore()).forEach(sr -> sr.setRank(i));
            System.out.println(String.format("[%1$d]   scores -> %2$s", i, scores));
        });
    }

    private static int countRemain(List<ScoreRank> scores) {
        return (int)scores.stream().filter(o -> !o.hasRank()).count();
    }

    private static void output(List<ScoreRank> scores) {
        scores.forEach(v -> System.out.println(v.getRank()));
    }
}

class ScoreRank extends Object implements Comparable<ScoreRank> {
    private final int score;
    private int rank;

    public ScoreRank(int score) {
        this.score = score;
        this.rank = -1;
    }

    public int getScore() {
        return this.score;
    }

    public boolean hasRank() {
        return this.rank != -1;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("score(%1$d), rank(%2$d)", this.score, this.rank);
    }

    @Override
    public int compareTo(ScoreRank sr) {
        return this.score == sr.getScore() ? 0 : (this.score < sr.getScore() ? -1 : 1);
    }
}