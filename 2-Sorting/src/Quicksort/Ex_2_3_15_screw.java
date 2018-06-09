package Quicksort;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.net.CookieHandler;

/**
 * Created by HJKLI on 2017/1/7.
 * N 个 螺丝 和 N 个 螺帽，如果必有 对等的 NN 则， sort(N) 和 sort(N) 是可以的
 */
public class Ex_2_3_15_screw {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    protected static int partition(Comparable[] a, int lo, int hi) {

        int lt = lo, gt = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++lt], v))
                if (lt == hi)
                    break;
            while (less(v, a[--gt]))
                if (gt == lo)
                    break;

            if (lt >= gt)
                break;
            exch(a, lt, gt);
        }
        exch(a, lo, gt);

        return gt;
    }

    /*
** 检查是否数组进行排序-可用于调试。
 */
    // is v < w ? -1 0 1;
    private static boolean less(Comparable v, Comparable w) {
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


    public static void main(String[] args) {

        int N = 0, i = 0;

        Integer[]  s = {20, -39, 40, 200, 1, 2, 3, 4, 5, 6};
        Integer[]  s1 = {20, -39, 40, 200, 1, 2, 3, 4, 5, 6};


        Stopwatch timer = new Stopwatch();

        sort(s);
        sort(s1);

        show(s);
        show(s1);
        double time = timer.elapsedTime();
        StdOut.print(time);
    }
}
