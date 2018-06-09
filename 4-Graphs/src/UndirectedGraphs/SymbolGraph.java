package UndirectedGraphs;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
* 符号图 st
*
* 用到三种数据结构
* 符号表 st ， 键为 String， 值 int
* 数组 keys[]   反向索引，保持每个顶点索引对于的顶点名
* Graph 图 G ， 使用索引引用图中的顶点
*
*  ../algs4-data/movies.txt "/"
*  ../algs4-data/routes.txt " "
*  ../algs4-data/moviestiny.txt
*  ../algs4-data/moviesG.txt
*  ../algs4-data/moviestopGrossing.txt
*
 */


public class SymbolGraph {

    private ST<String, Integer> st;     // 符号名 -- 索引
    private String[] keys;              // 索引 -- 符号名
    private Graph G;                    // 图


    public SymbolGraph(String stream, String sp) {
        st = new ST<String, Integer>();
        In in = new In(stream);                         // 第一遍

        while (in.hasNextLine()) {
           String[] a = in.readLine().split(sp);        // 读取字符串

            for (int i = 0; i< a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());              // st.size() 表示索引
                }
            }
        }

        StdOut.println("Done reading " + stream);

        keys = new String[st.size()];                   // 用来获得顶点名的反向索引是一个数组

        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        G = new Graph(st.size());
        in = new In(stream);                            // 第二遍, 生成关系树
        while (in.hasNextLine()) {
            String[]  a = in.readLine().split(sp);      // 将每一行的顶点和该行的其他顶点相连

            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    // 查看是否有
    public boolean contains(String s) {
        return st.contains(s);
    }

    // 获取 value
    public int index(String s) {
        return st.get(s);
    }

    // 获取名字
    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return G;
    }
    public Graph graph() {
        return G;
    }


    // 测试用例
    public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];

        SymbolGraph sg = new SymbolGraph(filename, delimiter);

        Graph graph = sg.graph();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            if (sg.contains(source)) {
                int s = sg.index(source);
                for (int v : graph.adj(s)) {
                    StdOut.println(" " + sg.name(v));
                }
            }
            else {
                StdOut.println("input not contain '" + source + "'");
            }

        }
    }
}
