package UndirectedGraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Graph;

/**
 * Created by HJKLI on 2017/7/14.
 * 深度优先遍历 depth-first search in a graph DFS
 * <p>
 * ../algs4-data/tinyG.txt 0
 * ../algs4-data/tinyG.txt 9
 * ../algs4-data/tinyCG.txt 0
 * ../algs4-data/tinyG.txt 0
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int       count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }


    public int count() {
        return count;
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    public static void main(String[] args) {
        In               in     = new In(args[0]);
        Graph            G      = new Graph(in);
        int              s      = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) {
                StdOut.println(v + " ");
            }
        }

        StdOut.println();
        if (search.count() != G.V()) StdOut.println("NOT connected");
        else StdOut.println("connected");
    }
}
