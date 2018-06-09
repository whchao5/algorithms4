package BasicProgModel;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/8/26.
 */
public class Ex_1_1_19 {
    public static void main(String[] args) {
//        for (int N = 0; N < 100; N++)
//            StdOut.println(N + " " + F(N));


        long[] fibs = new long[100];
        FT(fibs);
    }

    // 递归
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N - 2);
    }

    // 递推
    public static void FT(long[] fib) {
        fib[0] = 0;
        fib[1] = 1;
        int length = fib.length;
        for (int i = 2; i < length; i++) {
            fib[i] = fib[i-1] + fib[i - 2];
            StdOut.println(i + "  " + fib[i]);
        }
    }
}
