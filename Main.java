import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 394A
        Scanner sc = new Scanner(System.in);
        final String series = sc.nextLine();
        sc.close();
        final String opt = series.chars().boxed().reduce("", (acc, c) -> (char)(int)c  == '2' ? acc + (char)(int)c : acc, (a, b) -> b);
        System.out.println(opt);
    }
}
