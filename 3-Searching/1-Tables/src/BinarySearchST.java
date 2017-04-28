import edu.princeton.cs.algs4.*;

/**
 * Created by HJKLI on 2017/4/27.
 * 顺序搜索 :  基于 二分查找， 优点，适应于小型问， 对于大型符号很好。
 * 数据结构是 条 有序数组， 查询从二分查找， 插入 二分法 后插入
 * <p>
 * Key extents Comparable<Key> 可实现 ·自然顺序·， 返回 1, 0, -1
 *
 *
 * ../algs4-data/tinyTale.txt
 * ../algs4-data/tale.txt
 *
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

        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /*
    ** 删除
     */
    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to delete() is null");

        int i = rank(key);

        if (i == n || key.compareTo(keys[i]) != 0) {
            return;
        }

        for (int j = i; j < n; i--) {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;
        vals[n] = null;
    }

    /*
     *  二分查找
      */
    private int rank(Key key) {

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
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

//    public Iterable<Key> keys() {
//        Queue<Key> queue = new Queue<Key>();
//        for (int i = 0; i < n; i++) {
//
//        }
//    }

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

        st.delete("belief");

        double time = timer.elapsedTime();
        StdOut.print(time);
    }
}
