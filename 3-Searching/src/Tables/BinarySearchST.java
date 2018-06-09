package Tables;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.NoSuchElementException;

/**
 * Created by HJKLI on 2017/4/27.
 * 顺序搜索 :  基于 二分查找， 优点，适应于小型问， 对于大型符号很好。
 * 数据结构是 条 有序数组， 查询从二分查找， 插入 二分法 后插入
 * <p>
 * Key extents Comparable<Key> 可实现 ·自然顺序·， 返回 1, 0, -1
 * <p>
 * <p>
 * ../algs4-data/tinyTale.txt
 * ../algs4-data/tale.txt
 * <p>
 * ../algs4-data/tale_two.txt
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private static final int INIT_CAPACITY = 2;
    private int n = 0;
    private Key[] keys;
    private Value[] vals;

    /*
    ** 初始化
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    /*
    ** 初始化
     */
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];

    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // 验证 数组中是否有 key
    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {

        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        if (isEmpty()) return null;

        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return vals[i];
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (val == null) throw new IllegalArgumentException("first argument to put() is null");
        if (key == null) {
            return;
        }

        // 查找 key, 有相同的 update valeu;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // 创建 新 Key && Value
        if (n == keys.length) resize(keys.length * 2);

        // 找到 j + 1 位， 其余向后移一位
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /*
    ** 删除 操作
     */
    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to delete() is null");

        int i = rank(key);

        if (i == n || key.compareTo(keys[i]) != 0) {
            return;
        }

        for (int j = i; j < n; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }

        n--;
        keys[n] = null;
        vals[n] = null;
    }

    /*
    ** 删除最大值
     */
    public void deleteMax() {
        delete(max());
    }


    /*
    ** 删除最小值
     */
    public void deleteMin() {
        delete(min());
    }

    /******************************
     * 命令符号表的方法。
     ***************************** */
    public Key min() {
        if (isEmpty())
            throw new NoSuchElementException("called min() with empty symbol table");

        return keys[0];
    }

    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("called max() with empty symbol table");
        return keys[n - 1];
    }

    public Key select(int k) {
        if (k >= size() || k < 0)
            throw new IllegalArgumentException("called select() with empty invalid argument: " + k);
        return keys[k];
    }


    /*
     *  二分查找
      */
    private int rank(Key key) {

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }


    private void resize(int length) {
        if (!(length > n))
            return;
        Key[] ItemK = (Key[]) new Comparable[length];
        Value[] ItemV = (Value[]) new Object[length];

        for (int i = 0; i < n; i++) {
            ItemK[i] = keys[i];
            ItemV[i] = vals[i];
        }

        keys = ItemK;
        vals = ItemV;
    }

    /*
    ** floor 小于等于 key 的最大值
     */
    public Key floor(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to floor() is null");

        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0)
            return keys[i];
        if (i == 0)
            return null;
        else return keys[i - 1];

    }

    /*
    ** ceiling 大于等于 key 的值
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        int i = rank(key);
        if (i == n) return null;
        else return keys[i];

    }

    /*
    ** 遍历数据
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) return queue;

        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi))
                queue.enqueue(keys[rank(hi)]);
        return queue;
    }

    // 新的 keys , 视乎不是很好
    public Iterable<Key> keys_two() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < size(); i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }


    public static void main(String[] args) {
        In arr = new In(args[0]);
        int i = 1;
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();

        Stopwatch timer = new Stopwatch();

        while (!arr.isEmpty()) {
            String key = arr.readString();

            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
            }
        }

//        st.delete("belief");

        double time = timer.elapsedTime();
        StdOut.println(time);

//        for (String s : st.keys()) {
//            StdOut.println(s + " " + st.get(s));
//        }
//
//        StdOut.println(st.floor("despaiaee"));
    }
}
