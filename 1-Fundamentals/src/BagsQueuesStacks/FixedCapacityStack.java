package BagsQueuesStacks;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 泛型栈定容栈
 * 变成 Item 类型
 * Created by HJKLI on 2016/8/31.
 */
public class FixedCapacityStack<Item> {

    private Item[] a;
    private  int N = 0;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public boolean hasNext() {
        return N > 0;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> data = new FixedCapacityStack<String>(100);

        In arr = new In(args[0]);
        while (!arr.isEmpty()) {
            String key = arr.readString();
            if (!key.equals("-"))
                data.push(key);
            else if (!data.isEmpty())
                StdOut.println(data.pop() + " ");
        }
        StdOut.println("(" + data.size() + " left on stack!)");

//        for (String x : data) {
//
//        }
    }
}
