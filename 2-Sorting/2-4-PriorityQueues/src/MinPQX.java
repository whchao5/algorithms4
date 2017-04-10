/**
 * Created by HJKLI on 2017/3/26.
 * 完全版 的 MinPQ
 * 地址 url : http://algs4.cs.princeton.edu/24pq/MinPQ.java.html
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPQX<Key> implements Iterable<Key> {

    private Key[] pq;
    private int n;
    private Comparator<Key> comparator;

    // 创建一个容量 为 max 的优先队列
    public MinPQX(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    // 创建一个优先队列
    public MinPQX() {
        this(1);
    }

    // 初始化一个空的优先级队列与给定的初始容量、使用指定的比较器
    public MinPQX(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    public int size() {
        return n;
    }

    /**
     * 插入优先队列
     *
     * @param x 数据
     */
    public void insert(Key x) {
        if (n >= pq.length - 1)
            resize(pq.length * 2);

        pq[++n] = x;
        swim(n);
    }

    /**
     * 如果为空， 返回TRUE ，否则 FALSE
     *
     * @return
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /*
    ** 去除最大值
     */
    public Key delMax() {
        if (isEmpty())
            throw new NoSuchElementException("Priority queue underflow");

        Key max = pq[1];

        exch(1, n--); // 最大 值和 最后一个值交换，n 减一
        sink(1);

        pq[n + 1] = null;

        if (n > 0 && (n == (pq.length - 1) / 4))
            resize(pq.length / 2);

        return max;
    }

    /*
    ** helper函数双堆数组的大小
     */
    private void resize(int len) {
        Key[] temp = (Key[]) new Object[len];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /*
    ** 获取最大值
     */
    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /*
    ** 辅助函数， 帮助 队列 维持最大数组
     */

    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[i]) < 0;
        }
    }

    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[i]) > 0;
        }
    }

    /*
    ** 交换元素
     */
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /*
    ** 上浮
     */
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    /*
    ** 下沉
     */
    private void sink(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && greater(j, j + 1))
                j++;
            if (!greater(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }


    //
    public MinPQX(Comparator<Key> comparator) {
        this(1, comparator);
    }

    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        MinPQX<Key> copy;

        public HeapIterator() {
            if (comparator == null)
                copy = new MinPQX<Key>(size());
            else
                copy = new MinPQX<Key>(size(), comparator);

            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        //        public void remove() {}
        public Key next() {
            if (copy.isEmpty())
                throw new NoSuchElementException("Priority queue underflow");
            return copy.delMax();
        }
    }

    public void show() {

        for (int i = 1; i < n + 1; i++) {
            StdOut.println(pq[i]);
        }
    }

    public static void main(String[] args) {
        In arr = new In(args[0]);
//        String[] a = arr.readAllStrings();

        MinPQX<String> pq = new MinPQX<String>();

        while (!arr.isEmpty()) {
            String item = arr.readString();
            if (!item.equals("-"))
                pq.insert(item);
            else
                pq.delMax();

        }
        pq.show();
        StdOut.println("(" + pq.size() + " left on pq)");
    }
}
