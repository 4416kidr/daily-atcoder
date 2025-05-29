import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double x = sc.nextDouble();
    sc.close();
    int res = 0;
    if (x >= 38.0) {
        res = 1;
    } else if (x < 37.5) {
        res = 3;
    } else {
        res = 2;
    }
    System.out.println(res);
  }
}