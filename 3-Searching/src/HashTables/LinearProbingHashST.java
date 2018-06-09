package HashTables;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by W on 2017/6/5.
 * 哈希表 ，基于线性探测法 散列表，
 * <p>
 * M > N, 依靠数组的空位 搞定 碰撞冲突， 开放地址散列表。
 * 有三种结果 ：
 * 1） 命中， 该位置的建和被查找相同
 * 2）未命中，建为空
 * 3）继续查找
 *
 * ../algs4-data/tinyST.txt
 */
public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int     n;              // 符号表中的总数 （不包括 null）
    private int     m;              // 线性表的大小   (包括 null)
    private Key[]   keys;         // key
    private Value[] vals;       // value


    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int capacity) {
        this.m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
    }

    /*
    ** get
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    /*
    ** contains
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /*
    ** 没有 key 新建 一个key value， 有key 覆盖 value
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            return;
        }

        if (n >= m / 2) resize(m * 2);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }

        keys[i] = key;
        vals[i] = val;
        n++;
    }

    // 将 m 值扩大
    private void resize(int L) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(L);

        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        this.keys = temp.keys;
        this.vals = temp.vals;
        m = temp.m;
    }

    /*
    ** 删除， 删除  key, , 并且后面有 key&value, 将 key & value 前进
     */
    public void  delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to delete() is null");

        if (!contains(key)) {
            return;
        }

        int i = hash(key);
        while (!keys[i].equals(key)) {
            i = (i + 1) % m;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key keyToRehash = keys[i];
            Value ValueToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;

            this.put(keyToRehash, ValueToRehash);
            i = (i + 1) % m;
        }
        n--;

        // 重新计算
        if (n > 0 && n <= m / 8)        // 动态条件， 1/8 ~ 1/2 是基于数学分析
            resize(m / 2);
    }

    // 获取 size();
    public int size() {
        return n;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();

        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } // 获得非负整数


    public static void main(String[] args) {
        In arr = new In(args[0]);

//        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        var st = new LinearProbingHashST<String, Integer>();

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
        StdOut.println(st.contains("x"));
//        st.delete("H");

        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
