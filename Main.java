import java.util.Scanner;

public class Main {
    // 03m15s
    // ABC387A
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int A = sc.nextInt();
        final int B = sc.nextInt();
        sc.close();
        System.out.println((A+B) * (A+B));
    }
}