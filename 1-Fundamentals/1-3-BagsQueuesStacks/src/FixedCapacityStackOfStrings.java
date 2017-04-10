import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 不是泛型容定栈
 * Created by HJKLI on 2016/8/31.
 */
public class FixedCapacityStackOfStrings {

    private String[] a;
    private int n;
    private int caps;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
        caps = cap;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(String item) {
        a[n++] = item;
    }

    public String pop() {
        return a[--n];
    }

    // 1.3.1
    public boolean isFull() {
        return n == caps;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings data = new FixedCapacityStackOfStrings(100);

        In arr = new In(args[0]);
        while (!arr.isEmpty()) {
            String key = arr.readString();
            if (!key.equals("-"))
                data.push(key);
            else if (!data.isEmpty())
                StdOut.println(data.pop() + " ");
        }
        StdOut.println("(" + data.size() + " left on stack!");
    }
}
