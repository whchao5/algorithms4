import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;


public class TwoSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);

        int N = a.length;
        int cut = 0;

        for (int i = 0; i < N; i++) {
            if (BinarySearch.rank(-a[i], a) > 1)
                cut++;
        }
        return cut;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);

        StdOut.println(count(a));
    }
}
