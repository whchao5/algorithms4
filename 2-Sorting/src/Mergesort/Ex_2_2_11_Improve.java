package Mergesort;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/12/5.
 * 改进 Merge.sort() ，加快小数组排序， 检查已存在的有序数组， 避免数组复杂
 */
public class Ex_2_2_11_Improve {

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
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

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        sort(a, aux, 0, N-1);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

    }
    /*
    ** 检查是否数组进行排序-可用于调试。
     */
    // is v < w ? -1 0 1;
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {


    }
}
