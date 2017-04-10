import edu.princeton.cs.algs4.StdOut;

/**
 * 1111111 1234567
 * Created by HJKLI on 2016/8/27.
 */
public class Ex_1_1_24_gcd {
    public static void main(String[] args) {
        int i = gcd(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        StdOut.println(i);
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int i = p % q;
        StdOut.println(p + "  " + q);
        return gcd(q, i);
    }
}

//        1111111 1234567
//        1111111 123456
//        1234567 1111111
//        123456 7
//        7 4
//        4 3
//        3 1
//        1