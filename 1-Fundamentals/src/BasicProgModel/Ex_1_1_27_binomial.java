package BasicProgModel;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/8/27.
 */
public class Ex_1_1_27_binomial {

    public static void main(String[] args) {
        double bin = binomial(100, 50, 0.25);

        StdOut.println(bin);
    }

    // 二项分布
    public static double binomial(int N, int k, double p) {
        if (N == 0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        return (1.0 - p) * binomial(N-1, k, p) + p * binomial(N-1, k - 1, p);
    }

//    public static double binomialProduct(int N, int k, double p) {
//        if (N == 0 && k == 0)
//            return 1.0;
//        if (N < 0 || k < 0)
//            return 0.0;
//
//    }
}
