import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by W on 2017/7/6.
 * 无向图
 * Graph
 *
 * ../algs4-data/tinyG.txt
 * ../algs4-data/mediumG.txt
 *  ../algs4-data/largeG.txt
 */


public class Graph {

    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;  // 定点数
    private int E;  // 边数
    private Bag<Integer>[] adj;

    /*
    ** 初始化一个空的图 顶点和边。
     */
    public Graph(int V) {
        this.V = V;
        E = 0;
        adj = (Bag<Integer>[]) new Bag[V];   // 创建邻接表
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    // 初始化图形从指定的输入流。
    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();

        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            addEdge(v, w);
        }
    }

    public int V() {return this.V;}
    public int E() {return this.E;}

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     *返回顶点{ @code v }的程度。
     * @param v
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /*
    ** 验证 validateVertex
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= this.V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     *  return toString
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.V + " vertices, " + this.E + " edge " + this.NEWLINE);
        for (int v = 0; v < this.V; v++) {
            str.append(v + " : ");
            for (int w : adj[v]) {
                str.append(w + " ");
            }
            str.append(NEWLINE);
        }
        return str.toString();
    }


    /**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}
