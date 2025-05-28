import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    // ABC383B
    // ?H?M

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int D = sc.nextInt();
        debug("H(%d), W(%d), D(%d)", H, W, D);
        sc.nextLine();

        final List<String> office = new ArrayList<>(H);
        IntStream.range(0, H).forEach(i -> office.add(sc.nextLine()));
        sc.close();
        debug(office.toString());
        System.out.println(solve(new Office(office, W, H), D));
    }

    public static void debug(String format, Object... args) {
        MyLogger.debug(format, args);
    }

    public static int solve(Office office, int distance) {
        debug("%s", CellType.CHAIR.getSymbol());
        debug("%s", CellType.FLOOR.getSymbol());
        debug("%s", office);
        return -1;
    }
}

class Office {
    private int width;
    private int height;
    private List<CellType> map;

    public Office(List<String> map, int w, int h) {
        this.width = w;
        this.height = h;
        String oneLine = map.stream().reduce("", (total, cur) -> total += cur);
        List<CellType> cells = new ArrayList<>(w*h);
        IntStream.range(0, oneLine.length()).forEach(i -> cells.add(CellType.fromChar(oneLine.charAt(i))));
        this.map = cells;
        debug("Office: %s", cells);
    }

    private void debug(String format, Object... args) {
        MyLogger.debug(format, args);
    }

    public int size() {
        // return this.getFlatten().length();
        return -1;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<>(this.height);
        IntStream.range(0, this.height).forEach(h -> {
            List<String> tList = new ArrayList<>(this.width);
            IntStream.range(0, this.width).forEach(w -> tList.add(String.valueOf(this.map.get(h*this.width + w).getSymbol())));
            String str = tList.stream().reduce("", (acc, cur) -> acc += cur);
            debug("%d: %s", h, str);
            list.add(str);
        });
        String res = list.stream().reduce("", (acc, cur) -> acc += "[DEBUG] " + cur + "\n");
        return "--- Office ---\n" + res + "--- Office ---";
    }
}

enum CellType {
    FLOOR('.'),
    CHAIR('#'),
    HUMID('o'),
    HUMIDIFIER('x');


    private char symbol;

    private CellType(char symbol) {
        this.symbol = symbol;
    }

    public static CellType fromChar(char c) {
        for (CellType cell : CellType.values()) {
            if (cell.symbol == c) {
                return cell;
            }
        }
        throw new IllegalArgumentException("Unknown symbol: " + c);
    }

    public char getSymbol() {
        return this.symbol;
    }
}

class MyLogger {
    private static boolean isDebugMode = true;

    public static void debug(String format, Object... args) {
        if (isDebugMode) {
            System.out.printf("[DEBUG] " + format + "\n", args);
        }
    }
}