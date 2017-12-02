import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/11/2.
 *
 * 算法 分析 ， 分析三元数组 在不同 数测试用例 中， 所用的时间
 *
 *  ../algs4-data/1Kints.txt
 *
 *  ../algs4-data/2Kints.txt
 *  ../algs4-data/4Kints.txt
 *  ../algs4-data/8Kints.txt
 *  ../algs4-data/16Kints.txt
 *  ../algs4-data/32Kints.txt
 *  ../algs4-data/1Mints.txt

 *
 */
public class ThreeSum {

    public static int count(int[] a) {

        int N = a.length;
        int cut = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cut++;
                    }
                }
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
