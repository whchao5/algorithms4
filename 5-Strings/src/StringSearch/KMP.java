package StringSearch;

import edu.princeton.cs.algs4.StdOut;

/**
 *  字符串查找  使用 KMP 算法，  构建状态自动机 （DFA)
 *  适合在长度不确定的输入流
 *
 *  *  % java KMP abracadabra abacadabrabracabracadabrabrabracad
 *  *  text:    abacadabrabracabracadabrabrabracad
 *  *  pattern:               abracadabra
 *  *
 *  *  % java KMP rab abacadabrabracabracadabrabrabracad
 *  *  text:    abacadabrabracabracadabrabrabracad
 *  *  pattern:         rab
 *  *
 *  *  % java KMP bcara abacadabrabracabracadabrabrabracad
 *  *  text:    abacadabrabracabracadabrabrabracad
 *  *  pattern:                                   bcara
 *  *
 *  *  % java KMP rabrabracad abacadabrabracabracadabrabrabracad
 *  *  text:    abacadabrabracabracadabrabrabracad
 *  *  pattern:                        rabrabracad
 *  *
 *  *  % java KMP abacad abacadabrabracabracadabrabrabracad
 *  *  text:    abacad abacadabrabracabracadabrabrabracad
 *  *  pattern: abacad
 */

public class KMP {

    private final int R;
    private int[][] dfa;

    private String pat;
    private char[] pattern;    // either the character array for the pattern

    public KMP(String pat) {

        this.R = 256;
        this.pat = pat;

        int M = pat.length();
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;

        // 用 一个精巧的dfa 记录 字符串的轨迹
        for (int x = 0, j = 1; j < M; j++) {

            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];          // 复制匹配失败情况下的值，  对
            }
            dfa[pat.charAt(j)][j] = j+1;        // 设置匹配成功状态下的值
            x = dfa[pat.charAt(j)][x];          // 更新重启状态
        }
    }

    public KMP (char[] pattern, int R) {
        this.R = R;
        this.pattern = new char[pattern.length];

        for (int j = 0; j < pattern.length; j++) {
            this.pattern[j] = pattern[j];
        }

        int m = pattern.length;
        dfa = new int[R][m];
        dfa[pattern[0]][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];
            }
            dfa[pattern[j]][j] = j+1;
            x = dfa[pattern[j]][x];
        }
    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();
        int i , j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }

        if (j == M)
            return i - M;
        return N;
    }

    public int search(char[] text) {

        // simulate operation of DFA on text
        int m = pattern.length;
        int n = text.length;
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[text[i]][j];
        }
        if (j == m) return i - m;    // found
        return n;                    // not found
    }


    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        char[] pattern = pat.toCharArray();
        char[] text    = txt.toCharArray();

        KMP kmp1 = new KMP(pat);
        int offset1 = kmp1.search(txt);

        KMP kmp2 = new KMP(pattern, 256);
        int offset2 = kmp2.search(text);

        // print results
        StdOut.println("text:    " + txt + " -- length:" + txt.length());

        StdOut.print("pattern: ");
        for (int i = 1; i <= offset1; i++)
            StdOut.print(i);
        StdOut.println("-"+pat);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset2; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
