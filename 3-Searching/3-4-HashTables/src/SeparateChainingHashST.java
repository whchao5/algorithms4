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

    private int n;          // 减值对总数
    private int m;          // 散列表的大小
    private SequentialSearchST<Key, Value>[] st;    // 存放链表对象的数组

    public SeparateChainingHashST(int m) {
        this.m = m;
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
