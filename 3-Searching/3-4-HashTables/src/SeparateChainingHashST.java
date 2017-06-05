import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.SequentialSearchST;

/**
 * Created by W on 2017/5/19.
 * http://algs4.cs.princeton.edu/34hash/SeparateChainingHashST.java.html
 * 单链表 哈希表
 * <p>
 * ../algs4-data/tinyST.txt
 */
public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int                              n;          // 减值对总数
    private int                              m;          // 散列表的大小
    private SequentialSearchST<Key, Value>[] st;    // 存放链表对象的数组 - 链表

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    // 获取 get
    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("first argument to get() is null");

        int i = hash(key);

        return st[i].get(key);
    }

    // 添加 put
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            return;
        }

        // ，如果双表的大小平均长度列表>=10
        if (n > 10 * m)
            resize(2 * m);

        int i = hash(key);  //计数 哈希值

        if (!st[i].contains(key))
            n++;
        st[i].put(key, val);        // 链表 的 put
    }

    // 查看 是否用该 key
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    // 删除
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");

        int i = hash(key);
        if (st[i].contains(key))
            n--;
        st[i].delete(key);

        if (m > INIT_CAPACITY && n <= 2 * m)
            resize(m / 2);
    }

    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);

        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));      // 重新计算 hash 值
            }
        }

        this.n = temp.n;
        this.m = temp.m;
        this.st = temp.st;
    }

    // 0 和 m-1之间的哈希值
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }


    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();

        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {  // st[i].keys 是个 含有 key 迭代的 链表
                queue.enqueue(key);
            }
        }
        return queue;
    }


    public static void main(String[] args) {
        In arr = new In(args[0]);

        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();

        int i = 0;
        while (!arr.isEmpty()) {
            String key = arr.readString();
            st.put(key, i);
            ++i;
        }
        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));

        StdOut.println(" ================================ ");

        st.delete("H");

        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
