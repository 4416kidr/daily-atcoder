import java.util.Scanner;

public class Main {
    // 22m26s
    // ABC387B
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int X = sc.nextInt();
        sc.close();
        solve(X);
    }
    private static void solve(int inptX) {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (inptX == i * j) {
                    continue;
                }
                sum += i * j;
            }
        }
        System.out.println(sum);
    }
}