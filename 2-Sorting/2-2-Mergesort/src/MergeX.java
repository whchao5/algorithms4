import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/12/6.
 * MergeX 加强版 Merge
 */
public class MergeX {
    public MergeX() {
    }

    private static final int CUTOFF = 7;

    public static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {

        assert isSorted(src, lo, mid);
        assert isSorted(src, mid+1, hi);

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              dst[k] = src[j++];
            else if (j > hi)               dst[k] = src[i++];
            else if (less(src[j], src[i])) dst[k] = src[j++];   // to ensure stability
            else                           dst[k] = src[i++];
        }

        assert isSorted(dst, lo, hi);
    }

    private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {

        if (hi <= lo)  return;

        // 用新的代替
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);
        merge(src, dst, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {

        Comparable[] aux = a.clone();
        sort(aux, a,  0, a.length - 1);
        assert isSorted(a);
    }

    private static void insertionSort(Comparable[] dst, int lo, int hi) {

    }

    // is v < w ? -1 0 1;  v 比 w 小 返回 true
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

    /*
    ** 检查数组的排序， 并调试 debug
     */
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length-1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }





    public static void main(String[] args) {
        In arr = new In(args[0]);
        String[] a = arr.readAllStrings();
//        Integer[] a = {20, 39, 40 ,200, 1, 2, 3, 4, 5, 6 };

        MergeX.sort(a);
        show(a);
    }
}
