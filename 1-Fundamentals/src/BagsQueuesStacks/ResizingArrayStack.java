package BagsQueuesStacks;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 动态调节 栈
 * <p>
 * Created by HJKLI on 2016/8/31.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a;
    private  int N;

    public ResizingArrayStack() {
        a = (Item[]) new Object[2];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;       // a 引用 temp
    }

    public void push(Item item) {
        if (N == a.length)
            resize(a.length * 2);
        a[N++] = item;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stacks underflow");
        Item temp = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return temp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

//    Iterable 接口定义了
//Iterator<Item> iterator()

    public class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return a[--i];
        }

        public void remove() {throw new UnsupportedOperationException(); }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> data = new ResizingArrayStack<String>();

        In arr = new In(args[0]);
        while (!arr.isEmpty()) {
            String key = arr.readString();
            if (!key.equals("-"))
                data.push(key);
            else if (!data.isEmpty())
                StdOut.println(data.pop() + " ");
        }
        StdOut.println("(" + data.size() + " left on stack!");

        // 迭代
        for (String x : data) {
            StdOut.println(x);
        }
    }
}
