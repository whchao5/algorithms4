import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/9/1.
 */
public class LinkedBag<Item> {

    private Node first;
    private int  n;

    private class Node {
        private Item item;
        private Node next;
    }

    public LinkedBag() {
        first = null;
        n     = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Unit tests the {@code LinkedBag} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        LinkedBag<String> bag = new LinkedBag<String>();

        In arr = new In(args[0]);
        while (!arr.isEmpty()) {
            String item = arr.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
//        for (String s : bag) {
//            StdOut.println(s);
//        }
    }
}
