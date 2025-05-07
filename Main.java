import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String series = sc.nextLine();
        sc.close();

        int count = 0;
        for (int i = 0; i < series.length(); i++) {
            if (series.charAt(i) != 'A') {
                continue;
            }
            for (int j = i+1; j < series.length(); j++) {
                if (series.charAt(j) != 'B') {
                    continue;
                }
                if (j + (j-i) >= series.length()) {
                    continue;
                }
                if (series.charAt(j + (j-i)) == 'C') {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}