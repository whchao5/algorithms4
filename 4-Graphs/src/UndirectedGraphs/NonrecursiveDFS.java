package UndirectedGraphs;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;

import java.util.Iterator;
import java.util.Stack;


/**
 * 深度优先遍历 depth-first search in a graph DFS 非递归实现
 * <p>
 * ../algs4-data/tinyCG.txt
 * ../algs4-data/tinyCG.txt 0
 * ../algs4-data/tinyG.txt 9
 */

public class NonrecursiveDFS {

    private boolean[] marked;

    public NonrecursiveDFS(Graph G, int s) {
        marked = new boolean[G.V()];
        validateVertex(s);

        // 能够遍历每个邻接表,跟踪
        // 在每个顶点邻接表需要探讨下
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];

        for (int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();   // 强制转换
        }

        // 深度优先搜索使用显式的堆栈
        Stack<Integer> stack = new Stack<Integer>();   // 记录 运行的 轨迹，
        marked[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {      // 不空
            int v = stack.peek();       // 栈的值

            if (adj[v].hasNext()) {
                int w = adj[v].next();
                if (!marked[w]) {
                    marked[w] = true;
                    stack.push(w);
                }

            } else {
                stack.pop();
            }
        }
    }


    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    public static void main(String[] args) {
        In              in  = new In(args[0]);
        Graph           G   = new Graph(in);
        int             s   = Integer.parseInt(args[1]);
        NonrecursiveDFS dfs = new NonrecursiveDFS(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) {
                StdOut.println(v + " ");
            }
        }
    }
}
