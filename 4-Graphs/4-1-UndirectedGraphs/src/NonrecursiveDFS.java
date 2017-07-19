import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;

import java.util.Iterator;


/**
 * 深度优先遍历 depth-first search in a graph DFS 非递归实现
 *
 * ../algs4-data/tinyCG.txt
 * ../algs4-data/tinyCG.txt 0
 */

public class NonrecursiveDFS {

    private boolean[] marked;

    public NonrecursiveDFS(Graph G, int s) {
        marked = new boolean[G.V()];
        validateVertex(s);

        // 能够遍历每个邻接表,跟踪
        // 在每个顶点邻接表需要探讨下
        Iterator<Integer>[] adj = (Iterator<Integer>[])  new Iterator[G.V()];

        for (int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();   // 强制转换
        }


//        while ()
    }


    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }
}
