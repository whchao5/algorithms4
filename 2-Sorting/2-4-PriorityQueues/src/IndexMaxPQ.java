
/*
 * Created by HJKLI on 2017/3/26.
 * 大到小 索引优先队列 IndexMaxPQ.java
 * URL : http://algs4.cs.princeton.edu/24pq/IndexMaxPQ.java.html
 */


import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

/*
**  索引pq[n] = i 对应 keys[] 的 key
 */
public class IndexMaxPQ<Key extends Comparable<Key>> {

    private int n;      // number of elements on PQ
    private int[] pq;    // PQ上的元素数
    private int[] qp;   // 反向的 pq   qp[pq[i]] = pq[qp[i]] = i， 存储索引
    private Key[] keys;

    /**
     * 初始化
     *
     * @param maxN 长度
     */
    public IndexMaxPQ(int maxN) {
        if (maxN < 0)
            throw new IllegalArgumentException();

        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];                 // 实例化长度
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // 索引在优先队列中
    public boolean contains(int i) {
        return qp[i] != -1;  // 不等, 队列一切都是变量, -1 返回 false,
    }

    public int size() {
        return n;
    }

    /*
    ** 插入元素
     */
    public void insert(int i, Key key) {
        if (contains(i))
            throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;      // Index 的 value
        pq[n] = i;      // keys 的 key
        keys[i] = key;
        swin(n);
    }

    /*
    ** 删除最大的值， 返回 key
     */
    public int delMax() {
        if (n == 0)
            throw new IllegalArgumentException("index is already in the priority queue");
        int min = pq[1];
        exch(1, n--);
        sink(1);

        assert pq[n + 1] == min;
        qp[min] = -1;
        keys[min] = null;
        pq[n + 1] = -1;

        return min;
    }


    /*
    ** 获得索引的最大值
     */
    public int maxIndex() {
        if (n == 0)
            throw new IllegalArgumentException("index is already in the priority queue");
        return pq[1];
    }

    /*
    ** return is max key
     */
    public Key maxKey() {
        if (n == 0)
            throw new IllegalArgumentException("index is already in the priority queue");
        return keys[pq[1]];
    }

    /*
    ** 返回与索引关联的关键
     */
    public Key keyOf(int i) {
        if (!contains(i))
            throw new NoSuchElementException("index is not in the priority queue");
        else
            return keys[i];
    }

    /******************************************************************************
    **  辅助 函数 比较 和 交换
     ******************************************************************************/

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /***************************************************************************
     * Heap helper functions.
     ***************************************************************************/
    private void swin(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    /*
    ** 输出值
     */
    public void show() {
        for (int i = 0; i < n; i++) {
            StdOut.println(keys[i]);
        }
    }

    /*
    * 返回一个迭代器遍历优先级队列上的键按降序。
    *  迭代器没有实现{@code remove()}，因为它是可选的
     */
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {
        private IndexMaxPQ<Key> copy;

        public HeapIterator() {
            copy = new IndexMaxPQ<Key>(pq.length - 1);
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i], keys[pq[i]]);
            }
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }


    public static void main(String[] args) {
        String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};

//        int[] in = {-1, -1, -1};

        int sL = strings.length;
        IndexMaxPQ<String> pq = new IndexMaxPQ<String>(sL);

        for (int i = 0; i < sL; i++) {
            pq.insert(i, strings[i]);
        }

        pq.show();


    }
}
