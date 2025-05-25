import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String series = sc.nextLine();
        sc.close();
        System.out.println(solve(series));
    }

    private static void devideNumbers(String series, List<Integer> mustList, List<Integer> mayList) {
        IntStream.range(0, series.length()).forEach(i -> {
            switch (series.charAt(i)) {
                case 'o':
                    mustList.add(i);
                    break;
                case '?':
                    mayList.add(i);
                default:
                    break;
            }
        });
    }

    private static int solve(String series) {
        List<Integer> mustSeries = new ArrayList<>();
        List<Integer> maySeries = new ArrayList<>();
        devideNumbers(series, mustSeries, maySeries);
        int mustSize = mustSeries.size();
        
        if (mustSize > 4) {
            return 0;
        } else if (mustSize == 4) {
            return 4*3*2;
        } else if (mustSize == 0) {
            return (int)Math.pow(maySeries.size(), 4);
        } else if (mustSize == 3) {
            // 総数 = mustBとmayBの配置 (4!/(1*3!) = 4) * MayBのパターン * mustBの順列 (3! = 6)
            // may+mustのマスに入るパターン = mustのみの場合 (3/2) + mayのみの場合 (may.size())
            // mayのみの場合は重複が発生しないが、mustのみの場合は「mustのみの順列」と重複が発生する
            // mustのみで構成される場合 (4 * 3 * 3! / 2) -> 約分
            int mustOnly = 4 * 3 * 3;
            int includeMay = 4 * maySeries.size() * (3*2);
            return mustOnly + includeMay;
        } else if (mustSize == 2) {
            // 総数 = must4の場合 + must3may1の場合 + must2may2の場合
            // must4の場合: 全通り (2^4) - 余事象 (2) = 14
            // must3may1の場合: ブロックの配置(4) * mustBlock(2^3 - 2 = 6) * mayBlock(may.size) = 24 * may.size()
            // must2may2の場合: ブロックの配置(6) * mustBlock(2) * mayBlock(may.size^2 = 4) = 12 * pow(may.size, 2)
            final int must4 = 14;
            final int must3 = 24 * maySeries.size();
            final int must2 = 12 * (int)Math.pow(maySeries.size(), 2);
            return must4 + must3 + must2;
        } else if (mustSize == 1) {
            // 総数 = may+mustで構成した場合 - mayのみで構成した場合
            return (int)Math.pow(maySeries.size()+1, 4) - (int)Math.pow(maySeries.size(), 4);
        } else {
            // mustSize < 0
            System.out.println("error");
            return -1;
        }
    }
}