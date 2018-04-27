import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;


/*
** 字母表
 */


public class Alphabet {

    public static final Alphabet BINARY = new Alphabet("01");


    /**
     * The lowercase alphabet { a, b, c, ..., z }.
     */
    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");



    /**
     *  The base-64 alphabet (64 characters).
     */
    public static final Alphabet BASE64 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    private       char[] alphabet;     // 字母表里的 字符
    private       int[]  inverse;      // // 倒转
    private final int    R;         //alphabe的基数

    /**
     * 根据 alpha 中的字符创建一个新的字符表
     *
     * @param alpha
     */
    public Alphabet(String alpha) {

        // 检查字母不包含重复的字符
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);

            // 如果有相同的字母 报错
            if (unicode[c]) {
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
            }

            unicode[c] = true;
        }

        this.alphabet = alpha.toCharArray();
        this.R = alpha.length();
        this.inverse = new int[Character.MAX_VALUE];
        for (int i = 0; i < this.inverse.length; i++) {
            inverse[i] = -1;
        }

        for (int c = 0; c < this.R; c++) {
            inverse[alphabet[c]] = c;
        }
    }


    // 获取 字母表中位置的字符
    public char toChar(int index) {
        if (index < 0 || index >= this.R) {
            throw new IllegalArgumentException("index must be between 0 and " + R + ": " + index);
        }

        return this.alphabet[index];
    }

    // 获取 c 的索引， 在 0 ~ R-1 之间
    public int toIndex(char c) {
        if (c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }

        return inverse[c];
    }

    // c 在字母表中吗
    // 使用 char 隐式转换 int 类型
    public boolean contains(char c) {

        return inverse[c] != -1;
    }

    // 字符表的数量
    public int R() {
        return this.R;
    }

    public int radix() {
        return this.R;
    }

    // 表示 一个索引所需的位数
    public int loR() {

        int lgR = 0;
        for (int t = R - 1; t >= 1; t /= 2)
            lgR++;

        return lgR;
    }

    // 将 s 转换为 R 进制的整数
    public int[] toIndices(String s) {

        char[] source = s.toCharArray();
        int[] target = new int[s.length()];

        for (int i = 0; i < source.length; i++)
            target[i] = toIndex(source[i]);

        return target;
    }

    // 将R 进制的整数 转换 为 基于该字母表的字符串
    public String toChars(int[] indices) {

        StringBuilder s = new StringBuilder(indices.length);
        for (int i = 0; i < indices.length; i++) {
            s.append(toChar(i));
        }

        return s.toString();
    }

    public static void main(String[] args) {
//        Alphabet al = new Alphabet("bksy");

        Alphabet lowercase = Alphabet.LOWERCASE;

        char dow = 'e';

        int k = (int) dow;

        StdOut.println(lowercase.toIndex('y'));
        StdOut.println(lowercase.loR());

        int[]  encoded1 = Alphabet.BASE64.toIndices("NowIsTheTimeForAllGoodMen");
        String decoded1 = Alphabet.BASE64.toChars(encoded1);
        StdOut.println(decoded1);
    }

}
