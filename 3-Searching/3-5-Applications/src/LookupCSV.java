import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by W on 2017/6/11.
 * 字典类应用
 *
 * ../algs4-data/amino.csv 0 3
 * ../algs4-data/ip.csv 0 1
 * ../algs4-data/ip.csv 1 0
 * ../algs4-data/amino.csv 3 0
 * ../algs4-data/DJIA.csv 0 1
 * ../algs4-data/UPC.csv 0 2
 *
 */
public class LookupCSV {

    public static void main(String[] args) {
        int KeyField = Integer.parseInt(args[1]);
        int ValField = Integer.parseInt(args[2]);

        ST<String, String> st = new ST<String, String>();

        In in = new In(args[0]);
//        while (!in.isEmpty()) {
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[KeyField];
            String val = tokens[ValField];

            st.put(key, val);
        }

//        for (String itemSt : st.keys()) {
//            StdOut.println(itemSt);
//        }
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (st.contains(s)) {
                StdOut.println(st.get(s));
            } else
                StdOut.println("Not found");
        }
    }
}
