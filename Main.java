import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int N = sc.nextInt();
    final int D = sc.nextInt();
    sc.nextLine();
    String tStr = sc.nextLine();
    sc.close();

    int ind = -1;
    for (int i = 0; i < D; i++) {
        ind = tStr.lastIndexOf("@");
        tStr = tStr.substring(0, ind) + "." + tStr.substring(ind+1, N);
    }
    System.out.println(tStr);
  }
}