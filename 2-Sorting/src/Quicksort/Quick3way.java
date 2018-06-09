package Quicksort;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2017/1/3.
 * 三向切分的快速排序
 * 对于大量重复的数组， 有可能是线性
 */
public class Quick3way {
    public Quick3way() {
    }



    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /*
    ** a[i] 小于v ,将 a[lt] 和 a[i] 交换，lt && i 加一
    ** a[i] 大于v, 将a[gt] 和a[i] 交换, gt减一
    ** a[i] 定于0 ，i 加一
     */

    protected static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int md = a[i].compareTo(v);
            if (md < 0)
                exch(a, lt++, i++);
            else if (md > 0)
                exch(a, i, gt--);   // 和最远的交换
            else
                i++;
        }
        sort(a, lo, lt-1);  // 这里是 lo ~~~ lt-1
        sort(a, gt+1, hi);  // 这里是 gt+1 ~~~ hi
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

        Integer[] s = {20, -39, 40, 200, 1, 2, 3, 4, 5, 6, 6998};
//        Double[] s = arr.readDoubles();
        Stopwatch timer = new Stopwatch();

        sort(s);

        show(s);
        double time = timer.elapsedTime();
        StdOut.print(time);
    }
}
