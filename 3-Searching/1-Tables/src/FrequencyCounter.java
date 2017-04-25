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
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        In arr = new In(args[1]);

        ST<String, Integer> st = new ST<String, Integer>();

        while (arr.isEmpty()) {
            String key = arr.readString();
            if (key.length() < minlen) {
                continue;
            }
            words++;                // 单词总数
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
                distinct++;         // 去重复后的单词数
            }
        }

        StdOut.print(words);

    }
}
