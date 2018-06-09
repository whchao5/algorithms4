package ElementarySorts;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2016/11/14.
 * 希尔排序
 */
public class Shell {


    public static void sort(Comparable[] a) {

        int N = a.length;
        int high = 0;
        if (high < N / 3)
            high = high * 3 + 1;

        while (high > 0) {
            for (int i = high; i < N; i++) {
                for (int j = i; j > 0 && less(a[j], a[j-high]); j -= high) {
                    exch(a, j, j-high);
                }
            }
            high = high / 3;
        }
    }

    /*
    ** 检查是否数组进行排序-可用于调试。
     */
    // is v < w ? -1 0 1;
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 交换
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String[]  s     = In.readStrings(args[0]);
        Stopwatch timer = new Stopwatch();

        sort(s);

        double time = timer.elapsedTime();
        assert isSorted(s);
        StdOut.print("time: " + time);
        StdOut.println();
        show(s);
    }
}
