import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;


/*
** 字母表
 */


public class Alphabet {

    public static final Alphabet BINARY = new Alphabet("01");


    /**
     *  The lowercase alphabet { a, b, c, ..., z }.
     */
    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");

    private char[] alphabet;     // 字母表里的 字符
    private int[] inverse;      // // 倒转
    private final int R;         //alphabe的基数
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
            if (unicode[c])
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
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
    public boolean contains(char c) {

        return true;
    }

    // 字符表的数量
    public int R() {
        return this.R;
    }

    // 表示 一个索引所需的位数
    public int loR() {

        return 1;
    }

    // 将 s 转换为 R 进制的整数
    public int[] toIndices(String s) {

        return null;
    }

    // 将R 进制的整数 转换 为 基于该字母表的字符串
    public String toChars(int[] indices) {

        return "00";
    }

    public static void main(String[] args) {
//        Alphabet al = new Alphabet("bksy");

        Alphabet lowercase = Alphabet.LOWERCASE;


        StdOut.println(lowercase.toIndex('b'));
    }

}
