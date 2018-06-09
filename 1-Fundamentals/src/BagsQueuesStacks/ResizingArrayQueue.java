package BagsQueuesStacks;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by HJKLI on 2016/8/31.
 *
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {

    private Item[] a;
    private int    N;
    private int    first;
    private int    last;

    public ResizingArrayQueue() {
        a = (Item[]) new Object[2];
        N = 0;
        first = 0;
        last = 0;
    }

    // 这块数据 核心
    private void resize(int max) {
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[(first+i) % a.length];
        a = temp;       // a 引用 temp

        first = 0;
        last = N;  // a的数据 全部从 0 开始，so 要 = N
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (N == a.length)
            resize(a.length * 2);

        a[last++] = item;
        if (last == a.length)
            last = 0;
        N++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item temp = a[first];
        a[first++] =null;
        N--;
        if (first == a.length)
            first = 0;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return temp;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<Item> {

        private int i = 0;
        public boolean hasNext() {
            return i < N;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item temp = a[(i+first ) % a.length];
            i++;
            return temp;
        }

        public void remove() {throw new UnsupportedOperationException();  }
    }

    // 测试用例
    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();

        In arr = new In(args[0]);
        while (!arr.isEmpty()) {
            String item = arr.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");

        for (String x : queue) {
            StdOut.println(x);
        }
    }
}
