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
        office.setHumidifier(0, distance);
        debug("\n");
        office.setHumidifier(4, distance);
        return office.countHumid();
    }
}

class Office implements Cloneable {
    private int width;
    private int height;
    private List<CellType> flattenMap;

    public Office(List<String> map, int w, int h) {
        this.width = w;
        this.height = h;
        String oneLine = map.stream().reduce("", (total, cur) -> total += cur);
        List<CellType> cells = new ArrayList<>(w*h);
        IntStream.range(0, oneLine.length()).forEach(i -> cells.add(CellType.fromChar(oneLine.charAt(i))));
        this.flattenMap = cells;
        debug("Office: %s", cells);
    }

    private void debug(String format, Object... args) {
        MyLogger.debug(format, args);
    }

    public int size() {
        return this.flattenMap.size();
    }

    public void setHumidifier(int pos, int pow) {
        CellType toSetCell = this.flattenMap.get(pos);
        if (!toSetCell.canSet()) {
            debug("setHumidifier(%d): cant set at %d -> %s", pos, pos, toSetCell);
            return;
        }
        debug("setHumidifier(%d): before all", pos);
        debug("%s", this);
        this.flattenMap.set(pos, CellType.HUMIDIFIER);
        debug("setHumidifier(%d): after set", pos);
        debug("%s", this);

        // 5*5 -> 0: (1, 1) 3: (1, 3), 5: (1, 5) 17: (3, 2)
        // diffuse
        int ph = pos / this.width;
        int pw = pos % this.height;
        IntStream.range(0, this.size()).forEach(i -> {
            CellType tCell = this.flattenMap.get(i);
            if (!tCell.canSet() || tCell == CellType.HUMID) return;
            int th = i / this.width;
            int tw = i % this.width;
            debug("(%d -> %d, %d), (%d -> %d, %d)", pos, ph, pw, i, th, tw);
            int distance = Math.abs(ph - th) + Math.abs(pw - tw);
            if (distance > pow) return;
            this.flattenMap.set(i, CellType.HUMID);
        });

        debug("setHumidifier(%d): after humid", pos);
        debug("%s", this);
    }

    public List<String> transform() {
        List<String> list = new ArrayList<>(this.height);
        IntStream.range(0, this.height).forEach(h -> {
            List<String> tList = new ArrayList<>(this.width);
            IntStream.range(0, this.width).forEach(w -> tList.add(String.valueOf(this.flattenMap.get(h*this.width + w).getSymbol())));
            String str = tList.stream().reduce("", (acc, cur) -> acc += cur);
            list.add(str);
        });
        return list;
    }

    public int countHumid() {
        return (int)this.flattenMap.stream().filter(c -> c == CellType.HUMID || c == CellType.HUMIDIFIER).count();
    }

    @Override
    public Office clone() {
        try {
            return (Office)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("cant clone...", e.getCause());
        }
    }

    @Override
    public String toString() {
        List<String> list = this.transform();
        String res = list.stream().reduce("", (acc, cur) -> acc += "[DEBUG] " + cur + "\n");
        return "--- Office ---\n" + res + "[DEBUG] --- Office ---";
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

    public boolean canSet() {
        boolean cantSet = this == CellType.CHAIR || this == CellType.HUMIDIFIER;
        return !cantSet;
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