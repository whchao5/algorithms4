package UndirectedGraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


/**
 * 使用 Graph 例子
 * Created by HJKLI on 2017/7/13.
 *
 * ../algs4-data/tinyG.txt
 */
public class GraphClient {

    // 最大 的  degree
    public static int maxDegree(Graph G) {

        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (G.degree(v) > max) {
                max = G.degree(v);
            }
        }
        return max;
    }

    // average degree
    public static int avgDegree(Graph G) {
        return 2 * G.E() / G.V();
    }

    // 闭环图的数量
    public static int numberOfSelfLoops(Graph G) {

        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count/2; // 闭环图 self loops 会出现两次的情况
    }

    public static void main(String[] args) {

        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);



        StdOut.println("vertex of maximum degree = " + maxDegree(G));
        StdOut.println("average degree           = " + avgDegree(G));
        StdOut.println("number of self loops     = " + numberOfSelfLoops(G));
    }
}
