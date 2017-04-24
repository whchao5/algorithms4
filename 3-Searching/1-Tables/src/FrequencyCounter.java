import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

/**
 * 符号表， 基于顺序查看 顺序搜索
 * 2017、4/22 23:12
 *
 * ../algs4-data/tinyTale.txt
 */



public class FrequencyCounter {
    private FrequencyCounter() {

    }

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        In arr = new In(args[1]);


        ST<String, Integer> st = new ST<String, Integer>();


        while (arr.isEmpty()) {

        }

        StdOut.print(minlen);

    }
}
