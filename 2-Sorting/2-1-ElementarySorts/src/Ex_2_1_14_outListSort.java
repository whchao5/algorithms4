import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2016/11/17.
 * 出列排序
 */
public class Ex_2_1_14_outListSort {

    public static void sort(Comparable[] a) {

        int N = a.length;
        for (int i = 1; i < N; i++) {

            for (int j = 0; j < N-i; j++) {
                if (less(a[1], a[0]))
                    exch(a, 0, 1);
                moveQueue(a, 1);
            }
            moveQueue(a, i);
        }
    }

    // 移动到最后
    public static void moveQueue(Comparable[] a, int times) {

        int N = a.length;
        for (int j = 0; j < times; j++) {       // 这个必须加
            Comparable item = a[0];
            for (int i = 0; i < N - 1; i++)
                a[i] = a[i + 1];
            a[N - 1] = item;
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

//        String[]  s     = In.readStrings(args[0]);
        Integer[] s     = {39, 20, 40, 1, 2, 3, 4, 5, 6, 7};
        Stopwatch timer = new Stopwatch();

        sort(s);

        double time = timer.elapsedTime();
        assert isSorted(s);
        StdOut.print("time: " + time);
        StdOut.println();
        show(s);
    }
}
