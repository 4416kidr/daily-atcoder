import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    // ??m??s 多分20分ぐらい
    // ABC386B
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inpt = sc.nextLine();
        sc.close();
        System.out.println(solve(inpt));
    }

    private static int solve(String inpt) {
        Iterator<String> inpIterator = inpt.chars().mapToObj(c -> String.valueOf(c - '0')).collect(Collectors.toList()).iterator();

        int count = 0;
        boolean isZero = false;
        while (inpIterator.hasNext()) {
            char c = inpIterator.next().charAt(0);
            if (c == '0') {
                count += isZero ? 1 : 0;
                isZero = !isZero;
                continue;
            }
            // 0が終わった
            if (isZero) {
                count++;
                isZero = false;
            }
            if (c == 'z') {

            }
            // 0出ないので加算
            count++;
        }
        // 終了処理 (0で終わった場合は1加算)
        count += isZero ? 1 : 0;
        return count;
    }
}