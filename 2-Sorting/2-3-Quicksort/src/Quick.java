import edu.princeton.cs.algs4.*;

/**
 * Created by feijihqda on 2016/12/19.
 * 快速排序
 */
public class Quick {
    public Quick() {

    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {

        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true) {          // 一直循环，直到 i >= j 的时候跳出
            while (less(a[++i], v)) // a[i] 比 j 小的，跳过 ,比他大的 为 false, 跳出while继续执行
                if (i == hi)
                    break;
            while (less(v, a[--j]))  // 从 hi+1 开始 对比 v
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);      // i 和 j 交换
        }
        exch(a, lo, j);     //将 v = a[j] 放入正确的位置

        return j;
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

    /*
    ** 获得 文本的数量
     */
    public static int InLength(In arr) {

        int N = 0;
        while (!arr.isEmpty()) {
            Integer item = arr.readInt();
            N++;
        }
        return N;
    }

    public static void main(String[] args) {

        int N = 0, i = 0;

        Integer[] s = {20, -39, 40, 200, 1, 2, 3, 4, 5, 6};

        /*
        In arr = new In(args[0]);
        In arr2 = new In(args[0]);

        // 如果 arr 的数据不满足 sd 的长度， 则后面的数据为空， 就会出现错误

        N = InLength(arr);
        Integer[] sd = new Integer[N];

        while (!arr2.isEmpty()) {
            sd[i] = arr2.readInt();
            i++;
        }
        */

//        Double[] s = arr.readDoubles();
        Stopwatch timer = new Stopwatch();

        sort(s);

        show(s);
        double time = timer.elapsedTime();
        StdOut.print(time);
    }
}
