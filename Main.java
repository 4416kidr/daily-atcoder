import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        sc.nextLine();
        int[] seriesA = new int[inptN];
        for (int i = 0; i < inptN; i++) {
            seriesA[i] = sc.nextInt();
        }
        sc.close();

        int evenCount = 0;
        for (int a : seriesA) {
            int nxt = a;
            while (nxt % 2 == 0) {
                evenCount += 1;
                nxt /= 2;
            }
        }
        System.out.println(evenCount);
    }
}