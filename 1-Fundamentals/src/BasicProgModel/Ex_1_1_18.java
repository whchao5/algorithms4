package BasicProgModel;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/8/26.
 */
public class Ex_1_1_18 {

    public static void main(String[] args) {
//        int result = mystery(2, 25); // 50
        int result = mystery(3, 5);  // 3 + 3 + 3 = 3 * 5
        int results = myMultiply(3, 4); // (3 * 3) * (3* 3)
        StdOut.println(result);
        StdOut.println(results);
    }

    private static int mystery(int a, int b) {
        if (b == 0) return  0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }

    private static int myMultiply(int a, int b) {  // = 这是
        if (b == 0) return  1;
        if (b % 2 == 0) return myMultiply(a*a, b/2);
        return myMultiply(a*a, b/2) * a;
    }
}
