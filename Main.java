import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 389A
        Scanner sc = new Scanner(System.in);
        final String inpt = sc.nextLine();
        sc.close();
        // System.out.println(solve(inpt.charAt(0), inpt.charAt(2)));
        System.out.println(solve2(inpt.charAt(0), inpt.charAt(2)));
    }

    private static int solve(char a, char b) {
        return Integer.valueOf(String.valueOf(a)) * Integer.valueOf(String.valueOf(b));
    }

    private static int solve2(char a, char b) {
        return (a - '0') * (b - '0');
    }
}