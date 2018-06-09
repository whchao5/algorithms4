package Mergesort;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2016/12/1.
 * 基础的并归排序 top-down merge sort 自顶向下
 */
public class Merge {

    private static Comparable[] aux;

    public Merge() {
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    // 分治思想， 自定向下的并归排序
    public static void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        sort(a, 0, n - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;

        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    // 自底向上的并归排序



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

        Integer[] s = {20, 39, 40 ,200, 1, 2, 3, 4, 5, 6 };
        Stopwatch timer = new Stopwatch();

        sort(s);

        show(s);
        double time = timer.elapsedTime();
        StdOut.print(time);
    }
}
