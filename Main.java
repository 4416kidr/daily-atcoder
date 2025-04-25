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

        boolean isLogin = false;
        int count = 0;
        for (String operation : operations) {
            switch (operation) {
                case "login":
                    isLogin = true;
                    break;
                case "logout":
                    isLogin = false;
                    break;
                case "private":
                    count += isLogin ? 0 : 1;
                    break;
            }
        }
        System.out.println(count);
    }

    public void logIn(boolean flag) {

    }
}