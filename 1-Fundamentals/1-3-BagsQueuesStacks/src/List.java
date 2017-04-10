import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by HJKLI on 2016/9/7.
 */
public class List<Item> implements Iterable<Item> {

    private Node last;
    private Node first;
    private int n;

    private class Node {
        private  Item item;
        private Node next;
    }

    public List() {
        last = null;
        first = null;
        n    = 0;
    }
    public List(Item[] a) {
        for (Item t : a) {
            push(t);
        }
    }

    public List(Iterable<Item> coll) {
        for (Item t : coll)
            push(t);
    }

    public boolean isEmpty() {return first == null;}

    public int size() { return n;}

    public Item first() {
        if(isEmpty())
            throw new NoSuchElementException("Queue underflow");

        return first.item;
    }

    public Item last() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        return last.item;
    }

    public void push(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    /*
    ** 接口
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {

        private Node current = first;
        public boolean hasNext() { return current != null;}
        public void remove() { throw new UnsupportedOperationException();  }
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }


    }

    public Item removeFist() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first.item = null;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }

        return item;
    }

    /*
    ** 获取node 第几个节点
     */

    public Node node(int k) {

        if (!(k > 0))
            throw new NoSuchElementException("Queue underflow");

        int i = 0;
        Node curr = first;
        while (i < k && curr != null) {
            curr = curr.next;
            i++;
        }

        return curr;
    }

    /*
    *  1.3.19 delete last node
    *  获取最后 的上一个值
    */
    public Item removeLast() {

        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        if (first == last)
            return first();

        Item item = last.item;
        Node prev = null;
        Node curr = first;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        last = prev;
        n--;
        return item;
    }

    /*
    *  1.3.20 delete last node
    *  prev = curr.next;
    *  curr.next = prev.next;
    */
    public Item delete(int k) {

        if (k < 1 || k >= n)
            return null;

        Node curr = first, prev;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }
        Item item = curr.item;
        prev = curr.next;
        curr.next = prev.next;
        n--;
        return item;
    }

    /*
    *  1.3.21 delete last node
    */
    public boolean find(Item key) {

        Node curr = first;
        while (curr != null && !curr.item.equals(key)) {
            curr = curr.next;
        }
        return curr != null;
    }

    // 1.3.24

    public void removeAfter(Node node) {

        if (node != null && node.next != null) {
            if (node.next.next == null) {  // Node 是最后一个node
                last = node;
            }
            node.next = node.next.next;
            n--;
        }
    }

    // 1.3.37
    public Item max(Node node) {
        if (node == null)
            throw new  RuntimeException("List is empty");

        return max(node, null);
    }

    public Item max(Node node, Item def) {
        if (node == null)
            return def;

        Item max = node.item;
        Node curr = node;

        while (curr.next != null) {
            curr = node.next;
            if (((Comparable)max).compareTo(curr.item) < 0)
                max = curr.item;
        }

        return max;
    }

    /*
    ** Unit tests
     */

    public static  void testRemoveAfter() {

        List<Integer> lst = new List<Integer>(new Integer[] { 2, 6, 10, 12 });
        showList(lst);

        int k[] =  { 0, 2, 1, 5, 3, 2, 1 };
        for (int i = 0; i < k.length; i++) {
            StdOut.printf("removeAfter(node(%d)):\n", k[i]);
//            lst.removeAfter();
//            StdOut.println(lst.Node(k[i]));
        }
        int s = 2;
//        Node item = lst.node(s);
        lst.removeAfter(lst.node(s));
        StdOut.println(lst);
    }

    /*
    ** Unit help
    */
    public static void showList(List lst) {

        StdOut.println(lst);
        if (!lst.isEmpty()) {
            StdOut.printf("Size: %d, First: %s, Last: %s\n\n", lst.size(), lst.first(), lst.last());
        } else {
            StdOut.printf("Size: %d\n\n", lst.size());
        }
    }

    /*
    ** main program
     */
    public static void main(String[] args) {
//        List<String> list = new List<String>();
//
//        List<Integer> lst = new List<Integer>(new Integer[] { 2, 6, 10, 12 });
//
//        int s = 0;
//        In arr = new In(args[0]);
//        while (!arr.isEmpty()) {
//            String item = arr.readString();
//            if (!item.equals("-")) {
//                list.push(item);
//            }
//        }
//        list.removeLast();
//        list.removeFist();
//        String d = list.delete(6);
//        String textStr = "or";
//        boolean d  = list.find("ors");
//        StdOut.println(d);

//        list.removeAfter();
        testRemoveAfter();
//        StdOut.println(list.size());
    }
}
