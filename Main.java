import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // 44m
    // ABC066C
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int X = sc.nextInt();
        final int Y = sc.nextInt();
        System.out.println(String.format("%1$d, %2$d, %3$d, %4$d", H, W, X, Y));
        sc.nextLine();
        List<String> inptField = new ArrayList<>();
        IntStream.range(0, H).forEach(i -> inptField.add(sc.nextLine()));
        final String moveSeries = sc.nextLine();
        System.out.println(inptField);
        System.out.println(moveSeries);
        sc.close();
        Field field = new Field(X, Y, inptField);
        solve(field, moveSeries);
    }

    public static void solve(Field field, String moveSeries) {
        moveSeries.chars().forEach(c -> field.move((char)c));
        System.out.println(field);
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }

    public Point move(int dx, int dy) {
        return new Point(this.x+dx, this.y+dy);
    }
}

class Field extends Object {
    private Point userPosition;
    private List<String> field;
    private int enterCount;


    public Field(int x, int y, List<String> field) {
        this.userPosition = new Point(x, y);
        this.field = field;
        this.enterCount = 0;
    }

    public Point getUserPosition() {
        return this.userPosition;
    }

    public char getFieldPoint(Point p) {
        char c = this.field.get(p.getX()).charAt(p.getY());
        System.out.println(c);
        return c;
    }

    public int getEnterCount() {
        return this.enterCount;
    }

    @Override
    public String toString() {
        return String.format("%1$d %2$d %3$d", this.userPosition.getX(), this.userPosition.getY(), this.enterCount);
    }

    public Point getMovedPosition(char m) {
        int dx = 0;
        int dy = 0;
        switch (m) {
            case 'U':
                dx--;
                break;
            case 'D':
                dx++;
                break;
            case 'L':
                dy--;
                break;
            case 'R':
                dy++;
                break;
            default:
                break;
        }
        return new Point(this.userPosition.getX() + dx, this.userPosition.getY() + dy);
    }

    public void move(char m) {
        Point tempPoint = getMovedPosition(m);
        switch (getFieldPoint(tempPoint)) {
            case '@':
                this.userPosition = tempPoint;
                this.enterCount++;
                break;
            case '.':
                this.userPosition = tempPoint;
                break;
            default: // 「#」もここ
                break;
        }
        System.out.println(m + " -> " + this);
    }
}