import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import javax.print.DocFlavor;

/**
 * 高位优先 从 左往 右
 */

public class MSD {

    private static void sort(String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        sort(a, 0, n - 1, 0,aux);
    }

    private static void sort(String[] a, int lo, int hi, int d, String[] aux) {

    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;

        sort(a);

        for(int i = 0; i < n; i++) {
            StdOut.println(a[i]);
        }
    }
}
