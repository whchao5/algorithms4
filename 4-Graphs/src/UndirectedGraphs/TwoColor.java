package UndirectedGraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;

/*
**  深度优先， ---- 双色
 */

public class TwoColor {

    private boolean[] marked;
    private boolean[] colors;
    private int[] edgeTo;
    private boolean hasTwoColorable = true;
    private Stack<Integer> cycle;  // odd-length cycle

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        colors = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                colors[w] = !colors[v];
                edgeTo[w] = v;
                dfs(G, w);
            } else if (colors[w] == colors[v]) {


                this.hasTwoColorable = false;
            }
        }
    }

    public boolean isHasTwoColorable() {
        return this.hasTwoColorable;
    }


}
