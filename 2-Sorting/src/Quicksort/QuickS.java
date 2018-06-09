package Quicksort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2017/1/1.
 * 优化 ------ 快速排序算法
 */
public class QuickS {

    public QuickS() {

    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {

        int i = lo, j = hi+1;

        // 优化代码部分
        int m = lo + (hi - lo) / 2;
        if (less(a[hi], a[lo]))
            exch(a, hi, lo);
        if (less(a[hi], a[m]))
            exch(a, hi, m);
        if (less(a[m], a[lo]))
            exch(a, m, lo);

        Comparable v = a[lo];

        while (true) {          // 一直循环，直到 i >= j 的时候跳出
            while (less(a[++i], v)) // a[i] 比 V 小的，跳过 ,比他大的 less 放回 false， 执行 exch();
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);     //将 v = a[j] 放入正确的位置

        return j;
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

        Integer[] s = {20, -39, 40 ,200, 1, 2, 3, 4, 5, 6 };
//        Double[] s = arr.readDoubles();
        Stopwatch timer = new Stopwatch();

        sort(s);

        show(s);
        double time = timer.elapsedTime();
        StdOut.print(time);
    }
}
