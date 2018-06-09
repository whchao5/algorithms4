package BagsQueuesStacks;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by HJKLI on 2016/8/31.
 * 链表队列  FIFO queue (linked list)
 */
public class LinkedQueue<Item> implements Iterable<Item> {
    private int  n;
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
    }

    public LinkedQueue() {
        first = null;
        last = null;
        n = 0;
//        assert check();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())      // 没有节点，
            first = last;   // 创建第一个节点
        else
            oldlast.next = last;
        n++;
        assert check();
    }

    public Item dequeue() {

        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item temp = first.item;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;
        assert check();
        return temp;
    }

//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        for (Item item : this)
//            s.append(item + " ");
//        return s.toString();
//    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node  current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    //
    private boolean check() {
        if (n < 0) {
            return false;
        } else if (n == 0) {
            if (first != null)  return false;
            if (last != null)   return false;
        } else if (n == 1) {
            if (first == null || last == null)  return false;
            if (first != last)                  return false;
            if (first.next != null)             return false;
        } else {
            if (first == null || last == null)  return false;
            if (first == last)                  return false;
            if (first.next == null)             return false;
            if (last.next != null)              return false;

            int numberOfNodes = 0;
            for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
                numberOfNodes++;
            }
            if (numberOfNodes != n)
                return false;

            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            if (last != lastNode)
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        LinkedQueue<String> q   = new LinkedQueue<String>();
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
