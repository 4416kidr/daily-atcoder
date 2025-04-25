import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String operations[] = new String[n];
        for (int i = 0; i < n; i++) {
            operations[i] = sc.nextLine();
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            System.out.println(operations[i]);
        }
    }
}