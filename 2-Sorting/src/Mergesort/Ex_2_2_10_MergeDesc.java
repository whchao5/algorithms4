package Mergesort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2016/12/5.
 * 不稳定的 降序
 * answer 1 2 3 4 5 6 20 39 40 200
 */
public class Ex_2_2_10_MergeDesc {

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= mid; k++) {
            aux[k] = a[k];
        }

        for (int k = mid+1; k <= hi; k++) {
            aux[k] = a[hi-k+mid+1];
        }

        int i = lo, j = hi;
        for (int k = lo; k <= hi; k++) {
            if (less(aux[j], aux[i]))
                a[k] = aux[j--];
            else
                a[k] = aux[i++];
        }

    }


    // 分治思想， 自定向下的并归排序
    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, 0, n - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
