import edu.princeton.cs.algs4.Graph;

import java.util.Iterator;
import java.util.Queue;

/*
** paths in a graph (BFS) 广度优先 ， 遍历图的边
*  ../algs4-data/largeG.txt 0
*  ../algs4-data/tinyCG.txt 0
 */

public class BreadthFirstPaths {

    private boolean[] marked;           // 到达顶点最短路径
    private int[] edgeTo;               // 到达顶点的
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
    }
}
