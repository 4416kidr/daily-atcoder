import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 386A
        // 2220-2310
        final Scanner sc = new Scanner(System.in);
        System.out.println(solveByList(sc) ? "Yes" : "No");
        sc.close();
    }

    public static boolean solve(Scanner sc) {
        final Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, 4).forEach(i -> {
            final int inpt = sc.nextInt();
            if (map.containsKey(inpt)) {
                map.put(inpt, map.get(inpt) + 1);
            } else {
                map.put(inpt, 1);
            }
        });
        return map.keySet().size() == 2;
    }

    public static boolean solveByList(Scanner sc) {
        final List<Integer> list = new ArrayList<>();
        IntStream.range(0, 4).forEach(i -> {
            final int inpt = sc.nextInt();
            if (list.contains(inpt)) {
                return;
            }
            list.add(inpt);
        });
        return list.size() == 2;
    }

    public static boolean solveBySimple(Scanner sc) {
        int a = -1;
        int b = -1;
        for (int i = 0; i < 4; i++) {
            final int inpt = sc.nextInt();
            if (inpt != a && inpt != b) {
                return false;
            }
            if (a == inpt || b == inpt) {
                continue;
            }
            if (a == -1) {
                a = inpt;
                continue;
            }
            if (b == -1) {
                b = inpt;
                continue;
            } 
        }
        return a != -1 && b != -1;
    }
}