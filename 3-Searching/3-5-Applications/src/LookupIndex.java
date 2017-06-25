import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.ST;

/**
 * Created by W on 2017/6/24.
 * 索引查找 和 反向索引查找
 * <p>
 * ../algs4-data/aminoI.csv ","
 * ../algs4-data/movies.txt "/"
 */
public class LookupIndex {

    public LookupIndex() {

    }

    public static void main(String[] args) {

        In     in        = new In(args[0]);
        String separator = args[1];

        ST<String, Queue<String>> st = new ST<String, Queue<String>>();
        ST<String, Queue<String>> ts = new ST<String, Queue<String>>();

        while (in.hasNextLine()) {
            String   line  = in.readLine();
            String[] field = line.split(separator);

            String key = field[0];

            for (int i = 1; i < field.length; i++) {
                String val = field[i];
                if (!st.contains(key))
                    st.put(key, new Queue<String>());
                if (!ts.contains(val))
                    ts.put(val, new Queue<String>());

                st.get(key).enqueue(val);  // why,  因为 st.get() = value, value 是 queue
                ts.get(val).enqueue(key);
            }
        }

        StdOut.println("Done indexing");

        for (String item : st.keys()) {

            StdOut.println(item);
        }
        StdOut.println("show indexing");

        while (!StdIn.isEmpty()) {
            String query = StdIn.readLine();

            if (st.contains(query)) {
                for (String vals : st.get(query)) {     // why,  因为 value 是 queue
                    StdOut.println(" " + vals);
                }
            }

            if (ts.contains(query)) {
                for (String keys : ts.get(query)) {     // why,  因为 value 是 queue
                    StdOut.println(" " + keys);
                }
            }
        }
    }
}
