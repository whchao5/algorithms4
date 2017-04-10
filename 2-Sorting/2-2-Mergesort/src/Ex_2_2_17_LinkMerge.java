import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/12/18.
 * 链表排序, 未完
 */
public class Ex_2_2_17_LinkMerge<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }
    public int size() { return n;}

    public Ex_2_2_17_LinkMerge () {
        first = null;
        last = null;
        n = 0;
    }

    public void enqueue(Item item) {
        Node oldNode = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldNode.next = last;
        }
        n++;
    }


    public static void main(String[] args) {
        Ex_2_2_17_LinkMerge<String> q = new Ex_2_2_17_LinkMerge<String>();
        In                          arr = new In(args[0]);

        while (!arr.isEmpty()) {
            String item = arr.readString();
            q.enqueue(item);
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
