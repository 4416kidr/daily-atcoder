import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        int[] seriesA = new int[inptN];
        for (int i = 0; i < inptN; i++) {
            seriesA[i] = sc.nextInt();
        }
        sc.close();
        
        int count = 0;
        int add = -1;
        for (int i = 0; i < inptN; i++) {
            for (int j = i+1; j < inptN; j++) {
                add = (seriesA[i] - seriesA[j]) % 200 == 0 ? 1 : 0;
                count += add;
                if (add == 1)
                    System.out.println(String.format("[%1$d, %2$d] %3$d, %4$d", i+1, j+1, seriesA[i], seriesA[j]));
            }
        }
        System.out.println("last: " + count);
    }
}