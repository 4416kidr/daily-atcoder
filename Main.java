import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 380B
        Scanner sc = new Scanner(System.in);
        String tStr = sc.nextLine();
        sc.close();
        show(solve(tStr));
    }

    private static List<Integer> solve(String inpt) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i < inpt.length(); i++) {
            if (inpt.charAt(i) == '|') {
                list.add(count);
                count = 0;
            } else {
                count++;
            }
        }
        return list;
    }
    private static void show(List<Integer> list) {
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }
        System.out.printf("%d", list.get(0));
        list.stream().skip(1).forEach(i -> System.out.printf(" %d", i));
        System.out.println();
    }
}