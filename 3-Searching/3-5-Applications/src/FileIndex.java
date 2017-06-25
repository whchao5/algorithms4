import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by W on 2017/6/25.
 * 读取 文件 ， 见 单词 生成 key， 便于查找
 * ../algs4-data/ex*.txt

 */
public class FileIndex {

    public FileIndex() {
    }

    public static void main(String[] args) {
        ST<String, SET<File>> st = new ST<String, SET<File>>();

        StdOut.println("Indexing files");

        //获取 所有文件
        for (String filename : args) {
            StdOut.println(" " + filename);
            File file = new File(filename);

            In in = new In(file);
            while (!in.isEmpty()) {
                String word =  in.readString();

                if (!st.contains(word)) {
                    st.put(word, new SET<File>());
                }

                SET<File> set = st.get(word);
                set.add(file);
            }
        }


        // read queries from standard input, one per line
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                SET<File> set = st.get(query);
                for (File file : set) {
                    StdOut.println("  " + file.getName());
                }
            }
        }
    }
}
