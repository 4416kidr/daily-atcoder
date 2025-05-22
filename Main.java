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
        checkFormat(list);
    }

    public static boolean checkFormat(List<Data> list) {
        list.sort((x, y) -> Integer.compare(x.getAbs(), y.getAbs()));
        boolean isOK = false;
        if (list.size() % 2 == 1) {
            isOK = IntStream.range(0, list.size()).allMatch(i -> (i+1)/2 == list.get(i).getAbs());
        } else {
            isOK = IntStream.range(0, list.size()).allMatch(i -> i/2 == list.get(i).getAbs());
        }
        System.out.println(String.format("%1$s, isOK(%2$s), list: %3$s", list.size() % 2 == 0 ? "even" : "odd", isOK, list));
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