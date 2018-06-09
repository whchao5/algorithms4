package ElementarySorts;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Comparator;
/**
 * 选择排序 : 就是一个和下一个的对比
 * for (i) {
 *     for(j = i+1) {
 *         .......
 *         less(j, min)
 *          min = j
 *     }
 *     exch(a, i, min)
 *     x x x x x x x x x x x x x
 *       j j j j j j j j j j j j
 * }
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++) {
                if (less(a[j], a[min]))
                    min = j;            // 这里和其他 冒泡不一样 , 选择比a[i] 最小的a[min]
            }
            exch(a, i, min);
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

//        String[] s = In.readStrings(args[0]);
        Integer[]  s     = {39, 20, 40, 1, 2, 3, 4, 5, 6, 7};
        Stopwatch timer = new Stopwatch();

        sort(s);

        double time = timer.elapsedTime();
        assert isSorted(s);
        StdOut.print("time: " + time);
        StdOut.println();
        show(s);
    }
}
