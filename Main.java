import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 393A
        // 2108-2119 (11m)
        Scanner sc = new Scanner(System.in);
        boolean sickFirst = sc.next().equals("sick");
        boolean sickSecond = sc.next().equals("sick");
        sc.close();
        System.out.println(solve(sickFirst, sickSecond));
    }

    private static int solve(boolean isSick1, boolean isSick2) {
        // 4 fine, fine -> 1 + 2+1
        // 3 fine, sick -> 1 + 2+0
        // 2 sick, fine -> 1 + 0+1
        // 1 sick, sick -> 1 + 0+0
        final int first = isSick1 ? 0 : 2;
        final int second = isSick2 ? 0 : 1;
        return first + second + 1;
    }
}
