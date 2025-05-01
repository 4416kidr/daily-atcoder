import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inptN = sc.nextInt();
        sc.nextLine();
        sc.close();

        // i = 1, 2, ..., N
        // j = N+1-i
        // i <= j ---> i % 2 == 1 ? "#" : "."

        char[][] area = new char[inptN][inptN];
        for (int i = 0; i < inptN; i++) {
            int j = inptN - i; //j = N + 1 - i
            char color = i % 2 == 0 ? '#' : '.';
            square(i, j, color, area, inptN);
        }

        // System.out.println("------------------");
        for (int i = 0; i < inptN; i++) {
            System.out.println(new String(area[i]));
        }
    }
    private static char[][] square(int inptI, int inptJ, char color, char[][] area, int inptN) {
        for (int i = inptI; i < inptJ; i++) {
            for (int j = inptI; j < inptJ; j++) {
                area[i][j] = color;
            }
        }

        // for (int i = 0; i < inptN; i++) {
        //     System.out.println(new String(area[i]));
        // }
        return area;
    }
}