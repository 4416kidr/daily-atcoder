import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    // 24m55s
    // ABC386B
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inpt = sc.nextLine();
        sc.close();
        System.out.println(inpt);
        System.out.println(solve(inpt));
    }

    private static int solve(String inpt) {
        Iterator<String> inpIterator = inpt.chars().mapToObj(c -> String.valueOf(c - '0')).collect(Collectors.toList()).iterator();
        // List<String> inpIterator = inpt.chars().mapToObj(c -> String.valueOf(c - '0')).collect(Collectors.toList());
        // inpIterator.forEachRemaining(actualList::add);
        // System.out.println(inpIterator);
        int count = 0;
        boolean isZero = false;
        while (inpIterator.hasNext()) {
            char c = inpIterator.next().charAt(0);
            System.out.println(String.format("[%1$s] %2$s, %3$s", c, count, isZero));
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
        System.out.println("before finishize: " + count);
        // 終了処理 (0で終わった場合は1加算)
        count += isZero ? 1 : 0;
        System.out.println("finish while: " + count);
        return count;
    }
}