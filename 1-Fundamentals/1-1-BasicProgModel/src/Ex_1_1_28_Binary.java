import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * largeW.txt < largeT.txt
 * &
 * tinyW.txt < tinyT.txt
 * Created by HJKLI on 2016/8/27.
 */
public class Ex_1_1_28_Binary {

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

    public static int wuchao_cnt(int[] data) {
        int s = 0;
        int dataLength = data.length-1;
        for (int i = 0; i < dataLength; i++) {
            if (data[i] == data[i+1]) {
                s++;
            }
        }
        return  s;
    }

    public static int[] remove(int[] data, int cut) {

        int length = data.length;
        int[] copy = new int[length - cut];
        int s = 0;

        copy[0] = data[0];

        for (int i = 0; i < length-1; i++) {
            if (data[i] == data[i+1]) {
                s++;
            } else {
                copy[i-s+1] = data[i+1];
            }
        }

        return copy;
    }

    public static void main(String[] args) {

        In in = new In(args[0]);
        In arr = new In(args[2]);
        int[] whitelist = in.readAllInts();
        int cuts = 0;


        Arrays.sort(whitelist);

        cuts = wuchao_cnt(whitelist);
        whitelist = remove(whitelist, cuts);

//        while (!arr.isEmpty()) {
//            int key = arr.readInt();
//            if (rank(key, whitelist) < 0) {
//                StdOut.println(key);
//            }
//        }
    }
}
