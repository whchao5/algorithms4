package BasicProgModel;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * largeW.txt < largeT.txt
 * &
 * tinyW.txt < tinyT.txt
 * Created by HJKLI on 2016/8/27.
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        In in = new In(args[0]);
        In arr = new In(args[2]);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);

        while (!arr.isEmpty()) {
            int key = arr.readInt();
            if (rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
    }
}
