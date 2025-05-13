import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inptD = sc.nextLine();
        String ans = "";
        for (int i = 0; i < inptD.length(); i++) {
            switch (inptD.charAt(i)) {
                case 'N':
                    ans += "S";
                    continue;
                case 'S':
                    ans += "N";
                    continue;
                case 'E':
                    ans += "W";
                    continue;
                case 'W':
                    ans += "E";
                    continue;
                default:
                    ans += "";
                    continue;
            }
        }
        System.out.println(ans);
    }
}