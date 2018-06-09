package Quicksort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2017/1/7.
 * 将 已知两张主键值排序
 */
public class Ex_2_3_5_Sort2distinct {

    public Ex_2_3_5_Sort2distinct() {

    }

    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length - 1;
        int i = 0;

        while (i <= gt) {
            int cmp = a[i].compareTo(a[lt]);
            if      (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else              i++;
        }
    }

    /*
    ** 交换数据
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable item = a[i];
        a[i] = a[j];
        a[j] = item;
    }

    public static void main(String[] args) {
        // parse command-line argument as an array of 1-character strings
        String s = args[0];
        int n = s.length();
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = s.substring(i, i+1);

        // sort a print results
        sort(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i]);
        StdOut.println();
    }
}
