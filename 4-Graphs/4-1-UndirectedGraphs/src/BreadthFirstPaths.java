import edu.princeton.cs.algs4.Graph;

import java.util.Iterator;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
** paths in a graph (BFS) 广度优先 ， 遍历图的边
*  ../algs4-data/largeG.txt 0
*  ../algs4-data/tinyCG.txt 0
*  ../algs4-data/mediumG.txt 0
 */

public class BreadthFirstPaths {

    private       boolean[] marked;           // 到达顶点最短路径
    private       int[]     edgeTo;               // 到达顶点的
    private final int       s;                // 起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;

        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();

        marked[s] = true;       // 标记
        queue.enqueue(s);       // 加入队列

        while (!queue.isEmpty()) {

            int v = queue.dequeue();     // 从队列删去下一个顶点
            for (int w : G.adj(v)) {
                if (!marked[w]) {       // 对于未被标记的顶点
                    marked[w] = true;   // 标记它， 最短路径已知
                    edgeTo[w] = v;      //  保持最短路径 的最好一条边
                    queue.enqueue(w);   // 添加到队列中
                }
            }
        }
    }

    // 返回 一个源顶点的 状态
    public boolean hasPathTo(int i) {
        validateVertex(i);
        return marked[i];
    }


    // 抛出 IllegalArgumentException 异常 {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }


    // 记录线路
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);

        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }


    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        // StdOut.println(G);

        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d :  ", s, v);
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }

        }
    }
}
