package PriorityQueues;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;
import java.util.Iterator;
//import sun.security.krb5.internal.KdcErrException;

import java.util.Iterator;

/**
 * Created by HJKLI on 2017/2/12.
 * 最大值 API
 */

public class MaxPQ<Key extends Comparable<Key>> {
    private int N = 0;
    private Key[] pq;

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public int size() {
                return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void install(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];        // 根据节点获得最大元素
        exch(1, N--);         // 将其和最后一个节点交替, delMax 时， N要减一
        pq[N+1] = null;         // 放在对象游离
        sink(1);             // 恢复 堆的有序性
        return max;
    }

    /*
    ** 帮助程序维护 堆不变 ， 这是 Max 的排在 顶部, 如果是 Mix 将 less 改成其他
     */
    // 由下 向上的堆 有序的实现 (上浮)  d
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k , k / 2);
            k = k /  2;
        }
    }

    /*
    399
    345
    23
    10
    30
    -12
    4
     */

    // 有上 向下的堆 有序实现 (下浮)
    private void sink(int k) {
        while (k * 2 < N) {
            int j = k * 2;
            if (j < N && less(j, j+1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    /*
    ** 帮助程序 比较 和 交换
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key ts = pq[i];
        pq[i] = pq[j];
        pq[j] = ts;
    }

    public void show () {

        for (int i = 1; i < N + 1; i++) {
            StdOut.println(pq[i]);
        }
    }

    public static void main(String[] args) {

        Integer[] key = {30, 10, -12, 399, 345, 23,3003, 4};
        MaxPQ<Integer> pq = new MaxPQ<>(key.length + 1);

        for (int i = 0; i < key.length; i++) {
            pq.install(key[i]);
        }

        pq.delMax();

        pq.show();

    }
}

//public class MaxPQ<Key> implements Iterable<Key> {
//    private Key[] pq;
//    private int n;
//    private Comparable<Key> comparable;
//
//    public MaxPQ() {
//        this(1);
//    }
//
//    public MaxPQ(int initCapacity) {
//        pq = (Key[]) new Object[initCapacity + 1];
//        n = 0;
//    }
//
//    public MaxPQ(int initCapacity, Comparable<Key> comparable) {
//        this.comparable = comparable;
//        pq = (Key[]) new Object[initCapacity + 1];
//        n = 0;
//    }
//
//    /*
//    * 初始化
//     */
//    public MaxPQ(Comparable<Key> comparable) {
//        this(1, comparable);
//    }
//
//    /*
//    * 插入数据
//     */
//    public void insert(Key item) {
//        if (n > pq.length - 1)
//            resize(pq.length * 2);
//
//        pq[++n] = item;
//        swin(n);
//    }
//
//    /*
//    ** 返回最大的数
//     */
//    public Key max() {
//
//    }
//
//    /*
//    ** 删除并返回最大的数
//     */
//    public Key delMax() {
//
//    }
//
//    /*
//    ** 返回队列是否为空
//     */
//    public boolean isEmpty() {
//        return n == 0;
//    }
//
//    /*
//    ** 返回队列 中的元数个数
//     */
//    public int size() {
//        return n;
//    }
//
//    private void resize(int max) {
//        if (max < n)
//            return;
//    }
//
//    /*
//    * 帮助函数维持堆不变
//     */
//    private void swin(int n) {
//
//    }
//
//    private void sink(int k) {
//
//    }
//
//    private boolean less(int i, int j) {
//        if (comparator == null)
//        return pq[i].compareTo(pq[j]) < 0;
//    }
//
//
//
//
//    public Iterator<Key> iterator () {
//        return new HeapIterator();
//    }
//    private class HeapIterator implements Iterator<Key> {
//
//        public boolean hasNext() {
//            return true;
//        }
//        public  void remove() {}
//        public Key next() {
//            return 0;
//        }
//    }
//
//}
