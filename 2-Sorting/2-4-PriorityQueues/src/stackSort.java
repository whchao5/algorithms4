import edu.princeton.cs.algs4.StdOut;


/*
** 堆排序, 用数组模拟 堆， 堆数据 大于两个
 */
public class stackSort {

    // This class should not be instantiated.
    private stackSort() { }

    //
    public static void sore(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >=1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--); // 开头最大，，和尾部交换
            sink(a, 1, N);  //重新 排序堆
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = t;
    }

    private static boolean less(Comparable[] pq,  int v, int w) {
        return pq[v-1].compareTo(pq[w-1]) < 0;
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(a, j, j+1)) {
                j++;
            }
//            if (!less(a[j], a[N])) {
            if (!less(a, k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;

        }
    }

    public static void main(String[] args) {
        Integer[] keys = {20, -39, 40, 200, 1, 2, 3, 4, 5, 6};

        sore(keys);

        int N = keys.length;
        for (int i = 0; i < N; i++) {
            StdOut.println(keys[i]);
        }

    }
}
