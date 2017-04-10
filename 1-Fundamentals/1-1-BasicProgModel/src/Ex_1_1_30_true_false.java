import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HJKLI on 2016/8/27.
 */
public class Ex_1_1_30_true_false {


    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int i = p % q;
        return gcd(q, i);
    }

    public static void migrateRamon(int[][] a, int N) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = StdRandom.uniform(N);
            }
        }
    }

    public static void trueAndFalse(int[][] arr) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result = gcd(arr[i][0], arr[i][j]);
//                result = Ex_1_1_24_gcd.gcd(arr[i][0], arr[i][j]);

                if (result == 1) {
                    StdOut.println("true");
                } else
                    StdOut.println("false");
            }
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] arr = new int[n][n];

        migrateRamon(arr, n); // 生成数据
        trueAndFalse(arr);
    }
}
