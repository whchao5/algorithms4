import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;

/**
 * Created by W on 2017/7/16.
 * 使用 深度优先搜索 查找图中 的路径
 * 显示 查找节点的 路径
 *
 * ../algs4-data/tinyCG.txt
 * ../algs4-data/tinyCG.txt 0
 * ../algs4-data/tinyCG.txt 5
 * ../algs4-data/mediumG.txt 0
 * ../algs4-data/tinyG.txt 0
 */
public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int count;
    private final int s;

    /**
     * 初始化
     * @param G 数组表示的 图结构
     * @param s 表示从那个点开始查找
     */
    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        count = 0;
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;      // 该节点 是从那个节点来
                dfs(G, w);
            }
        }
    }

    // 返回 一个源顶点的 状态
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    // 抛出 IllegalArgumentException 异常 {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    // 数据结构 如下
    // edgeTo[]
    /*
     1 | 2
     2 | 0
     3 | 2
     4 | 3
     5 | 3
    */
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>(); // 将路径 排列成 先进后出
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;

    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);          // 表示从那个点开始查找
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s)
                        StdOut.print(x);
                    else
                        StdOut.print("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d: not connected\n", s , v);
            }
        }
    }
}
