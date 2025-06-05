import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 377B
        // 1848-2015
        Scanner sc = new Scanner(System.in);
        final List<String> list = new ArrayList<>();
        IntStream.range(0, 8).forEach(i -> list.add(sc.nextLine()));
        sc.close();
        Board board = new Board(list);
        System.out.println(solve(board));
    }

    private static int solve(Board board) {
        Board paintedBoard = board.paintAll();
        return paintedBoard.countCanPaint();
    }
}

class Board {
    private final String board;
    private final int width;
    private final int height;

    public Board(List<String> list) {
        this.board = list.stream().reduce("", (acc, cur) -> acc + cur);
        this.width = 8;
        this.height = 8;
    }

    public Board(String str) {
        this.board = str;
        this.width = 8;
        this.height = 8;
        if (str.length() != this.width * this.height) {
            throw new RuntimeException("not expected size");
        }
    }

    public Board paintAll() {
        Board finalBoard = IntStream.range(0, this.height)
            .boxed()
            .reduce(this, (prevLine, h) -> {
                Board lineBoard = IntStream.range(0, this.width)
                    .boxed()
                    .reduce(prevLine, (prev, w) -> isPiece(translatePoint(w, h)) ? prev.paintFromPoint(w, h) : prev, (a, b) -> b);
                System.out.printf("lineBoard(%d)\n%s", h+1, lineBoard);
                return lineBoard;
            }, (a, b) -> b);
        return finalBoard;
    }

    public Board paintFromPoint(int fw, int fh) {
        // same width (vertical)
        // Javaの型推論の都合により、reduceの第1引数とStream<T>の型が違う場合、2引数版のreduceは使えないので、3引数版reduceを使う必要がある
        // 第3引数combinerは並列処理に使う引数で、今回は使われないが安全で副作用のない実装をダミーとして置くのが通例
        // (a, b) -> b がよく使われる
        final Board verticalBoard = IntStream.range(0, this.height).boxed().reduce(this, (prev, i) -> i == fh ? prev : prev.paintPoint(translatePoint(fw, i)), (a, b) -> b);
        final Board crossBoard = IntStream.range(0, this.width).boxed().reduce(verticalBoard, (prev, i) -> i == fw ? prev : prev.paintPoint(translatePoint(i, fh)), (a, b) -> b);
        // System.out.println(crossBoard);
        return crossBoard;
    }

    public Board paintPoint(int flatPoint) {
        if (!canPaint(flatPoint)) {
            return this;
        }
        String newStr = this.board.substring(0, flatPoint) + "x" + this.board.substring(flatPoint+1);
        // System.out.printf("paintPoint: %d -> %d\n%s\n", this.board.length(), newStr.length(), newStr);
        return new Board(newStr);
    }

    // public char getPointStatus

    public boolean canPaint(int flatPoint) {
        final char res = board.charAt(flatPoint);
        // System.out.printf("getPoint: ind(%d) = %d * %d + %d ---> %s\n", ind, this.width, h, w, res);
        return res == '.';
    }

    public boolean isPiece(int flatPoint) {
        final char res = board.charAt(flatPoint);
        return res == '#';
    }

    public int translatePoint(int w, int h) {
        return this.width * h + w;
    }

    public int countCanPaint() {
        return IntStream.range(0, this.width * this.height).reduce(0, (count, i) -> canPaint(i) ? ++count : count);
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.height).mapToObj(i -> board.substring(this.width*i, this.width*(i+1) - 1)).reduce("", (acc, cur) -> acc + cur + "\n");
    }
}
