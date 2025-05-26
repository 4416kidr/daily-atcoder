import java.util.Scanner;

public class Main {
    // ABC398A
    // ?H?M
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        sc.close();
        final String strEqual = "=".repeat(N%2 == 0 ? 2 : 1);
        final String strHyphen = "-".repeat((N-1)/2);
        System.out.println(strHyphen + strEqual + strHyphen);
    }
}