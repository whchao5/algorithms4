
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * time : 2017-4-26
 * 顺序搜索 :  基于 链表， 优点，适应于小型问， 对于大型符号很好。
 * 数据结构是 条 链表， 查询从0开始， 插入插到 [0] 上
 * SequentialSearchST
 * <p>
 * 2 ../algs4-data/tinyTale.txt
 *
 * ../algs4-data/tale.txt        9.523   26.841
 * ../algs4-data/tale_two.txt
 */
public class SequentialSearchST<Key, Value> {
    private int n;
    private Node first;

    // 这是一个类
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        // 初始化
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {

    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to get() is null");

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }


    public void put(Key key, Value value) {

        if (key == null)
            throw new IllegalArgumentException("first argument to put() is null");

        if (value == null) {    // 这是方法论, 当value 为 null ,是可以默认一个值， 也可以把key delete,
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = value;
                return;
            }
        }

        first = new Node(key, value, this.first);
        n++;
    }

    /**
     * 从表中 删除 key 以及对于的 value
     * @param key
     */
    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to delete() is null");

        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {

        if (x == null)
            return null;

        if (key.equals(x.key)) {
            n--;
            return x.next;
        }

        x.next = delete(x.next, key);
        return x;
    }

    // 这个cool, 讲 Node ,加入 queue 中 ,在输出
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }


    public static void main(String[] args) {
        In arr = new In(args[0]);
        int i = 1;
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();

        Stopwatch timer = new Stopwatch();

        while (!arr.isEmpty()) {
            String key = arr.readString();

            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
            }
        }

//        st.delete("despair");

        double time = timer.elapsedTime();
        StdOut.println(time);

//        for (String s : st.keys())
//            StdOut.println(s + " " + st.get(s));
    }
}
