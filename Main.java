import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long inptX = sc.nextLong(); // 9 * 10^18
        sc.close();

        int ans = 1;
        long temp = inptX;
        for (int i = 2; i < 21; i++) {
            // System.out.println(String.format("[%1$d]: ans(%2$d), temp(%3$d)", i, ans, temp));
            if (temp % i != 0) {
                break;
            }
            temp /= i;
            ans = i;
        }
        System.out.println(ans);
    }
}