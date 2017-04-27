import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2017/4/27.
 * 顺序搜索 :  基于 二分查找， 优点，适应于小型问， 对于大型符号很好。
 * 数据结构是 条 有序数组， 查询从二分查找， 插入 sort
 * <p>
 * Key extents Comparable<Key> 可实现 ·自然顺序·， 返回 1, 0, -1
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private int n = 0;
    private Key[] keys;
    private Value[] vals;

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


    }

    public void delete(Key key) {

    }

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

    public static void main(String[] args) {
        In arr = new In(args[0]);

        Stopwatch timer = new Stopwatch();

        double time = timer.elapsedTime();
        StdOut.print(time);
    }
}
