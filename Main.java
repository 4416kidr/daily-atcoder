import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        sc.nextLine();
        String strS = sc.nextLine();
        String strT = sc.nextLine();
        sc.close();

        int hammingDistance = 0;
        for (int i = 0; i < inptN; i++) {
            hammingDistance += strS.charAt(i) != strT.charAt(i) ? 1 : 0;
        }
        
        System.out.println(hammingDistance);
    }
}