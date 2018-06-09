package BagsQueuesStacks;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by HJKLI on 2016/9/1.
 */
public class Queue<Item> {

    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    // 空
    public boolean isEmpty() {
        return first == null;
    }

    // 大小
    public int size() { return n; }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty())      // 没有节点，
            first = last;   // 创建第一个节点
        else
            oldlast.next = last;
        n++;
//        assert check();
    }

    public Item dequeue() {

        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item temp = first.item;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;
//        assert check();
        return temp;
    }

    // 测试用例
    public static void main(String[] args) {
        Queue<String> q   = new Queue<String>();
        In                  arr = new In(args[0]);

            while (!arr.isEmpty()) {
            String item = arr.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.println(q.dequeue());
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
