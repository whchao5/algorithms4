import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/12/14.
 * 合并两个参数， 并且排序
 */
public class Ex_2_2_14_joinMerge {

    public Ex_2_2_14_joinMerge() {

    }

    public static Comparable[] join(Comparable[] a, Comparable[] b) {
        Comparable[] one = a;
        Comparable[] two = b;

        Comparable[] c = new Comparable[one.length + two.length];
        System.arraycopy(one, 0, c, 0, a.length);
        System.arraycopy(two, 0, c, a.length, b.length);

        return c;
    }
    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    public static void main(String[] args) {
        In arr = new In(args[0]);
        String[] a = arr.readAllStrings();
        In arr_t = new In(args[1]);
        String[] b = arr_t.readAllStrings();

        Comparable[] d = join(a, b);

        Merge.sort(d);

        show(d);
//        StdOut.println(d);
    }
}
