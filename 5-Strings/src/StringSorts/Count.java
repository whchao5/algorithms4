package StringSorts;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 计算输入的数值， 在 Alphabet 实例化 的次数
 * <p>
 * ../algs4-data/abra.txt
 * ../algs4-data/pi.txt
 */

public class Count {


    public static void main(String[] args) {

        Alphabet alphabet = new Alphabet(args[0]);
        int R = alphabet.R();
        //        int R = alphabet.radix();
        int[] count = new int[R];

        while (StdIn.hasNextChar()) {
            char c = StdIn.readChar();

            if (alphabet.contains(c))
                count[alphabet.toIndex(c)]++;
        }

        for (int b = 0; b < R; b++) {
            StdOut.println(alphabet.toChar(count[b]) + " " + count[b]);
        }

    }
}
