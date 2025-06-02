import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 379B
        Scanner sc = new Scanner(System.in);
        sc.nextInt(); // 文字数不要
        final int k = sc.nextInt();
        sc.nextLine(); // 改行読み捨て
        String series = sc.nextLine();
        sc.close();
        System.out.println(solve(series, k));
    }

    private static int solve(String inpt, int threshold) {
        if (!inpt.contains("X")) {
            return inpt.length() / threshold;
        }
        int count = 0;
        String[] splt = inpt.split("X");
        for (int i = 0; i < splt.length; i++) {
            count += splt[i].length() / threshold;
        }
        return count;
    }
}