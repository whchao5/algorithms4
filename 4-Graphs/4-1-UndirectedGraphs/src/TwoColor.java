import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
**  深度优先， ---- 双色
 */

public class TwoColor {

    private boolean[] marked;
    private boolean[] colors;
    private boolean hasTwoColor = true;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        colors = new boolean[G.V()];
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
                dfs(G, w);
            }
        }
    }

}
