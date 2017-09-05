
//import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
** G 是无环图
*
*  ../algs4-data/tinyG.txt
*
 */

public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i, i);
            }
        }
    }

    // u 是 图首
    private void dfs(Graph G, int v, int u) {

        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }



    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);

        Cycle finder = new Cycle(G);

        StdOut.println(finder.hasCycle);
    }
}
