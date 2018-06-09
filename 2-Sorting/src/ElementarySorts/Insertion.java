package ElementarySorts;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2016/11/13.
 * 插入排序 也称 冒泡排序
 *
 * ../algs4-data/tiny.txt
 * ../algs4-data/words3.txt
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j -1);
            }
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
//        Integer[]  s     = {39, 20, 40, 1, 2, 3, 4, 5, 6, 7};
        Stopwatch timer = new Stopwatch();

        sort(s);

        double time = timer.elapsedTime();
        assert isSorted(s);
        StdOut.print("time: " + time);
        StdOut.println();
        show(s);
    }
}
