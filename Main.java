import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String series = sc.nextLine();
        sc.close();
        solve(series);
    }
    private static int countMayAns(int mustC, int mayC) {
        return -1;
    }
    private static int countMustAns(int n) {
        // n: 必須になっている数字の数
        switch (n) {
            case 4:
                return permutation(4);
            case 3:
                // 重複なしの順序 * 重複の場所 / 重複数 * 重複にする数字の種類
                return permutation(3) * 4 / 2 * 3;
            case 2:
                // 1:3の場合(1の場所(4)) + 2:2の場合(全順序/前者の重複/後者の重複) + 3:1の場合(1の場所(4))
                return 4 + permutation(4) / 2/ 2 + 4;
            case 1:
                return 1;
            default:
                return -1;
        }
    }

    private static int permutation(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int res = 1;
        for (int i = n; i > 1; i--) {
            res *= i;
        }
        return res;
    }

    private static void solve(String series) {
        List<Integer> mustSeries = new ArrayList<>();
        List<Integer> maySeries = new ArrayList<>();
        for (int i = 0; i < series.length(); i++) {
            if (series.charAt(i) == 'x') {
                continue;
            }
            if (series.charAt(i) == 'o') {
                mustSeries.add(i);
            } else if (series.charAt(i) == '?') {
                maySeries.add(i);
            }
            continue;
        }
        System.out.println(String.format("must(%1$d), may(%2$d)", mustSeries.size(), maySeries.size()));

        // int moreElm = 4 - mustSeries.size();
        // int mayCount = ;
        System.out.println(permutation(3) * maySeries.size());

        // o012?345x67889
        // 012/3, 012/4, 012/5
        // 0/012, 1/012, 2/012
        // 012, 021, 102, 120, 201, 210
        // 3!*4*3 + 3!*4*3/2(重複分)
        // 3*3!(4+2) = 18*6 = 108
        // 0111, 0011, 0001
        // 0011 -> 0011, 0101, 0110, 1001, 1010, 1100
        for (int i = 1; i <= 4; i++) {
            System.out.println(countMustAns(i));
        }
        System.out.println(countMayAns(0, 0));
    }
}