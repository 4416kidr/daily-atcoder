import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptQ = sc.nextInt();
        sc.nextLine();
        sc.close();

        int[] deck = new int[100];
        int pointer = 0;
        for (int i = 0; i < inptQ; i++) {
            int query = sc.nextInt();
            if (query == 1) {
                deck[pointer] = sc.nextInt();
                pointer += 1;
            } else {
                if (pointer <= 0) {
                    System.out.println(0);
                } else {
                    System.out.println(deck[pointer-1]);
                    deck[pointer-1] = -1;
                    pointer -= 1;
                }
            }
        }
    }
}