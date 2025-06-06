# daily-atcoder

## 実行

- `docker compose run --rm app sh -c "javac Main.java && echo 'compiled!' && java Main < main.in"`

## 0506: 配列のインデックスとスライス, Math, 階乗

- [【Java】for文で階乗を計算する (個人ブログ)](https://interuniversitylearning.com/archives/5798)
  - 階乗は `java.lang.Math` にないみたいなので、for文で自作するしかない
- [java.lang.Math (javaDocs)](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html)
  - abs(int a), ceil(double a), floor(double a), floorMod(int x, int y), max(int a, int b), min(int a, int b), pow(double a, double b), random(), round(double a), signum(double d), sqrt(double a), toDegrees(double angrad), toRadians(double angdeg)
    - absを使えたが自力実装した
- [Java 配列のインデックス (delfstack)](https://www.delftstack.com/ja/howto/java/java-array-indexof/)
  - arraysにはindexOfが存在しない
  - java.util.List: `Arryas.asList(arr).indexOf(8)`
    - 8という要素のIndexを取得する
    - java.util.ListのindexOfという関数を使う
  - java.util.stream.IntStream: IntStream.range(0, arr.length).filter(i -> elm == arr[i]).findFirst().orElse(-1)
- [Java で配列をスライスする (delfstack)](https://www.delftstack.com/ja/howto/java/java-array-splice/)
  - java.utils.Arrays: copyOfRange(arr, stIndx, enIndx)
    - インデックス1-3の要素を取りたい場合は(arr, 1, 4)

## 0504: オーバーフローに抗う方法

- [NTTアルゴリズム](https://www.perplexity.ai/search/number-theoric-transformwoshi-ZzpaUItmQxWwC0Sgy8Phbw)
  - 12289を使うと掛け算にも対抗できる

## 0503: 配列の出力や配列の可変長化について

- [配列の要素を昇順・降順にソートする(sort) (会社(@buzzword)ブログ/@javadrive)](https://www.javadrive.jp/start/array/index14.html)
  - Arryas.sort(array)
  - 逆順ソートはsortしてから、並び替える
  - `for (int f = 0, l = src.length-1; f < l; f++, l--) {fとlの要素を入れ替える}`
- [配列の中身(要素)を表示したい時の例文 いろいろ。超初心者のJavaの勉強 (個人ブログ/@programmer-life.work)](https://programmer-life.work/java/show-array)
  - 一次元配列: System.out.println(Arrays.toString(array))
  - 多次元配列: System.out.println(Arrays.deepToString(array))
- [forについて (paize.io)](https://paiza.io/projects/esKF0wg3mbDd7Z2KOGVkAQ)
  - for文の初期条件が終了条件を満たしていた場合、エラーは特になくスキップされる
- [配列をコピーする(シャローコピーとディープコピー)  (会社(@buzzword)ブログ/@javadrive)](https://www.javadrive.jp/start/array/index10.html)
  - 配列長の拡張: Arrays.copyOf(array, length)
    - これで固定長を実質的に可変長として扱える
    - 新しい配列を作っているので、パフォーマンスはイマイチ

## 0428: char配列やjava.lang.Stringについて

- [java.lang.String](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/String.html)
  - string.charAt(int index): indexのchar値を返却
  - string.length(): 文字列の長さを返却
  - string.toCharArray(): 文字列をchar[]に変換して返却
- [Java – for文で文字列を1文字ずつ取得・処理する方法 (af-e.net (個人サイトっぽい))](https://af-e.net/java-for-statement-string/)
  - 基本: `for (int i = 0; i < string.length(); i++)`
  - for-each: `for (char c : string.toCharArray())`
  - streamAPI: `IntStream.range(0, string.length()).mapToObj(string::charAt).forEach(System.out::println)`
    - `string::charAt`: 各インデックスに対して文字を取得
    - メモ: Streamの書き方なんもわからない。ただ宣言的に記述できるのは好き。
- [Java で配列をスライスする (delfstack.com, 個人サイトっぽい)](https://www.delftstack.com/ja/howto/java/java-array-splice/)
  - for文
    - `int[] sliceArr = new int[endIndx - stIndx];`
    - `for (int i = 0; i < sliceArr.length; i++) { sliceArr[i] = arr[stIndx + i] }`
  - ArrayクラスのcopyOfRange: `Arrays.copyOfRange(arr, stIndx, enIndx)`
  - Stream: `IntStream.range(stIndx, enIndx).map(i -> arr[i]).toArray()`
- [charの配列をStringに変換する方法！Java超初心者の勉強](https://programmer-life.work/java/chararry-to-string-java)
  - new String(char配列)
  - String.valueof(char配列)

## 参考サイト

- [Javaの標準入力 (Hatena/@neginegitoro)](https://neginegitoro.hatenablog.com/entry/competitive-programming-java)