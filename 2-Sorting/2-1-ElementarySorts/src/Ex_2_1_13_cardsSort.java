import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2016/11/15.
 * 纸牌排序
 * 按 花色排序， 就是 黑桃1~k -》 红桃1~K -》 梅花1~k -》 方块1~k
 *
 * 定义
 * 黑桃 39,红桃 26,草花 13,方块 0
 * value  =  39 + ?
 */
public class Ex_2_1_13_cardsSort {

    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
        }
    }

//    public static

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
