
/*
 * Created by HJKLI on 2017/3/5.
 * 使用 索引队列例子
 * IndexMinPQ 解决了多项 并归问题:  ` ``它将多个有序的输入流并归成一个有序的输出流 ```
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.IndexMaxPQ;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdOut;


/*
* ../algs4-data/m1.txt ../algs4-data/m2.txt ../algs4-data/m3.txt
* A A B B B C D E F F G H I I J N P Q Q Z
 */
public class Multiway {

    private Multiway(){}

    public static void merge(In[] streams){
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
//        IndexMaxPQ<String> pq = new IndexMaxPQ<String>(N);

        for (int i = 0; i < N; i++)
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());

        // 初始化后，代码进入一个循环， 删除并打印队列中最小的字符串，
        // 然后将输入下一个字符串添加为一个元素
        // A A B B B C D E F F G H I I J N P Q Q Z
        while (!pq.isEmpty()) {
            StdOut.print(pq.minKey() + " ");
            int i = pq.delMin();
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }

        // B D H P Q Q A B E F J N A B C F G I I Z
//        while (!pq.isEmpty()) {
//            StdOut.print(pq.maxKey() + " ");
//            int i = pq.delMax();
//            if (!streams[i].isEmpty())
//                pq.insert(i, streams[i].readString());
//        }

        StdOut.println();
    }

    public static void main(String[] args) {
        int N = args.length;
        In[] streams = new In[N];

        for (int i = 0; i < N; i++) {
            streams[i] = new In(args[i]);
        }

        merge(streams);
    }
}
