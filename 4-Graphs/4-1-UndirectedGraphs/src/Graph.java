import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by W on 2017/7/6.
 * 无向图
 * Graph
 *
 */
public class Graph {

    private int V;  // 定点数
    private int E;  // 边数
    private Bag<Integer>[] adj;

    /*
    ** 初始化一个空的图 顶点和边。
     */
    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];   // 创建邻接表
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    // 初始化图形从指定的输入流。
    public Graph(In in) {
        this.V = in.readInt();

    }
}
