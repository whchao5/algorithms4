package StringSearch;


import edu.princeton.cs.algs4.StdOut;

/**
 * 从右向左扫描字符串 和文本匹配，
 * <p>
 * *  % java BoyerMoore abracadabra abacadabrabracabracadabrabrabracad
 * *  text:    abacadabrabracabracadabrabrabracad
 * *  pattern:               abracadabra
 * *
 * *  % java BoyerMoore rab abacadabrabracabracadabrabrabracad
 * *  text:    abacadabrabracabracadabrabrabracad
 * *  pattern:         rab
 * *
 * *  % java BoyerMoore bcara abacadabrabracabracadabrabrabracad
 * *  text:    abacadabrabracabracadabrabrabracad
 * *  pattern:                                   bcara
 * *
 * *  % java BoyerMoore rabrabracad abacadabrabracabracadabrabrabracad
 * *  text:    abacadabrabracabracadabrabrabracad
 * *  pattern:                        rabrabracad
 * *
 * *  % java BoyerMoore abacad abacadabrabracabracadabrabrabracad
 * *  text:    abacadabrabracabracadabrabrabracad
 * *  pattern: abacad
 */
public class BoyerMoore {

    private final int    R;
    private       int[]  right;
    private       String pat;

    public BoyerMoore(String pat) {
        this.pat = pat;
        this.R = 256;
        int M = pat.length();
        // 计算跳跃表
        right = new int[R];

        for (int c = 0; c < R; c++)
            right[c] = -1;          // 不包含在模式字符串中的 字符的值为 -1
        for (int j = 0; j < M; j++) // 包含在模式字符串中的字符的值为 它在其中的最右位置， 因为被覆盖了
            right[pat.charAt(j)] = j;
    }

    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        int skip;

        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j))
                    skip = Math.max(1, j = right[txt.charAt(i + j)]);
            }
            if (skip == 0)
                return i;
        }
        return n;
    }


    /**
     * Takes a pattern string and an input string as command-line arguments;
     * searches for the pattern string in the text string; and prints
     * the first occurrence of the pattern string in the text string.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];

        BoyerMoore boyermoore1 = new BoyerMoore(pat);
        int        offset1     = boyermoore1.search(txt);

        // print results
        StdOut.println("text:    " + txt);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
