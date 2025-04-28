import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String series = sc.nextLine();
        char[] seriesAns = new char[300];
        sc.close();
        // 終了条件: 長さが偶数、奇数文字がiで偶数文字がo
        // 挿入する必要のある文字数の最小値を求める

        final char IN = 'i';
        final char OUT = 'o';
        int pointer = 1; // 1, 2, ..., ?
        int insertCount = 0;
        for (char next : series.toCharArray()) {
            // System.out.println(pointer + ": " + next + ", " + String.valueOf(seriesAns));
            int rp = pointer - 1; // 実際の配列のインデックス
            // [ i, o, ? (pointer), ?, ..., ? ]
            // char next = seriesC.charAt(i);
            // if (i % 2 == 0) {
            if (pointer % 2 == 1) {
                // odd (1, 3, 5, ...)
                // prev is o, next must be i
                if (next == IN) {
                    // System.out.println("ok (odd, simple add o): pointer % 2 == 1 && next == IN");
                    // ok: simple add
                    seriesAns[rp] = next; // IN
                    // init
                    pointer += 1;
                } else if (next == OUT) {
                    // System.out.println("ng (odd, insert i before o): pointer % 2 == 1 && next == OUT");
                    // ng: insert i before o
                    seriesAns[rp] = IN;
                    seriesAns[rp + 1] = next; // OUT
                    // init
                    pointer += 2;
                    insertCount += 1;
                } else {
                    throw new Error("not implemented");
                }
            } else {
                // even (2, 4, 6, ...)
                // prev is i, next must be o
                if (next == OUT) {
                    // System.out.println("ok(even, simple add o): pointer % 2 == 0 && next == OUT");
                    // ok: simple add
                    seriesAns[rp] = next; // OUT
                    // init
                    pointer += 1;
                } else if (next == IN) {
                    // System.out.println("ng(even, insert o before i): pointer % 2 == 0 && next == IN");
                    // ng: insert o before i
                    seriesAns[rp] = OUT;
                    seriesAns[rp + 1] = next; // IN
                    // init
                    pointer += 2;
                    insertCount += 1;
                }
            }
            // 初期化 (pointer, prev)
        }
        // 終了処理
        int rp = pointer - 1;
        // System.out.println(pointer + " (final is " + seriesAns[rp-1] + "): " + String.valueOf(seriesAns));
        if (seriesAns[rp - 1] != OUT) {
            // System.out.println("final ng: must add o");
            seriesAns[rp] = OUT;
            pointer += 1;
            insertCount += 1;
        }

        // 判定
        int ansSize = pointer-1;
        if (ansSize % 2 != 0) {
            System.out.println("ng: length not even");
        }
        for (int i = 0; i < ansSize; i++) {
            if (i % 2 == 0 && seriesAns[i] != IN) {
                System.out.println("ng(" + i + "): must be IN, but OUT");
            } else if (i % 2 == 1 && seriesAns[i] != OUT) {
                System.out.println("ng(" + i + "): must be OUT, but IN");
            }
        }
        
        // 判定成功
        System.out.println(insertCount);
    }
}