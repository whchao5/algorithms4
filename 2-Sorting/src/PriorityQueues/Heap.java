/**
 * Created by HJKLI on 2017/3/8.
 * 堆排序
 */
package PriorityQueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;

public class Heap {
    public Heap() {}

    public static void sort(Comparable[] a){
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }

        while(n > 1) {
            exch(a, 1, n--);        // 交互其数据
            sink(a, 1, n);
        }
    }


    private static void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = k * 2;
            if (j < n && less(pq, j, j+1))
                j++;
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    // 比较
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Comparable[] pq, int i, int j) {
        Comparable swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; heapsorts them;
     * and prints them to standard output in ascending order
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        In arr = new In(args[0]);
        String[] a = arr.readAllStrings();
        Heap.sort(a);
        show(a);
    }
}
