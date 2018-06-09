package DataAbstraction;

import edu.princeton.cs.algs4.StdOut;

//import java.util.Date;
//  使用 Date

/**
 * Created by HJKLI on 2016/8/28.
 */
public class TestDate {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        Date date = new Date(m, d, y);
        StdOut.println(date);
    }
}
