import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 392A
        // 2330-2340
        final Scanner sc = new Scanner(System.in);
        final int A = sc.nextInt();
        final int B = sc.nextInt();
        final int C = sc.nextInt();
        sc.close();
        System.out.println(solve(A, B, C) ? "Yes" : "No");
    }

    private static boolean solve(int a, int b, int c) {
        final boolean ab = a*b == c;
        final boolean bc = b*c == a;
        final boolean ca = c*a == b;
        return ab || bc || ca;
    }
}