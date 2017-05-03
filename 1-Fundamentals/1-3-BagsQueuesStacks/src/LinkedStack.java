import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/*
 * Created by HJKLI on 2016/9/1.
 *  链表式 栈  LIFO stack (linked list)
 *
 *  ../algs4-data/tobe.txt
 */
public class LinkedStack<Item> {
    private Node first;
    private int  n;

    private class Node {
        private Item item;
        private Node next;

//        public  Node (Item item, Node n) {      // 这样写 也OK
//            this.item = item;
//            this.next = n;
//        }
    }

    public LinkedStack() {
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
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {

        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");

        Item temp = first.item;
        first.item = null;
        first = first.next;
        n--;
        return temp;
    }

    // 测试用例
    public static void main(String[] args) {
        LinkedStack<String> data = new LinkedStack<String>();

        In arr = new In(args[0]);
        while (!arr.isEmpty()) {
            String key = arr.readString();
            if (!key.equals("-"))
                data.push(key);
            else if (!data.isEmpty())
                StdOut.println(data.pop() + " ");
        }
        StdOut.println("(" + data.size() + " left on stack! )");

        // 迭代
//        for (String x : data) {
//            StdOut.println(x);
//        }
    }
}
