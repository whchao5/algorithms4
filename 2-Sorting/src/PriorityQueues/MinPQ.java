package PriorityQueues;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2017/3/5.
 * 最小 优先队列
 */
public class MinPQ<Key extends Comparable<Key>> {
    protected Key[] pq;
    protected int N;

    public MinPQ(int Max) {
        pq = (Key[]) new Comparable[Max + 1];
    }

    public int size() {
        return this.N;
    }

    public boolean empty() {
        return  N == 0;
    }

    public void install(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMin() {
        exch(1, N);
        Key min = pq[N];
        pq[N--] = null;
        sink(1);
        return min;
    }

    /*
    ** 上浮
     */
    private void swim(int k) {
        while (k > 1 && mores(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /*
    ** 下沉
     */
    private void sink(int k) {
        while (k * 2 < N) {
            int j = k * 2;
            if (j < N && mores(j, j + 1))
                j++;
            if (!mores(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /*
    ** j 小为 turn
     */
    private boolean less(int j, int i) {
        return pq[j].compareTo(pq[i]) < 0;
    }

    private boolean mores(int j, int i) {
        return pq[j].compareTo(pq[i]) > 0;
    }

    private void exch(int i, int j) {
        Key ts = pq[i];
        pq[i] = pq[j];
        pq[j] = ts;
    }

    public void show() {

        for (int i = 1; i < N + 1; i++) {
            StdOut.println(pq[i]);
        }
    }


    public static void main(String[] args) {

        Integer[] key = {30, 10, -12, 399, 345, 23,3003, 4};
        MinPQ<Integer> pq = new MinPQ<>(key.length + 1);

        for (int i = 0; i < key.length; i++) {
            pq.install(key[i]);
        }

        pq.show();

//         pq.delMin();
    }

}
