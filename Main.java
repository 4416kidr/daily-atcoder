import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        int inptQ = sc.nextInt();
        sc.nextLine();
        int[] seriesT = new int[inptQ];
        for (int i = 0; i < inptQ; i++) {
            seriesT[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(inptN + ", " + inptQ);
        System.out.println(Arrays.toString(seriesT));
        
        boolean[] noTeeth = new boolean[inptN];
        System.out.println(Arrays.toString(noTeeth));
        for (int s : seriesT) {
            noTeeth[s-1] = !noTeeth[s-1];
        }
        System.out.println(Arrays.toString(noTeeth));
        int count = 0;
        for (boolean b : noTeeth) {
            count += b ? 0 : 1;
        }
        System.out.println(count);

    }
}