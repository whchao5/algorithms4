package DirectedGraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;
import java.util.Stack;


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


    /**
     * 用文本生成一个 有向图
     * @param in
     */
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

    /**
     * 拷贝一个 反方向的 有向图,
     * @param G
     */
    public Digraph(Digraph G) {
        this(G.V());
        this.E = G.E();

        for (int v = 0; v < G.V; v++) {

            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }

            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    public int V() {return this.V;}
    public int E() {return this.E;}

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /*
** 验证 validateVertex
 */
    private void validateVertex(int v) {
        if (v < 0 || v >= this.V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
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
        Digraph G2 = new Digraph(G);
        StdOut.println(G);
        StdOut.println(G2);
    }
}
