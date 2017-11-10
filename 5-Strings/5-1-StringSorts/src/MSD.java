import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import javax.print.DocFlavor;

/**
 * 高位优先 从 左往 右
 */

public class MSD {

    private static final int CUTOFF = 15;   // 数据分类的辅助数组

    private static void sort(String[] a) {
        int      n   = a.length;
        String[] aux = new String[n];
        sort(a, 0, n - 1, 0, aux);
    }

    private static void sort(String[] a, int lo, int hi, int d, String[] aux) {
        if (hi <= lo + CUTOFF) {

        }
    }

    // 插入 排序
    private static void insertion(String[] a, int lo, int hi, int d) {

    }

    // 交换 数值
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    private static boolean less(String v, String w, int d) {

    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int      n = a.length;

        sort(a);

        for (int i = 0; i < n; i++) {
            StdOut.println(a[i]);
        }
    }
}
