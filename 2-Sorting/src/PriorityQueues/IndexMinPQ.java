/**
 * Created by HJKLI on 2017/3/26.
 * 使用 小到大 索引队列例子
 * IndexMinPQ 解决了多项 并归问题:  ` ``它将多个有序的输入流并归成一个有序的输出流 ```
 */
package PriorityQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class  IndexMinPQ<Key extends Comparable<Key>> {

    private int maxN;   // PQ上的元素的最大数目
    private int n;      // number of elements on PQ
    private int[] pq;    // PQ上的元素数
    private int[] qp;   // 方向的 pq   qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;

    /**
     * 初始化一个空的索引与指数之间的优先级队列{@code 0}
     *
     * @param maxN 长度
     */
    public IndexMinPQ(int maxN) {
        if (maxN < 0)
            throw new IllegalArgumentException();

        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    /**
     * 查看 IndexMin 是否是 空值
     *
     * @return {@code true} if this priority is empty
     *          {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }


    public void insert(Key val) {

    }

    public static void main(String[] args) {
        String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};

        int SLength = strings.length;

        IndexMinPQ<String> pq = new IndexMinPQ<String>(SLength);

    }

}
