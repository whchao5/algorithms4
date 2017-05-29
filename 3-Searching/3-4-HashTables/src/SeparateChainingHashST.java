import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.SequentialSearchST;

/**
 * Created by W on 2017/5/19.
 * http://algs4.cs.princeton.edu/34hash/SeparateChainingHashST.java.html
 * 单链表 哈希表
 */
public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;          // 减值对总数
    private int m;          // 散列表的大小
    private SequentialSearchST<Key, Value>[] st;    // 存放链表对象的数组 - 链表

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            return;
        }

        int i = hash(key);

    }

    private void resize(int chains) {

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


}
