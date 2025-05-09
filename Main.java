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
        for (int i = 0; i < inptN; i++) {
            for (int j = i+1; j < inptN; j++) {
                if (seriesA[i] % 100 != seriesA[j] % 100) {
                    continue;
                }
                count += (seriesA[i] - seriesA[j]) % 200 == 0 ? 1 : 0;
            }
        }
        System.out.println(count);
    }
}