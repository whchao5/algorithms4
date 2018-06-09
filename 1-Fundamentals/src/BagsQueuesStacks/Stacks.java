package BagsQueuesStacks;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by HJKLI on 2016/9/1.
 */
public class Stacks<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int        n;

    private static class Node<Item> {
        private Item       item;
        private Node<Item> next;
    }

    public Stacks() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }

    public void copy(Stacks<Item> Data, Stacks<Item> copyData) {
        for (Item s : Data)
            copyData.push(s);
    }

    //迭代
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item temp = current.item;
            current = current.next;
            return temp;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Stacks<String> data = new Stacks<String>();
        Stacks<String> data2 = new Stacks<String>();

        In arr = new In(args[0]);
        while (!arr.isEmpty()) {
            String key = arr.readString();
            if (!key.equals("-"))
                data.push(key);
            else if (!data.isEmpty())
                StdOut.println(data.pop() + " ");
        }
        StdOut.println("(" + data.size() + " left on stack!");

        for (String s : data)
            StdOut.println(s);
        data.copy(data, data2);

        for (String s : data2)
            StdOut.println(s);
    }
}
