import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 381B
    Scanner sc = new Scanner(System.in);
    String tStr = sc.nextLine();
    sc.close();
    // System.out.println(tStr);
    System.out.println(solve(tStr) ? "Yes" : "No");
  }

  private static boolean solve(String inpt) {
    if (inpt.length() % 2 != 0) {
        // System.out.println("ERROR: odd");
        return false;
    }
    String containStr = "";
    for (int i = 0; i < inpt.length() / 2; i++) {
        // System.out.printf("%s != %s\n", inpt.charAt(2*i+1), inpt.charAt(2*i));
        if (inpt.charAt(2*i + 1) != inpt.charAt(2*i)) {
            // System.out.println("ERROR: series");
            return false;
        }
        // System.out.printf("%s in %s \n", inpt.charAt(2*i), containStr);
        if (containStr.contains(String.valueOf(inpt.charAt(2*i)))) {
            // System.out.println("ERROR: contain");
            return false;
        }
        containStr += inpt.charAt(2*i);
        // System.out.println(containStr);
    }
    return true;
  }
}