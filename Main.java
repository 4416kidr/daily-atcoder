import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // 60m: 正確には測れなかったが、60分ぐらい
    // ABC066C
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        List<Data> list = new ArrayList<>(N);
        IntStream.range(0, N).forEach(i -> list.add(new Data(sc.nextInt())));
        sc.close();
        solve(list);
    }

    public static void solve(List<Data> list) {
        if (!isSafeFormat(list)) {
            System.out.println(0);
            return;
        }
        long ans = 1;
        for (int i = 0; i < list.size() / 2; i++) {
            ans = ans * 2 % 1_000_000_007;
        }
        System.out.println(ans);
    }

    public static boolean isSafeFormat(List<Data> list) {
        list.sort((x, y) -> Integer.compare(x.getAbs(), y.getAbs()));
        boolean isOK = false;
        if (list.size() % 2 == 1) {
            // odd
            isOK = IntStream.range(0, list.size()).allMatch(i -> (i+1)/2 == list.get(i).getAbs()/2);
        } else {
            isOK = IntStream.range(0, list.size()).allMatch(i -> i/2 == list.get(i).getAbs()/2);
        }
        return isOK;
    }
}

class Data extends Object implements Comparable<Data> {
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

    @Override
    public int compareTo(Data d) {
        return Integer.compare(d.getAbs(), this.getAbs());
    }
}