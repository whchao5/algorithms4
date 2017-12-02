import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
** 多个 数 相加
*
*  ../algs4-data/1Kints.txt
*  ../algs4-data/4Kints.txt
 */
public class ThreeSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cut = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j)
                    cut++;
            }
        }
        return cut;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch stopwatch = new Stopwatch();
        int count = count(a);

        StdOut.println(stopwatch.elapsedTime());


        StdOut.println(count);
    }
}
