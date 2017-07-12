import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

/**
 * Created by W on 2017/6/11.
 * 过滤器
 *
 * ../algs4-data/tinyTale.txt
 * ../algs4-data/tinyG.txt
 */
public class DeDup {

    // Do not instantiate.
    private DeDup() { }

    public static void main(String[] args) {
        SET<String> set = new SET<String>();

        In in = new In(args[0]);
        StdOut.println(in.readInt());
        StdOut.println(in.readInt());
        StdOut.println(in.readInt());
        StdOut.println(in.readInt());
        StdOut.println(in.readInt());

        while (!StdIn.isEmpty()) {
            String key = StdIn.readAll();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.println(key);
            }
        }
    }
}
