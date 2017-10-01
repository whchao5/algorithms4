import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;


/**
    用向图
 ../algs4-data/tinyDG.txt
 */

public class Digraph {

    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;  // 定点数
    private int E;  // 边数
    private Bag<Integer>[] adj;


    /**
     * 初始化一个空的图 顶点和边。
     * @param V
     */
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            this.adj[i] = new Bag<Integer>();
        }
    }

    public Digraph(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be nonnegative");
            this.adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                this.adj[v] = new Bag<Integer>();
            }

            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w);
            }


        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
        }
    }

    public int V() {return this.V;}
    public int E() {return this.E;}

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    /**
     * 输出字符串
     * @return
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.V + " vertices, " + this.E + " edge " + NEWLINE);
        for (int v = 0; v < this.V; v++) {
            str.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                str.append(String.format("%d ", w));
            }
            str.append(NEWLINE);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        StdOut.println(G);
    }
}
