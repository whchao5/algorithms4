
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
** 连通分量 ，表示与 。。。 连通
*
*  API :
*  CC（Graph G)
*  bool connected(int v, int w)  v 和 w 是连通吗
*  count （）                     连通分量数
*  id()                          v 所在的连通分量的标识符 （0 ~ count -1)
*
*  ../algs4-data/tinyCG.txt
*  ../algs4-data/tinyG.txt
 */

public class CC {

    private boolean[] marked;
//    private int[] edgeTo;
    private int[] id;
    private int[] size;    // size[id] 记录联通分量的数量
    private int count;

    public CC(Graph G) {
        int v = G.V();
        this.marked = new boolean[v];
        this.id = new int[v];
        this.size = new int[v];
        for (int s = 0; s < v; s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public int id(int v) {
        validateVertex(v);
        return id[v];
    }


    public int size(int v) {
        return size[id[v]];
    }
    public int ccSize(int v) {
        return size[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In (args[0]));

        CC cc = new CC(G);
        int M = cc.count;

        StdOut.println(M + " components");

        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            components[cc.id[v]].add(v);
        }

        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println("  count = " + cc.ccSize(i) );
        }

    }
}
